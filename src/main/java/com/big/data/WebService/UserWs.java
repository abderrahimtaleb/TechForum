package com.big.data.WebService;

import com.big.data.Bean.Auth;
import com.big.data.Entity.User;
import com.big.data.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserWs {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/login")
    public  User login(@RequestBody Auth auth){
        return userService.findByLoginAndPwd(auth.getLogin(), auth.getPassword());
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping (value = "/{id}")
    public User update(@PathVariable Long id, @RequestParam User user){
        return userService.update(id, user);
    }

    @DeleteMapping
    public  void delete(@RequestBody User user)
    {
        userService.delete(user);
    }
}
