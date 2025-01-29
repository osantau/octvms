package oct.soft.octvms.visitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Visitor {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 50)
    private String company;

    @Column(nullable = false)
    private String visiting;

    @Column(nullable = false, length = 100)
    private String email;

    @Column
    private Boolean vehicleOnSite;

    @Column(length = 50)
    private String licensePlate;

    @Column
    private Boolean legalAccepted;

    @Column(nullable = false)
    private LocalDateTime inDate;

    @Column(nullable = false)
    private LocalDateTime outDate;

    @Column
    private Boolean signOut;

    @Column
    private String pdfFilePath;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public String getVisiting() {
        return visiting;
    }

    public void setVisiting(final String visiting) {
        this.visiting = visiting;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Boolean getVehicleOnSite() {
        return vehicleOnSite;
    }

    public void setVehicleOnSite(final Boolean vehicleOnSite) {
        this.vehicleOnSite = vehicleOnSite;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getLegalAccepted() {
        return legalAccepted;
    }

    public void setLegalAccepted(final Boolean legalAccepted) {
        this.legalAccepted = legalAccepted;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(final LocalDateTime inDate) {
        this.inDate = inDate;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(final LocalDateTime outDate) {
        this.outDate = outDate;
    }

    public Boolean getSignOut() {
        return signOut;
    }

    public void setSignOut(final Boolean signOut) {
        this.signOut = signOut;
    }

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(final String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
