package ru.mirea.alfabank.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="transactions")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;
    @ManyToOne
    @JoinColumn(name = "id_clientsourse")
    private ClientEntity sourse;
    @ManyToOne
    @JoinColumn(name = "id_sourseaccount")
    private AccountEntity sourseaccount;
    @ManyToOne
    @JoinColumn(name = "id_clientdestination")
    private ClientEntity destination;
    @ManyToOne
    @JoinColumn(name = "id_destinationaccoun")
    private AccountEntity destinationaccount;
    @Column(name="summa")
    private int summa;
}
