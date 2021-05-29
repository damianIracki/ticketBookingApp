package com.example.damian.iracki.ticketBookingApp.resources;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/screening")
public class ScreeningResource {

    private final ScreeningService screeningService;

    @Autowired
    public ScreeningResource(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Screening>> getAllScreenings() {
        List<Screening> screenings = screeningService.findAllScreeningOrderByStartingDate();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    //Ind date param put string in format yyyy-MM-dd_HH:mm
    @GetMapping("/date/{sortingType}")
    public ResponseEntity<List<Screening>> getScreeningsBetweenDate(@PathVariable String sortingType,
                                                                    @RequestParam(required = true) String startDate,
                                                                    @RequestParam(required = true) String endDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
        LocalDateTime starTime = LocalDateTime.parse(startDate, dateTimeFormatter);
        LocalDateTime endTime = LocalDateTime.parse(endDate, dateTimeFormatter);
        List<Screening> screenings = new ArrayList<>();
        if(sortingType.equals("date")){
            screenings = screeningService.findAllScreeningsBetweenDateSortedByDate(starTime, endTime);
        } else if(sortingType.equals("title")){
            screenings = screeningService.findAllScreeningsBetweenDateSortedByMovieTitle(starTime, endTime);
        }
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }
}
