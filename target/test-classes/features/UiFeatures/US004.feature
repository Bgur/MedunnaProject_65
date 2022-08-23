Feature:US004.feature

  Scenario:US004-TC01 Kullanicinin mevcut kimlik bilgilerini her zaman kullanabilecegi bir beni hatirla secenegi olmalidir
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then Kullanici gecerli user name bilgisi girer
    And Kullanici gecerli bir password girer
    And Acilan pencerede"Remember me" checkbox'ini gorur
    And Browser close04

  Scenario:US004-TC02  Eger sifre unutulursa diye "Did you forget your password?" secenegi olmali


    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then Username alanina gecerli kullanici adini yazar
    Then Kullanici Did you forget your password? yazisini gorur
    And Kullanici Did you forget your password? linkini tiklar
    And Browser close04


  Scenario:US004-TC03 "You don't have an account yet? Register a new account" secenegi olmali
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then Username alanina gecerli kullanici adini yazar
    Then Kullanici You don't have an account yet? Register a new account seçeneğini gorur
    And Kullanici You don't have an account yet? Register a new account linkini tiklar


  Scenario:US004-TC04 "Cancel" secenegi olmali
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then Username alanina gecerli kullanici adini yazar
    Then Cancel secenegini tiklar


  Scenario:US004- TC05 Giris yapinca  basari mesaji olmali.
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then Username alanina gecerli kullanici adini yazar
    And Kullanici gecerli bir password girer
    And Formdaki Sign in tusuna tiklar
    And Giris yapinca basarili mesajini gorur


  Scenario:US004-TC06 Gecerli bir kullanici adi ve gecerli sifre ile basarili giris yapmali .
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And Sign in tusuna tiklar
    Then  Username alanina gecerli kullanici adini yazar
    And Kullanici gecerli bir password girer
    And Formdaki Sign in tusuna tiklar
    And  Basirili giris yaptigi gorulur

  Scenario:US004-TC07 Kullanici gecerli username ve gecersiz pasword ile giris basarisiz olur
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And  Sign in tusuna tiklar
    Then  Username alanina gecerli kullanici adini yazar
    And password alanina gecersiz pasword girer
    And  Formdaki Sign in tusuna tiklar
    And  Kullanici Failed to sign in Please check your credentials and try again uyarisini gorur

  Scenario:US004-TC08 Kullanici gecersiz username ve gecerli pasword ile giris basarisiz olur
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And  Sign in tusuna tiklar
    Then  Username alanina gecersiz kullanici adini yazar
    And password alanina gecerli pasword girer
    And  Formdaki Sign in tusuna tiklar
    And  Kullanici Failed to sign in Please check your credentials and try again uyarisini gorur

  Scenario:US004-TC09 Kullanici gecersiz username ve gecersiz pasword ile giris basarisiz olur
    Given Kullanici Url'e gider
    When Sag ust kosedeki ikonu tiklar
    And  Sign in tusuna tiklar
    Then  Username alanina gecersiz kullanici adini yazar
    And password alanina gecersiz pasword girer
    And  Formdaki Sign in tusuna tiklar
    And  Kullanici Failed to sign in Please check your credentials and try again uyarisini gorur