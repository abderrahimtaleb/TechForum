package com.big.data.Bean;

import com.big.data.Entity.User;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@NodeEntity
public class Commentaire {

    private Integer id;
    private User auteur;
    private String dateCreation;
    private String text;
    private String image;
    private String video;

    private List<Commentaire> reponses;

    public Commentaire(Integer id, User auteur, String dateCreation, String text, String image, String video, List<Commentaire> reponses) {
        this.id = id;
        this.auteur = auteur;
        this.dateCreation = dateCreation;
        this.text = text;
        this.image = image;
        this.video = video;
        this.reponses = reponses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
