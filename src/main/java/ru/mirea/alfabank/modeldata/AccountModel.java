package ru.mirea.alfabank.modeldata;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {
    String email;
    int score;
    String password;
    int idAccount;
}
