package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="perfomances")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfomanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="date_time")
    private LocalDateTime date;
    @Column(name="decription")
    private String decription;
    @ManyToOne()
    @JoinColumn(name = "id_hall")
    private HallEntity hallEntity;
    @Column(name="tickets_left")
    private int ticketsLeft;
    @Column(name="min_price")
    private int minPrice;
    @Column(name="max_price")
    private int maxPrice;
    @Column(name="style")
    private String style;

    @ManyToMany(mappedBy = "perfomances", fetch = FetchType.EAGER)
    private Set<WorkerEntity> workers = new HashSet<>();

    // Метод для получения имен работников
    public List<String> getWorkerNames() {
        return workers.stream()
                .map(worker -> worker.getFirstname() + " " + worker.getLastname())
                .collect(Collectors.toList());
    }

    @Lob
    @Column(name = "image")
    private byte[] image;

}
