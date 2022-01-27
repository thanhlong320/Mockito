package com.axonactive.mockito.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;
}