
Feature: Mainpage-Appointment form uzerinden hastalar randevu tarihi olusturabilmelidir

  Background:
    Given OS kullanici url'e gider
    Then OS kullanici Make an Appointment butonuna tiklar
    And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    And OS kullanici First Name kutusunu doldurur
    And OS kullanici Last Name kutusunu doldurur
    And OS kullanici SSN kutusunu doldurur
    And OS kullanici Email kutusunu valid bir deger ile doldurur
    Then OS kullanici phone textbox'ini valid bir deger ile doldurur


  Scenario: US06 Mainpage-Appointment formda date bos birakilabilmelidir
    #Given OS kullanici url'e gider
    #Then OS kullanici Make an Appointment butonuna tiklar
    #And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And OS kullanici First Name kutusunu doldurur
    #And OS kullanici Last Name kutusunu doldurur
    #And OS kullanici SSN kutusunu doldurur
    #And OS kullanici Email kutusunu valid bir deger ile doldurur
    #Then OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'inda yer alan tarihin sistem tarihi ile ayni oldugunu dogrular
    And OS kullanici Send an Appointment Request butonunu tiklar
    And OS kullanici OS kullanici randevusunun olustugunu cikan popup ile dogrular

  Scenario: US07 Mainpage-Appointment formda date alani icin gecmis tarih secildiginde randevu olusturulmamalidir
    #Given OS kullanici url'e gider
    #Then OS kullanici Make an Appointment butonuna tiklar
    #And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And OS kullanici First Name kutusunu doldurur
    #And OS kullanici Last Name kutusunu doldurur
    #And OS kullanici SSN kutusunu doldurur
    #And OS kullanici Email kutusunu valid bir deger ile doldurur
    #Then OS kullanici phone textbox'ini valid bir deger ile doldurur
    And OS kullanici date textbox'ini gecmis bir tarih ile doldurur
    Then OS kullanici date textboxinin altinda Appointment date can not be past date! uyarisinin gorundugunu dogrular
    And OS kullanici Send an Appointment Request butonunu tiklar
    Then OS kullanici randevunun basarili bir sekilde kaydedilemedigini cikan popup ile dogrular

  Scenario: US08 Mainpage-Appointment formda date alani icin ileri tarihli valid bir deger secildiginde randevu olusturulmamalidir
    #Given OS kullanici url'e gider
    #Then OS kullanici Make an Appointment butonuna tiklar
    #And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And OS kullanici First Name kutusunu doldurur
    #And OS kullanici Last Name kutusunu doldurur
    #And OS kullanici SSN kutusunu doldurur
    #And OS kullanici Email kutusunu valid bir deger ile doldurur
    #And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar
    And OS kullanici OS kullanici randevusunun olustugunu cikan popup ile dogrular

  Scenario Outline: US09 Mainpage-Appointment formda date alani gg/aa/yy formatina uygun olarak doldurulmalidir
    #Given OS kullanici url'e gider
    #Then OS kullanici Make an Appointment butonuna tiklar
    #And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And OS kullanici First Name kutusunu doldurur
    #And OS kullanici Last Name kutusunu doldurur
    #And OS kullanici SSN kutusunu doldurur
    #And OS kullanici Email kutusunu valid bir deger ile doldurur
    #And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni oldugunu dogrular

    Examples:
      | date |
      |01.01.2030|
      |31.01.2030|
      |01.12.2039|

  Scenario Outline: US10 Mainpage-Appointment formda date alani aa/gg/yy formatina uygun olarak dolduramamalidir
    #Given OS kullanici url'e gider
    #Then OS kullanici Make an Appointment butonuna tiklar
    #And OS kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And OS kullanici First Name kutusunu doldurur
    #And OS kullanici Last Name kutusunu doldurur
    #And OS kullanici SSN kutusunu doldurur
    #And OS kullanici Email kutusunu valid bir deger ile doldurur
    #And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni olmadigini dogrular

    Examples:
      | date |
      |12.13.2030|
      |01.31.2030|

