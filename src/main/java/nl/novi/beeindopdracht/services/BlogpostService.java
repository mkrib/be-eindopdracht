package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.entities.Blogpost;
import nl.novi.beeindopdracht.entities.Review;
import nl.novi.beeindopdracht.exceptions.RecordNotFoundException;
import nl.novi.beeindopdracht.repositories.BlogpostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogpostService {
    private final BlogpostRepository blogpostRepository;

    public BlogpostService(BlogpostRepository blogpostRepository) {
        this.blogpostRepository = blogpostRepository;
    }

    //    GET
    public List<Blogpost> getBlogPosts() {
        return blogpostRepository.findAll();
    }

    public Blogpost getBlogpost(Long id) {
        return blogpostRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Blogpost not found"));
    }

    //    POST
    public Blogpost addBlogpost(Blogpost blogpost) {
        blogpostRepository.save(blogpost);
        return blogpost;
    }

    //    DELETE
    public void deleteBlogpostById(Long id) {
        blogpostRepository.deleteById(id);
    }
}
