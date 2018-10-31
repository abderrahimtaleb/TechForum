package com.big.data.WebService;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.big.data.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostWs {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
        //postService.savePost();
        //return "created";
    }

    @PutMapping (value = "/{id}")
    public Post update(@PathVariable Long id,@RequestBody Post post){
        return postService.update(id, post);
    }


    @PostMapping(value = "like/{id}")
    public Set<User> like(@PathVariable Long id, @RequestBody User user) {
        return postService.like(id, user);
    }

    @PostMapping(value = "comment/{id}")
    public Set<User> comment(@PathVariable Long id, @RequestBody User user) {
        return postService.comment(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id)
    {
        postService.delete(id);
    }
}
