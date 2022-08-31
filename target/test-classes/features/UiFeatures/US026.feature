@US026
Feature: US026

  Background:
    Given  User Medunna Url ye gider
    Then   Herhangi bir kullanici contact butonunu tiklar

  @US026 @TC01
  Scenario:
    Then Name, Email, Subject ve Message bilgilerini dogru girer
    Then Send butonuna tiklar
    Then Mesajin gonderildigi dogrulanir

  @US026 @TC02
  Scenario:
    Then Kullanici name, Email, subject, Message bilgilerini girildigini dogrular
