Feature:US009 Staff hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silememelidir.

  @UITest
  Scenario:TC01 Staff hastanin tum bilgilerini duzenler

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Staff username ve password girer
    And Staff sign in butonuna tiklar ve sign olur
    Then Staff My Pages butonunu tiklar
    Then Staff Search Patient sekmesini tiklar
    And Staff, Patients SSN search Boxa bir hasta SSN'i girer
    Then Staff ekrani saga kaydirarak edit butonunu tiklar
    And Staff hastanin tum bilgilerini duzenler
    And Staff butonuna tiklar

  @UITest
  Scenario:TC02  Staff hastanin tum bilgilerinin dolu oldugunu kontrol eder

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Staff username ve password girer
    And Staff sign in butonuna tiklar ve sign olur
    Then Staff My Pages butonunu tiklar
    Then Staff Search Patient sekmesini tiklar
    And Staff, Patients SSN search Boxa bir hasta SSN'i girer
    And Staff hastanin tum bilgilerinin dolu oldugunu kontrol eder

  @UITest
  Scenario:TC03 Admin hastanin bilgilerini update eder

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Admin username ve password girer
    And Admin sign in butonuna tiklar ve sign olur
    Then Admin Items&Titles butonunu tiklar
    And Admin Dropdown menusunden Patients butonunu tiklar
    Then Admin edit butonuna tiklar
    And Admin patientin tum bilgilerini update eder
    And Admin save butonunu tiklar

  @UITest
  Scenario:TC04 Admin hastanin bilgilerini dogrular

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Admin username ve password girer
    And Admin sign in butonuna tiklar ve sign olur
    Then Admin Items&Titles butonunu tiklar
    And Admin Dropdown menusunden Patients butonunu tiklar
    Then Admin wiew butonunu tiklar
    And Admin Patient bilgilerini dogrular

  @UITest
  Scenario:TC05 Admin patientin bilgilerini siler

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Admin username ve password girer
    And Admin sign in butonuna tiklar ve sign olur
    Then Admin Items&Titles butonunu tiklar
    And Admin Dropdown menusunden Patients butonunu tiklar
    Then Admin delete butonuna tiklar
    And Admin patientin bilgilerini siler

  @UITest
  Scenario:TC08 Staf hastalari silememeli

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Staff username ve password girer
    And Staff sign in butonuna tiklar ve sign olur
    Then Staff My Pages butonunu tiklar
    Then Staff Search Patient sekmesini tiklar
    Then Delete butonu gorunmez

  @UITest
  Scenario:TC09 Admin SSN ile hasta arayamamali

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Admin username ve password girer
    And Admin sign in butonuna tiklar ve sign olur
    Then Admin Items&Titles butonunu tiklar
    And Admin Dropdown menusunden Patients butonunu tiklar
    Then Ptients Search Box gorunmez