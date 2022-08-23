Feature:US009 Kullanici hasta bilgilerini dogrular


  @Api_09
  @US009_API
  Scenario:TC08 Kullanici hastanin ID, firstname, ssn, email bilgilerini dogrular

    Given Kullanici "173461" id'li hasta verileri icin bir get request gonderir
    And Kullanici Status code 200 oldugunu dogrular
    And Kullanici gelen datayi deserialize eder
    Then Kullanici, hasta ID, adini, ssn'yi, e-postayi dogrular


  @Api_09
  @US009_API
  Scenario:Post request validation

    Given Kullanici patients icin post request yapar
    Then Kullanici post request validation yapar