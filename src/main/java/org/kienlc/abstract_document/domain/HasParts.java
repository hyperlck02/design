package org.kienlc.abstract_document.domain;

import org.kienlc.abstract_document.AbstractDocument;
import org.kienlc.abstract_document.Document;
import org.kienlc.abstract_document.domain.enums.Property;

import java.util.stream.Stream;

public interface HasParts extends Document {

    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part:: new);
    }
}
