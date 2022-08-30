@OSM
Feature:US020 Admin; "User management" menusunden, kullanici Active eder ve gerekli rolleri olusturur.

  Background:SignIn olma
    * Admin "baseUrl" adresine gider
    * Admin Sayfanin en Ust sag kismindaki Profile Ikonu'na Tiklanir.
    * Admin Acilan sekmeden Sign in sececegi secilmelidir.
    * Admin Kullanici kayitli oldugu "AdminUsername" i girmelidir.
    * Admin Kullanici kayitli oldugu "AdminPassword" u girmelidir.
    * Admin kullanici Sign in butonuna basar.

Scenario: TC01 Admin kayitli kisilerin "firstname, lastname, email...  bilgilerinini gorebilmelidir


    * Admin Ustteki menulerden "Adminisration" secenegine tiklanmalidir.
    * Admin Acilan sekmeden "User management" secenegi secilmelidir.
    * Admin Acilan sekmenin Users sayfasi oldugunu dogrulamalidir.
    * Admin Gormek istedigi kayitli kisinin uzerine gelip en sagda bulunan "View" butonuna tiklanmalidir.
    * Admin First name bilgisi gorunur olmalidir.
    * Admin Last name bilgisi gorunur olmalidir.
    * Admin Email bilgisi gorunur olmalidir.
    * Admin Profiles durumu gorunur olmalidir.
    * Admin Sign out butonuna basarak cikis yapmalidir.
#    * Admin Sayfa kapatilir.
@mamet
  Scenario Outline:TC02 Admin kullaniciliar aktive edebilir ve rollerini "ADMIN, USER, PATIENT, STAFF ve PHYSICIAN" olarak atayabilir.
#  TC02-Admin kullaniciliar aktive edebilir ve rollerini "ADMIN, USER
#  PATIENT, STAFF ve PAdminSICIAN" olarak atayabilir.
#    * Admin "url" adresine gider
#    * Admin Sayfanin en üst sag kismindaki Profile Ikonu'na Tiklanir.
#    * Admin Acilan sekmeden Sign in sececegi secilmelidir.
#    * Admin Kullanici kayitli oldugu "AdminUsername" i girmelidir.
#    * Admin Kullanici kayitli oldugu "AdminPassword" u girmelidir.
#    * Admin kullanici Sign in butonuna basar.
    * Admin Ustteki menulerden "Adminisration" secenegine tiklanmalidir.
    * Admin Acilan sekmeden "User management" secenegi secilmelidir.
  #  * Admin rol atamasi yapmak istedigi kisinin uzerine gelip en sagda bulunan "Edit" butonuna tiklamalidir.
   # * Admin "Create or edit a user" sayfasinin acildigini dogrulamaldiir.
    * Admin "<User profile>" olmayan ilk kullaniciyi bulup edit butonuna tiklar
    * Admin acilan sayfadan "<User profile>" secenegine tiklar
    #* Admin Acilan sayfada "Pofiles" kismina gelip dropdowndan rol atamasi yapabilmelidir.
    * Admin Save butonuna basmalidir.
    * Admin "A user is updated with identifier" yazisinin ciktigini dogrulamalidir.
    * Admin Sign out butonuna basarak cikis yapmalidir.
#    * Admin Sayfa kapatilir.
    Examples:
      | User profile   |  | User profile2  |
      | ROLE_ADMIN     |  | ROLE_ADMIN     |
      | ROLE_USER      |  | ROLE_USER      |
      | ROLE_STAFF     |  | ROLE_STAFF     |
      | ROLE_PATIENT   |  | ROLE_PATIENT   |
      | ROLE_PHYSICIAN |  | ROLE_PHYSICIAN |
@active
  Scenario: Admin kullanicilari active edebilir.
    * Admin Ustteki menulerden "Adminisration" secenegine tiklanmalidir.
    * Admin Acilan sekmeden "User management" secenegi secilmelidir.
    * Admin Active olmayan ilk kullaniciyi bulup edit butonuna tiklar
    * Admin acilan sayfadan kullaniciyi Active eder
    * Admin Save butonuna basmalidir.
    * Admin "A user is updated with identifier" yazisinin ciktigini dogrulamalidir.
    * Admin Sign out butonuna basarak cikis yapmalidir.

  Scenario: TC03- Admin kullaniclari silebilmelidir.
#    * Admin "url" adresine gider
#    * Admin Sayfanin en üst sag kismindaki Profile Ikonu'na Tiklanir.
#    * Admin Acilan sekmeden Sign in sececegi secilmelidir.
#    * Admin Kullanici kayitli oldugu "AdminUsername" i girmelidir.
#    * Admin Kullanici kayitli oldugu "AdminPassword" u girmelidir.
#    * Admin kullanici Sign in butonuna basar.
    * Admin Ustteki menulerden "Adminisration" secenegine tiklanmalidir.
    * Admin Acilan sekmeden "User management" secenegi secilmelidir.
    * Admin silmek istedigi kullanicinin ustune en sagda bulunan "Delete" butonuna tiklamalidir.
    * Admin Yukarida cikan popup uzerindeki "Delete" butonuna tiklanmalidir.
    * Admin A user is deleted with identifier yazisinin ciktigini dogrulamalidir.
    * Admin Sign out butonuna basarak cikis yapmalidir.
#    * Admin Sayfa kapatilir.
