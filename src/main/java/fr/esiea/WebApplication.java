package fr.esiea;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Sample web application.<br/>
 * Run {@link #main(String[])} to launch.
 */
@SpringBootApplication
@RestController
public class WebApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

    private final BiMap<Integer, Item> database = HashBiMap.create();
    private final AtomicInteger sequenceGenerator = new AtomicInteger();

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    @RequestMapping("/add_item")
    int createUser(@RequestParam("name") String name, @RequestParam("quality") int quality, @RequestParam("sellIn") int sellIn) {
        Item i = new Item(name, sellIn, quality);


        final int id;
        if (!database.containsValue(i)) {
            id = sequenceGenerator.incrementAndGet();
            i.setId(id);
            database.put(id, i);
            LOGGER.info(i + " created with ID: " + database.inverse()
                    .get(i));
        } else {
            id = database.inverse()
                    .get(i);
            LOGGER.info(i + " already exists with ID: " + database.inverse()
                    .get(i));
        }
        return id;
    }

    @RequestMapping("/list_items")
    List<Item> listItems() {
        return database.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }

//    @RequestMapping("/buy_item")
//    List<Item> buyItem() {
//        return database.entrySet()
//                .stream()
//                .map(Entry::getValue)
//                .collect(Collectors.toList());
//    }
}