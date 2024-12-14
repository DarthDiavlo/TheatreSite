package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {
    FeedbackEntity findById(int id);
}
