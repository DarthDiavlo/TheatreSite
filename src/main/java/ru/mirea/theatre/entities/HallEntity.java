package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="halls")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="parterre_seats")
    private int parterreSeats;
    @Column(name="balcony_seats")
    private int balconySeats;
    @Column(name="amphitheater_seats")
    private int amphitheaterSeats;
    @Column(name="beletage_seats")
    private int beletageSeats;
    @Column(name="benoirloge_seats")
    private int benoirlogeSeats;
}
