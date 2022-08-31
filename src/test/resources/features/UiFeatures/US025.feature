Feature:US25 Randevu Alma


  Scenario: TC_01 Giris yapilarak Randevu alma
    Given Patient login olur
    Then  Patient giris yapilabiligini dogrular
    And   Patient My pages'e tiklar
    And   Patient Make an Appointment tiklar
    Then  Patient acilan sayfada bilgileri doldurur
    And   Patient  Send an Appointment Request tiklar
    Then  Patient randevu aldigini dogrular
    #Then Sayfayi kapatir



  Scenario Outline: TC02 Giris yapmadan Randevu alma
    Given Patient URL sayfasina gider
    And   Patient acilan sayfada Make an Appointment tiklar
    Then  Patient  firstname girer "<firstname>"
    Then  Patient  lastname girer  "<lastname>"
    Then  Patient ssn girer  "<Ssn>"
    Then  Patient  email girer  "<email>"
    Then  Patient phone girer "<phone>"
    #Then  Patient Appointment DateTime girer "<DateTime>"
   # Then  Patient girilen tarihle sistem tarihi ayni olmali
   # Then Patient Tarih sirasi gun.ay.yil (ay.gun.yil) seklinde olmalidir
    And   Patient  Send an Appointment Request elementine tiklar
    Then  Patient randevu alabildigini dogrular


    Examples:
      | firstname | lastname | Ssn         | email                     | phone        | DateTime   |
      | Potilas   | Sairas   | 888-89-4090 | Potilassairas@medunna.com | 123-565-4478 | 30-08-2025 |