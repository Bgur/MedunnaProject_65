Feature:US022 Staff ssn ile hasta arayabilir


  Background:
    Given Kullanici Medunna Url'ye gider
    And Sign in butonunu tiklar
    And Staff username ve password girer
    When Staff sign in butonuna tiklar ve sign olur
  # And Staff My Pages butonunu tiklar
   # And Staff Search Patient sekmesini tiklar
   # And Staff SSN numarasini girerr.

  Scenario:Staff test sonuclarını gorebilmelidir.
    When Staff My Pages butonunu tiklar
    And Staff Search Patient sekmesini tiklar
    And Staff SSN numarasini girerr.
    And Staff Show appoinmant butonuna tiklar
    And Staff show test butonuna tiklar
    And Staff view results butonuna tiklar


  Scenario:Staff "ID, Date, Result, description, Created date, ..." gibi sonuc bilgileini gorebilmeli ve
  guncelleyebilmelidir

    When Staff My Pages butonunu tiklar
    And Staff Search Patient sekmesini tiklar
    And Staff SSN numarasini girerr.
    And Staff Show appoinmant butonuna tiklar
    And Staff show test butonuna tiklar
    And Staff view results butonuna
    And Staff edit butonuna tiklar
    And Staff result texboxa tiklar
    And Staff descripcion texboxuna tiklar
    And Staff save butomuna tiklar



  Scenario:Staff "ID, Date, Result, description, Created date, ..." gibi sonuc bilgileini gorebilmeli ve
    When Staff My Pages butonunu tiklar
    And Staff Search Patient sekmesini tiklar
    And Staff SSN numarasini girerr.
    And Staff Show appoinmant butonuna tiklar
    And Staff show test butonuna tiklar
    And Staff view results butonuna
    And Staff edit butonuna tiklar
    And Staff Date,Result,description,create date,test item,test texbox'larinin gorunurlugu test edilir


