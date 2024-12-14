package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.PerfomanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfomanceRepository extends JpaRepository<PerfomanceEntity, Integer> {
    PerfomanceEntity findById(int id);

}
