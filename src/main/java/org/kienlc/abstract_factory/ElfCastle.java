package org.kienlc.abstract_factory;

public class ElfCastle implements Castle {

    static final String DESCRIPTION = "This is the elven castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
