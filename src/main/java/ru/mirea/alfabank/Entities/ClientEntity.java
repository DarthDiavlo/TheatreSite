package ru.mirea.alfabank.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="clients")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private int gender;
    @OneToMany()
    @JoinColumn(name = "accounts")
    private List<AccountEntity> accountEntities;
    @OneToMany
    @JoinColumn(name = "transactions")
    private List<TransactionEntity> transactionEntities;
}
