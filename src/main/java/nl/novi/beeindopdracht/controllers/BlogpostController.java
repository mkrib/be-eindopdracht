package nl.novi.beeindopdracht.controllers;

import jakarta.validation.Valid;
import nl.novi.beeindopdracht.dtos.BlogpostDto;
import nl.novi.beeindopdracht.dtos.BlogpostRequestDto;
import nl.novi.beeindopdracht.entities.Blogpost;
import nl.novi.beeindopdracht.mappers.BlogpostMapper;
import nl.novi.beeindopdracht.services.BlogpostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogpostController {
    private final BlogpostService blogpostService;
    private final BlogpostMapper blogpostMapper;

    public BlogpostController(BlogpostService blogpostService, BlogpostMapper blogpostMapper) {
        this.blogpostService = blogpostService;
        this.blogpostMapper = blogpostMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<BlogpostDto>> getBlogposts() {
        List<Blogpost> blogposts = blogpostService.getBlogPosts();
        List<BlogpostDto> blogpostDtos = blogpostMapper.translateToDtos(blogposts);

        return ResponseEntity.ok().body(blogpostDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogpost> getBlogpost(@PathVariable Long id) {
        return ResponseEntity.ok(blogpostService.getBlogpost(id));
    }

    @PostMapping("")
    public ResponseEntity<BlogpostDto> addBlogpost(@Valid @RequestBody BlogpostRequestDto blogpostRequestDto) {
        Blogpost postedBlog = blogpostService.addBlogpost(blogpostMapper.translateToBlogpost(blogpostRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(blogpostMapper.translateToDto(postedBlog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBlogpost(@PathVariable Long id) {
        blogpostService.deleteBlogpostById(id);
        return ResponseEntity.noContent().build();
    }

}
