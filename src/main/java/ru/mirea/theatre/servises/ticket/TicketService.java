package ru.mirea.theatre.servises.ticket;

import ru.mirea.theatre.entities.TicketEntity;

import java.time.LocalDateTime;

public interface TicketService {
    TicketEntity createTicket(int perfomanceId, String email, String dateString, int row, int column, int price);
}
