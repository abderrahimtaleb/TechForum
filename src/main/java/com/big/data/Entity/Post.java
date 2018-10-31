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
    private Contenu contenu;
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

    public Post(Long id, User auteur, String titre, String datePublication, Contenu contenu, List<Commentaire> commentaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.contenu = contenu;
        this.commentaires = commentaires;
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

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
