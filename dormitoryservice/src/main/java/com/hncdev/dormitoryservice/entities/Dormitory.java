package com.hncdev.dormitoryservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "dormitories")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dormitory_id")
    private String dormitoryId;

    @Column(name = "dormitory_name")
    private String dormitoryName;

    @Column(name = "dormitory_type")
    private String dormitoryType;

    @Column(name = "capacity")
    private int capacity;
}
