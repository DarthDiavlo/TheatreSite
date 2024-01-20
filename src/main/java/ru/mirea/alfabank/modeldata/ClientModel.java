package ru.mirea.alfabank.modeldata;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    String email;
    String password;
}
