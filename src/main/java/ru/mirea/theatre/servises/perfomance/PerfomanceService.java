package ru.mirea.theatre.servises.perfomance;

import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.HallEntity;
import ru.mirea.theatre.entities.PerfomanceEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PerfomanceService {
    PerfomanceEntity createPerfomance(String name, LocalDateTime date,String decription, HallEntity hallEntity,
                                      int ticketsLeft, int minPrice, int maxPrice, String style,
                                      MultipartFile imageFile) throws IOException;
    List<PerfomanceEntity> getAllPerfomances();

    Optional<PerfomanceEntity> getPerfomanceById(int id);
}
