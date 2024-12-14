package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, Integer> {
        HallEntity findById(int id);
}
