@Api028
Feature: US_028_ApiTest

  @Api028_TC001
  Scenario: Kullanici, API kullanarak ulkeleri dogrular
    Given Kullanici set the Base Url
    And Send the GET request and get the response
    And Set the expected data
    Then Make validation

  @Api028_TC002
  Scenario: Kullanici, API kullanarak ulkeleri gunceller
    Given Kullanici, ulke guncellemesi icin beklenen verileri girer
    And Kullanici, ulke guncellemesi icin istek gonderir ve yanit alir
    And Kullanici, ulke guncellemesi icin tum API bilgilerini kaydeder
    Then Kullanici, ulke guncellemesi icin API kayitlarini dogrular

  @Api028_TC003
  Scenario: Kullanici, API kullanarak sehirleri dogrular
    Given Kullanici Base Url i olusturur
    And Kullanici post istegini gonderir ve yanitini alir
    Then Kullanici APi kayitlarini dogrular