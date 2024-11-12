package org.kienlc.abstract_factory;

public class OrcArmy implements Army {

    static final String DESCRIPTION = "This is the orc army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
