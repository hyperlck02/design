package org.kienlc.abstract_document.domain;

import org.kienlc.abstract_document.Document;
import org.kienlc.abstract_document.domain.enums.Property;

import java.util.Optional;

public interface HasModel extends Document {

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}
