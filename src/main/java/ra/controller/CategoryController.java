package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.service.category.ICategoryService;
import ra.model.service.post.IPostService;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @GetMapping()
    public ModelAndView categoryList() {
        Iterable<Category> categories = categoryService.findAll();
        return new ModelAndView("Category/list","categories",categories);
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        return new ModelAndView("Category/add","category",new Category());
    }

    @PostMapping("/add")
    public ModelAndView saveCat(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("Category/add");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("Category/edit","category",category.get());
    }


    @PostMapping("/update")
    public ModelAndView updateProvince(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("Category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }


}
