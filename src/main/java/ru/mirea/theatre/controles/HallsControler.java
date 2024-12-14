package ru.mirea.theatre.controles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.theatre.entities.HallEntity;
import ru.mirea.theatre.servises.hall.HallService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/halls")
@CrossOrigin(origins = "http://localhost:5173")
public class HallsControler {

    private final HallService hallService;

    @PostMapping("/create")
    public ResponseEntity<HallEntity> createHall(@RequestBody HallEntity hall) {
        HallEntity createdHall = hallService.createHall(hall);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHall);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HallEntity>> getAllHalls() {
        List<HallEntity> halls = hallService.getAllHalls();
        return ResponseEntity.ok(halls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallEntity> getHallById(@PathVariable int id) {
        HallEntity hall = hallService.getHallById(id);
        return ResponseEntity.ok(hall);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HallEntity> updateHall(@PathVariable int id, @RequestBody HallEntity updatedHall) {
        HallEntity hall = hallService.updateHall(id, updatedHall);
        return hall != null ? ResponseEntity.ok(hall) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHall(@PathVariable int id) {
        hallService.deleteHall(id);
        return ResponseEntity.noContent().build();
    }
}
