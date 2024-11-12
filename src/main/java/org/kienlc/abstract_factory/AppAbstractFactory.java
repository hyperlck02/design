package org.kienlc.abstract_factory;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class AppAbstractFactory implements Runnable {

    private final Kingdom kingdom = new Kingdom();

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        var app = new AppAbstractFactory();
        app.run();
    }

    @Override
    public void run() {
        log.info("elf kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        log.info(kingdom.getArmy().getDescription());
        log.info(kingdom.getCastle().getDescription());
        log.info(kingdom.getKing().getDescription());

        log.info("orc kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        log.info(kingdom.getArmy().getDescription());
        log.info(kingdom.getCastle().getDescription());
        log.info(kingdom.getKing().getDescription());
    }

    /**
     * Creates kingdom.
     * @param kingdomType type of Kingdom
     */
    public void createKingdom(final Kingdom.FactoryMaker.KingdomType kingdomType) {
        final KingdomFactory kingdomFactory = Kingdom.FactoryMaker.makeFactory(kingdomType);
        kingdom.setKing(kingdomFactory.createKing());
        kingdom.setCastle(kingdomFactory.createCastle());
        kingdom.setArmy(kingdomFactory.createArmy());
    }
}
