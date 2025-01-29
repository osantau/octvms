package oct.soft.octvms.visitor.service;

import java.util.List;
import java.util.stream.Collectors;
import oct.soft.octvms.util.NotFoundException;
import oct.soft.octvms.visitor.domain.Visitor;
import oct.soft.octvms.visitor.model.VisitorDTO;
import oct.soft.octvms.visitor.repos.VisitorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(final VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<VisitorDTO> findAll() {
        final List<Visitor> visitors = visitorRepository.findAll(Sort.by("id"));
        return visitors.stream()
                .map(visitor -> mapToDTO(visitor, new VisitorDTO()))
                .collect(Collectors.toList());
    }

    public VisitorDTO get(final Long id) {
        return visitorRepository.findById(id)
                .map(visitor -> mapToDTO(visitor, new VisitorDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final VisitorDTO visitorDTO) {
        final Visitor visitor = new Visitor();
        mapToEntity(visitorDTO, visitor);
        return visitorRepository.save(visitor).getId();
    }

    public void update(final Long id, final VisitorDTO visitorDTO) {
        final Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(visitorDTO, visitor);
        visitorRepository.save(visitor);
    }

    public void delete(final Long id) {
        visitorRepository.deleteById(id);
    }

    private VisitorDTO mapToDTO(final Visitor visitor, final VisitorDTO visitorDTO) {
        visitorDTO.setId(visitor.getId());
        visitorDTO.setFirstName(visitor.getFirstName());
        visitorDTO.setLastName(visitor.getLastName());
        visitorDTO.setCompany(visitor.getCompany());
        visitorDTO.setVisiting(visitor.getVisiting());
        visitorDTO.setEmail(visitor.getEmail());
        visitorDTO.setVehicleOnSite(visitor.getVehicleOnSite());
        visitorDTO.setLicensePlate(visitor.getLicensePlate());
        visitorDTO.setLegalAccepted(visitor.getLegalAccepted());
        visitorDTO.setInDate(visitor.getInDate());
        visitorDTO.setOutDate(visitor.getOutDate());
        visitorDTO.setSignOut(visitor.getSignOut());
        visitorDTO.setPdfFilePath(visitor.getPdfFilePath());
        return visitorDTO;
    }

    private Visitor mapToEntity(final VisitorDTO visitorDTO, final Visitor visitor) {
        visitor.setFirstName(visitorDTO.getFirstName());
        visitor.setLastName(visitorDTO.getLastName());
        visitor.setCompany(visitorDTO.getCompany());
        visitor.setVisiting(visitorDTO.getVisiting());
        visitor.setEmail(visitorDTO.getEmail());
        visitor.setVehicleOnSite(visitorDTO.getVehicleOnSite());
        visitor.setLicensePlate(visitorDTO.getLicensePlate());
        visitor.setLegalAccepted(visitorDTO.getLegalAccepted());
        visitor.setInDate(visitorDTO.getInDate());
        visitor.setOutDate(visitorDTO.getOutDate());
        visitor.setSignOut(visitorDTO.getSignOut());
        visitor.setPdfFilePath(visitorDTO.getPdfFilePath());
        return visitor;
    }

}
