@US015
Feature:US015-Admin tarafindan hasta olusturma ve duzenleme

  Background:Admin olarak sayfaya giris
    Given Admin medunnaUrl sayfasina gider
    When Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan sign in butonuna tiklar
    And Admin username alanina gecerli "AdminUsername" girer
    And Admin password alanina gecerli "AdminPassword" girer
    And Admin Sign in butonuna tiklar
    And Admin acilan anasayfada Items&Titles ikonuna tiklar
    And Admin Items&Titles ikonu altinda yer alan Patient bolumune tiklar

  @US015TC001
  Scenario: US015_TC001-Yeni hastalar yalnizca yonetici tarafindan olusturulabilmeli


    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin first name alanina "hastanin ismi" girer
    And Admin last name alanina "hastanin soyismi" girer
    And Admin Birth date alanina  "hastanin dogum tarihi" girer
    And Admin Email alanina  "hastanin email adresini" girer
    And Admin Phone alanina hastanin telefon numarasini girer
    And Admin Gender alanina "hastanin cinsiyeti" secer
    And Admin Blood Group alanina "hastanin kan grubu" secer
    And Admin Address alanina "hastanin adressi" girer
    And Admin Description alanini doldurur
    And Admin user alanina  kullanici secer
    And Admin Country alanina hastanin ulkesini secer
    And Admin State-City alanina hastanin yasadigi sehri secer
    And Admin Save butonuna tiklar
    And Admin A new Patient is created mesajini gorur
    And Admin sayfayi kapatir
