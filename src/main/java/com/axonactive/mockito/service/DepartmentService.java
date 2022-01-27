package com.axonactive.mockito.service;

import com.axonactive.mockito.dao.DepartmentDAO;
import com.axonactive.mockito.entities.Department;

import javax.inject.Inject;

public class DepartmentService {

    @Inject
    private DepartmentDAO departmentDAO;

    public Department findDepartmentById(Long id){
        return departmentDAO.findDepartmentById(id);
    }

    public Department insert(Department department){
        return departmentDAO.insertDepartment(department);
    }
}
