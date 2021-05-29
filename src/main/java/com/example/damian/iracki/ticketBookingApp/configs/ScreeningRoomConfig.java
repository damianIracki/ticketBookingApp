package com.example.damian.iracki.ticketBookingApp.configs;

import com.example.damian.iracki.ticketBookingApp.entities.ScreeningRoom;
import com.example.damian.iracki.ticketBookingApp.repositories.ScreeningRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ScreeningRoomConfig {

    @Bean
    CommandLineRunner commandLineRunnerForScreeningRoom(ScreeningRoomRepository screeningRoomRepository) {
        return args -> {
            ScreeningRoom yellow = new ScreeningRoom("yellow", 4, 6);
            ScreeningRoom red = new ScreeningRoom("red", 6, 8);
            ScreeningRoom blue = new ScreeningRoom("blue", 10, 10);

            ArrayList<ScreeningRoom> screeningRooms = new ArrayList<>();
            screeningRooms.add(yellow);
            screeningRooms.add(red);
            screeningRooms.add(blue);

            screeningRoomRepository.saveAll(screeningRooms);
        };
    }
}
