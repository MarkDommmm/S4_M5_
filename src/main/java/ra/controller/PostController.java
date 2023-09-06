package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.dto.PostDto;
import ra.model.entity.Category;
import ra.model.entity.Post;
import ra.model.service.category.ICategoryService;
import ra.model.service.post.IPostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> categories() {
        List<Post> categories = (List<Post>) postService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    @GetMapping()
//    public ModelAndView postList(@RequestParam("search") Optional<String> search, Pageable pageable) {
//        Page<Post> posts;
//        pageable = PageRequest.of(pageable.getPageNumber(), 5, Sort.by(Sort.Order.desc("creationDate")));
//        if (search.isPresent()) {
//            posts = postService.findAllByTitleContaining(search.get(), pageable);
//        } else {
//            posts = postService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("Post/list");
//        modelAndView.addObject("posts", posts);
//        return modelAndView;
//    }
//
//    @GetMapping("/detail/{id}")
//    public ModelAndView detail(@PathVariable Long id) {
//        return new ModelAndView("Post/detail", "post", postService.findById(id).get());
//    }
//
//    @GetMapping("/add")
//    public ModelAndView showAddForm() {
//        return new ModelAndView("Post/add", "post", new PostDto());
//    }
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute PostDto postDto) {
//        postService.save(postDto);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable Long id) {
//        return new ModelAndView("Post/edit", "post", postService.findById(id).get());
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute PostDto postDto) {
//        postService.save(postDto);
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        postService.delete(id);
//        return "redirect:/";
//    }
}
