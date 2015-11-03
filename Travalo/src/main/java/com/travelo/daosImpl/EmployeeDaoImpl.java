package com.travelo.daosImpl;

/**
 * Created by ddph on 03/11/2015.
 */
import java.util.List;

import com.travelo.entities.EmployeeEntity;
import com.travelo.daos.EmployeeDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl implements EmployeeDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addEmployee(EmployeeEntity employee) {
        this.sessionFactory.getCurrentSession().save(employee);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
    }
    @Override
    public void deleteEmployee(Integer employeeId) {
        EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
                EmployeeEntity.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }
}