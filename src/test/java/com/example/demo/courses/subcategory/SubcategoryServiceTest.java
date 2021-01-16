package com.example.demo.courses.subcategory;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class SubcategoryServiceTest {
    @Autowired
    SubcategoryService subcategoryService;

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    public void init() {
        Category it = new Category("nameIT", "descriptionIT");
        Category it2 = new Category("nameIT2", "descriptionIT2");
        categoryRepository.save(it);
        categoryRepository.save(it2);

        Subcategory json = new Subcategory("nameJson", "descriptionJson", it);
        Subcategory json2 = new Subcategory("nameJson2", "descriptionJson", it);
        Subcategory json3 = new Subcategory("nameJson3", "descriptionJson", it);
        Subcategory javascript = new Subcategory("nameJavascript", "descriptionJavascript", it2);
        Subcategory javascript2 = new Subcategory("nameJavascript2", "descriptionJavascript", it2);
        subcategoryRepository.save(json);
        subcategoryRepository.save(json2);
        subcategoryRepository.save(json3);
        subcategoryRepository.save(javascript);
        subcategoryRepository.save(javascript2);
    }

    @Test
    public void shouldReturnSubcategoriesOnlyWithGivenCategory(){
    //when
        Optional<Category> it = categoryRepository.findCategoryByName("nameIT");
        List<SubcategoryDTO> result = subcategoryService.getSubcategory(it.get().getId());
    //then
        assertThat(result.size()).isEqualTo(3);
    }

}