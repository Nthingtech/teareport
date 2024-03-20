package org.ads.entities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.ads.entities.enums.DayRating;

import java.util.Objects;

@Entity
@Table(name = "tbl_childreport")
@ApplicationScoped
public class ChildReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_childreport")
    private Long id;

    @Column(name = "namechild")
    private String nameChild;

    @Column(name = "dayrating")
    private DayRating dayRating;

    public ChildReport() {
    }

    public ChildReport(Long id, String nameChild, DayRating dayRating) {
        this.id = id;
        this.nameChild = nameChild;
        this.dayRating = dayRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameChild() {
        return nameChild;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    public DayRating getDayRating() {
        return dayRating;
    }

    public void setDayRating(DayRating dayRating) {
        this.dayRating = dayRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildReport that = (ChildReport) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChildReport{" +
                "id=" + id +
                ", nameChild='" + nameChild + '\'' +
                ", dayRating=" + dayRating +
                '}';
    }
}
