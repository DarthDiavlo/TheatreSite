package ru.mirea.alfabank.servises;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.modeldata.DAOAccount;
import ru.mirea.alfabank.modeldata.DAOClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final DAOAccount daoAccount;
    private final DAOClient daoClient;
    @Override
    public String registr(ClientModel clientModel) {
        if(daoClient.findByEmail(clientModel.getEmail())==null){
            ClientEntity clientEntity = ClientEntity.builder()
                    .email(clientModel.getEmail())
                    .password(clientModel.getPassword())
                    .build();
            daoClient.save(clientEntity);
            AccountEntity accountEntity=AccountEntity.builder()
                    .clientEntity(clientEntity)
                    .score(0)
                    .build();
            List<AccountEntity> accountEntityList= new ArrayList<>();
            accountEntityList.add(accountEntity);
            clientEntity.setAccountEntities(accountEntityList);
            daoAccount.save(accountEntity);
            daoClient.save(clientEntity);
            return "Клиент успешно зарегистрирован";
        }else {return "Такой пользователь уже сущесвует";}
    }
    @Override
    public Boolean auth(ClientModel clientModel) {
        if (clientModel.getPassword().equals( daoClient.findByEmail(clientModel.getEmail()).getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
