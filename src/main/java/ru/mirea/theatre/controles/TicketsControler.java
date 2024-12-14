package ru.mirea.theatre.controles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.theatre.entities.TicketEntity;
import ru.mirea.theatre.servises.ticket.TicketService;

@RestController
@RequestMapping("/v1/tickets")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TicketsControler {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketEntity> createTicket(@RequestBody TicketRequest ticketRequest) {
        try {
            TicketEntity createdTicket = ticketService.createTicket(
                    ticketRequest.getPerfomanceId(),
                    ticketRequest.getEmail(),
                    ticketRequest.getDate(),
                    ticketRequest.getRow(),
                    ticketRequest.getColumn(),
                    ticketRequest.getPrice()
            );
            return ResponseEntity.ok(createdTicket);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Вспомогательный класс для запроса
    public static class TicketRequest {
        private int perfomanceId;
        private String email;
        private String date;
        private int row;
        private int column;
        private int price;

        // Геттеры и сеттеры
        public int getPerfomanceId() {
            return perfomanceId;
        }

        public void setPerfomanceId(int perfomanceId) {
            this.perfomanceId = perfomanceId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

}
