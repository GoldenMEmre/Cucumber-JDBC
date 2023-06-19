package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;
import static utilities.JDBCReusableMethods.getStatement;

public class Stepdefinition {

    String query;
    String query1;
    ResultSet rs;

    ResultSet rs1;

    Statement st;

    int flag;

    Manage manage = new Manage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.createConnection();
    }

    @Given("Query hazirlanir.")
    public void query_hazirlanir() {
        query = "SELECT charge_id FROM heallife_hospitaltraining.ambulance_call WHERE patient_id=1 AND driver= 'Smith';";

    }

    @Given("Query calistirilir ve sonuclari alinir.")
    public void query_calistirilir_ve_sonuclari_alinir() throws SQLException {

        rs = getStatement().executeQuery(query);//Yukarıda oluşturulan query bir rs'ye atandı.
    }

    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {
    int expectedData = 2;

        flag=0;
        while (rs.next()){//resultset(rs)'in içinde kaç veri olduğunu while döngüsü içinde iterator'ü next ile
            flag++;//ilerleterek, iteratörün kaç defa ilerlediğini bularak tespit edebiliriz. Böylece kaç tane satır
        }//olduğunu, yani satır sayısını bulabiliriz. Bunları bir liste atıp list'in size'ı da alınabilir.Array'e
        // atıp oradan da alabiliriz.Burada bize sadece sayı gerektiği için flag'la da alabiliriz.İki defa döndükten
        assertEquals(expectedData, flag);//sonra false olacak ve sayı 2 çıkacak.
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();

    }
    //------------------------------------------------------------

    @Given("Update Query'si hazirlanir.")
    public void update_query_si_hazirlanir() {
    query1="insert into heallife_hospitaltraining.appointment (priority,specialist,doctor,amount,message,appointment_status,source,is_opd,is_ipd,live_consult) values (1,2,2,0,'helloTeam113','approved','OFFline','no','yes','yes');";

    }
    @Given("Sonuclari alinir ve dogrulanir.")
    public void sonuclari_alinir_ve_dogrulanir() throws SQLException {

        int sonuc = JDBCReusableMethods.getStatement().executeUpdate(query1);

        int verify=0;
        if(sonuc > 0){
            verify++;

        }

        assertEquals(verify,1);
    }

    //-----------------------------------------------------------------------

    @Given("Randevu sayilarini ogrenebilecegimiz sql querysi hazirlanir.")
    public void randevu_sayilarini_ogrenebilecegimiz_sql_querysi_hazirlanir() {

    }
    @Given("Query calistirilir ve sonuclar dogrulanir.")
    public void query_calistirilir_ve_sonuclar_dogrulanir() throws SQLException {

     rs = getStatement().executeQuery(manage.getQuerySabah());
     rs.next();
        System.out.println(rs.getInt(1));
     int sabahRandevulari = rs.getInt(1);

     ResultSet rs1 = JDBCReusableMethods.getStatement().executeQuery(manage.getQueryAksam());
        rs1.next();
        System.out.println(rs1.getInt(1));
        int aksamRandevulari= rs1.getInt(1);

     assertTrue(sabahRandevulari < aksamRandevulari);
    }


//------------------------------------------------------------------------



    @Given("Languages tablosuna query gonderilir ve sonuclar dogrulanir.")
    public void languages_tablosuna_query_gonderilir_ve_sonuclar_dogrulanir() throws SQLException {

        rs = getStatement().executeQuery(manage.getLanguagesQuery());
        rs.next();
        String expectedLanguages="Yiddish";
        String actualLanuages= rs.getString(1);

        assertEquals(expectedLanguages,actualLanuages);

    }


}