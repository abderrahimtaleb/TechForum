package com.big.data.Bean;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.List;

@RelationshipEntity(type = "commented_by")
public class Commentaire {

    private Long id;
    @StartNode
    private User auteur;

    @JsonIgnore
    @EndNode
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
