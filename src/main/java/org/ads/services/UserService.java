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

    public User createNewUser(String name, String email, String userName, String password, String userType) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(BcryptUtil.bcryptHash(password));
        user.setUserType(userType);
        userRepository.persist(user);
        return user;
    }

    public List<User> listaAllUsers() {
        return userRepository.listAll();
    }


}
