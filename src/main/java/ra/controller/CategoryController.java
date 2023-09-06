package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.entity.Post;
import ra.model.service.category.ICategoryService;
import ra.model.service.post.IPostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> categories() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);

    }

//    @GetMapping("/add")
//    public ModelAndView showAddForm() {
//        return new ModelAndView("Category/add","category",new Category());
//    }

//    @PostMapping("/add")
//    public ModelAndView saveCat(@ModelAttribute("category") Category category) {
//        categoryService.save(category);
//
//        ModelAndView modelAndView = new ModelAndView("Category/add");
//        modelAndView.addObject("category", new Category());
//        modelAndView.addObject("message", "New category created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Category> category = categoryService.findById(id);
//        return new ModelAndView("Category/edit","category",category.get());
//    }
//
//
//    @PostMapping("/update")
//    public ModelAndView updateProvince(@ModelAttribute("category") Category category) {
//        categoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("Category/edit");
//        modelAndView.addObject("category", category);
//        modelAndView.addObject("message", "Category updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        categoryService.delete(id);
//        return "redirect:/categories";
//    }


}
