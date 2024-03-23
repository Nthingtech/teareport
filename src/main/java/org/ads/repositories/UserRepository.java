package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.User;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByNameUser(String nameUser) {
        return list("lower(name) like lower(?1)", "%" + nameUser + "%");
    }

    public int updateUser(User user) {
        return update("UPDATE User u SET u.name = :name, u.email = :email, u.userName = :userName, u.role = :role, u.password = :password WHERE u.id = :id",
                Parameters.with("name", user.getName())
                        .and("email", user.getEmail())
                        .and("userName", user.getUserName())
                        .and("role", user.getRole())
                        .and("password", user.getPassword())
                        .and("id", user.getId()));
    }

}
