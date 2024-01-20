package ru.mirea.alfabank.modeldata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mirea.alfabank.Entities.ClientEntity;
import ru.mirea.alfabank.repositories.ClientRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DAOClient {
    private  final ClientRepository clientRepository;
    public void save(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
    }
    public ClientEntity findById(int id){
        return clientRepository.findById(id).get();
    }
    public ClientEntity findByEmail(String email){
        return clientRepository.findByEmail(email);
    }
    public List<ClientEntity> findAllGender(int gender){
        return (List<ClientEntity>) clientRepository.findByGender(gender);
    }
    public List<ClientEntity> findAllAge(int age){
        return (List<ClientEntity>) clientRepository.findByAge(age);
    }
    public  void delete(ClientEntity clientEntity){
        clientRepository.delete(clientEntity);
    }
}
