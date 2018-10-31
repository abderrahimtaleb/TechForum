package com.big.data.Service;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.big.data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll()
    {
        return (List<User>) userRepository.findAll();
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }

    public User findByLoginAndPwd(String login, String pwd)
    {
        return  userRepository.findByLoginAndPassword(login, pwd);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(Long _id,User user){
        user.setId(_id);
        return userRepository.save(user);
    }

    public void delete(Long user)
    {
        userRepository.deleteById(user);
    }

    public Set<User> follow(Long id, User follower) {
        User user = userRepository.findById(id).get();
        user.follow(follower);
        return userRepository.save(user).getFollowers();
    }

    public Set<Post> savePost(Long id, Post post) {
        User user = userRepository.findById(id).get();
        user.savePost(post);
        return userRepository.save(user).getPostsSaved();
    }
}
