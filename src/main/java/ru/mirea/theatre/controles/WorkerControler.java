package ru.mirea.theatre.controles;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.theatre.entities.WorkerEntity;
import ru.mirea.theatre.servises.worker.WorkerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/workers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class WorkerControler {
    private final WorkerService workerService;

    // Эндпоинт для создания нового работника
    @PostMapping("/create")
    public ResponseEntity<WorkerEntity> createWorker(@RequestBody WorkerEntity worker) {
        WorkerEntity createdWorker = workerService.createWorker(worker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorker);
    }

    // Эндпоинт для получения всех работников
    @GetMapping("/all")
    public ResponseEntity<List<WorkerEntity>> getAllWorkers() {
        List<WorkerEntity> workers = workerService.getAllWorkers();
        return ResponseEntity.ok(workers);
    }

    // Эндпоинт для получения работника по ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkerEntity> getWorkerById(@PathVariable int id) {
        Optional<WorkerEntity> worker = workerService.getWorkerById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Эндпоинт для обновления работника
    @PutMapping("/{id}")
    public ResponseEntity<WorkerEntity> updateWorker(@PathVariable int id, @RequestBody WorkerEntity updatedWorker) {
        WorkerEntity worker = workerService.updateWorker(id, updatedWorker);
        return worker != null ? ResponseEntity.ok(worker) : ResponseEntity.notFound().build();
    }

    // Эндпоинт для удаления работника
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable int id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }
}
