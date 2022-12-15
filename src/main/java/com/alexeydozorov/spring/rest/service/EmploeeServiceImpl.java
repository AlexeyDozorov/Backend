package com.alexeydozorov.spring.rest.service;

import com.alexeydozorov.spring.rest.dao.EmploeeDAO;
import com.alexeydozorov.spring.rest.entity.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmploeeServiceImpl implements EmploeeService {

    @Autowired
    private EmploeeDAO emploeeDAO;

    @Override
    @Transactional
    public List<Emploee> getAllEmployees() {
        return emploeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmloee(Emploee emploee) {
        emploeeDAO.saveEmloee(emploee);
    }

    @Override
    @Transactional
    public Emploee getEmploee(int id) {
        return emploeeDAO.getEmploee(id);
    }

    @Override
    @Transactional
    public void deleteEmploee(int id) {
        emploeeDAO.deleteEmploee(id);
    }
}
