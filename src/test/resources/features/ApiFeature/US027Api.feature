Feature: US027 Messages by Admin Validate with API and DB


  @test27
  Scenario: TC_003 Kullanici27 API kullanarak mesaj okur
    When Kullanici27 API kullanarak id 237805 olan mesaji okur
    Then Kullanici27 okudugu mesaji dogrular




  Scenario: TC_004 Kullanici27 API kullanarak mesaj olusturur
    When Kullanici27 API kullanarak mesaj olusturur
    Then Kullanici27 mesaj olustugunu dogrular
