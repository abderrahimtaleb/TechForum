package com.big.data.Entity;

import com.big.data.Bean.Commentaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity
public class Post {

    private Long id;
    private String titre;
    private String datePublication;
    private String text;
    private String image;
    private String video;
    //private List<Commentaire> commentaires;


    @Relationship(type = "own", direction = Relationship.INCOMING)
    private User auteur;

    @Relationship(type = "liked by", direction = Relationship.UNDIRECTED)
    private Set<User> usersLiked;


    @JsonIgnoreProperties("post")
    @Relationship(type = "commented_by", direction = Relationship.UNDIRECTED)
    private List<Commentaire> commentaires;

    public Post() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsersLiked() {
        return usersLiked;
    }

    public List<Commentaire> getCommentaires() {
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
            commentaires = new ArrayList<>();
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
