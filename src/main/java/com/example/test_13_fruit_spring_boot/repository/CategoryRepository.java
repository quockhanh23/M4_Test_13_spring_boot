package com.example.test_13_fruit_spring_boot.repository;

import com.example.test_13_fruit_spring_boot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
