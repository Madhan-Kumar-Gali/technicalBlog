package technicalblog.model;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @SuppressWarnings("unused")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "mobile_number")
    private String mobileNumber;


    @SuppressWarnings("unused")
    public String getFullName() {
        return fullName;
    }

    @SuppressWarnings("unused")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @SuppressWarnings("unused")
    public String getEmailAddress() {
        return emailAddress;
    }

    @SuppressWarnings("unused")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @SuppressWarnings("unused")
    public String getMobileNumber() {
        return mobileNumber;
    }

    @SuppressWarnings("unused")
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
