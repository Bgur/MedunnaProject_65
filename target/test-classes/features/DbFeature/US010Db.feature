Feature:US10-DB ile randevu dogrulama

  @US010DB
  Scenario: Doktor DB ile randevu dogrulayabilmeli

    Given kullanici bilgileri kullanarak medunna_db baglanti kurar
    And kullanici query ve column gonderir
    And kullanici randevulari dogrular

