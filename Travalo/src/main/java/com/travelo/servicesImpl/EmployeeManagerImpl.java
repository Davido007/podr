package com.travelo.servicesImpl;

/**
 * Created by ddph on 03/11/2015.
 */
import java.util.List;

import com.travelo.daos.EmployeeDAO;
import com.travelo.entities.EmployeeEntity;
import com.travelo.services.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeManagerImpl implements EmployeeManager
{
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public void addEmployee(EmployeeEntity employee) {
        employeeDAO.addEmployee(employee);
    }
    @Override
    @Transactional
    public List<EmployeeEntity> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}