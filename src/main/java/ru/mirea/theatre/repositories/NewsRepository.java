package ru.mirea.theatre.repositories;

import ru.mirea.theatre.entities.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
    NewsEntity findById(NewsEntity newsEntity);
}