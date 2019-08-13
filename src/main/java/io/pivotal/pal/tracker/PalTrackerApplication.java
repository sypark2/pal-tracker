package io.pivotal.pal.tracker;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

}