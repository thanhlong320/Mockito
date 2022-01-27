package com.axonactive.mockito.dao;

import com.axonactive.mockito.entities.Department;

import javax.persistence.*;

public class DepartmentDAOImpl implements DepartmentDAO{

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public Department findDepartmentById(Long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public Department insertDepartment(Department department) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityManager.persist(department);
        entityTransaction.commit();
        return findDepartmentById(department.getId());
    }

}
