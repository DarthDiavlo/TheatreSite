package ru.mirea.alfabank.modeldata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.Entities.TransactionEntity;
import ru.mirea.alfabank.repositories.TransactionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DAOTransaction {
    private  final TransactionRepository transactionRepository;
    public void save(TransactionEntity transactionEntity){
        transactionRepository.save(transactionEntity);
    }
    public TransactionEntity findById(int id){
        return transactionRepository.findById(id).get();
    }
    public List<TransactionEntity> findAllSourse(ClientEntity clientEntity){
        return (List<TransactionEntity>) transactionRepository.findBySourse(clientEntity);
    }
    public List<TransactionEntity> findAllDestination(ClientEntity clientEntity){
        return (List<TransactionEntity>) transactionRepository.findByDestination(clientEntity);
    }
    public  void delete(TransactionEntity transactionEntity){
        transactionRepository.delete(transactionEntity);
    }
}
