Feature:US015 Admin tarafindan hasta olusturma ve duzenleme

  @US015Api

  Scenario: US015TC012 Api ile hasta bilgileri dogrulanabilmeli


    Given kullanici Url'e get request gonderir ve response alir
    Then Status Code 200 oldugunu dogrular
    And response deserialize eder ve hasta bilgilerini dogrular

