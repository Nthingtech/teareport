package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.ChildReport;

import java.util.List;

@ApplicationScoped
public class ChildReportRepository implements PanacheRepository<ChildReport> {

    public List<ChildReport> findByNameChild(String nameChild){
        return list("lower(nameChild) like lower(?1)", "%" + nameChild + "%");
    }

    public int updateChildReport(ChildReport childReport){
        return update("UPDATE ChildReport c SET c.date = :date, c.nameChild = :nameChild, c.dtBirth = :dtBirth, c.gender = :gender, c.aggressiveness = :aggressiveness, c.anxiety = :anxiety, c.childFeel = childFeel, c.communication = :communication, c.concentration = :concentration, c.dayRating = :dayRating, c.friendliness = :friendliness, c.impatience = :impatience, c.pleasant = :pleasant, c.socialInteraction = :socialInteraction WHERE c.idChildReport = :idChildReport",
                Parameters.with("date", childReport.getDate())
                        .and("nameChild", childReport.getNameChild())
                        .and("dtBirth", childReport.getDtBirth())
                        .and("gender", childReport.getGender())
                        .and("aggressiveness", childReport.getAggressiveness())
                        .and("anxiety", childReport.getAnxiety())
                        .and("childFeel", childReport.getChildFeel())
                        .and("communication", childReport.getCommunication())
                        .and("communication", childReport.getCommunication())
                        .and("dayRating", childReport.getDayRating())
                        .and("friendliness", childReport.getFriendliness())
                        .and("impatience", childReport.getImpatience())
                        .and("pleasant", childReport.getPleasant())
                        .and("socialInteraction", childReport.getSocialInteraction())
                        .and("idChildReport", childReport.getIdChildReport()));
    }

}
