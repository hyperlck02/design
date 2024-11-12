package org.kienlc.abstract_factory;

public class OrcCastle implements Castle {

    static final String DESCRIPTION = "This is the orc castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
