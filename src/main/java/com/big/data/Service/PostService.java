package com.big.data.Service;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    /*
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

    public Post findByAuteur(User auteur) {
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

    public Set<Commentaire> comment(Long id, Commentaire commentaire) {
        Post post = postRepository.findById(id).get();
        commentaire.setPost(post);
        post.commentedBy(commentaire);
        return postRepository.save(post).getCommentaires();
    }

    public Set<Commentaire> getComments(Long id) {
        Post post = postRepository.findById(id).get();
        return post.getCommentaires();
    }

    */
}
