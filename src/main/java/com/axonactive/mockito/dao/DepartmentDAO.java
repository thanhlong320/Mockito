package com.axonactive.mockito.dao;

import com.axonactive.mockito.entities.Department;


//This interface used to declare function to query data from your database

public interface DepartmentDAO {
    public Department findDepartmentById(Long id);
    public Department insertDepartment(Department department);
}
