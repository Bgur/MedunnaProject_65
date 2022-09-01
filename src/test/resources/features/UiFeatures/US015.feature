@US015
Feature:US015-Admin tarafindan hasta olusturma ve duzenleme

  Background:Admin olarak sayfaya giris
    Given Admin medunnaUrl sayfasina gider
    When Admin medunna anasayfasinin sag ust kosesindeki kullanici ikonuna tiklar
    And Admin kullanici ikonu altinda yer alan sign in butonuna tiklar
    And Admin username alanina gecerli "AdminUsername" girer
    And Admin password alanina gecerli "AdminPassword" girer
    And Admin Sign in butonuna tiklar
    And Admin acilan anasayfada Items&Titles ikonuna tiklar
    And Admin Items&Titles ikonu altinda yer alan Patient bolumune tiklar

  @US015TC001
  Scenario: US015_TC001_Yeni hastalar yalnizca yonetici tarafindan olusturulabilmeli

    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin first name alanina "hastanin ismi" girer
    And Admin last name alanina "hastanin soyismi" girer
    And Admin Birth date alanina  "hastanin dogum tarihi" girer
    And Admin Email alanina  "hastanin email adresini" girer
    And Admin Phone alanina hastanin telefon numarasini girer
    And Admin Gender alanina "hastanin cinsiyeti" secer
    And Admin Blood Group alanina "hastanin kan grubu" secer
    And Admin Address alanina "hastanin adressi" girer
    And Admin Description alanini doldurur
    And Admin user alanina  kullanici secer
    And Admin Country alanina hastanin ulkesini secer
    And Admin State-City alanini bos birakir
    And Admin Save butonuna tiklar
    And Admin A new Patient is created mesajini gorur


  @US015TC002
  Scenario: US015_TC002_Admin hastalarin SSN, First Name, Last Name, Birth Date, Phone, Gender bilgilerini gorebilmeli
    And Admin 3357 id nolu hastanin SSN numarasi bilgisini gorur
    And Admin 3357 id nolu hastanin First Name bilgisini gorur
    And Admin 3357 id nolu hastanin Last Name bilgisini gorur
    And Admin 3357 id nolu hastanin Birt Date bilgisini gorur
    And Admin 3357 id nolu hastanin Phone number bilgisini gorur
    And Admin 3357 id nolu hastanin Gender bilgisini gorur


  @US015TC003
  Scenario: US015_TC003_Admin hastanin Blood Group, Address, Description,
            Created Date, User, Country ve State-City bilgilerini gorebilmeli

    And Admin 3357 id nolu hastanin Blood Group bilgisini gorur
    And Admin 3357 id nolu hastanin Adress bilgilesini gorur
    And Admin 3357 id nolu hastanin Description bilgisini gorur
    And Admin 3357 id nolu hastanin Created Date bilgisini gorur
    And Admin 3357 id nolu hastanin User bilgisini gorur
    And Admin 3357 id nolu hastanin Country bilgisini gorur
    And Admin 3357 id nolu hastanin State-City bilgisini gorur

  @US015TC004
  Scenario: US015_TC004 Admin hasta bilgilerini guncellerken hastanin SNN ve Created Date bilgilerine data girisi yapabilmeli
    And Admin ilk siradaki hastanin bilgilerini guncellemek icin edit butonuna tiklar
    And Admin hastanin bilgilerini guncellemek icin SNN numarasina ve Created Date bilgisine data girisi yapar


  @US015TC005
  Scenario: US015_TC005 Admin yeni hasta kaydi olustururken hastanin SNN ve Created Date bilgilerine data girisi yapabilmeli
    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin yeni hasta kaydi olustururken hastanin SNN numarasina ve Created Date bilgisine data girisi yapar



  @US015TC006
  Scenario:US015_TC006 Admin hasta bilgilerini guncellerken hastanin First Name, Last Name, Birth Date,
            Phone, Gender, Blood Group, Address, Description, User, Country  bilgilerine data girisi yapabilmeli

    And Admin ilk siradaki hastanin bilgilerini guncellemek icin edit butonuna tiklar
    And Admin hastanin First Name bilgisine data girisi yapar
    And Admin hastanin Last Name bilgisine data girisi yapar
    And Admin hastanin Birth Date bilgisine data girisi yapar
    And Admin hastanin Phone Number bilgisine data girisi yapar
    And Admin hastanin Gender bilgisine data girisi yapar
    And Admin hastanin Blood Groub bilgisine data girisi yapar
    And Admin hastanin Adress bilgisine data girisi yapar
    And Admin hastanin Description bilgisine data girisi yapar
    And Admin hastanin User bilgisine data girisi yapar
    And Admin hastanin Country bilgisine data girisi yapar
    And Admin Save butonuna tiklar
    And Admin A Patient is updated mesajini gorur


  @US015TC007
  Scenario:US015_TC007 Admin yeni hasta kaydi olustururken hastanin First Name, Last Name, Birth Date, Phone,
  Gender, Blood Group, Address, Description, User, Country  bilgilerine data girisi yapabilmeli
    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin first name alanina "hastanin ismi" girer
    And Admin last name alanina "hastanin soyismi" girer
    And Admin Birth date alanina  "hastanin dogum tarihi" girer
    And Admin Email alanina  "hastanin email adresini" girer
    And Admin Phone alanina hastanin telefon numarasini girer
    And Admin Gender alanina "hastanin cinsiyeti" secer
    And Admin Blood Group alanina "hastanin kan grubu" secer
    And Admin Address alanina "hastanin adressi" girer
    And Admin Description alanini doldurur
    And Admin user alanina  kullanici secer
    And Admin Country alanina hastanin ulkesini secer
    And Admin Save butonuna tiklar
    And Admin A new Patient is created mesajini gorur



  @US015TC008
  Scenario:US015_TC008 "State", "US state" olmali ve bos birakilmamali
    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin hastanin bilgilerini doldurur
    And Admin Country alanina USA'yi secer
    And Admin State-City alanina data girisi yapar
    And Admin Save butonuna tiklar
    And Admin A new Patient is created mesajini gorur



  @US015TC009
  Scenario:US015_TC009 "State", "US state" olmali ve bos birakilmamali - NegatifTest
    And Admin acilan sayfada create a new Patient butonuna tiklar
    And Admin hastanin bilgilerini doldurur
    And Admin Country alanina USA'yi secer
    And Admin State-City alanini bos birakir
    And Admin Save butonuna tiklar
    And Admin A Patient is created yazisinin gorulmedigini dogrular



  @US015TC010
  Scenario: US015_TC010 Admin hastaya doktor atayabilmeli
    And Admin ilk siradaki hastaya doktor atayabilmek icin edit butonuna tiklar
    And Admin doktor atama sekmesini bulur ve doktor atamasi yapilabildigini test eder


  @US015TC011
  Scenario: US015_TC011 Admin herhangi bir hastayi silebilmeli
    And Admin ilk siradaki hastayi silmek icin delete butonuna tiklar
    And Admin acilan Confirm Delete Operation uyari mesajinda delete butonuna tiklar
    And Admin hastanin silinip silmedigini kontrol etmek icin A Patient is deleted mesajini gormeli









