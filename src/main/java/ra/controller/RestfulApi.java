package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Category;
import ra.model.entity.Post;
import ra.model.repository.IPostRepository;
import ra.model.service.category.ICategoryService;
import ra.model.service.post.IPostService;

import java.util.List;
import java.util.Optional;

@RestController
public class RestfulApi {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;
    @Autowired
    private IPostRepository postRepository;

    @GetMapping("/api/categories")
    public ResponseEntity<Iterable<Category>> categories() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<Iterable<Post>> posts() {
        List<Post> post = (List<Post>) postService.findAll();
        if (post.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> findCategoryById(@PathVariable Long id) {
        Optional<Post> postOptional = postService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(postOptional.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/by-category/{categoryId}")
    public List<Post> getPostsByCategory(@PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return postRepository.findByCategory(category);
    }

    @PostMapping("/api/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

}
