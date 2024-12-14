package ru.mirea.theatre.servises.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.theatre.entities.WorkerEntity;
import ru.mirea.theatre.repositories.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    @Override
    public WorkerEntity createWorker(WorkerEntity worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<WorkerEntity> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Optional<WorkerEntity> getWorkerById(int id) {
        return Optional.ofNullable(workerRepository.findById(id));
    }

    @Override
    public WorkerEntity updateWorker(int id, WorkerEntity updatedWorker) {
        if (workerRepository.existsById(id)) {
            updatedWorker.setId(id);
            return workerRepository.save(updatedWorker);
        }
        return null;
    }

    @Override
    public void deleteWorker(int id) {
        workerRepository.deleteById(id);
    }
}
