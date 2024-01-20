package ru.mirea.alfabank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.Entities.TransactionEntity;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    TransactionEntity findBySourse(ClientEntity sourse);
    TransactionEntity findByDestination(ClientEntity destination);
}
