package oct.soft.octvms.visitor.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


public class VisitorDTO {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String company;

    @NotNull
    @Size(max = 255)
    private String visiting;

    @NotNull
    @Size(max = 100)
    private String email;

    private Boolean vehicleOnSite;

    @Size(max = 50)
    private String licensePlate;

    private Boolean legalAccepted;

    @NotNull
    private LocalDateTime inDate;

    @NotNull
    private LocalDateTime outDate;

    private Boolean signOut;

    @Size(max = 255)
    private String pdfFilePath;

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

}
