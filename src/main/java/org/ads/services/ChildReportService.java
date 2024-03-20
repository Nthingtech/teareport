package org.ads.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ads.entities.ChildReport;
import org.ads.repositories.ChildReportRepository;

import java.util.List;

@ApplicationScoped
public class ChildReportService {

    @Inject
    private ChildReportRepository childReportRepository;

    public ChildReport createNewChildReport(ChildReport childReport) {
        childReportRepository.persist(childReport);
        return childReport;
    }

    public List<ChildReport> listAllChildReport() {
        return childReportRepository.listAll();
    }
}
