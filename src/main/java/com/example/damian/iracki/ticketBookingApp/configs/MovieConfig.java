package com.example.damian.iracki.ticketBookingApp.configs;


import com.example.damian.iracki.ticketBookingApp.entities.Movie;
import com.example.damian.iracki.ticketBookingApp.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunnerForMovie(MovieRepository movieRepository) {
        return args -> {

            Movie matrix = new Movie("Matrix", "Movie about choices");
            Movie terminator = new Movie("Terminator", "fooBar");
            Movie rambo = new Movie("Rambo", "the best soldier ever");

            ArrayList<Movie> movies = new ArrayList<>();
            movies.add(matrix);
            movies.add(terminator);
            movies.add(rambo);

            movieRepository.saveAll(movies);
        };
    }
}
