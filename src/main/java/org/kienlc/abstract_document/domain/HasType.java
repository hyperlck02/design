package org.kienlc.abstract_document.domain;

import org.kienlc.abstract_document.Document;
import org.kienlc.abstract_document.domain.enums.Property;

import java.util.Optional;

public interface HasType extends Document {
    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
