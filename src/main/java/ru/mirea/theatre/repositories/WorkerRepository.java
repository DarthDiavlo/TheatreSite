package ru.mirea.theatre.repositories;


import ru.mirea.theatre.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer> {
    WorkerEntity findByFirstname(String firstname);
    WorkerEntity findById(int id);
}
