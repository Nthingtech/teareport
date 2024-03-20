package org.ads.entities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.ads.entities.enums.Aggressiveness;
import org.ads.entities.enums.Anxiety;
import org.ads.entities.enums.ChildFeel;
import org.ads.entities.enums.Communication;
import org.ads.entities.enums.Concentration;
import org.ads.entities.enums.DayRating;
import org.ads.entities.enums.Friendliness;
import org.ads.entities.enums.Impatience;
import org.ads.entities.enums.Pleasant;
import org.ads.entities.enums.SocialInteraction;

import java.util.Objects;


@Entity
@Table(name = "tbl_childreport")
@ApplicationScoped
public class ChildReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_childreport")
    private Long idChildReport;

    @Column(name = "namechild")
    private String nameChild;

    @Column(name = "aggressiveness")
    private Aggressiveness aggressiveness;

    @Column(name = "anxiety")
    private Anxiety anxiety;

    @Column(name = "childfeel")
    private ChildFeel childFeel;

    @Column(name = "communication")
    private Communication communication;

    @Column(name = "concentration")
    private Concentration concentration;

    @Column(name = "dayrating")
    private DayRating dayRating;

    @Column(name = "friendliness")
    private Friendliness friendliness;

    @Column(name = "impatience")
    private Impatience impatience;

    @Column(name = "pleasant")
    private Pleasant pleasant;

    @Column(name = "socialinteraction")
    private SocialInteraction socialInteraction;


    public ChildReport() {
    }

    public ChildReport(Long idChildReport, String nameChild, Aggressiveness aggressiveness, Anxiety anxiety, ChildFeel childFeel, Communication communication, Concentration concentration,
                       DayRating dayRating, Friendliness friendliness, Impatience impatience, Pleasant pleasant, SocialInteraction socialInteraction) {
        this.idChildReport = idChildReport;
        this.nameChild = nameChild;
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
    }

    public Long getId() {
        return idChildReport;
    }

    public void setId(Long idChildReport) {
        this.idChildReport = idChildReport;
    }

    public String getNameChild() {
        return nameChild;
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
                ", nameChild='" + nameChild + '\'' +
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
                '}';
    }
}
