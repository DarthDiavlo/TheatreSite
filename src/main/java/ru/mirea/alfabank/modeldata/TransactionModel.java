package ru.mirea.alfabank.modeldata;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {
    String email;
    int sourseID;
    int destinationID;
    int summa;
    String password;
}
