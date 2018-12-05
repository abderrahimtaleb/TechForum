package com.big.data.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Commentaire {

    private Long id;
    private User auteur;

    @JsonIgnore
    private Post post;

    private String dateCreation;
    private String text;
    private String image;
    private String video;
    private List<Commentaire> reponses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
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

    public List<Commentaire> getReponses() {
        return reponses;
    }

    public void setReponses(List<Commentaire> reponses) {
        this.reponses = reponses;
    }
}
