package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.PerfomanceEntity;
import ru.mirea.theatre.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.theatre.entities.UserEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    TicketEntity findById(int id);
}
