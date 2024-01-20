package ru.mirea.alfabank.servises;

import ru.mirea.alfabank.modeldata.AccountModel;
import ru.mirea.alfabank.modeldata.ClientModel;

import java.util.List;

public interface AccountService {
    List<AccountModel> check(ClientModel clientModel);
    String addAccount(ClientModel clientModel);
}
