package ru.mirea.theatre.servises.worker;

import ru.mirea.theatre.entities.WorkerEntity;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
    WorkerEntity createWorker(WorkerEntity worker);
    List<WorkerEntity> getAllWorkers();
    Optional<WorkerEntity> getWorkerById(int id);
    WorkerEntity updateWorker(int id, WorkerEntity updatedWorker);
    void deleteWorker(int id);
}
