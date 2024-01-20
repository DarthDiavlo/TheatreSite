package ru.mirea.alfabank.controles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.servises.ClientService;

@Controller
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/registr")
    public ResponseEntity registration(@RequestBody ClientModel clientModel){
        return ResponseEntity.ok(clientService.registr(clientModel));
    }
    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody ClientModel clientModel){
        if(clientService.auth(clientModel)){
            return ResponseEntity.ok("ВХод выполнен");
        }else { return ResponseEntity.ok("Введен неправильный логин или пароль");}
    }
}
