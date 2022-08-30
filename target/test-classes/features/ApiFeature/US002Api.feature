Feature:US002_Kayıt olmak için email and username bilgileri girilebilmelidir.

  @US02 @TC203 @ApiRegistrant
  Scenario:TC03_Kullanıcı adı api kullanılarak doğrulanmalıdır
    When kullanici pathparams ve bearer token ayarlamasini yapar
    Then kullanici adini dogrular