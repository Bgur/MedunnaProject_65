
Feature: Kayitli kullanici adi ve sifresi ile giris yapma, sifre guncelleme
  Background:
    Given Kullanici siteye gider "baseUrl"
    When  Sayfaya gidildigi ana sayfadaki WELCOME TO MEDUNNA texti ile dogrulanir
    And  Kullanici sayfaya giris icin CONTACT linkinin saginda bulunan kullanici girisi linkine tiklar
    Then Kullanici Sign in sekmesine tiklar.

  Scenario: Oturum acma
    Then Kullanici Username Box'a gecerli "<username>" girerr
    Then Kullanici Password Box'a gecerli "<password>" girer.
  #Then Kullanici Password Box'a gecerli sifreyi girer
    Then Kullanici Sign in butonuna tiklar.
   # Then Kullanici sayfayi kapatir

  Scenario: Mevcut parolayi guncelleme ( Pozitif Test)
    Then Kullanici Username Box'a gecerli "<username>" girerr
    Then Kullanici Password Box'a gecerli "<password>" girerr.
    Then Kullanici Sign in butonuna tiklar.
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menude password yazisina tiklar
    Then Kullanici acilan sayfadaki Current password kutucuguna mevcut parolayi girer
    Then Kullanici new password kutucuguna yeni parolayi girer
    Then Kullanici Password strength seviyesinin degistigini gorur
    Then Kullanici new password confirmation kutucuguna yeni parolayi tekrar girer
    Then Kullanici save butonuna tiklar
    Then Passwordun basarili bir sekilde degistigi gorulur
    #Then Kullanici sayfayi kapatir

  Scenario Outline:Mevcut parolayi guncelleme ( Negatif Test)
    Then Kullanici username box'a gecerli "<username>" girer.
    Then Kullanici password box'a gecerli "<password>" girer.
    Then Kullanici Sign in butonuna tiklar.
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menude password yazisina tiklar
    Then Kullanici acilan sayfadaki Current password kutucuguna "<mevcutparolayi>" girer
    Then Kullanici new password kutucuguna "<yeniparolayi>" girer
    Then Kullanici new password confirmation kutucuguna "<yeniparolayi>" tekrar girer
    Then Kullanici save butonuna tiklar
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menuden signOut linkine tiklar
    Examples: Test Datalari
      | mevcutparolayi | yeniparolayi | username | password   |
      | Abc123.        | 1234567890   | saizah   | Abc123.    |
      | 1234567890     | abcdef       | saizah   | 1234567890 |
      | abcdef         | ABCDEFG      | saizah   | abcdef     |
      | ABCDEFG        | Abc123.      | saizah   | ABCDEFG    |