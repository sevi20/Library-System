package com.sevim.librarymanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sevim.librarymanagementsystem.entity.Book;
import com.sevim.librarymanagementsystem.exception.NotFoundException;
import com.sevim.librarymanagementsystem.repository.BookRepository;
import com.sevim.librarymanagementsystem.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> searchBooks(String keyword) {
		if (keyword != null) {
			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}

	@Override
	public List<Book> filterByCategoryAndAuthor(Long categoryId, Long authorId) {
		if (categoryId != null && authorId != null) {
			// Handle the case where either categoryId or name is null, you might throw an exception or return an empty list
			return bookRepository.findBooksByCategoryIdAndAuthorId(categoryId, authorId);
		}
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
	}

	@Override
	public void createBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		final Book book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

		bookRepository.deleteById(book.getId());
	}

}
