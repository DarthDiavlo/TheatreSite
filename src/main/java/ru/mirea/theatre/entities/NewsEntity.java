package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="news")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="shortDescription")
    private String shortDescription;
    @Column(name="fullDescription")
    private String fullDescription;
    @Column(name="date_time")
    private LocalDateTime dateTime;

    @Lob
    @Column(name = "image")
    private byte[] image;

}
