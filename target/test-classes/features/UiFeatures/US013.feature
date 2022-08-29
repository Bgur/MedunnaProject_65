
@US013
Feature:US013_Doktor "Test Results" islemleri yapabilmeli

  Background:US013 Ortak adimlar
    Given Kullanici "medunna_url" sayfasina gider
    And Kullanici Anasayfada kullanici ikonuna tiklar
    And Doktor  sign in sekmesini secer
    And Doktor acilan sayfada Username bolumune kullanici adini girer
    And Doktor ayni sayfada bulunan Password bolumune sifresini girer
    Then Doktor ayni sayfada bulunan Sign in butonuna tiklar
    And  Doktor giris yaptigi sayfada My Pages butonuna tiklar
    And Doktor My Appointments secenegini tiklar
    And Sonraki sayfada randevusu olan hastasinin satirindaki Edit secenegini tiklar

  @US013_TC01
  Scenario:US013_TC01 Doktor "Test Results" islemleri yapabilmeli
    Given Doktor Request A butonuna tiklar
    And Doktor Glucose, urea, creatinine, Sodium, Potassium,Total protein, Albumin, Hemoglobin testlerini secer
    And Doktor Save butonuna tiklar
    And Acilan sayfada Show Test Result secenegini tiklar
    And Acilan sayfada View Result secenegini tiklar
    And Doktor  id, name, default max value, default min value, test, description and the date bilgilerini gorur
    And Kullanici browseri kapatir

  @US013_TC02
  Scenario:US013_TC02 Doktor Request Impatient isteginde bulunabilmeli
    Given Acilan sayfada Request Inpatient secenegini tiklar
    And Kullanici browseri kapatir