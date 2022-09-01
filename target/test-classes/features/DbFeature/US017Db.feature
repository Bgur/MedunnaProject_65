Feature:US017 kullanici DB ile Test Items sorgular

  @US017 @US017_Db_TC01
  Scenario:

  Scenario Outline : kullanici database ile test item sorgular
    Given kullanici tablodan "<name_>" ile gerekli datayi alir
    Then kullanici db ile "<name_>" ile test item sorgulamasi yapar

    Examples:
      | name_ |
      | adf |

  @US017 @US017_Db_TC01
  Scenario Outline: id ile db üzerinden data kontrolü
    Given kullanici "<id>" ile data kontrol eder

    Examples:
      | id     |
      | 247687 |