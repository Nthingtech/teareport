package org.ads.entities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.ads.entities.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_child")
@ApplicationScoped
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_child")
    private Long id;

    @Column(name = "name", length = 40)
    @Size(max = 40, message = "O nome não pode exceder 40 caracteres")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    private Gender gender;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonbTransient
    private List<ChildReport> childReports;

    public Child() {
    }

    public Child(String name, LocalDate birthday, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<ChildReport> getChildReports() {
        return childReports;
    }

    public void setChildReports(List<ChildReport> childReports) {
        this.childReports = childReports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
