package ru.mirea.alfabank.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.modeldata.AccountModel;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.modeldata.DAOAccount;
import ru.mirea.alfabank.modeldata.DAOClient;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements  AccountService{
    private final DAOAccount daoAccount;
    private final DAOClient daoClient;
    @Override
    public List<AccountModel> check(ClientModel clientModel) {
        ClientEntity clientEntity= daoClient.findByEmail(clientModel.getEmail());
        List<AccountModel> scores= new ArrayList<>();
        for(AccountEntity accountEntity: clientEntity.getAccountEntities()){
            AccountModel accountModel= AccountModel.builder()
                    .email(clientEntity.getEmail())
                    .score(accountEntity.getScore())
                    .password(null)
                    .build();
            scores.add(accountModel);
        }
        return scores;
    }
    @Override
    public String addAccount(ClientModel clientModel) {
        ClientEntity clientEntity= daoClient.findByEmail(clientModel.getEmail());
        AccountEntity accountEntity= AccountEntity.builder()
                .clientEntity(clientEntity)
                .score(0)
                .build();
        daoAccount.save(accountEntity);
        List<AccountEntity> accountEntityList=clientEntity.getAccountEntities();
        accountEntityList.add(accountEntity);
        clientEntity.setAccountEntities(accountEntityList);
        daoClient.save(clientEntity);
        return "Счет создан";
    }
}
