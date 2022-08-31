Feature:US10-Api ile randevu dogrulama

  @US010api
  Scenario Outline:Doktor Api ile randevu dogrulayabilmeli
    Given Doktor Medunna randevu API endpointini "<id>" ile olusturur
    Then Doktor randevu icin Get request olusturur ve gonderir
    Then Doktor randevu icin Get response alir
    Given Doktor Status Kodun 200 oldugunu dogrular
    And Doktor gelen json randevu datalarini javaya donusturur
    And Doktor gelen randevu datalarini kayit eder
    And Doctor API ile gelen datalar "<patientId>" "<startDate>" "<endDate>" "<status>" dogrular
    Examples:
      | id     | patientId | startDate            | endDate              | status     |
      | 191393 |191852    | 2022-08-20T00:00:00Z | 2022-08-20T01:00:00Z | PENDING |
