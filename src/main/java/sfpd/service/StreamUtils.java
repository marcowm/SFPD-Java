/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfpd.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author F5115716
 * @since Aug 14, 2017
 */
public class StreamUtils {

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        return asStream(sourceIterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator, boolean parallel) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static String parse(String source, String pattern, Function<String, String> f) {
        String resultado = source;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        Map<String, String> conversao = new HashMap();
        while (m.find()) {
            if (m.group(1).isEmpty()) {
                conversao.put(m.group(), f.apply("yyyyMMdd"));
            } else {
                conversao.put(m.group(), f.apply(m.group(1)));
            }
        }

        for (Map.Entry<String, String> c : conversao.entrySet()) {
            resultado = resultado.replaceAll(Pattern.quote(c.getKey()), c.getValue());
        }

        return resultado;
    }
}
