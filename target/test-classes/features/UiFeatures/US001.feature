Feature:US001_Kayit olmak icin SSN, Firstname ve Lastname bilgileri girililebilmelidir.

  @TC01 @US001_TC01 @E2E
  Scenario:US001_TC01 Kullanici SSN bos birakilamaz
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    Then   Kullanici SSN kutucugunu bos birakir
    And    Kullanici FirstName kutusuna tiklar
    And    KUllanici SSN kutucugunu bos birakinca 'Your SSN is required.' uyarı mesajını görüntüle
    And    Kullanici browseri kapatir



  @TC02 @TC03 @Negative @US01 @E2E
  Scenario Outline:US001_TC02_TC03 Kullanici Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    Then   Kullanici SSN kutucugunu bos birakir
    And     Kullanici FirstName kutusuna tiklar
    And    KUllanici SSN kutucugunu bos birakinca 'Your SSN is required.' uyarı mesajını görüntüle
    And    Kullanici SSN kutucuguna tiklar
    And   Kullanici SSN kutucuğuna "<karekter>"lerden ve "<harf>"lerden  olusan SSN girmeli ve kabul edilmemeli
    And      Kullanici Your SSN is invalid' uyarı mesajı görüntülenmeli
    And    Kullanici browseri kapatir
    Examples:
      | karekter    | harf       |
      | *-/-\- @#$$ | aaa-bb-aaa |
      | ass-**-dd1  | ccc-cc-ccc |

  @TC04 @Negative @US01 @E2E
  Scenario Outline:US001_T04 Kullanici Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.

    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    Then   Kullanici SSN kutucugunu bos birakir
    And     Kullanici FirstName kutusuna tiklar
    And    KUllanici SSN kutucugunu bos birakinca 'Your SSN is required.' uyarı mesajını görüntüle
    And    Kullanici SSN kutucuguna tiklar
    And   Kullanici SSN kutucuğuna "<8ile10haneli>"rakamlardan olusan ve "<2.ve6.rakamlardan sonra>"içeren bir ssn girer
    And      Kullanici Your SSN is invalid' uyarı mesajı görüntülenmeli
    And    Kullanici browseri kapatir
    Examples:
      | 8ile10haneli | 2.ve6.rakamlardan sonra |
      | 456-12-78520 | 45-612-7852             |
      | 456-12-785   | 4561-2-7852             |
      | 456-127-852  | 4565-22-5555            |

  @TC05 @Pozitive @US01 @E2E
  Scenario:TC_005 Kullanici Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.

    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    Then   Kullanici SSN kutucugunu bos birakir
    And   Kullanici SSN kutucuguna tiklar
    And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    And Kullanici dogru SSN girdigini dogrular
    And    Kullanici browseri kapatir

  @TC06 @Pozitive @US01 @E2E
  Scenario:TC_006 Kullanici First Name bos kutusunu birakilamaz

    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    Then    Kullanici FirstName kutusuna tiklar
    And    Kullanici FirstName kutusunu bos birakir
    And   Kullanici LastName kutusuna tiklar
    And    KUllanici FirstName kutucugunu bos birakinca Your FirstName is required. uyarı mesajını görüntüler

  @TC07 @Negative @US01 @E2E
  Scenario Outline:TC_07 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "First Name" olmalidir

    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    Then    Kullanici FirstName kutusuna tiklar
    And Kullanici First Name kutucuğuna "<karekterlerden ve rakamlardan>" olusan First Name girer
    And Kullanici gecerli olmayan bir First Name girmesine ragmen kabul edildigini gorur


    Examples:
      | karekterlerden ve rakamlardan |
      | 11**--??44                    |
      | ..                            |
      | 1/.*sa                        |


  @TC08 @Pozitive @US01 @E2E
  Scenario:TC_08 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "First Name" olmalidir

    Given  Kullanici "medunna_url" sayfasina gider
    And    Kullanici Anasayfada kullanici ikonuna tiklar
    And    Kullanici ikonu altindaki regester'i tiklar
    When   Kullanici SSN kutucuguna tiklar
    And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
    Then    Kullanici FirstName kutusuna tiklar
    And Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
    And Kullanici gecerli olan bir First Name girer ve kabul edildigini gorur

  @TC09 @Negative @US01 @E2E
    Scenario:TC_09 Kullanici Last Name kutusunu bos birakilamaz
      Given  Kullanici "medunna_url" sayfasina gider
      And    Kullanici Anasayfada kullanici ikonuna tiklar
      And    Kullanici ikonu altindaki regester'i tiklar
      When   Kullanici SSN kutucuguna tiklar
      And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
      And    Kullanici FirstName kutusuna tiklar
      And Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
      Then   Kullanici LastName kutusuna tiklar
      And Kullanici FirstName kutusuna tiklar
      And    KUllanici LastName kutucugunu bos birakinca Your LastName is required. uyarı mesajını görüntüler

  @TC10 @Negative @US01 @E2E
    Scenario Outline:TC_10 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Last Name" olmalidir

      Given  Kullanici "medunna_url" sayfasina gider
      And    Kullanici Anasayfada kullanici ikonuna tiklar
      And    Kullanici ikonu altindaki regester'i tiklar
      When   Kullanici SSN kutucuguna tiklar
      And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
      And    Kullanici FirstName kutusuna tiklar
      And Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
      Then   Kullanici LastName kutusuna tiklar
      And Kullanici Last Name kutucuğuna "<karekterlerden ve rakamlardan>" olusan Last Name girer
      And Kullanici gecerli olmayan bir Last Name girmesine ragmen kabul edildigini gorur
      Examples:
        | karekterlerden ve rakamlardan |
      | 11**--??44                    |
      | .                             |
      | 1/.*sa                        |


  @TC11 @Pozitive @US01 @E2E
    Scenario:TC_11 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Last Name" olmalidir

      Given  Kullanici "medunna_url" sayfasina gider
      And    Kullanici Anasayfada kullanici ikonuna tiklar
      And    Kullanici ikonu altindaki regester'i tiklar
      When   Kullanici SSN kutucuguna tiklar
      And Kullanici SSN kutusuna dokuz rakamdan oluşan ve ucuncu ve besinci rakamdan sonra - içeren  bir ssn girer
      And    Kullanici FirstName kutusuna tiklar
      And Kullanici First Name kutucuğuna karekterlerden ve rakamlardan olusan First Name girer
      Then   Kullanici LastName kutusuna tiklar
      And Kullanici Last Name kutucuğuna karekterlerden ve rakamlardan olusan Last Name girer


