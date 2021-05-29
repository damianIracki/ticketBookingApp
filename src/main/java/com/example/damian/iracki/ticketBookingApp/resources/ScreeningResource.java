package com.example.damian.iracki.ticketBookingApp.resources;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Screening>> getAllScreenings(){
        List<Screening> screenings = screeningService.findAllScreening();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }
}
