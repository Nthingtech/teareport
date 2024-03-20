package org.ads.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ads.entities.ChildReport;

@ApplicationScoped
public class ChildReportRepository implements PanacheRepository<ChildReport> {
}
