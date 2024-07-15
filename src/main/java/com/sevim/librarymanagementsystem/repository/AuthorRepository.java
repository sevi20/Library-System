package com.sevim.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevim.librarymanagementsystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
