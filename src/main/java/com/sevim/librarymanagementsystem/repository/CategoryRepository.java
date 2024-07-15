package com.sevim.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevim.librarymanagementsystem.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.name LIKE %:text%")
    List<Category> findByTextContaining(@Param("text") String text);
}
