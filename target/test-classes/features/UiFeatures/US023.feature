Feature:US023 Staff Hasta Bilgileri

  Background:US023 Hasta Bilgileri test
    Given Kullanici Medunna Url'ye gider
    And  Sign in butonunu tiklar
    And  Staff username ve password girer
    When Staff sign in butonuna tiklar ve sign olur
    And  Staff My Pages butonunu tiklar
    And  Staff Search Patient sekmesini tiklar
    And  SearchPatientSSNBox kutusuna hasta numarasi olarak "<SSN>" girer
    And  Staff Show appoinmant butonuna tiklar

  Scenario:TC001 Staff 'Payment Invoice / process' e gidebilir

    Then PaymentInvoiceProcessButton a tiklar
    And  PAYMENT DETAIL sayfasini gorur
#    Then PAYMENT DETAIL sayfasinin ekran goruntusunu alir




  Scenario:TC002 Staff 'Appointments' portalinda hasta icin bir fatura olusturmak icin
                    hastanin randevu durumunun COMPLETED veya CANCELED oldugunu gorur

    Then Personel Hasta adina fatura olusturmak icin RandevuDurumu nun COMPLETED veya CANCELED oldugunu gorur



  Scenario:TC003 Staff hastanin "PAYMENT DETAIL" sayfasininda test item ve exam fee'lerini
                    gorebilir
    Then  PaymentInvoiceProcessButton a tiklar
    And   Exam Fee yi gorur
    And  TestItem Fee yi gorur



  Scenario:TC004 Staff randevu durumu COMPLETED olan hasta icin yeni bir fatura olusturabilir
   Then Hastanin randevu durumunun COMPLETED olup olmadigini kontrol eder
   And Eger COMPLETED ise PaymentInvoiceProcessButton a tiklar
   And  Create Invoice butonuna tiklar
   And Create or edit a Bill formunu doldurur ve save butonuna tiklar
   And A Bill is updated with identifier yazili uyariyi gorur




  Scenario:TC005 Staff hastaya gonderilen faturayi gorebilir

    Then PaymentInvoiceProcessButton a tiklar
    And  ShowInvoiceButton a tiklar
    And InvoicePageTitleText in altinda INVOICE u gorur


