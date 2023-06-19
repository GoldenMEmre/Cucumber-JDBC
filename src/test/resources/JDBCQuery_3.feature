Feature: JDBC Query 3

  # Database üzerinden appointment tablosunda ögleden önce icin alinmis randevularin ögleden
  # sonra icin alinan randevulardan az oldugunu dogrulayiniz.

  Background: Connection
    * Database baglantisi kurulur.
  @day4
  Scenario: appointment tablosunda ögleden önce icin alinmis randevularin ögleden sonra icin alinan randevulardan az oldugunu dogrulayiniz.

    * Randevu sayilarini ogrenebilecegimiz sql querysi hazirlanir.
    * Query calistirilir ve sonuclar dogrulanir.
    * Database baglantisi kapatilir.