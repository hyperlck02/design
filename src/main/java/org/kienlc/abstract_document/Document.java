package org.kienlc.abstract_document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {
    int MIN = 5;

    void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
