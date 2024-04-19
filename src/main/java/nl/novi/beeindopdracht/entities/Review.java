package nl.novi.beeindopdracht.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String content;
    private Date issueDate;
}
