Feature: Admin olarak duzenleme yapma

  Background:Admin olarak sayfaya giris
    Given Admin medunnaUrl sayfasina gider
    * Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar
    * Admin kullanici ikonu altinda yer alan sign in butonuna tiklar
    * Admin username alanina gecerli "AdminUsername" girer
    * Admin password alanina gecerli "AdminPassword" girer
    * Admin Sign in butonuna tiklar
    * Admin acilan anasayfada Administration kismindan User management yazisina tiklar


  Scenario: Admin kullanicilari active edebilir
    Given Admin dokuzuncu sayfaya gider
    * Deactivate olan ilk kullaniciyi bulur ve activate eder

  Scenario: Admin kullanicilarin bilgilerini goruntuleyebilir
    Given Admin sayfadaki ilk kullanicinin view butonuna tiklar
    * Admin firstname bolumunde kullanici adinin gorunebildigini dogrular
    * Admin lastname bolumunde kullanici soyadinin gorunebildigini dogrular
    * Admin email bolumunde kullanici mailinin gorunebildigini dogrular
    * Admin Login bolumunde kullanici username gorunebildigini dogrular

  Scenario Outline: Admin kullanicilari "User profile" olarak atayabiliyor
    * Admin "<User profile>" olmayan ilk kullaniciyi bulup edit butonuna tiklar
    * Admin acilan sayfadan "<User profile>" secenegine tiklar
    * Admin save butonuna tiklayip yapilan degisikligi kaydeder
    * Admin yapilan degisikligin onaylandigini acilan popup ile dogrular
    * Admin yeniden ilk sayfaya gider

    Examples:
      | User profile   |  | User profile2  |
      | ROLE_ADMIN     |  | ROLE_ADMIN     |
      | ROLE_USER      |  | ROLE_USER      |
      | ROLE_STAFF     |  | ROLE_STAFF     |
      | ROLE_PATIENT   |  | ROLE_PATIENT   |
      | ROLE_PHYSICIAN |  | ROLE_PHYSICIAN |
#
#
#   Scenario: Admin kullanicilari USER olarak atayabiliyor
#         * Admin ROLE_USER olmayan ilk kullaniciyi bulur
#          * Admin ROLE_USER olmayan kullanicinin edit butonuna tiklar
#          * Admin acilan sayfadan ROLE_USER secenegine tiklar
#
#
#   Scenario: Admin kullanicilari PATIENT olarak atayabiliyor
#         * Admin ROLE_PATIENT olmayan ilk kullaniciyi bulur
#          * Admin ROLE_PATIENT olmayan kullanicinin edit butonuna tiklar
#          * Admin acilan sayfadan ROLE_PATIENT secenegine tiklar
#
#
#   Scenario: Admin kullanicilari STAFF olarak atayabiliyor
#         * Admin ROLE_STAFF olmayan ilk kullaniciyi bulur
#          * Admin ROLE_STAFF olmayan kullanicinin edit butonuna tiklar
#          * Admin acilan sayfadan ROLE_STAFF secenegine tiklar
#
#
#   Scenario: Admin kullanicilari PHYSICAN olarak atayabiliyor
#         * Admin ROLE_PHYSICAN olmayan ilk kullaniciyi bulur
#          * Admin ROLE_PHYSICAN olmayan kullanicinin edit butonuna tiklar
#          * Admin acilan sayfadan ROLE_PHYSICAN secenegine tiklar
#
#     Scenario: Admin kullanicilari silebiliyor
#       * Admin sayfadaki ilk kullanicin yaninda bulunan delete butonuna tiklar
#       * Admin kullanicinin silindigini cikan popupla dogrular
#
#
#
