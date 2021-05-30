package com.example.damian.iracki.ticketBookingApp.validators;

import com.example.damian.iracki.ticketBookingApp.entities.Screening;
import com.example.damian.iracki.ticketBookingApp.entities.Ticket;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicketValidator {

    public boolean checkTicket(Ticket ticket, Screening screening, LocalDateTime localDateTime){

        if(checkName(ticket) && checkSurname(ticket) && checkTicketDate(screening, localDateTime)
                && checkCorrectnessOfSeat(ticket,screening)){
            return true;
        }
        return false;
    }

    private boolean checkTicketDate(Screening screening, LocalDateTime localDateTime){
        if(!localDateTime.isBefore(screening.getStartingDateTime().minusMinutes(15))){
            throw new IllegalStateException("Is too late to book this ticket");
        }
        return true;
    }

    private boolean checkName(Ticket ticket){
        Pattern namePattern = Pattern.compile("[A-ZŁŚ][a-ąęółśżźćń]+");
        Matcher matcher = namePattern.matcher(ticket.getName());
        if(!matcher.matches()){
            throw new IllegalStateException("Name isn't correct. Name must begin at capital letter and can not" +
                    " be short than 3 characters");
        }
        return true;
    }

    private boolean checkSurname(Ticket ticket){
        Pattern twoPartSurnamePattern = Pattern.compile("[A-ZĆŁŚŻ][a-ąęółśżźćń]{2,}[-][A-ZĆŁŚŻ][a-ąęółśżźćń]{2,}");
        Pattern surnamePattern = Pattern.compile("[A-ZĆŁŚŻ][a-ąęółśżźćń]{2,}");
        Matcher surnameMatcher = surnamePattern.matcher(ticket.getSurname());
        Matcher twoPartSurnameMatcher = twoPartSurnamePattern.matcher(ticket.getSurname());
        if(!(surnameMatcher.matches() || twoPartSurnameMatcher.matches())){
            throw new IllegalStateException("Surname isn't correct. Surname must begin at capital letter and can not" +
                    " be short than 3 characters. Additionally to parts surname must be divided by \"-\" adn second part" +
                    " must begin at capital letter too");
        }
        return true;
    }

    private boolean checkCorrectnessOfSeat(Ticket ticket, Screening screening){
        if(ticket.getNumberOfRow() <= screening.getScreeningRoom().getRowCount()
                && ticket.getNumberOfSeatInRow() <= screening.getScreeningRoom().getSeatsInRowCount()
                && 0 < ticket.getNumberOfRow() && 0 < ticket.getNumberOfSeatInRow()){
            return true;
        } else {
            throw new IllegalStateException("Entered seats isn't correct");
        }
    }

}
