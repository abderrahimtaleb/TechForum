package com.big.data.Service;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.big.data.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post findByTitre(String titre) {
        return postRepository.findByTitre(titre);
    }

    public Post findByTitre(User auteur) {
        return postRepository.findByAuteur(auteur);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    //test
    public void savePost() {
        postRepository.savePost();
    }

    public Post update(Long id, Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    public void delete(Long post) {
        postRepository.deleteById(post);
    }

    public Set<User> like(Long id, User liker) {
        Post post = postRepository.findById(id).get();
        post.likedBy(liker);
        return postRepository.save(post).getUsersLiked();
    }

    public Set<User> comment(Long id, User user) {
        Post post = postRepository.findById(id).get();
        post.commentedBy(user);
        return postRepository.save(post).getUsersCommented();
    }
}
