package nl.novi.beeindopdracht.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String previewText;

}
