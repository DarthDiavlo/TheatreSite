package ru.mirea.alfabank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.ClientEntity;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByEmail(String email);
    ClientEntity findByAge(int age);
    ClientEntity findByGender(int gender);
}
