Feature: US002_Kayit olmak icin email and username bilgileri girilebilmelidir.

  @US02 @TC201
  Scenario:TC01_UserName bos birakilamaz
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And     Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
    And   Kullanici UserName kutucuguna tiklar ardından boş bırakır
    And   Kullanici Your UserName is required. uyarı mesajını görüntüler


  @US02 @TC2028 @Negative
  Scenario:TC02_Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Username" olmalidir
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
    Then   Kullanici UserName kutucuguna tiklar
    And  Kullanici harfler ve rakamlardan olusan "1as2sd5" girilirer. ve Your username is invalid. uyari mesaji gorulmez


  @US02 @TC202 @Negative
  Scenario:TC02_Kullanici Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Username" olmalidir
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
   Then  Kullanici UserName kutucuguna tiklar
    And  Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan "<*/*/>" girilir ve Your username is invalid. uyari mesaji gorulur



  @US02 @TC202 @Pozitive
  Scenario:TC02_Kullanici Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Username" olmalidir
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
    Then  Kullanici UserName kutucuguna tiklar
    And  Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan "Team65" girilir ve uyari mesaji alinmaz
  @US02 @TC204 @Negative
    Scenario:TC04_Kullanici Email kutusunu bos birakamaz

      Given  Kullanici "medunna_url" sayfasina gider
      And    Kullanici Anasayfada kullanici ikonuna tiklar
      And    Kullanici ikonu altindaki regester'i tiklar
      When   Kullanici SSN kutucuguna tiklar
      And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
      And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
      And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
      And Kullanici UserName kutucuguna tiklar
      And  Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan "Team65" girilir ve uyari mesaji alinmaz
      Then Kullanici Email kutusuna tiklar
      And Kullanici Email kutusunu bos birakinca Your email is required. uyarı mesajını görüntüler

  @US02 @TC205 @Negative
      Scenario:TC_05_Kullanici Email adresi 5 karekterden az ve  "@" ve "." karakterleri olmadan doldurulamamalidir.
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
    And Kullanici UserName kutucuguna tiklar
    And  Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan "Team65" girilir ve uyari mesaji alinmaz
    Then Kullanici Email kutusuna tiklar
    And Kullanici Email kutucuğuna bes karakterden az "gjk2" yollandığında Your email is required to be at least five characters. uyarı mesajı görüntülenmeli
    And Kullanici Email kutusuna ve . olmadan "healthteam65@gmailcom" girer.Ve This field is invalid mesajini alir
    And Kullanici Mail kutusuna ve @ olmadan "healthteam65gmail.com" girer. This field is invalid mesajini alir

    Scenario:TC06_Kullanici Email adresi "@" ve "." karakterleri kullanarak dogru email girebilmeli

      Given  Kullanici "medunna_url" sayfasina gider
      And    Kullanici Anasayfada kullanici ikonuna tiklar
      And    Kullanici ikonu altindaki regester'i tiklar
      When   Kullanici SSN kutucuguna tiklar
      And    Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
      And   Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
      And   Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer
      And Kullanici UserName kutucuguna tiklar
      And  Kullanici harfler ve rakamlardan olusan herhangi bir karakter sinirlamasina tabi tutulmayan "Team65" girilir ve uyari mesaji alinmaz
      Then Kullanici Email kutusuna tiklar
      And Kullanici Email kutucuğuna mail adresi @ ve . karakterleri kullanarak "healthteam65@gmail.com" girer.
      And Kullanici herhangi bir uyarı mesajı almaz


