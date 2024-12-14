package ru.mirea.theatre.servises.ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.theatre.entities.PerfomanceEntity;
import ru.mirea.theatre.entities.TicketEntity;
import ru.mirea.theatre.repositories.PerfomanceRepository;
import ru.mirea.theatre.repositories.TicketRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public TicketEntity createTicket(int perfomanceId, String email, String dateString, int row, int column, int price) {

        // Создать новый билет
        TicketEntity ticket = new TicketEntity();
        ticket.setIdPerfomance(perfomanceId);
        ticket.setEmail(email);
        ticket.setDateTime(dateString);
        ticket.setRow(row);
        ticket.setColumn(column);
        ticket.setPrice(price);

        // Сохранить билет в базе данных
        TicketEntity savedTicket = ticketRepository.save(ticket);
        log.info("Билет успешно сохранен с ID: {}", savedTicket.getId());

        return savedTicket;
    }
}
