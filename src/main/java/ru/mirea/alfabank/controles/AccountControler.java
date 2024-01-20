package ru.mirea.alfabank.controles;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.servises.AccountService;
import ru.mirea.alfabank.servises.ClientService;

@Controller
@RequiredArgsConstructor
public class AccountControler {
    private final AccountService accountService;
    private final ClientService clientService;
    @PostMapping("/v1/account")
    public ResponseEntity check(@RequestBody ClientModel clientModel){
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok(accountService.check(clientModel).toString());
        } else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
    @PostMapping("/v1/account/add")
    public ResponseEntity add(@RequestBody ClientModel clientModel){
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok(accountService.addAccount(clientModel));
        } else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
}
