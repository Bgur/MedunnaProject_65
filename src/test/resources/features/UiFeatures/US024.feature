@US024
Feature:US024 Hasta test sonuclarini ve faturayi gorebilmelidir

  @US024_TC01
  Scenario:TC01 Hasta testsonuclarini gorebilmelidir

  Given Kullanici Medunna Url'ye gider
  Then Sign in butonunu tiklar
  And Kullanici username ve password girer
  And Kullanicisign in butonuna tiklar ve sign olur
  And Kullanici My Pages butonunu tiklar
  And Kullanici My Appointment butonunu tiklar
  And Testleri goruntule butonunu tiklar
  And Kullanici sonuclari gor butonunu tiklar
  And Id, name for test, max ve min value, test data ve description bolumleri gorulur

  @US024_TC02
  Scenario:TC02 Hasta faturayi gorebilmelidir
  Given Kullanici Medunna Url'ye gider
  Then Sign in butonunu tiklar
  And Kullanici username ve password girer
  And Kullanicisign in butonuna tiklar ve sign olur
  And Kullanici My Pages butonunu tiklar
  And Kullanici My Appointment butonunu tiklar
  And Kullanici shov Invoice butonuna tiklar
  And Kullanici faturayi gorur