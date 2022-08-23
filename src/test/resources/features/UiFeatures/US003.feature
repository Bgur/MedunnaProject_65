@US003
Feature:US003

  Background: US003 ortak methodlar
    Given  User Medunna Url ye gider
    Then   User isaretine ve register butonunu tiklar


  @US003 @TC01
  Scenario:Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    Then   Kullanici alti karakterli tüm parametreleri iceren veya sadece tek parametre iceren sifre girer ve Password strengthde degisme olmadigini dogrular
    Then   Kullanici yedi veya daha fazla karakterli fakat yalnizca tek parametreli karakterler girer ve Password strengthde degisme olmadigini dogrular
    Then   Kullanici yedi karakterli ve ayni zamanda iki parametreli sifreler girerek Password strengthde bir sekme güclenme oldugunu dogrular
    Then   Kullanicinin en güclü sifre icin en az yedi karakter, en az iki farkli özel karakter ve diger parametrelerden en az bir tane iceren sifre girmesi gerektigi dogrulanir

  @US003 @TC02
  Scenario: Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Kullanici ilk alti karakteri büyük harften farkli en az bir cesit karakter iceren sifreye yedinci karakter olarak büyük harf girdiginde Password strength: de bir sekme güclenme oldugunu dogrular
    Then Kullanici ilk alti karaktere iki farkli parametreli olarak abcde*A girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak büyük harf girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular

  @US003 @TC03
  Scenario:  Daha guclu sifre icin en az 1 kucuk harf olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Kullanici ilk alti karakteri kücük harften farkli en az  bir cesit karakter iceren sifreye yedinci karakter olarak kücük harf girdiginde Password strength: de bir sekme güclenme oldugunu dogrular
    Then Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak kücük harf girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular

  @US003 @TC04
  Scenario: Sifre en az 1 rakam icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir
    Then Kullanici ilk alti karakteri rakamdan farkli en az bir cesit karakter iceren sifreye yedinci karakter olarak rakam girdiginde Password strength: de bir sekme güclenme oldugunu dogrular
    Then Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak rakam girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular

  @US003 @TC05
  Scenario: Sifre en az 1 ozel karakter icermeli ve"Password strength:" seviyesinin degistigi gorulebilmelidir
    Then Kullanici ilk alti karakteri özel karakterden farkli en az bir karakter iceren sifreye yedinci karakter olarak özel karakter  girdiginde Password strength: de bir sekme güclenme oldugunu dogrular
    Then Kullanici ilk alti karaktere iki farkli parametre girdikten sonra yedinci karaktere farkli bir tür ücüncü parametre olarak özel karakter girdiginde Password strength: de ücüncü sekme isiginin yandigini dogrular




