package org.ads.entities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.ads.entities.enums.Aggressiveness;
import org.ads.entities.enums.Anxiety;
import org.ads.entities.enums.ChildFeel;
import org.ads.entities.enums.Communication;
import org.ads.entities.enums.Concentration;
import org.ads.entities.enums.DayRating;
import org.ads.entities.enums.Friendliness;
import org.ads.entities.enums.Gender;
import org.ads.entities.enums.Impatience;
import org.ads.entities.enums.Pleasant;
import org.ads.entities.enums.SocialInteraction;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "tbl_childreport")
@ApplicationScoped
public class ChildReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idChildReport")
    private Long idChildReport;

    @Column(name = "date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate date;

    @Column(name = "nameChild")
    private String nameChild;

    @Column(name = "dtBirth", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtBirth;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "aggressiveness")
    private Aggressiveness aggressiveness;


    @Column(name = "anxiety")
    private Anxiety anxiety;

    @Column(name = "childFeel")
    private ChildFeel childFeel;

    @Column(name = "communication")
    private Communication communication;

    @Column(name = "concentration")
    private Concentration concentration;

    @Column(name = "dayRating")
    private DayRating dayRating;

    @Column(name = "friendliness")
    private Friendliness friendliness;

    @Column(name = "impatience")
    private Impatience impatience;

    @Column(name = "pleasant")
    private Pleasant pleasant;

    @Column(name = "socialInteraction")
    private SocialInteraction socialInteraction;

    @ManyToOne
    @JoinColumn(name = "tbl_user_id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tbl_child_id_child")
    private Child child;


    public ChildReport() {
    }

    public ChildReport(Long idChildReport, LocalDate date, String nameChild, LocalDate dtBirth, Gender gender, Aggressiveness aggressiveness, Anxiety anxiety, ChildFeel childFeel, Communication communication,
                       Concentration concentration, DayRating dayRating, Friendliness friendliness, Impatience impatience, Pleasant pleasant, SocialInteraction socialInteraction, User user, Child child) {
        this.idChildReport = idChildReport;
        this.date = date;
        this.nameChild = nameChild;
        this.dtBirth = dtBirth;
        this.gender = gender;
        this.aggressiveness = aggressiveness;
        this.anxiety = anxiety;
        this.childFeel = childFeel;
        this.communication = communication;
        this.concentration = concentration;
        this.dayRating = dayRating;
        this.friendliness = friendliness;
        this.impatience = impatience;
        this.pleasant = pleasant;
        this.socialInteraction = socialInteraction;
        this.user = user;
        this.child = child;
    }

    public Long getIdChildReport() {
        return idChildReport;
    }

    public void setIdChildReport(Long idChildReport) {
        this.idChildReport = idChildReport;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNameChild() {
        return nameChild;
    }

    public LocalDate getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(LocalDate dtBirth) {
        this.dtBirth = dtBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    public Aggressiveness getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(Aggressiveness aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public Anxiety getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(Anxiety anxiety) {
        this.anxiety = anxiety;
    }

    public ChildFeel getChildFeel() {
        return childFeel;
    }

    public void setChildFeel(ChildFeel childFeel) {
        this.childFeel = childFeel;
    }

    public Communication getCommunication() {
        return communication;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public Concentration getConcentration() {
        return concentration;
    }

    public void setConcentration(Concentration concentration) {
        this.concentration = concentration;
    }

    public DayRating getDayRating() {
        return dayRating;
    }

    public void setDayRating(DayRating dayRating) {
        this.dayRating = dayRating;
    }

    public Friendliness getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(Friendliness friendliness) {
        this.friendliness = friendliness;
    }

    public Impatience getImpatience() {
        return impatience;
    }

    public void setImpatience(Impatience impatience) {
        this.impatience = impatience;
    }

    public Pleasant getPleasant() {
        return pleasant;
    }

    public void setPleasant(Pleasant pleasant) {
        this.pleasant = pleasant;
    }

    public SocialInteraction getSocialInteraction() {
        return socialInteraction;
    }

    public void setSocialInteraction(SocialInteraction socialInteraction) {
        this.socialInteraction = socialInteraction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildReport that = (ChildReport) o;
        return Objects.equals(idChildReport, that.idChildReport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChildReport);
    }

    @Override
    public String toString() {
        return "ChildReport{" +
                "idChildReport=" + idChildReport +
                ", date=" + date +
                ", nameChild='" + nameChild + '\'' +
                ", dtBirth=" + dtBirth +
                ", gender=" + gender +
                ", aggressiveness=" + aggressiveness +
                ", anxiety=" + anxiety +
                ", childFeel=" + childFeel +
                ", communication=" + communication +
                ", concentration=" + concentration +
                ", dayRating=" + dayRating +
                ", friendliness=" + friendliness +
                ", impatience=" + impatience +
                ", pleasant=" + pleasant +
                ", socialInteraction=" + socialInteraction +
                ", user=" + user +
                '}';
    }
}
