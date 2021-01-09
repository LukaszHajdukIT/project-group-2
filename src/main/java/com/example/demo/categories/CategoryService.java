package com.example.demo.categories;

 class CategoryService {

    private final CategoryRepository categoryRepository;

     CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    void addCourseCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(coursesCategories(categoryDTO));
    }

    private Category coursesCategories(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }
}
