package com.sevim.librarymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sevim.librarymanagementsystem.entity.Book;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.name LIKE %?1%" + " OR b.isbn LIKE %?1%" + " OR b.serialName LIKE %?1%")
	public List<Book> search(String keyword);

	@Query("SELECT DISTINCT b FROM Book b " +
			"JOIN b.authors a " +
			"JOIN b.categories c " +
			"WHERE c.id = :categoryId AND a.id = :authorId")
	List<Book> findBooksByCategoryIdAndAuthorId(@Param("categoryId") Long categoryId,
												@Param("authorId") Long authorId);
}
