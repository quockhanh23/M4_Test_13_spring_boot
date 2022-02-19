package com.example.test_13_fruit_spring_boot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String made;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
