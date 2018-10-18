package com.big.data.Entity;

import com.big.data.Bean.Commentaire;
import com.big.data.Bean.Contenu;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@NodeEntity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String titre;
    private String datePublication;
    private Contenu contenu;
    private List<Commentaire> commentaires;

    @Relationship(type = "own", direction = Relationship.UNDIRECTED)
    private User auteur;

    @Relationship(type = "liked", direction = Relationship.UNDIRECTED)
    private List<User> usersLiked;

    @Relationship(type = "saved", direction = Relationship.UNDIRECTED)
    private List<User> usersSaved;


    public Post() {
    }

    public Post(Long id, String titre, User auteur, String datePublication, Contenu contenu, List<Commentaire> commentaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.contenu = contenu;
        this.commentaires = commentaires;
    }

    //like
    public List<User> like(User liker)
    {
        if (usersLiked == null) {
            usersLiked = new ArrayList<>();
        }
        usersLiked.add(liker);
        return usersLiked;
    }


    //save
    public List<User> save(User saver)
    {
        if (usersSaved == null) {
            usersSaved = new ArrayList<>();
        }
        usersSaved.add(saver);
        return usersLiked;
    }

    public List<User> getUsersLiked() {
        return usersLiked;
    }

    public List<User> getUsersSaved() {
        return usersSaved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
