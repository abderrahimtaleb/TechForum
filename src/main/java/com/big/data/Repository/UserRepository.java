package com.big.data.Repository;

import com.big.data.Entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);

}
