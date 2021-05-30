/*
package com.example.damian.iracki.ticketBookingApp.configs;

import com.example.damian.iracki.ticketBookingApp.entities.Movie;
import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.ScreeningRoom;
import com.example.damian.iracki.ticketBookingApp.repositories.MovieRepository;
import com.example.damian.iracki.ticketBookingApp.repositories.ScreeningRepository;
import com.example.damian.iracki.ticketBookingApp.repositories.ScreeningRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunnerForScreeningRoom(ScreeningRoomRepository screeningRoomRepository, MovieRepository movieRepository,
                                                        ScreeningRepository screeningRepository) {
        return args -> {
            ScreeningRoom yellowScreeningRoom = new ScreeningRoom("yellow", 4, 6);
            ScreeningRoom redScreeningRoom = new ScreeningRoom("red", 6, 8);
            ScreeningRoom blueScreeningRoom = new ScreeningRoom("blue", 10, 10);

            ArrayList<ScreeningRoom> screeningRooms = new ArrayList<>();
            screeningRooms.add(yellowScreeningRoom);
            screeningRooms.add(redScreeningRoom);
            screeningRooms.add(blueScreeningRoom);

            screeningRoomRepository.saveAll(screeningRooms);

            Movie matrix = new Movie("Matrix", "Movie about choices");
            Movie terminator = new Movie("Terminator", "fooBar");
            Movie rambo = new Movie("Rambo", "the best soldier ever");

            ArrayList<Movie> movies = new ArrayList<>();
            movies.add(matrix);
            movies.add(terminator);
            movies.add(rambo);

            movieRepository.saveAll(movies);

            Screening screening1 = new Screening(matrix, yellowScreeningRoom, LocalDateTime.of(2021, 6, 2, 15, 0));
            Screening screening2 = new Screening(matrix, redScreeningRoom, LocalDateTime.of(2021, 6, 5, 18, 0));
            Screening screening3 = new Screening(terminator, yellowScreeningRoom, LocalDateTime.of(2021, 6, 3, 21, 0));
            Screening screening4 = new Screening(terminator, blueScreeningRoom, LocalDateTime.of(2021, 6, 8, 18, 0));
            Screening screening5 = new Screening(rambo, redScreeningRoom, LocalDateTime.of(2021, 6, 2, 18, 0));
            Screening screening6 = new Screening(matrix, blueScreeningRoom, LocalDateTime.of(2021, 6, 5, 19, 0));

            ArrayList<Screening> screenings = new ArrayList<>();
            screenings.add(screening1);
            screenings.add(screening2);
            screenings.add(screening3);
            screenings.add(screening4);
            screenings.add(screening5);
            screenings.add(screening6);

            screeningRepository.saveAll(screenings);
        };
    }
}
*/
