/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.
    
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS
    
    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/
    
    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.
    
    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.
    
    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.
    
    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.html2pdf.css.resolve.func.counter;

import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.kernel.numbering.ArmenianNumbering;
import com.itextpdf.kernel.numbering.EnglishAlphabetNumbering;
import com.itextpdf.kernel.numbering.GeorgianNumbering;
import com.itextpdf.kernel.numbering.GreekAlphabetNumbering;
import com.itextpdf.kernel.numbering.RomanNumbering;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.styledxmlparser.node.INode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Class that manages counters (e.g. for list symbols).
 */
public class CssCounterManager {

    /**
     * The Constant DISC_SYMBOL.
     */
    private static final String DISC_SYMBOL = "\u2022";

    /**
     * The Constant CIRCLE_SYMBOL.
     */
    private static final String CIRCLE_SYMBOL = "\u25e6";

    /**
     * The Constant SQUARE_SYMBOL.
     */
    private static final String SQUARE_SYMBOL = "\u25a0";

    /**
     * The Constant DEFAULT_COUNTER_VALUE.
     */
    private static final int DEFAULT_COUNTER_VALUE = 0;

    /**
     * The Constant DEFAULT_INCREMENT_VALUE.
     */
    private static final int DEFAULT_INCREMENT_VALUE = 1;

    /**
     * The Constant MAX_ROMAN_NUMBER.
     */
    private static final int MAX_ROMAN_NUMBER = 3999;

    /**
     * Map to store target-counter values. First key is target-counter ID. Second key is counter name.
     */
    private final Map<String, Map<String, Integer>> targetCounterMap = new HashMap<>();

    /**
     * Map to store target-counters values. First key is target-counters ID. Second key is counter name.
     */
    private final Map<String, Map<String, String>> targetCountersMap = new HashMap<>();

    /**
     * Map to store counters values. The key is the counter name, the value is the {@link Stack} with counters values.
     */
    private final Map<String, Deque<Integer>> counters = new HashMap<>();

    /**
     * Map to store counter values. The key is the counter name, the value is the current counter value.
     */
    private final Map<String, Integer> counterValues = new HashMap<>();

    private final Map<IElementNode, List<String>> pushedCountersMap = new HashMap<>();

    /**
     * Creates a new {@link CssCounterManager} instance.
     */
    public CssCounterManager() {
    }

    /**
     * Clears information about counters. Target-counter(s) information remains.
     */
    public void clearManager() {
        counters.clear();
    }

    /**
     * Pushes every current non-null counter to stack of counters.
     * This method should be called when we are about to process child nodes.
     *
     * @param element the element which counters shall be pushed
     */
    public void pushEveryCounterToCounters(IElementNode element) {
        final List<String> pushedCounters = new ArrayList<>();
        for (final Map.Entry<String, Integer> counter : new HashSet<>(counterValues.entrySet())) {
            if (counter.getValue() != null) {
                pushCounter(counter.getKey(), counter.getValue());
                pushedCounters.add(counter.getKey());
                counterValues.put(counter.getKey(), null);
            }
        }
        pushedCountersMap.put(element, pushedCounters);
    }

    /**
     * Pops every given counter from stack of counters.
     * This method should be called when we have finished processing child nodes.
     *
     * @param element the element which counters shall be popped
     */
    public void popEveryCounterFromCounters(IElementNode element) {
        counterValues.clear();
        if (pushedCountersMap.get(element) != null) {
            for (final String pushedCounter : pushedCountersMap.get(element)) {
                counterValues.put(pushedCounter, popCounter(pushedCounter));
            }
            pushedCountersMap.remove(element);
        }
    }

    /**
     * Gets target-counter value for specified ID and counterName. Value is converted according to listSymbolType.
     *
     * @param id             ID of the element. The first call adds ID to the Map, which means we require its value.
     *                       The second call returns corresponding value if we already encountered corresponding element
     * @param counterName    name of the counter. The first call adds counterName to the Map,
     *                       which means we require its value.
     *                       The second call returns corresponding value if we already encountered corresponding element
     * @param listSymbolType the list symbol type to convert counter's value. null if conversion is not required.
     * @return target-counter value.
     */
    public String resolveTargetCounter(String id, String counterName, String listSymbolType) {
        Integer counterValue = null;
        if (targetCounterMap.containsKey(id)) {
            final Map<String, Integer> countersForThisId = targetCounterMap.get(id);
            if (countersForThisId.containsKey(counterName)) {
                counterValue = countersForThisId.get(counterName);
            } else {
                countersForThisId.put(counterName, null);
            }
        } else {
            targetCounterMap.put(id, new HashMap<>());
            targetCounterMap.get(id).put(counterName, null);
        }
        return counterValue == null ? null : convertCounterToSymbol(listSymbolType, counterValue);
    }

    /**
     * Gets target-counter value for specified ID and counterName. Value is converted according to listSymbolType.
     *
     * @param id                  ID of the element. The first call adds ID at the Map,
     *                            which means we require its value. The second call returns corresponding value
     *                            if we already encountered this element
     * @param counterName         name of the counter. The first call adds name at the Map,
     *                            which means we require its value. The second call returns corresponding value
     *                            if we already encountered this element
     * @param counterSeparatorStr separator to separate counters values.
     * @param listSymbolType      the list symbol type to convert counter's value. null if conversion is not required.
     * @return target-counter value.
     */
    public String resolveTargetCounters(String id,
                                        String counterName, String counterSeparatorStr, String listSymbolType) {
        String countersStr = null;
        if (targetCountersMap.containsKey(id)) {
            final Map<String, String> countersForThisId= targetCountersMap.get(id);
            if (countersForThisId.containsKey(counterName)) {
                countersStr = countersForThisId.get(counterName);
            } else {
                countersForThisId.put(counterName, null);
            }
        } else {
            targetCountersMap.put(id, new HashMap<>());
            targetCountersMap.get(id).put(counterName, null);
        }
        if (countersStr == null) {
            return null;
        } else {
            final String[] resolvedCounters = countersStr.split("\\.");
            final List<String> convertedCounters = new ArrayList<>();
            for (String counter : resolvedCounters) {
                convertedCounters.add(convertCounterToSymbol(listSymbolType, Integer.valueOf(counter)));
            }
            return buildCountersStringFromList(convertedCounters, counterSeparatorStr);
        }
    }

    /**
     * Adds counter value to every counter in the Map corresponding to a node ID.
     *
     * @param node node to take ID and scope from
     */
    public void addTargetCounterIfRequired(IElementNode node) {
        final String id = node.getAttribute(AttributeConstants.ID);
        if (id != null && targetCounterMap.containsKey(id)) {
            for (final Map.Entry<String, Integer> targetCounter : new HashSet<>(targetCounterMap.get(id).entrySet())) {
                final String counterName = targetCounter.getKey();
                final String counterStr = resolveCounter(counterName, null);
                if (counterStr != null) {
                    targetCounterMap.get(id).put(counterName, Integer.parseInt(counterStr));
                }
            }
        }
    }

    /**
     * Adds counters value to every counter in the Map corresponding to a node ID.
     *
     * @param node node to take ID and scope from
     */
    public void addTargetCountersIfRequired(IElementNode node) {
        final String id = node.getAttribute(AttributeConstants.ID);
        if (id != null && targetCountersMap.containsKey(id)) {
            for (final Map.Entry<String, String> targetCounter : new HashSet<>(targetCountersMap.get(id).entrySet())) {
                final String counterName = targetCounter.getKey();
                final String resolvedCounters = resolveCounters(counterName, ".", null);
                if (resolvedCounters != null) {
                    targetCountersMap.get(id).put(counterName, resolvedCounters);
                }
            }
        }
    }

    /**
     * Resolves a counter.
     *
     * @param counterName    the counter name
     * @param listSymbolType the list symbol type
     * @param node           current element
     * @return the counter value as a {@link String}
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public String resolveCounter(String counterName, String listSymbolType, INode node) {
        return resolveCounter(counterName, listSymbolType);
    }

    /**
     * Resolves a counter.
     *
     * @param counterName    the counter name
     * @param listSymbolType the list symbol type
     * @return the counter value as a {@link String}
     */
    public String resolveCounter(String counterName, String listSymbolType) {
        Integer result = counterValues.get(counterName);
        if (result == null) {
            if (!counters.containsKey(counterName) || counters.get(counterName).isEmpty()) {
                result = 0;
            } else {
                result = counters.get(counterName).getLast();
            }
        }
        return convertCounterToSymbol(listSymbolType, result);
    }

    /**
     * Resolves counters.
     *
     * @param counterName         the counter name
     * @param counterSeparatorStr the counter separator
     * @param listSymbolType      the list symbol type
     * @param node                current element
     * @return the counters as a {@link String}
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public String resolveCounters(String counterName, String counterSeparatorStr, String listSymbolType, INode node) {
        return resolveCounters(counterName, counterSeparatorStr, listSymbolType);
    }

    /**
     * Resolves counters.
     *
     * @param counterName         the counter name
     * @param counterSeparatorStr the counter separator
     * @param listSymbolType      the list symbol type
     * @return the counters as a {@link String}
     */
    public String resolveCounters(String counterName, String counterSeparatorStr, String listSymbolType) {
        final List<String> resolvedCounters = new ArrayList<>();
        if (counters.containsKey(counterName)) {
            for (final Integer value : counters.get(counterName)) {
                resolvedCounters.add(convertCounterToSymbol(listSymbolType, value));
            }
        }
        final Integer currentValue = counterValues.get(counterName);
        if (currentValue != null) {
            resolvedCounters.add(convertCounterToSymbol(listSymbolType, currentValue));
        }
        if (resolvedCounters.isEmpty()) {
            return convertCounterToSymbol(listSymbolType, 0);
        } else {
            return buildCountersStringFromList(resolvedCounters, counterSeparatorStr);
        }
    }

    /**
     * Resets the counter.
     *
     * @param counterName the counter name
     * @param node        current element
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public void resetCounter(String counterName, INode node) {
        resetCounter(counterName, DEFAULT_COUNTER_VALUE);
    }

    /**
     * Resets the counter.
     *
     * @param counterName the counter name
     * @param value       the new value
     * @param node        current element
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public void resetCounter(String counterName, int value, INode node) {
        resetCounter(counterName, value);
    }

    /**
     * Resets the counter.
     *
     * @param counterName the counter name
     */
    public void resetCounter(String counterName) {
        resetCounter(counterName, DEFAULT_COUNTER_VALUE);
    }

    /**
     * Resets the counter.
     *
     * @param counterName the counter name
     * @param value       the new value
     */
    public void resetCounter(String counterName, int value) {
        counterValues.put(counterName, value);
    }

    /**
     * Increments the counter.
     *
     * @param counterName the counter name
     * @param node        current element.
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public void incrementCounter(String counterName, INode node) {
        incrementCounter(counterName, DEFAULT_INCREMENT_VALUE);
    }

    /**
     * Increments the counter.
     *
     * @param counterName    the counter name
     * @param incrementValue the increment value
     * @param node           current element
     * @deprecated Need to be removed in 7.2
     */
    @Deprecated
    public void incrementCounter(String counterName, int incrementValue, INode node) {
        incrementCounter(counterName, incrementValue);
    }

    /**
     * Increments the counter.
     *
     * @param counterName the counter name
     */
    public void incrementCounter(String counterName) {
        incrementCounter(counterName, DEFAULT_INCREMENT_VALUE);
    }

    /**
     * Increments the counter.
     *
     * @param counterName    the counter name
     * @param incrementValue the increment value
     */
    public void incrementCounter(String counterName, int incrementValue) {
        Integer currentValue = counterValues.get(counterName);
        if (currentValue == null) {
            final Deque<Integer> counterStack = counters.get(counterName);
            if (counterStack == null || counterStack.isEmpty()) {
                // If 'counter-increment' or 'content' on an element or pseudo-element refers to a counter that is not in the scope of any 'counter-reset',
                // implementations should behave as though a 'counter-reset' had reset the counter to 0 on that element or pseudo-element.
                currentValue = DEFAULT_COUNTER_VALUE;
                resetCounter(counterName, (int) currentValue);
                counterValues.put(counterName, currentValue + incrementValue);
            } else {
                currentValue = counterStack.getLast();
                counterStack.removeLast();
                counterStack.addLast((int) (currentValue + incrementValue));
            }
        } else {
            counterValues.put(counterName, currentValue + incrementValue);
        }
    }

    private Integer popCounter(String counterName) {
        if (counters.containsKey(counterName) && !counters.get(counterName).isEmpty()) {
            Integer last = counters.get(counterName).getLast();
            counters.get(counterName).removeLast();
            return last;
        }
        return null;
    }

    private void pushCounter(String counterName, Integer value) {
        if (!counters.containsKey(counterName)) {
            counters.put(counterName, new LinkedList<>());
        }
        counters.get(counterName).addLast((int) value);
    }

    private static String buildCountersStringFromList(List<String> resolvedCounters, String counterSeparatorStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resolvedCounters.size(); i++) {
            sb.append(resolvedCounters.get(i));
            if (i != resolvedCounters.size() - 1) {
                sb.append(counterSeparatorStr);
            }
        }
        return sb.toString();
    }

    private static String convertCounterToSymbol(String listSymbolType, Integer counterValue) {
        if (listSymbolType == null) {
            return String.valueOf(counterValue);
        } else {
            if (CssConstants.NONE.equals(listSymbolType)) {
                return "";
            } else if (CssConstants.DISC.equals(listSymbolType)) {
                return DISC_SYMBOL;
            } else if (CssConstants.SQUARE.equals(listSymbolType)) {
                return SQUARE_SYMBOL;
            } else if (CssConstants.CIRCLE.equals(listSymbolType)) {
                return CIRCLE_SYMBOL;
            } else if (CssConstants.UPPER_ALPHA.equals(listSymbolType) || CssConstants.UPPER_LATIN.equals(listSymbolType)) {
                return counterValue > 0 ? EnglishAlphabetNumbering.toLatinAlphabetNumberUpperCase((int) counterValue)
                        : String.valueOf(counterValue);
            } else if (CssConstants.LOWER_ALPHA.equals(listSymbolType) || CssConstants.LOWER_LATIN.equals(listSymbolType)) {
                return counterValue > 0 ? EnglishAlphabetNumbering.toLatinAlphabetNumberLowerCase((int) counterValue)
                        : String.valueOf(counterValue);
            } else if (CssConstants.LOWER_GREEK.equals(listSymbolType)) {
                return counterValue > 0 ? GreekAlphabetNumbering.toGreekAlphabetNumberLowerCase((int) counterValue)
                        : String.valueOf(counterValue);
            } else if (CssConstants.LOWER_ROMAN.equals(listSymbolType)) {
                return counterValue <= MAX_ROMAN_NUMBER ? RomanNumbering.toRomanLowerCase((int) counterValue)
                        : String.valueOf(counterValue);
            } else if (CssConstants.UPPER_ROMAN.equals(listSymbolType)) {
                return counterValue <= MAX_ROMAN_NUMBER ? RomanNumbering.toRomanUpperCase((int) counterValue)
                        : String.valueOf(counterValue);
            } else if (CssConstants.DECIMAL_LEADING_ZERO.equals(listSymbolType)) {
                return (counterValue < 10 ? "0" : "") + String.valueOf(counterValue);
            } else if (CssConstants.GEORGIAN.equals(listSymbolType)) {
                return GeorgianNumbering.toGeorgian((int) counterValue);
            } else if (CssConstants.ARMENIAN.equals(listSymbolType)) {
                return ArmenianNumbering.toArmenian((int) counterValue);
            } else {
                return String.valueOf(counterValue); //TODO
            }
        }
    }

}
