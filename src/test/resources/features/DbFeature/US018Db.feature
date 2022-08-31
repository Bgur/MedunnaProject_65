Feature:US018 Admin, API kullanarak doktorları doğrular

  @DB_018
  Scenario:TC06 Admin DB deki doktor bilgilerini okuyabilmelidir
    Given Kullanici database baglanir
    When Kullanici databese query gonderir ve gerekli columnu alir
    Then Kullanici doktorun bilgilerini dogrular
    And Kullanici database baglantisini kapatir

