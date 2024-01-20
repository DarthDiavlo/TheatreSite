package ru.mirea.alfabank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.ClientEntity;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findByClientEntity(ClientEntity clientEntity);
}
