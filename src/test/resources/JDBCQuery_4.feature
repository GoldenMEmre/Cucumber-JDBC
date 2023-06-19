Feature: JDBC Query_4

  Background: Connection
    * Database baglantisi kurulur.

  #heallife_hospitaltraining.languages bolumunde karsilastirma yapilir
  # Database üzerinden languages tablosundaki short_code "yi" olan verinin language bilgisinin
  # "Yiddish" oldugunu dogrulayin.
    @query4
    Scenario:Database üzerinden languages tablosundaki short_code "yi" olan verinin language bilgisinin "Yiddish" oldugunu dogrulayin.

      * Languages tablosuna query gonderilir ve sonuclar dogrulanir.
      * Database baglantisi kapatilir.


