package org.ads.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ads.entities.Child;
import org.ads.repositories.ChildRepository;

import java.util.List;

@ApplicationScoped
public class ChildService {

    @Inject
    private ChildRepository childRepository;

   public Child newChild(Child child){
        childRepository.persist(child);
        return child;
    }


    public void updateChild (Child child) {
        childRepository.updateChild(child);
    }

    public List<Child> listAllChild() {
        return childRepository.listAll();
    }

    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }

    public Child findById (Long id) {
       return childRepository.findById(id);
    }

    public List<Child> searchByName(String keychild) {
        return childRepository.findByNameChild(keychild);
    }



}
