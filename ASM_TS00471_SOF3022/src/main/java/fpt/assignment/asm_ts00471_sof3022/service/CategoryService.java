package fpt.assignment.asm_ts00471_sof3022.service;

import fpt.assignment.asm_ts00471_sof3022.model.Category;
import fpt.assignment.asm_ts00471_sof3022.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
