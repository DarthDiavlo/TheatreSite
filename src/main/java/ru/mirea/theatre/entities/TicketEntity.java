package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.mirea.theatre.entities.PerfomanceEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;

    @Column(name = "id_perfomance", nullable = false)
    private int idPerfomance;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_time", nullable = false)
    private String dateTime;

    @Column(name = "point", nullable = false)
    private int column;

    @Column(name = "row", nullable = false)
    private int row;

    @Column(name = "price", nullable = false)
    private int price;
}