package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.PerfomanceEntity;
import ru.mirea.theatre.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
    PriceEntity findById(int id);
    PriceEntity findByPerfomanceEntity(PerfomanceEntity perfomanceEntity);
}
