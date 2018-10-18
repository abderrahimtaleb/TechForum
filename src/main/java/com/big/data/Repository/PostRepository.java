package com.big.data.Repository;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, String> {
    Post findBy_id(Long id);
    Post findByTitre(String titre);
    Post findByAuteur(User auteur);
}
