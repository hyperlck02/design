package org.kienlc.abstract_document.domain;

import org.kienlc.abstract_document.Document;
import org.kienlc.abstract_document.domain.enums.Property;

import java.util.Optional;

public interface HasPrice extends Document {
    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(Property.PRICE.toString()));
    }
}
