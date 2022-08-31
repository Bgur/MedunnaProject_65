Feature: US_027 Messages by Admin Validate with API and DB

  @us27tc001
  Scenario: TC_001 Admin, mesaj portalina gidebilir ve tum mesajlari, yazarlarini ve e-postalarini goruntuleyebilir.
    Given Admin27  Medunna internet sitesine gider
    When Admin27 anasayfa sag ust kosede bulunan kullanici ikonunu tiklar
    And Admin27 acilan dropdown menuden  "sign in" sekmesini secer
    And Admin27 acilan sayfada "Username" ve "Password" girerek kendi sayfasina erisir
    And Admin27 giris yaptigi sayfada "Items&Titles" butonuna tiklar
    And Admin27 acilan dropdown menuden "Messages" i secer
    Then Admin27 mesajlar bolumunde ID, name, email, subject, message  basliklarinin ve iceriklerinin tamaminin gorunur oldugunu dogrular
    #And  Admin27 sayfayi kapatir

  Scenario: TC_002 Admin, mesajlari olusturabilir, guncelleyebilir, silebilir.
    Given Admin27  Medunna internet sitesine gider
    When Admin27 anasayfa sag ust kosede bulunan kullanici ikonunu tiklar
    And Admin27 acilan dropdown menuden  "sign in" sekmesini secer
    And Admin27 acilan sayfada "Username" ve "Password" girerek kendi sayfasina erisir
    And Admin27 giris yaptigi sayfada "Items&Titles" butonuna tiklar
    And Admin27 acilan dropdown menuden "Messages" i secer
    And Admin27 "name", "email", "subject" ve "message" alanlarina giris yapar ve "save" butonunu tiklar
    Then Admin27 yeni mesajinin girisinin basarili oldugunu dogrular
    And Admin27 kendisi tarafindan kaydi yapilan son mesajin butun alanlarini gunceller
    Then Admin27 ilgili mesajin guncellendigini dogrular
    And Admin27 kendisi tarafindan guncellenen son mesaji siler
    Then Admin27 mesajin silindigini dogrular
    #And  Admin27 sayfayi kapatir




