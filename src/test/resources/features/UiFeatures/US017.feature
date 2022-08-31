Feature:US017 Test items (oge) olustur/guncelle/sil

  Background: US017 ortak methodlar
    Given  User Medunna Url ye gider
    Then   User isaretine ve signin butonunu tiklar
    Then Admin username ve passwordu girer ve sign in butonuna tiklar
    Then Items items sekmesine ve test item sekmesine tiklar

  @US017_TC01 @US017
  Scenario:Admin yeni test ogeleri oluşturabilir
    Then Create a new Test Item butonuna tiklar
    Then Name Description Price Default  Min Value Default Max Value lari girer ve Save butonuna tiklayarak Test Item olusturur ve dogrular

  @US017_TC02 @US017
  Scenario:Admin, "test items; Name, Description, price Default min value, Default max value ve
  created date (Gun/Ay/Yıl) oluşturabilir ve guncelleyebilir.
    Then Create a new Test Item butonuna tiklar
    Then Name Description Price Default Min Value Default ve Created Date verilerini girer
    Then Save butonuna tiklar, ID sekmesine tiklar, olusturulan Itemin Edit butonuna tiklayarak eski verileri gunceller ve save butonuna tiklar
    Then Güncel Itemin gorunurlugu dogrulanir

  @US017_TC03 @US017
  Scenario:Admin test ogelerini goruntuleyebilir
    Then Create a new Test Item butonuna tiklar
    Then Name Description Price Default Min Value Default ve Created Date verilerini girer
    Then Save butonuna tiklar, ID sekmesine tiklar, olusturulan Itemin Edit butonuna tiklayarak eski verileri gunceller ve save butonuna tiklar
    Then Herhangi bir Test Iteminin View butonuna tiklayarak goruldugunu dogrular

  @US017_TC04 @US017
  Scenario: Admin test ogelerini silebilir
    Then Create a new Test Item butonuna tiklar
    Then Name Description Price Default Min Value Default ve Created Date verilerini girer
    Then Herhangi bir Test Iteminin Delete butonuna tiklayarak silindigini dogrular


