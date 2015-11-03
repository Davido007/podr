package com.travelo.daos;

import com.travelo.entities.EmployeeEntity;

import java.util.List;

/**
 * Created by ddph on 03/11/2015.
 */
public interface EmployeeDAO
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}