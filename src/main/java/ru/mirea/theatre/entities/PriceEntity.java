package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="prices")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @OneToOne()
    @JoinColumn(name = "id_perfomance")
    private PerfomanceEntity perfomanceEntity;
    @Column(name="parterre_price")
    private int parterrePrice;
    @Column(name="balcony_price")
    private int balconyPrice;
    @Column(name="amphitheater_price")
    private int amphitheaterPrice;
    @Column(name="beletage_price")
    private int beletagePrice;
    @Column(name="benoirloge_price")
    private int benoirlogePrice;
}
