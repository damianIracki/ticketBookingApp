package com.example.damian.iracki.ticketBookingApp.services;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> findAllScreeningOrderByStartingDate() {
        return screeningRepository.findAllByOrderByStartingDateTime();
    }

    public List<Screening> findAllScreeningsBetweenDateSortedByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return screeningRepository.findAllByStartingDateTimeBetweenOrderByStartingDateTime(startDate, endDate);
    }

    public List<Screening> findAllScreeningsBetweenDateSortedByMovieTitle(LocalDateTime startDate, LocalDateTime endDate) {
        return screeningRepository.findAllByStartingDateTimeBetweenOrderByMovieTitle(startDate, endDate);
    }

    public List<Screening> findAllScreeningsBetweenDateSortedByDateAndMovieTitle(LocalDateTime startDate, LocalDateTime endDate) {
        return screeningRepository.findAllByStartingDateTimeBetweenOrderByStartingDateTimeAscMovieTitle(startDate, endDate);
    }

    public Screening findScreeningById(Long id) {
        return screeningRepository.findScreeningById(id)
                .orElseThrow(() -> new IllegalStateException("Selected screening doesn't exist"));
    }

    public String[][] getTableOfSeatsByScreeningId(Long id) {
        Screening screening = findScreeningById(id);
        String[][] tableOfSeats = new String[screening.getScreeningRoom().getRowCount()]
                [screening.getScreeningRoom().getSeatsInRowCount()];
        for (int i = 0; i < tableOfSeats.length; i++) {
            for (int j = 0; j < tableOfSeats[i].length; j++) {
                if (i + 1 < 10 && j + 1 < 10) {
                    tableOfSeats[i][j] = "0" + (i + 1) + "0" + (j + 1);
                } else if (i + 1 < 10) {
                    tableOfSeats[i][j] = "0" + (i + 1) + (j + 1);
                } else if (j + 1 < 10) {
                    tableOfSeats[i][j] = (i + 1) + "0" + (j + 1);
                } else {
                    tableOfSeats[i][j] = "" + (i + 1) + (j + 1);
                }
            }
        }
        for (Ticket ticket : screening.getTickets()) {
            tableOfSeats[ticket.getNumberOfRow() - 1][ticket.getNumberOfSeatInRow() - 1] = "UNAVAILABLE";
        }
        return tableOfSeats;
    }
}
