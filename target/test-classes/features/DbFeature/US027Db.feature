Feature: Kullanıcı DB ile mesajları doğrulamalıdır

  Scenario: Kullanıcı DB ile mesajları doğrulamalıdır
    Given Kullanici27 database'e baglanir
    When Kullanici27 id'si 237805 olan mesaji database'den alir
    Then Kullanici27 bu mesajin name, email, subject ve message bolumlerini dogrular
    And Kullanici27 baglantiyi sonlandirir
