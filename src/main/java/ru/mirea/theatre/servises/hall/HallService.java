package ru.mirea.theatre.servises.hall;

import ru.mirea.theatre.entities.HallEntity;

import java.util.List;

public interface HallService {
    HallEntity createHall(HallEntity hall);
    List<HallEntity> getAllHalls();
    HallEntity getHallById(int id);
    HallEntity updateHall(int id, HallEntity updatedHall);
    void deleteHall(int id);
}
