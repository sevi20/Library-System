package com.sevim.librarymanagementsystem.service;

import java.util.List;

import com.sevim.librarymanagementsystem.entity.Book;

public interface BookService {

	public List<Book> findAllBooks();
	
	public List<Book> searchBooks(String keyword);

	public List<Book> filterByCategoryAndAuthor(Long categoryId, Long authorId);

	public Book findBookById(Long id);

	public void createBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Long id);

}
