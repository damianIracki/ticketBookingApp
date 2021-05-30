package com.example.damian.iracki.ticketBookingApp.resources;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.ScreeningRoom;
import com.example.damian.iracki.ticketBookingApp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningResource {

    private final ScreeningService screeningService;

    @Autowired
    public ScreeningResource(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Screening>> getAllScreenings() {
        List<Screening> screenings = screeningService.findAllScreeningOrderByStartingDate();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    //Ind date param put string in format yyyy-MM-dd_HH:mm
    @GetMapping("/sorted/{sortingType}")
    public ResponseEntity<List<Screening>> getScreeningsBetweenDate(@PathVariable("sortingType") String sortingType,
                                                                    @RequestParam(required = false) String startDate,
                                                                    @RequestParam(required = false) String endDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(startDate, dateTimeFormatter);
        LocalDateTime endTime = LocalDateTime.parse(endDate, dateTimeFormatter);
        List<Screening> screenings = new ArrayList<>();
        if (sortingType.equals("date")) {
            screenings = screeningService.findAllScreeningsBetweenDateSortedByDate(startTime, endTime);
        } else if (sortingType.equals("title")) {
            screenings = screeningService.findAllScreeningsBetweenDateSortedByMovieTitle(startTime, endTime);
        } else if (sortingType.equals("dateTitle")) {
            screenings = screeningService.findAllScreeningsBetweenDateSortedByDateAndMovieTitle(startTime, endTime);
        }
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable("id") Long id) {
        Screening screening = screeningService.findScreeningById(id);
        return new ResponseEntity<>(screening, HttpStatus.OK);
    }

    @GetMapping("/{id}/screeningRoom")
    public ResponseEntity<ScreeningRoom> getScreeningRoomByScreeningId(@PathVariable("id") Long id) {
        ScreeningRoom screeningRoom = screeningService.findScreeningById(id).getScreeningRoom();
        return new ResponseEntity<>(screeningRoom, HttpStatus.OK);
    }

    @GetMapping("/{id}/tableOfSeats")
    public ResponseEntity<String[][]> getAllTicket(@PathVariable("id") Long screeningId) {
        String[][] seats = screeningService.getTableOfSeatsByScreeningId(screeningId);
        for (int i = 0; i < seats.length; i++) {
            for (int j = 1; j < seats[i].length - 1; j++) {
                if (seats[i][j].equals("UNAVAILABLE")) {
                    continue;
                }
                if (seats[i][j - 1].equals("UNAVAILABLE") && seats[i][j + 1].equals("UNAVAILABLE")) {
                    seats[i][j] = "UNAVAILABLE";
                }
            }
        }
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }
}
