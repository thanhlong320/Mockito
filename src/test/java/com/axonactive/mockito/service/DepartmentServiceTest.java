package com.axonactive.mockito.service;

import com.axonactive.mockito.dao.DepartmentDAO;
import com.axonactive.mockito.entities.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.registry.infomodel.User;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentDAO departmentDAO;

    @Test
    public void insertDepartment(){
        Department department = new Department();
        department.setId(1L);
        department.setName("Long");
        department.setStartDate(LocalDate.of(2022, 01, 04));

        when(departmentDAO.insertDepartment(ArgumentMatchers.any(Department.class))).thenReturn(department);

        Department created = departmentService.insert(department);

        assertEquals(created.getName(), department.getName());
        verify(departmentDAO,times(1)).insertDepartment(department);
    }

    @Test()
    public void findDepartmentById(){
        Department department = new Department();
        department.setId(1L);
        department.setName("Long");
        department.setStartDate(LocalDate.of(2022, 01, 04));

        when(departmentDAO.findDepartmentById(ArgumentMatchers.any(Long.class))).thenReturn(department);

        Department expected = departmentService.findDepartmentById(department.getId());
        assertEquals(expected, department);
        verify(departmentDAO,times(1)).findDepartmentById(department.getId());
    }

    @Test
    public void insertDepartment_ShouldReturnException(){
        Department department = new Department();
        department.setId(1L);
        department.setName("Long");
        department.setStartDate(LocalDate.of(2022, 01, 04));

        when(departmentDAO.insertDepartment(department)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> departmentService.insert(department));

    }
}