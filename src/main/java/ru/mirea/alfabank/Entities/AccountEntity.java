package ru.mirea.alfabank.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="accounts")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="score")
    private int score;
    @ManyToOne()
    @JoinColumn(name = "id_client")
    private ClientEntity clientEntity;
}
