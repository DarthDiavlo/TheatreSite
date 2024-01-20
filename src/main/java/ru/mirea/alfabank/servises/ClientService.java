package ru.mirea.alfabank.servises;

import ru.mirea.alfabank.modeldata.ClientModel;

public interface ClientService {
    String registr(ClientModel clientModel);
    Boolean auth(ClientModel clientModel);
}
