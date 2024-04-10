package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.Child;

import java.util.List;

@ApplicationScoped
public class ChildRepository implements PanacheRepository<Child> {

    public List<Child> findByNameChild(String nameChild) {
        return list("lower(name) like lower(?1)", "%" + nameChild + "%");
    }

    public int updateChild(Child child) {
        return update("UPDATE Child c SET c.name = :name, c.birthday = :birthday, c.gender = :gender WHERE c.id = :id",
                Parameters.with("name", child.getName())
                        .and("birthday", child.getBirthday())
                        .and("gender", child.getGender())
                        .and("id", child.getId()));
    }

}
