package ru.mirea.alfabank.servises;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mirea.alfabank.Entities.AccountEntity;
import ru.mirea.alfabank.Entities.TransactionEntity;
import ru.mirea.alfabank.modeldata.*;


@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements  TransactionService{
    private final DAOAccount daoAccount;
    private final DAOTransaction daoTransaction;
        @Override
        public String trans(TransactionModel transactionModel) {
            int moneyClient=daoAccount.findById(transactionModel.getSourseID()).getScore();
            if (moneyClient>transactionModel.getSumma()){
                TransactionEntity transactionEntity= TransactionEntity.builder()
                                .sourse(daoAccount.findById(transactionModel.getSourseID()).getClientEntity())
                                .destination(daoAccount.findById(transactionModel.getDestinationID()).getClientEntity())
                                .sourseaccount(daoAccount.findById(transactionModel.getSourseID()))
                                .destinationaccount(daoAccount.findById(transactionModel.getDestinationID()))
                                .summa(transactionModel.getSumma())
                                .build();
                daoTransaction.save(transactionEntity);
                AccountEntity accountEntity=daoAccount.findById(transactionModel.getDestinationID());
                accountEntity.setScore(accountEntity.getScore()+transactionModel.getSumma());
                daoAccount.save(accountEntity);
                accountEntity=daoAccount.findById(transactionModel.getSourseID());
                accountEntity.setScore(accountEntity.getScore()-transactionModel.getSumma());
                daoAccount.save(accountEntity);
                return "Транзакция прошла успешно";}
            else {return "Недостаточно средств";}
        }
    @Override
    public String putMoney(AccountModel accountModel) {
        AccountEntity accountEntity=daoAccount.findById(accountModel.getIdAccount());
        int money=accountEntity.getScore()+accountModel.getScore();
        accountEntity.setScore(money);
        daoAccount.save(accountEntity);
        return "Счет пополнен";
    }
    @Override
    public String takeMoney(AccountModel accountModel) {
        AccountEntity accountEntity=daoAccount.findById(accountModel.getIdAccount());
        if(accountEntity.getScore()>=accountModel.getScore()){
        accountEntity.setScore(accountEntity.getScore()-accountModel.getScore());
            daoAccount.save(accountEntity);
        return "Возьмите деньги";}
        return "Недостаточно средств";
    }
}
