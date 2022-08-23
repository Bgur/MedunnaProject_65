Feature:US001_Kayıt olmak icin SSN, Firstname ve Lastname bilgileri girililebilmelidir.


  @TC13 @US01@E2E
  Scenario:TC_0013 DB ile SSN kimliklerini doğrulayın
    When Kullanici tablodan gerekli sutunu alir
    Then Kullanici ssn dogrulamasini yapar