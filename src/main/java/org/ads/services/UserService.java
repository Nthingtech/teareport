package org.ads.services;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ads.entities.User;
import org.ads.repositories.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User createNewUser(String name, String email, String userName, String password, String role) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(BcryptUtil.bcryptHash(password));
        user.setRole(role);
        userRepository.persist(user);
        return user;
    }


    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public List<User> listaAllUsers() {
        return userRepository.listAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> searchByName(String keyuser) {
        return userRepository.findByNameUser(keyuser);
    }

}
