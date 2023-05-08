@Nasa
Feature: Kullanıcı belirli tarihe gore resim goruntuler
  
  Scenario: Tarih girilerek resim goruntulenir
    
    Given Api kullanicisi "planetary/apod" path parametreleri set eder
    Then "api_key","start_date","end_date" query parametreleri set eder
    Then api kullanicisi Get request gonderir