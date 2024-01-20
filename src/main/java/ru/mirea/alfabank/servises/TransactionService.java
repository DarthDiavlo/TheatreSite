package ru.mirea.alfabank.servises;

import ru.mirea.alfabank.modeldata.AccountModel;
import ru.mirea.alfabank.modeldata.TransactionModel;

public interface TransactionService {
    String trans(TransactionModel transactionModel);
    String putMoney(AccountModel accountModel);
    String takeMoney(AccountModel accountModel);
}
