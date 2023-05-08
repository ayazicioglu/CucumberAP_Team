

  Feature: Trello da yer alan fonksiyonlar test edilir

    Scenario: Create a Board bilgi girisi yapilir

      Given Api kullanicisi "1/boards" path parametreleri set eder
      Given api kullanicisi "isim", "key", "token" query parametrelerini set eder
      Then api kullanicisi Post request gonderir

    Scenario: Get a Board ile id girilerek bilgilere ulasilir

      Given  Api kullanicisi "1/boards/644fae553204da7e617e3ecf" path parametreleri set eder
      Given  "key", "token" query parametrelerini set eder
      Then api kullanicisi Get request gonderir

    Scenario: Update a Board bilgi girisi yapilir
      
      Given Api kullanicisi "1/boards/644fae553204da7e617e3ecf" path parametreleri set eder
      Given  "key", "token" ve "isim" query parametrelerini set eder
      Then api kullanicisi Put request gonderir

    Scenario: Delete a Board ile silme islemi yapilir
      Given Api kullanicisi "1/boards/644fae553204da7e617e3ecf" path parametreleri set eder
      Given  "key", "token" query parametrelerini set eder
      Then api kullanicisi Delete request gonderir

    @API
      Scenario: Update a board ile renk degistirilir
        Given Api kullanicisi "1/boards/645109eea08583e4623b90dd" path parametreleri set eder
        Given  "key", "token" ve "renk" query parametreleriyle gunceller eder
        Then api kullanicisi Put request gonderir





        
