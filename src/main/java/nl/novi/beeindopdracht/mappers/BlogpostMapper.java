package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.BlogpostDto;
import nl.novi.beeindopdracht.dtos.BlogpostRequestDto;
import nl.novi.beeindopdracht.entities.Blogpost;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogpostMapper {

    //    Mapper om de blogpost om te zetten naar een dto, die we willen teruggeven aan de gebruiker
    public BlogpostDto translateToDto(Blogpost blogpost) {
        BlogpostDto dto = new BlogpostDto();
        dto.setId(blogpost.getId());
        dto.setTitle(blogpost.getTitle());
        dto.setContent(blogpost.getContent());
        dto.setPreviewText(blogpost.getPreviewText());

        return dto;
    }

    public List<BlogpostDto> translateToDtos(List<Blogpost> blogpostsList) {
        List<BlogpostDto> result = new ArrayList<>();
        for (Blogpost blogpost : blogpostsList) {
            result.add(translateToDto(blogpost));
        }
        return result;
    }

    //    Mapper om de request blogpost om te zetten naar een blogpost voor in de db
    public Blogpost translateToBlogpost(BlogpostRequestDto dto) {
        Blogpost blogpost = new Blogpost();

        blogpost.setTitle(dto.getTitle());
        blogpost.setContent(dto.getContent());
        blogpost.setPreviewText(dto.getPreviewText());
        blogpost.setUser(dto.getUser());

        return blogpost;
    }
}
