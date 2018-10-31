package com.big.data.Entity;

import com.big.data.Bean.Commentaire;
import com.big.data.Bean.Contenu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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
    private List<Commentaire> commentaires;


    @Relationship(type = "own", direction = Relationship.INCOMING)
    private User auteur;

    @JsonIgnore
    @Relationship(type = "liked by", direction = Relationship.UNDIRECTED)
    private Set<User> usersLiked;

    @JsonIgnore
    @Relationship(type = "commented by", direction = Relationship.UNDIRECTED)
    private Set<User> usersCommented;


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

    public Set<User> getUsersCommented() {
        return usersCommented;
    }


    public void likedBy(User user) {
        if (usersLiked == null) {
            usersLiked = new HashSet<>();
        }
        usersLiked.add(user);
    }

    public void commentedBy(User user) {
        if (usersCommented == null) {
            usersCommented = new HashSet<>();
        }
        usersCommented.add(user);
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

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
