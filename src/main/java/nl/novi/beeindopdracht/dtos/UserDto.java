package nl.novi.beeindopdracht.dtos;

import nl.novi.beeindopdracht.entities.Blogpost;
import nl.novi.beeindopdracht.entities.Reservation;
import nl.novi.beeindopdracht.entities.Review;
import nl.novi.beeindopdracht.entities.Role;

import java.util.List;
import java.util.Set;

public class UserDto {

    public String username;
    //    public String password;
    public String apiKey;
    public Set<Role> roles;
    public List<Reservation> reservations;
    public List<Review> reviews;
    public List<Blogpost> blogposts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Blogpost> getBlogposts() {
        return blogposts;
    }

    public void setBlogposts(List<Blogpost> blogposts) {
        this.blogposts = blogposts;
    }
}

