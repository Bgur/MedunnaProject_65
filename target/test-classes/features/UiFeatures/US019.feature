@US019
Feature:US019 Admin; yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme

  @US019_TC01
  Scenario Outline:US019TC01 Admin, SSN kimligine gore kayitli bir Staff(Personel) secebilir, arayabilir
    Given Admin medunna_Url sayfasina gider
    When Admin medunna anasayfasinda sag_ust kosedeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan Sign_In butonuna tiklar
    And Admin user name "<AdminUsername>" alanini doldurur
    And Admin user password "<AdminPassword>" alanini doldurur
    And Admin Sign_In butonuna tiklar
    And Admin acilan anasayfada Items&Titles alanina tiklar
    And Admin Items&Titles dropdown menusunde yer alan Staff secenegine tiklar
    And Admin Create_A_Staff butonuna tiklar
    Then Admin Use Search box'a tik atar
    And Admin SSN box'una var olan bir staff'a ait "<SSN>" girer
    And Admin Search_User butonuna tiklar
    Then Admin User found with search SSN mesajini gorur
    And Admin browser'i kapatir

    Examples: users credentials
      | AdminUsername | AdminPassword | SSN             |
      | Team65        | Team65.       | 111-22-3333     |

  @US019_TC02
  Scenario Outline:US019TC02 Admin; yeni Staff (Personel) Olusturabilmeli
    Given Admin medunna_Url sayfasina gider
    When Admin medunna anasayfasinda sag_ust kosedeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan Sign_In butonuna tiklar
    And Admin user name "<AdminUsername>" alanini doldurur
    And Admin user password "<AdminPassword>" alanini doldurur
    And Admin Sign_In butonuna tiklar
    And Admin acilan anasayfada Items&Titles alanina tiklar
    And Admin Items&Titles dropdown menusunde yer alan Staff secenegine tiklar
    And Admin Create_A_Staff butonuna tiklar
    And Admin SSN box'a staff'a ait "<SSN>" girer
    And Admin Search_User butonuna tiklar
    Then "<FirstName>", "<LastName>", "<BirthDate>", "<Phone>", "<Gender>", "<BloodGroup>", "<Address>", "<Description>", "<User>", "<Country>" alanlarini doldurulur
    And Save butonuna tiklar
    Then Admin yeni Satff olusturuldu mesajini dogrular
    And Admin browser'i kapatir

    Examples: users credentials
      | AdminUsername | AdminPassword | SSN         |  FirstName  | LastName  | BirthDate   | Phone      | Gender | BloodGroup | Address       | Description   | User                                  | Country         |
      | Team65        | Team65.       | 123-45-9871 | Staff-Emre  | Dursun    | 01.01.2000  | 0686303905 | MALE   | A+         | Pimpelmees 34 | IT_Department |user_112233445_56677889991646855897634 | France          |

  @US019_TC03
  Scenario Outline:US019TC03 Admin; kayıtlı Staff'in (Personel) bilgilerini Guncelleyebilir
    Given Admin medunna_Url sayfasina gider
    When Admin medunna anasayfasinda sag_ust kosedeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan Sign_In butonuna tiklar
    And Admin user name "<AdminUsername>" alanini doldurur
    And Admin user password "<AdminPassword>" alanini doldurur
    And Admin Sign_In butonuna tiklar
    And Admin acilan anasayfada Items&Titles alanina tiklar
    And Admin Items&Titles dropdown menusunde yer alan Staff secenegine tiklar
    And Admin bilgilerini guncellemek istedigi Staff'i secer
    Then "<FirstName>", "<LastName>" alanlarina yeni bilgiler doldurulur
    And Save butonuna tiklar
    Then Admin Satff bilgilerinin guncellendigini dogrular
    And Admin browser'i kapatir

    Examples: users credentials
      | AdminUsername | AdminPassword | FirstName   | LastName  |
      | Team65        | Team65.       | Can         | Tunay     |

  @US019_TC04
  Scenario Outline:US019TC04 Admin; kayıtlı Staff'in (Personel) bilgilerini Silebilir
    Given Admin medunna_Url sayfasina gider
    When Admin medunna anasayfasinda sag_ust kosedeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan Sign_In butonuna tiklar
    And Admin user name "<AdminUsername>" alanini doldurur
    And Admin user password "<AdminPassword>" alanini doldurur
    And Admin Sign_In butonuna tiklar
    Given Admin acilan anasayfada Administration ikonuna tiklar
    And Admin Administration ikonu altinda yer alan User managementi tiklar
    And Profiles bilgisi ROLE_STAFF olan herhangi bir Staff'i secer ve Delete butonuna tiklanir
    And Admin acilan Pop Up mesajinda Delete butonuna tekrar tiklar
    Then Basarili bir sekilde silindigi gelen Pop-Up bildirimi ile teyit edilir
    And Admin browser'i kapatir
    Examples: users credentials
      | AdminUsername | AdminPassword |
      | Team65        | Team65.       |