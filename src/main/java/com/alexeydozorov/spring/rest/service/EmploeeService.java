package com.alexeydozorov.spring.rest.service;

import com.alexeydozorov.spring.rest.entity.Emploee;

import java.util.List;

public interface EmploeeService {
    public List<Emploee> getAllEmployees();

    public void saveEmloee(Emploee emploee);

    public Emploee getEmploee(int id);

    public void deleteEmploee(int id);
}
