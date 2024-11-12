package org.kienlc.active_object;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public abstract class ActiveCreature {
//    private static final Logger logger = LoggerFactory.getLogger(ActiveCreature.class);

    private final BlockingQueue<Runnable> requests;

    private final String name;

    private final Thread thread; // Thread of execution.

    /**
     * -- GETTER --
     *  Returns the status of the thread of execution.
     *
     * @return the status of the thread of execution.
     */
    @Getter
    private int status; // status of the thread of execution.

    protected ActiveCreature(String name) {
        this.name = name;
        this.status = 0;
        this.requests = new LinkedBlockingQueue<>();
        thread = new Thread(() -> {
            boolean infinite = true;
            while (infinite) {
                try {
                    requests.take().run();
                } catch (InterruptedException e) {
                    if (this.status != 0) {
                        log.error("Thread was interrupted. --> {}", e.getMessage());
                    }
                    infinite = false;
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
    }

    /**
     * Eats the porridge.
     * @throws InterruptedException due to firing a new Runnable.
     */
    public void eat() throws InterruptedException {
        requests.put(() -> {
            log.info("{} is eating!", name());
            log.info("{} has finished eating!", name());
        });
    }

    /**
     * Roam the wastelands.
     * @throws InterruptedException due to firing a new Runnable.
     */
    public void roam() throws InterruptedException {
        requests.put(() ->
                log.info("{} has started to roam in the wastelands.", name())
        );
    }

    /**
     * Returns the name of the creature.
     * @return the name of the creature.
     */
    public String name() {
        return this.name;
    }

    /**
     * Kills the thread of execution.
     * @param status of the thread of execution. 0 == OK, the rest is loggergerging an error.
     */
    public void kill(int status) {
        this.status = status;
        this.thread.interrupt();
    }

}
