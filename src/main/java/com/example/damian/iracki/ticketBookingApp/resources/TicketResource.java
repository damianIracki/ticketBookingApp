package com.example.damian.iracki.ticketBookingApp.resources;


import com.example.damian.iracki.ticketBookingApp.dto.TicketDto;
import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.services.ScreeningService;
import com.example.damian.iracki.ticketBookingApp.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketResource {

    private final TicketService ticketService;
    private final ScreeningService screeningService;

    @Autowired
    public TicketResource(TicketService ticketService, ScreeningService screeningService) {
        this.ticketService = ticketService;
        this.screeningService = screeningService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping("/addTickets")
    public String addTickets(@RequestBody List<TicketDto> ticketDtos){
        List<Ticket> tickets = mapAllTicketDtoToTicket(ticketDtos);
        ticketService.addNewTickets(tickets);
        BigDecimal price = new BigDecimal(0);
        for (Ticket ticket : tickets) {
            price = price.add(ticket.getTypeOfTicket().getPrice());
        }
        Screening screening = screeningService.findScreeningById(tickets.get(0).getScreeningId());
        return "redirect: /ticket/summary?price=" + price + "&screeningId=" + screening.getId();
    }

    @GetMapping("/summary")
    public String getSummary(@RequestParam BigDecimal price, @RequestParam Long screeningId){
        StringBuilder stringBuilder = new StringBuilder();

        String priceMessage = "Your summary to pay: " + price.toString() + "PLN.<br>";

        Screening screening = screeningService.findScreeningById(screeningId);
        LocalDateTime paymentDeadline = screening.getStartingDateTime().minusDays(1);
        String deadline = "You must make the payment by " + paymentDeadline.getDayOfMonth() + "-"
                + paymentDeadline.getMonth() + " at the latest";

        stringBuilder.append(priceMessage);
        stringBuilder.append(deadline);
        return stringBuilder.toString();
    }

    private List<Ticket> mapAllTicketDtoToTicket(List<TicketDto> ticketDtos){
        List<Ticket> tickets = new ArrayList<>();
        for (TicketDto ticketDto : ticketDtos) {
            Ticket ticket = ticketDto.mapTicketDtoToTicket(ticketDto);
            tickets.add(ticket);
        }
        return tickets;
    }
}
