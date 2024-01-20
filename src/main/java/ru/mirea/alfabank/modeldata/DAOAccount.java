package ru.mirea.alfabank.modeldata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.repositories.AccountRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DAOAccount {
    private  final AccountRepository accountRepository;
    public void save(AccountEntity accountEntity){
        accountRepository.save(accountEntity);
    }
    public AccountEntity findById(int id){
        return accountRepository.findById(id).get();
    }
    public List<AccountEntity> findAllClientEntity(ClientEntity clientEntity){
        return (List<AccountEntity>) accountRepository.findByClientEntity(clientEntity);
    }
    public  void delete(AccountEntity accountEntity){
        accountRepository.delete(accountEntity);
    }
}
