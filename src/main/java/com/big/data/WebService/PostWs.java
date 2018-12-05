package com.big.data.WebService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostWs {

    /*
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
    public Set<Commentaire> comment(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        return postService.comment(id, commentaire);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id)
    {
        postService.delete(id);
    }

    @GetMapping(value = "comments/{id}")
    public Set<Commentaire> comments(@PathVariable Long id)
    {
        return postService.getComments(id);
    }

    */
}
