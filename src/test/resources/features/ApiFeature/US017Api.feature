Feature: US017 Api Test items (oge) olustur/guncelle/sil

  @US017api @US017_Api_TC05
  Scenario:Test Items with Get Request / Test Items api testi
    Given kullanici test itemlar icin get request yapar
    And kullanici gelen test item datayi deserialize yapar

  @US017api @US017_Api_TC06_1_2
  Scenario: Test item with Post Request/ Test Items api testi
    Given kullanici test itemlar icin post request yapar
    Then kullanici post request validation yapar

  @US017api @US017_Api_TC06_3_4
  Scenario: Test item with Put Request/ Test Items api testi
    Given kullanici test itemlar icin put request yapar
    Then kullanici put request validation yapar


  @US017api @US017_Api_TC06_5_6
  Scenario Outline: Test item with Delete Request/ Test Items api testi
    Given kullanici Delete request eder "<id>"
    Then delete validation

    Examples: test data: (ids)
      | id     |
      | 254754 |

