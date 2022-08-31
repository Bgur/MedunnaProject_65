Feature: US25Api Test


  Scenario Outline: TC

    * kullanici gerekli path params ayarlari yapar
    * kullanici expected datalari girer "<firstname>" "<lastname>" "<Ssn>" "<email>" "<phone>" "<startDate>"
    * kullanici request gonderir ve response alir
    * kullanici Api kayitlarini dosyaya kaydeder
    * kullanici Api kayitlari dogrular

    Examples:
      | firstname | lastname   | Ssn          | email                    | phone        | startDate  |
      | Nona      | csthi7xv7v | 3178-69-0249 | hramon.roberts@yahoo.com | 455-455-4555 | 30.08.2023 |
