package com.alexeydozorov.spring.rest.dao;

import com.alexeydozorov.spring.rest.entity.Emploee;

import java.util.List;

public interface EmploeeDAO {
    public List<Emploee> getAllEmployees();

    public void saveEmloee(Emploee emploee);

    public Emploee getEmploee(int id);

    public void deleteEmploee(int id);
}
