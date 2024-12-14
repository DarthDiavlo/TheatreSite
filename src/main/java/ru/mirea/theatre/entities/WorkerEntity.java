package ru.mirea.theatre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="workers")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="age")
    private int age;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="post")
    private String post;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "worker_perfomance", // Название промежуточной таблицы
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "perfomancee_id")
    )
    private Set<PerfomanceEntity> perfomances = new HashSet<>();
}
