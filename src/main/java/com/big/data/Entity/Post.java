package com.big.data.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

public class Post {

    private String id;
    private String titre;
    private String datePublication;
    private String text;
    private String image;
    private String video;
    private User auteur;
    @JsonIgnore
    private Set<User> usersLiked;
    @JsonIgnoreProperties("post")
    private Set<Commentaire> commentaires;

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<User> getUsersLiked() {
        return usersLiked;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void likedBy(User user) {
        if (usersLiked == null) {
            usersLiked = new HashSet<>();
        }
        usersLiked.add(user);
    }

    public void commentedBy(Commentaire commentaire) {
        if (commentaires == null) {
            commentaires = new HashSet<>();
        }
        commentaires.add(commentaire);
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
