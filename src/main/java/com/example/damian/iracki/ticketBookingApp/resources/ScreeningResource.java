package com.example.damian.iracki.ticketBookingApp.resources;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.ScreeningRoom;
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
    public ResponseEntity<List<Screening>> getScreeningsBetweenDate(@PathVariable("sortingType") String sortingType,
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

    @GetMapping("/find/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable("id") Long id){
        Screening screening = screeningService.findScreeningById(id);
        return new ResponseEntity<>(screening, HttpStatus.OK);
    }

    @GetMapping("/find/{screeningId}/screeningRoom")
    public ResponseEntity<ScreeningRoom> getScreeningRoomByScreeningId(@PathVariable("screeningId") Long id){
        ScreeningRoom screeningRoom = screeningService.findScreeningById(id).getScreeningRoom();
        return new ResponseEntity<>(screeningRoom, HttpStatus.OK);
    }

    @GetMapping("/find/{screeningId}/tableOfSeats")
    public ResponseEntity<String[][]> getAllTicket(@PathVariable("screeningId") Long screeningId){
        String[][] seats = screeningService.getTableOfSeatsByScreeningId(screeningId);
        for (int i = 0; i < seats.length; i++){
            for(int j = 1; j < seats[i].length-1; j++){
                if(seats[i][j].equals("UNAVAILABLE")){
                    continue;
                }
                if(seats[i][j-1].equals("UNAVAILABLE") && seats[i][j+1].equals("UNAVAILABLE")){
                    seats[i][j] = "UNAVAILABLE";
                }
            }
        }
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }
}
