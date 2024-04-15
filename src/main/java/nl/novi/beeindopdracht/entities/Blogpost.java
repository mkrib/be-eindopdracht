package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Blogpost {
    private Long id;
    private String title;
    private String content;
    private String previewText;

}
