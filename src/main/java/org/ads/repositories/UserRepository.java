package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {


}
