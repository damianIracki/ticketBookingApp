package com.example.damian.iracki.ticketBookingApp.resources;


import com.example.damian.iracki.ticketBookingApp.dto.TicketDto;
import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.Ticket;
import com.example.damian.iracki.ticketBookingApp.services.ScreeningService;
import com.example.damian.iracki.ticketBookingApp.services.TicketService;
import com.example.damian.iracki.ticketBookingApp.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketResource {

    private final TicketService ticketService;
    private final ScreeningService screeningService;

    @Autowired
    public TicketResource(TicketService ticketService, ScreeningService screeningService) {
        this.ticketService = ticketService;
        this.screeningService = screeningService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/")
    public String addTickets(@RequestBody List<TicketDto> ticketDtos){
        if(ticketDtos.size() < 1){
            throw  new IllegalStateException("You must book one ticket at least");
        }
        List<Ticket> tickets = mapAllTicketDtoToTicket(ticketDtos);
        Screening screening = screeningService.findScreeningById(tickets.get(0).getScreeningId());
        TicketValidator ticketValidator = new TicketValidator();
        for (Ticket ticket : tickets) {
            if(ticketValidator.checkTicket(ticket, screening, LocalDateTime.now())){
                ticketService.addNewTicket(ticket);
            }
        }
        BigDecimal price = getTotalPrice(tickets);
        return "redirect: /ticket/summary?price=" + price + "&screeningId=" + screening.getId();
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary(@RequestParam BigDecimal price, @RequestParam Long screeningId){
        Screening screening = screeningService.findScreeningById(screeningId);
        LocalDateTime deadline = screening.getStartingDateTime().minusMinutes(15);

        Map<String, Object> summaryMap = new HashMap<>();
        summaryMap.put("price", price);
        summaryMap.put("deadline", deadline);

        return summaryMap;
    }

    private List<Ticket> mapAllTicketDtoToTicket(List<TicketDto> ticketDtos){
        List<Ticket> tickets = new ArrayList<>();
        for (TicketDto ticketDto : ticketDtos) {
            Ticket ticket = ticketDto.mapTicketDtoToTicket(ticketDto);
            tickets.add(ticket);
        }
        return tickets;
    }

    private BigDecimal getTotalPrice(List<Ticket> tickets){
        BigDecimal price = new BigDecimal(0);
        for (Ticket ticket : tickets) {
            price = price.add(ticket.getTypeOfTicket().getPrice());
        }
        return price;
    }
}