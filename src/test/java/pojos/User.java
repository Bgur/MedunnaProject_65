package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    /*
     {
    "id": 152712,
    "login": "team65",
    "firstName": "Team",
    "lastName": "65",
    "ssn": "456-12-7852",
    "email": "healthteam65@gmail.com",
    "imageUrl": null,
    "activated": false,
    "langKey": null,
    "createdBy": null,
    "createdDate": null,
    "lastModifiedBy": null,
    "lastModifiedDate": null,
    "authorities": null
}
     */


    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String imageUrl;
    private boolean activated;
    private String langKey;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String authorities;

  // public User(String login, String firstName, String lastName, String ssn, String email) {
  //     this.login = login;
  //     this.firstName = firstName;
  //     this.lastName = lastName;
  //     this.ssn = ssn;
  //     this.email = email;
  // }

  // public User() {
  // }

  // @Override
  // public String toString() {
  //     return "User{" +
  //             "login='" + login + '\'' +
  //             ", firstName='" + firstName + '\'' +
  //             ", lastName='" + lastName + '\'' +
  //             ", ssn='" + ssn + '\'' +
  //             ", email='" + email + '\'' +
  //             '}';
  // }
}
