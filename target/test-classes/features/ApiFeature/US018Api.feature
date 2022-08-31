@MainApi
Feature:US018 Kullanici Api kullanarak doktorlari dogrular

  Scenario:TC01 Kullanici Doktor bilgileerini gonderir ve dogrular

    And  Kullanici "239609" id'li doktor verileri icin bir get request gonderir
    And Doktorun "<Tabib>", "<Onaran>","<509-65-1661>","<300>", "<ALLERGY_IMMUNOLOGY>" Datalarina Sahip Oldugunu Dogrular.

