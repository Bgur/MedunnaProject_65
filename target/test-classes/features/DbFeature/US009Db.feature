
Feature:US009 Kullanici hasta bilgilerini gorebilmeli ve duzenleyebilmeli


  @DB_09
  Scenario:TC07 Kullanici Staff DB deki hasta bilgilerini okuyabilmelidir
    Given Kullanici database baglanir
    When Kullanici "*" "patient" ile "id" tablosundan "173461" alir
    Then Hastanin "FIRST_NAME" "Muzmin" olmalidir
    And Kullanici database baglantisini kapatir

  @DB_09
  Scenario:TC07 Kullanici Admin DB deki hasta bilgilerini dogrulayabilmeli
    Given Kullanici database baglanir
    When Kullanici "*" "patient" ile "id" tablosundan "173461" alir
    Then Hastanin "FIRST_NAME" "Muzmin" olmalidir
    And Kullanici database baglantisini kapatir




