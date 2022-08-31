package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class US25_appointment {

    private String firstname;
    private String lastname;
    private String Ssn;
    private String email;
    private String phone;
    private String DateTime;
    private String id;

    public US25_appointment(String firstname, String lastname, String ssn, String email, String phone, String dateTime, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        Ssn = ssn;
        this.email = email;
        this.phone = phone;
        DateTime = dateTime;
        this.id = id;
    }

    public US25_appointment() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSsn() {
        return Ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateTime() {
        return DateTime;
    }

    public String getId() {
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSsn(String ssn) {
        Ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "US25_appointment{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Ssn='" + Ssn + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", DateTime='" + DateTime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}