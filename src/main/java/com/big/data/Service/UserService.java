package com.big.data.Service;

import com.big.data.Entity.User;
import com.big.data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userRepository.findBy_id(id);
    }

    public User findByLoginAndPwd(String login, String pwd)
    {
        return  userRepository.findByLoginAndPassword(login, pwd);
    }

    public User save(User user){
        if(user.getProfil().equals(""))
            user.setProfil(null);
        return userRepository.save(user);
    }

    public User update(Long _id,User user){
        user.set_id(_id);
        return userRepository.save(user);
    }

    public  void delete(User user)
    {
        userRepository.delete(user);
    }
}
