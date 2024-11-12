package org.kienlc.abstract_document;

import org.kienlc.abstract_document.domain.Car;
import org.kienlc.abstract_document.domain.enums.Property;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        System.out.println("Constructing parts and car");

        var wheelProperties = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L);

        var doorProperties = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L);

        var carProperties = Map.of(
                Property.MODEL.toString(), "300SL",
                Property.PRICE.toString(), 10000L,
                Property.PARTS.toString(), List.of(wheelProperties, doorProperties));

        var car = new Car(carProperties);

        System.out.println("Here is our car:");
        System.out.println("-> model: " + car.getModel().orElseThrow());
        System.out.println("-> price: " + car.getPrice().orElseThrow());
        System.out.println("-> parts: ");
        car.getParts().forEach(p -> System.out.println("\t" +
                p.getType().orElse(null) + "/" +
                p.getModel().orElse(null) + "/" +
                p.getPrice().orElse(null))
        );
    }
}

