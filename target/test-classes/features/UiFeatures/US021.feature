Feature:US021 Staff hastalar için randevulari gorur


  Background:

    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Staff username ve password girer
    And Staff sign in butonuna tiklar ve sign olur


  Scenario:TC_01 Personel sadece appoinment leri guncelleyebilir

    Then Staff My Pages butonunu tiklar
    And Staff Search Patient sekmesini tiklar
    #And Staf sayfayi kapatir

  Scenario:TC_02 Personel hastanin status durumunu UNAPPROVED, PENDING or CANCELLED, secebilmeli COMLETED secememeli

    Then   Staff My Pages butonunu tiklar
    And    Staff Search Patient sekmesini tiklar
    And   Staff gecerli bir ssn girer.
    And   Staff schowAppoinmen e tiklar
    And    Staff edit butonuna tiklar.
    Then   Staff hastanin  Status durumunu UNAPPROVED, PENDING or CANCELLED secebildigini test eder
    #And    Staff sayfayi kapatir


  Scenario:TC_03 Personel icin Anamnesis, Treatment or Diagnosis kisimlari doldurmasi gerekli degildir
    Then   Staff My Pages butonunu tiklar
    And    Staff Search Patient sekmesini tiklar
    And   Staff gecerli bir ssn girer.
    And   Staff schowAppoinmen e tiklar
    And    Staff edit butonuna tiklar.
    Then Staff Anamnesis,diagnos sayfalari bos olsada sisteme kaydedebilir
   # And    Staff sayfayi kapatir


  Scenario:TC_04 Personel hasta icin gerekli doktoru secer

    Then   Staff My Pages butonunu tiklar
    And    Staff Search Patient sekmesini tiklar
    And   Staff gecerli bir ssn girer.
    And   Staff schowAppoinmen e tiklar
    And    Staff edit butonuna tiklar.
    Then Staff hasta icin doktoru secer
    And Staff kaydeder
   # And    Staff sayfayi kapatir


  Scenario:TC_05 Personel hastalarin test sonuclarini gorebilir
    Then   Staff My Pages butonunu tiklar
    And    Staff Search Patient sekmesini tiklar
    And   Staff gecerli bir ssn girer.
    And   Staff schowAppoinmen e tiklar
    And Staff schowTest e tiklar
    Then Staff hastanin testlerinin gorunurlugunu dogrular
   # And    Staff sayfayi kapatir