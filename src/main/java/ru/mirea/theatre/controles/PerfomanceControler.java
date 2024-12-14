package ru.mirea.theatre.controles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.theatre.entities.HallEntity;
import ru.mirea.theatre.entities.PerfomanceEntity;
import ru.mirea.theatre.modeldata.PerfomanceDTO;
import ru.mirea.theatre.servises.perfomance.PerfomanceService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/perfomances")
public class PerfomanceControler {

    private final PerfomanceService perfomanceService;

    @PostMapping("/create")
    public ResponseEntity<PerfomanceDTO> createPerfomance(
            @RequestParam("name") String name,
            @RequestParam("date") LocalDateTime date,
            @RequestParam("decription") String decription,
            @RequestParam("hallEntity") HallEntity hallEntity,
            @RequestParam("ticketsLeft") int ticketsLeft,
            @RequestParam("minPrice") int minPrice,
            @RequestParam("maxPrice") int maxPrice,
            @RequestParam("style") String style,
            @RequestParam("image") MultipartFile imageFile) throws IOException {
        PerfomanceEntity createdPerfomance = perfomanceService.createPerfomance(
                name, date, decription, hallEntity, ticketsLeft, minPrice, maxPrice, style, imageFile);
        return ResponseEntity.ok(convertToDTO(createdPerfomance));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PerfomanceDTO>> getAllPerfomances() {
        List<PerfomanceEntity> perfomances = perfomanceService.getAllPerfomances();
        List<PerfomanceDTO> perfomanceDTOs = perfomances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(perfomanceDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfomanceDTO> getPerfomanceById(@PathVariable int id) {
        Optional<PerfomanceEntity> perfomanceOptional = perfomanceService.getPerfomanceById(id);
        return perfomanceOptional.map(perfomance -> ResponseEntity.ok(convertToDTO(perfomance)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private PerfomanceDTO convertToDTO(PerfomanceEntity perfomance) {
        PerfomanceDTO dto = new PerfomanceDTO();
        dto.setId(perfomance.getId());
        dto.setName(perfomance.getName());
        dto.setDate(perfomance.getDate());
        dto.setDecription(perfomance.getDecription());
        dto.setTicketsLeft(perfomance.getTicketsLeft());
        dto.setMinPrice(perfomance.getMinPrice());
        dto.setMaxPrice(perfomance.getMaxPrice());
        dto.setStyle(perfomance.getStyle());
        dto.setWorkerNames(perfomance.getWorkerNames());
        dto.setImageBase64(Base64.getEncoder().encodeToString(perfomance.getImage()));
        return dto;
    }
}