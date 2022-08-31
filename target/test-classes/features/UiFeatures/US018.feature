@US018
Feature:US018 Admin, doktorlarin bilgilerini gorebilmelidir, duzenleyebilmeli, silebilmeli.

  Background:Admin olarak sayfaya giris
    Given Admin medunnaUrl sayfasina gider
    When Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan sign in butonuna tiklar
    And Admin username alanina gecerli "AdminUsername" girer
    And Admin password alanina gecerli "AdminPassword" girer
    And Admin Sign in butonuna tiklar

  @US018TC01
  Scenario:US018TC01 Admin, doktorlarin bilgilerini gorebilmelidir
    And Admin acilan anasayfada Items&Titles ikonuna tiklar
    And Admin Items&Titles ikonu altinda yer alan Physician bolumune tiklar
    And Admin doktorlarin bilgilerini gorur

  @US018TC02
  Scenario:US018TC02 Admin, SSN kimligine gore kayitli bir kisiyi secebilir, arayabilir
    And Admin acilan anasayfada Items&Titles ikonuna tiklar
    And Admin Items&Titles ikonu altinda yer alan Physician bolumune tiklar
    And Admin Edit butonunu tiklar
    Then Use Search boxsa tik atar
    And SSN boxa gecerli bir SSN girer
    And Search User butonuna tiklar

  @US018TC03
  Scenario:US018TC03 Admin Doktorin bilgilerini Edit butonu uzerinden duzenleyebilir
    And Admin acilan anasayfada Items&Titles ikonuna tiklar
    And Admin Items&Titles ikonu altinda yer alan Physician bolumune tiklar
    And Admin Edit butonunu tiklar
    Then Use Search boxsa tik atar
    And SSN boxa gecerli bir SSN girer
    And Search User butonuna tiklar
    Then Firstname, lastname, birth date doldurur
    And Admin, dr icin bir uzmanlik alani secer
    And Admin dr nin profil resmini duzenler
    And Admin dr nin muayene ucretini girer
    And Save butonunu tiklar

  @US018TC04
  Scenario:US018TC04 Admin,mevcut kullanicilar arasindan doktoru secmeli
    Given Admin Administration dropdownu tiklar
    Then Admin User managementi tiklar
    And Admin 555. sayfaya gider
    And Admin first name Lokman olan dr secer

  @US018TC05
  Scenario:US018TC05 Admin mevcut doktorları silebilir.
    Given Admin Administration dropdownu tiklar
    Then Admin User managementi tiklar
    And Admin 555. sayfaya gider
    And Admin first name Lokman olan dr secer
    And Secilen doktoru siler

