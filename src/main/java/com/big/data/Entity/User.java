package com.big.data.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private String id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String login;
    private String password;
    private String profil;

    @JsonIgnore
    public Set<User> followers;
    @JsonIgnore
    public Set<Post> postsSaved;
    private String email;

    public User() {
    }

    public User(String id, String nom, String prenom, String dateNaissance, String login, String password, String profil) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.login = login;
        this.password = password;
        this.profil = profil;
    }

    public void follow(User user) {
        if (followers == null) {
            followers = new HashSet<>();
        }
        followers.add(user);
    }

    public void savePost(Post post) {
        if (postsSaved == null) {
            postsSaved = new HashSet<>();
        }
        postsSaved.add(post);
    }

    public Set<Post> getPostsSaved() {
        return postsSaved;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
