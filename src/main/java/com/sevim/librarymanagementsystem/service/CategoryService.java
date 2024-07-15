package com.sevim.librarymanagementsystem.service;

import java.util.List;

import com.sevim.librarymanagementsystem.entity.Category;
import org.springframework.stereotype.Service;

public interface CategoryService {

	public List<Category> findAllCategories();
	public List<Category> searchCategory(String text);
	public Category findCategoryById(Long id);

	public void createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Long id);

}
