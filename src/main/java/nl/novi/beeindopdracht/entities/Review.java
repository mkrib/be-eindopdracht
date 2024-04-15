package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Review {
    private String fullName;
    private String content;
    private Date issueDate;
}
