@US012_Request_Test
Feature: Request_Test
  Background: doktor_medunna_sayfasina_gider
    Given doktor medunna sayfasina gider
    And doktor sag üst kösedeki kullanici ikonuna tiklar
    And doktor dropdown menüden Sign in ikonuna tiklar

  @Smoke
    @TC_001
  Scenario Outline: TC_001_doktor_test_isteyebilmeli
    And doktor gecerli bir kullanici adi "<username>" Sign in sayfasina girer
    And doktor gecerli bir kullanici parolasi "<password>" Sign in sayfasina girer
    When doktor sign in butonuna tiklar
    Then doktor basarli giris yaptigini "<signedInUserName>" teyit eder
    And doktor my pages sekmesine tiklar
    And doktor my appoinments sekmesine tiklar
    And doktor edit buttonuna tiklar
    And doktor bir test iste button'a cift tiklar
    Then doktor test isteme sayfasinda oldugunu teyit eder

    Examples: customer credentials
      | username     | password      | signedInUserName |
      | DoktorOnur65 | DoktorOnur.65 | Doktor Onur      |

  @Smoke
    @TC_002
  Scenario Outline: TC_002_doktor_noTestItemsFound_mesajini_görür_eger_herhangi_bir_test_secenegi_secmezse
    And doktor gecerli bir kullanici adi "<username>" Sign in sayfasina girer
    And doktor gecerli bir kullanici parolasi "<password>" Sign in sayfasina girer
    When doktor sign in butonuna tiklar
    Then doktor basarli giris yaptigini "<signedInUserName>" teyit eder
    And doktor my pages sekmesine tiklar
    And doktor my appoinments sekmesine tiklar
    And doktor edit buttonuna tiklar
    And doktor bir test iste button'a cift tiklar
    Then doktor test isteme sayfasinda oldugunu teyit eder
    And doktor Save butonuna tiklar
    And doktor No Test Items Found bildirimini görür

    Examples: customer credentials
      | username     | password      | signedInUserName |
      | DoktorOnur65 | DoktorOnur.65 | Doktor Onur      |

  @Smoke
    @TC_003
  Scenario Outline: TC_003_test_iceriginde_Glucose_Urea_Creatinine_Sodium_Potassium_Total_protein_Albumin_Hemoglobin_secenekleri_olmali
    And doktor gecerli bir kullanici adi "<username>" Sign in sayfasina girer
    And doktor gecerli bir kullanici parolasi "<password>" Sign in sayfasina girer
    When doktor sign in butonuna tiklar
    Then doktor basarli giris yaptigini "<signedInUserName>" teyit eder
    And doktor my pages sekmesine tiklar
    And doktor my appoinments sekmesine tiklar
    And doktor edit buttonuna tiklar
    And doktor bir test iste button'a cift tiklar
    Then doktor test isteme sayfasinda oldugunu teyit eder
    And doktor Urea checkmark'ina tiklar
    And doktor Creatinine checkmark'ina tiklar
    And doktor Sodium checkmark'ina tiklar
    And doktor Potassium checkmark'ina tiklar
    And doktor Total_protein checkmark'ina tiklar
    And doktor Albumin checkmark'ina tiklar
    And doktor Hemoglobin checkmark'ina tiklar
    When doktor Save butonuna tiklar
    Then doktor A New Test Created bildirimini görür

    Examples: customer credentials
      | username     | password      | signedInUserName |
      | DoktorOnur65 | DoktorOnur.65 | Doktor Onur      |