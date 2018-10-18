package com.big.data.Service;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.big.data.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll()
    {
        return (List<Post>) postRepository.findAll();
    }

    public Post findById(Long id)
    {
        return postRepository.findBy_id(id);
    }

    public Post findByTitre(String titre)
    {
        return postRepository.findByTitre(titre);
    }

    public Post findByTitre(User auteur)
    {
        return postRepository.findByAuteur(auteur);
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post update(Long id,Post post){
        post.setId(id);
        return postRepository.save(post);
    }

    public  void delete(Post post)
    {
        postRepository.delete(post);
    }
}
