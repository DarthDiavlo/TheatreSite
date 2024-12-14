package ru.mirea.theatre.servises.perfomance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.HallEntity;
import ru.mirea.theatre.entities.PerfomanceEntity;
import ru.mirea.theatre.repositories.PerfomanceRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerfomanceServiceImpl implements PerfomanceService {
    private final PerfomanceRepository perfomanceRepository;

    @Override
    public PerfomanceEntity createPerfomance(String name, LocalDateTime date, String decription, HallEntity hallEntity,
                                             int ticketsLeft, int minPrice, int maxPrice, String style,
                                             MultipartFile imageFile) throws IOException {
        PerfomanceEntity perfomance = new PerfomanceEntity();
        perfomance.setName(name);
        perfomance.setDate(date);
        perfomance.setDecription(decription);
        perfomance.setHallEntity(hallEntity);
        perfomance.setTicketsLeft(ticketsLeft);
        perfomance.setMinPrice(minPrice);
        perfomance.setMaxPrice(maxPrice);
        perfomance.setStyle(style);

        if (imageFile != null && !imageFile.isEmpty()) {
            perfomance.setImage(imageFile.getBytes());
        }
        return perfomanceRepository.save(perfomance);
    }

    @Override
    public List<PerfomanceEntity> getAllPerfomances() {
        return perfomanceRepository.findAll();
    }

    @Override
    public Optional<PerfomanceEntity> getPerfomanceById(int id) {
        return Optional.ofNullable(perfomanceRepository.findById(id));
    }
}