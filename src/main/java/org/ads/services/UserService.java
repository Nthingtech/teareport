package org.ads.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ads.entities.User;
import org.ads.repositories.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User createNewUser(User user) {
        userRepository.persist(user);
        return user;
    }

    public List<User> listaAllUsers() {
        return userRepository.listAll();
    }
}
