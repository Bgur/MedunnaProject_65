

Feature: Login-Appointment form uzerinden hastalar randevu tarihi olusturabilmelidir

  Scenario: TC01 Login-Appointment formda guncel tarih kabul edilmelidir.
    Given OS kullanici url'e gider
    Then OS kullanici signIn olur
    And OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And OS kullanici phone textbox'ini valid bir deger ile doldurur
    And OS kullanici date textbox'inda yer alan tarihin sistem tarihi ile ayni oldugunu dogrular
    And OS kullanici Send an Appointment Request butonunu tiklar
    And OS kullanici randevunun basarili bir sekilde kaydedildigini cikan popup ile dogrular


  Scenario: TC02 Login-Appointment formda date alani icin gecmis tarih secildiginde randevu olusturulmamalidir
    Given OS kullanici url'e gider
    Then OS kullanici signIn olur
    And OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And OS kullanici phone textbox'ini valid bir deger ile doldurur
    And OS kullanici date textbox'ini gecmis bir tarih ile doldurur
    And OS kullanici date textboxinin altinda Appointment date can not be past date! uyarisinin gorundugunu dogrular
    And OS kullanici Send an Appointment Request butonunu tiklar
    Then OS kullanici randevunun basarili bir sekilde kaydedilemedigini cikan popup ile dogrular

  Scenario: TC03 Login-Appointment formda date alani icin ileri tarihli valid bir deger secildiginde randevu olusturulmamalidir
    #Given OS kullanici signOut olur
    Given OS kullanici url'e gider
    Then OS kullanici signIn olur
    And OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    And OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar
    And OS kullanici randevunun basarili bir sekilde kaydedildigini cikan popup ile dogrular


  Scenario Outline: TC04 Login-Appointment formda date alani gg/aa/yy formatina uygun olarak doldurulmalidir
    Given OS kullanici url'e gider
    Then OS kullanici signIn olur
    And OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    And OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni oldugunu dogrular
    And OS kullanici signOut olur

    Examples:
      | date |
      |01.01.2030|
      |31.01.2030|
      |01.12.2039|


  Scenario Outline: TC05 Login-Appointment formda date alani aa/gg/yy formatina uygun olarak dolduramamalidir
    Given OS kullanici url'e gider
    Then OS kullanici signIn olur
    And OS kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    And OS kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And OS kullanici phone textbox'ini valid bir deger ile doldurur
    Then OS kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni olmadigini dogrular
    And OS kullanici signOut olur


    Examples:
      | date |
    |12.13.2030|
    |01.31.2030|








