package ru.mirea.alfabank.security.jwt;

import ru.mirea.alfabank.modeldata.ClientModel;

public interface JWTService {
    String generateToken(ClientModel userModel);
    ClientModel parseToke(String jwt);
}
