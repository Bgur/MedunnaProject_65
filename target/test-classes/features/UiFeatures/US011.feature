@US11
Feature:"My Appointments" Physician (Doctor) tarafendan duzenlenebilmeli

  @US11TC01
  Scenario:TC01-Doktor yeni bir randevu olusturabilmeli

   Given Doktor medunnaUrl sayfasina gider
    When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
    Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
    And Doktor username alanina gecerli "DoktorUsername" girer
    And Doktor Password alanina gecerli "DoktorPasssword" girer
    And  Doktor Sign in butonuna tiklar
    And Doktor MY PAGES ikonuna tiklar
    And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
    And  Doktor  Useful Links altindaki Make an appointment'a tiklar
    And  Doktor first name alanina "hastanin ismi" girer
    And  Doktor last name alanina "hastanin soyismi" girer
    And  Doktor SSN alanina hastanin 3. ve 5. rakamlarindan sonra "-" koymak uzere 9 haneli sayi girer
    And  Doktor hastanin "email adresini" girer
    And  Doktor hastanin telefon numarasini girer
    And  Doktor randevu tarihini girer
    And  Doktor Send an Appointment Request butonuna tiklar
    And  Doktor Appointment registration saved! We will call you as soon as possible mesajini gorur
    And Doktor sayfayi kapatir

  @US11TC02
   Scenario: TC02-Doktor mevcut bir randevuyu duzenleyebilmeli

      Given Doktor medunnaUrl sayfasina gider
      When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor edit butonuna tiklar
      And  Doktor Status menusunu Pending olarak secer
      And  Doktor Anamnesis alanini doldurur
      And  Doktor Treatment alanini doldurur
      And  Doktor Diagnosis alanini doldurur
      And  Doktor Prescription alanini bos birakir
      And  Doktor Description alanini bos birakir
      And  Doktor save butonuna tiklar
      And  Doktor The Appointment is updated mesajini gorur
      And Doktor sayfayi kapatir

  @US11TC03
  Scenario: TC03-Doktor bir randevuyu guncelediginde; hastanin "id, start and end date, Status, physician and patient" bilgilerini gormeli

      Given Doktor medunnaUrl sayfasina gider
      When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor edit butonuna tiklar
      And  Doktor Status menusunu Pending olarak secer
      And  Doktor Anamnesis alanini doldurur
      And  Doktor Treatment alanini doldurur
      And  Doktor Diagnosis alanini doldurur
      And  Doktor Prescription alanini bos birakir
      And  Doktor Description alanini bos birakir
      And  Doktor save butonuna tiklar
      And  Doktor The Appointment is updated mesajini gorur
      And  Doktor randevu guncellendikten sonra hastanin id, start and end date, Status, physician and patient bilgilerini gorur
      And Doktor sayfayi kapatir

  @US11TC04
  Scenario:TC04-Doktor tarafindan "Anamnesis, Treatment ve Diagnosis" alanlarin doldurulmasi zorunlu olmali
    Given Doktor medunnaUrl sayfasina gider
    When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor edit butonuna tiklar
      And  Doktor Status menusunu Pending olarak secer
      And  Doktor Anamnesis alanini doldurur
      And  Doktor Treatment alanini doldurur
      And  Doktor Diagnosis alanini doldurur
      And  Doktor Prescription alanini doldurur
      And  Doktor Description alanini doldurur
      And  Doktor save butonuna tiklar
      And Doktor sayfayi kapatir

  @US11TC05
  Scenario: TC05-Doktor tarafindan  "prescription ve description" alanlarinin doldurulmasi zorunlu olmamali

    Given Doktor medunnaUrl sayfasina gider
    When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor edit butonuna tiklar
      And  Doktor Status menusunu Pending olarak secer
      And  Doktor Anamnesis alanini doldurur
      And  Doktor Treatment alanini doldurur
      And  Doktor Diagnosis alanini doldurur
      And  Doktor Prescription alanini bos birakir
      And  Doktor Description alanini bos birakir
      And  Doktor save butonuna tiklar
      And Doktor sayfayi kapatir

  @US11TC06
  Scenario:TC06-"Status" doktor tarafindan "PENDING, COMPLETED veya CANCELLED" olarak secilebilmeli
    Given Doktor medunnaUrl sayfasina gider
    When Doktor sayfada sag ust kosedeki kullanici ikonuna tiklar
      Then Doktor sayfada kullanici ikonu altinda yer alan sign in butonuna tiklar
      And Doktor username alanina gecerli "DoktorUsername" girer
      And Doktor Password alanina gecerli "DoktorPasssword" girer
      And  Doktor Sign in butonuna tiklar
      And Doktor MY PAGES ikonuna tiklar
      And  Doktor sayfada MY PAGES ikonu altinda yer alan My Appointmeints bolumune tiklar
      And  Doktor edit butonuna tiklar
      And  Doktor Status menusunu Pending olarak secer
      And  Doktor Anamnesis alanini doldurur
      And  Doktor Treatment alanini doldurur
      And  Doktor Diagnosis alanini doldurur
      And  Doktor Prescription alanini bos birakir
      And  Doktor Description alanini bos birakir
      And  Doktor save butonuna tiklar
      And Doktor sayfayi kapatir





