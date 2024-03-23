package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.User;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByNameUser(String nameUser) {
        return list("lower(name) like lower(?1)", "%" + nameUser + "%");
    }

    public int updateUser(User user) {
        return update("UPDATE User u SET ")//TODO
    }

}
