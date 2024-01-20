package ru.mirea.alfabank.controles;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.alfabank.modeldata.AccountModel;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.modeldata.TransactionModel;
import ru.mirea.alfabank.servises.ClientService;
import ru.mirea.alfabank.servises.TransactionService;

@Controller
@RequestMapping("/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final ClientService clientService;
    @PostMapping()
    public ResponseEntity trans(@RequestBody TransactionModel transactionModel){
        ClientModel clientModel=ClientModel.builder()
                .email(transactionModel.getEmail())
                .password(transactionModel.getPassword())
                .build();
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok(transactionService.trans(transactionModel));
        }else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
    @PostMapping("/putMoney")
    public ResponseEntity putMoney(@RequestBody AccountModel accountModel){
        ClientModel clientModel=ClientModel.builder()
                .email(accountModel.getEmail())
                .password(accountModel.getPassword())
                .build();
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok(transactionService.putMoney(accountModel));
        }else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
    @PostMapping("/takeMoney")
    public ResponseEntity takeMoney(@RequestBody AccountModel accountModel){
        ClientModel clientModel=ClientModel.builder()
                .email(accountModel.getEmail())
                .password(accountModel.getPassword())
                .build();
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok(transactionService.takeMoney(accountModel));
        }else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
}
