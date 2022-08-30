Feature:US001_Kayıt olmak icin SSN, Firstname ve Lastname bilgileri girililebilmelidir.
  @US01 @TC12 @ApiRegistrant @E2E
  Scenario:TC_0012 Swagger kullanarak tüm kayıt bilgilerini alın ve doğrulanmalıdır
    When Kullanici pathparams ayarlamasini yapar
    Then Kullanici accountlarin bilgilerini alir
    And Kullanici alinan bilgilerin dogrulamasini yapar

  @TC12 @E2E @US01 @E2E
  Scenario:TC_0012  API kullanarak kayıtlı kişiler oluşturulup doğrulanmalıdır
    When Kullanici gerekli path params ayarlar
    Then Kullanici expected datalari girer
    And Kullanici request gonderir ve response alir
    Then Kullanici api kayitlarini dosyaya kaydeder
    And Kullanici  api kayitlarini dogrular