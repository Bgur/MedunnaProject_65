@US010
Feature:US010-Doktor (Physician) randevulari

  @US010TC01
  Scenario:TC01-Doktor, randevu listesini ve zaman dilimlerini "My Appointments" sekmesinden gorebilmeli

    Given Doktor medunnaUrl sayfasina gider
      When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor randevu listesi ve zaman dilimlerini gorur
      And Doktor sayfayi kapatir

  @US010TC02
  Scenario:TC02-Doktor"patient id, start date, end date, status" bilgilerini gorebilmeli

    Given Doktor medunnaUrl sayfasina gider
     When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
     Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
     And Doktor username alanina gecerli "DoktorUsername" girer
     And Doktor Password alanina gecerli "DoktorPasssword" girer
     And Doktor Sign in butonuna tiklar
     And Doktor MY PAGES ikonuna tiklar
     And Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
     And Doktor patient id, start date, end date, status bilgilerini gorur
     And Doktor sayfayi kapatir


