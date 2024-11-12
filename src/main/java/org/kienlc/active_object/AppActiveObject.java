package org.kienlc.active_object;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The Active Object pattern helps to solve synchronization difficulties without using
 * 'synchronized' methods. The active object will contain a thread-safe data structure
 * (such as BlockingQueue) and use to synchronize method calls by moving the logic of the method
 * into an invocator(usually a Runnable) and store it in the DSA.
 *
 * <p>In this example, we fire 20 threads to modify a value in the target class.
 */

@Slf4j
public class AppActiveObject implements Runnable {

//    private static final Logger logger = LoggerFactory.getLogger(AppActiveObject.class);

    private static final int NUM_CREATURES = 3;

    /**
     * Program entry point.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        var app = new AppActiveObject();
        app.run();
    }

    @Override
    public void run() {
        List<ActiveCreature> creatures = new ArrayList<>();
        try {
            for (int i = 0; i < NUM_CREATURES; i++) {
                creatures.add(new Orc(Orc.class.getSimpleName() + i));
                creatures.get(i).eat();
                creatures.get(i).roam();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            for (int i = 0; i < NUM_CREATURES; i++) {
                creatures.get(i).kill(0);
            }
        }
    }
}