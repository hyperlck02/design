package org.kienlc.abstract_document;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.Collection;

public abstract class AbstractDocument implements Document {

    private final Map<String, Object> documentProperties;

    protected AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "properties map is required");


        this.documentProperties = properties;
    }

    @Override
    public void put(String key, Object value) {
        documentProperties.put(key, value);
    }

    @Override
    public Object get(String key) {
        return documentProperties.get(key);
    }


    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> childConstructor) {
        return Stream.ofNullable(get(key))
                .filter(Objects::nonNull)
                .map(el -> (List<Map<String, Object>>) el)
                .findAny()
                .stream()
                .flatMap(Collection::stream)
                .map(childConstructor);
    }

    @Override
    public String toString() {
        return buildStringRepresentation();
    }

    private String buildStringRepresentation() {
        var builder = new StringBuilder();
        builder.append(getClass().getName()).append("[");

        // Explaining variable for document properties map
        Map<String, Object> documentProperties = this.documentProperties;

        // Explaining variable for the size of document properties map
        int numProperties = documentProperties.size();

        // Explaining variable for tracking the current property index
        int currentPropertyIndex = 0;

        // Iterate over document properties map
        for (Map.Entry<String, Object> entry : documentProperties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Append key-value pair
            builder.append("[").append(key).append(" : ").append(value).append("]");

            // Add comma if not last property
            if (++currentPropertyIndex < numProperties) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }


}
