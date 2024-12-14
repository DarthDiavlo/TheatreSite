package ru.mirea.theatre.servises.hall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.theatre.entities.HallEntity;
import ru.mirea.theatre.modeldata.NewsModel;
import ru.mirea.theatre.repositories.HallRepository;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HallServiceImpl implements HallService{
    private final HallRepository hallRepository;

    @Override
    public HallEntity createHall(HallEntity hall) {
        return hallRepository.save(hall);
    }

    @Override
    public List<HallEntity> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public HallEntity getHallById(int id) {
        return hallRepository.findById(id);
    }

    @Override
    public HallEntity updateHall(int id, HallEntity updatedHall) {
        if (hallRepository.existsById(id)) {
            updatedHall.setId(id);
            return hallRepository.save(updatedHall);
        }
        return null;
    }

    @Override
    public void deleteHall(int id) {
        hallRepository.deleteById(id);
    }
}
