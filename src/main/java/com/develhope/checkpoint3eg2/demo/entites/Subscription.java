package com.develhope.checkpoint3eg2.demo.entites;

import jakarta.persistence.*;

@Entity
@Table
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;

    @ManyToOne
    private Newsletter newsletter;

    public Subscription(User user, Newsletter newsletter) {
        this.user = user;
        this.newsletter = newsletter;
    }

    public Subscription(){

    }
    public User getUser() {
        return user;
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }
}
