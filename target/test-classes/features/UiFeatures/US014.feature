Feature: US_014 Physician (Doctor) "Edit Inpatient" (Yatili Tedavi) islemleri yapabilmeli
  (My Appointments / View / Edit Impatients)
@tcbir
Scenario: TC001 Doktor"ID, start and end dates, description, created date
appointment id, status, room and patient" bilgilerini görüntülüyebilmeli ve güncelenebilmeli
Given Doktor  Medunna internet sitesine gider
When Doktor anasayfa sag ust kosede bulunan kullanici ikonunu tiklar
And Doktor acilan dropdown menuden  Sign in sekmesini secer
And Doktor kullanici adi ve parola girerek kendi sayfasina giris yapar
And Doktor giris yaptigi sayfada "My Pages" butonuna tiklar
And Doktor acilan dropdown menuden "My inpatients" i secer
Then Doktor yatan hastanin ID, start and end dates, description, created date, appointment id, status, room and patient bilgilerinin gorunur oldugunu dogrular
And Doktor sayfayi kapatir

@tciki
Scenario: TC002 "Status" doktor tarafindan "UNAPPROVED, DISCHARGED, STAYING veya CANCELLED" olarak güncellenebilmeli
Given Doktor  Medunna internet sitesine gider
When Doktor anasayfa sag ust kosede bulunan kullanici ikonunu tiklar
And Doktor acilan dropdown menuden  Sign in sekmesini secer
And Doktor kullanici adi ve parola girerek kendi sayfasina giris yapar
And Doktor giris yaptigi sayfada "My Pages" butonuna tiklar
And Doktor acilan dropdown menuden "My inpatients" i secer
And Doktor "My inpatients" ekraninda hasta bilgilerinin son kisminda bulunan "Edit" butonuna listedeki hastalardan "status" u  "UNAPPROVED" olan ilk hasta icin tiklar
And Doktor acilan ekranda status basligi altindaki dropdown menuyu tiklar, "UNAPPROVED" secenegini secer ve Save butonuna tiklar
And Doktor ekranin sol ust kosesinde uzerinde "The In Patient is updated with identifier" yazan bir alert box un ciktigini dogrular
And Doktor "My inpatients" ekraninda hasta bilgilerinin son kisminda bulunan "Edit" butonuna listedeki hastalardan "status" u  "UNAPPROVED" olan ilk hasta icin tiklar
And Doktor status basligi altindaki dropdown menuden "STAYING" secenegini secer
Then Doktor Room menusunden varsa ilk Available odayi secer Save butonuna basar ve uzerinde "The In Patient is updated with identifier" yazan bir alert'in ciktigini test eder, Available oda yoksa ilk Unavailable odayi secer, Save butonuna tiklar ve "The room already reserved" yazan bir alertin ciktigini dogrular
And Doktor giris yaptigi sayfada "My Pages" butonuna tiklar
And Doktor acilan dropdown menuden "My inpatients" i secer
And Doktor "My inpatients" ekraninda hasta bilgilerinin son kisminda bulunan "Edit" butonuna listedeki hastalardan "status" u  "STAYING" olan ilk hasta icin tiklar
And Doktor acilan ekranda status basligi altindaki dropdown menuyu tiklar, "DISCHARGED" secenegini secer ve Save butonuna tiklar
And Doktor ekranin sol ust kosesinde uzerinde "The In Patient is updated with identifier" yazan bir alert box un ciktigini dogrular
And Doktor "My inpatients" ekraninda hasta bilgilerinin son kisminda bulunan "Edit" butonuna listedeki hastalardan "status" u  "UNAPPROVED" olan ilk hasta icin tiklar
And Doktor acilan ekranda status basligi altindaki dropdown menuyu tiklar, "CANCELLED" secenegini secer ve Save butonuna tiklar
And Doktor ekranin sol ust kosesinde uzerinde "The In Patient is updated with identifier" yazan bir alert box un ciktigini dogrular
And Doktor sayfayi kapatir



Scenario: TC003 Doktor rezerve edilmis odayi güncelleyebilmeli
  Given Doktor  Medunna internet sitesine gider
  When Doktor anasayfa sag ust kosede bulunan kullanici ikonunu tiklar
  And Doktor acilan dropdown menuden  Sign in sekmesini secer
  And Doktor kullanici adi ve parola girerek kendi sayfasina giris yapar
  And Doktor giris yaptigi sayfada "My Pages" butonuna tiklar
  And Doktor acilan dropdown menuden "My inpatients" i secer
  And Doktor "My inpatients" ekraninda hasta bilgilerinin son kisminda bulunan "Edit" butonuna listedeki hastalardan "status" u  "STAYING" olan ilk hasta icin tiklar
  Then Doktor Room menusunden varsa ilk Available odayi secer Save butonuna basar ve uzerinde "The In Patient is updated with identifier" yazan bir alert'in ciktigini test eder, Available oda yoksa ilk Unavailable odayi secer, Save butonuna tiklar ve "The room already reserved" yazan bir alertin ciktigini dogrular
  And Doktor sayfayi kapatir

