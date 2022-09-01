@US028_DB
Feature: Kullanici admin olarak DataBase ile ulkeleri dogrulayabilmeli.

  @US028_DB_001
  Scenario: Kullanici DB ile ulkeleri bilgilerini dogrular
    Given Kullanici DB ile baglanti kurar
    And Kullanici Query tanimlar
    And  Kullanici ulke bilgilerine ulasir ve kaydeder
    And Kullanici DB ile ulke bilgilerini dogrular

  @US028_DB_002
  Scenario: Kullanici DB ile sehir bilgilerini dogrular
    Given Kullanici DB ile baglanti kurar
    And  Kullanici sehir icin Query tanimlar
    And   Kullanici sehir bilgilerine ulasir ve kaydeder
    And Kullanici DB ile sehir bilgilerini dogrular