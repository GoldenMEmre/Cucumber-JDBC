package utilities;

public class Manage {//GETTER :Query'lerimizin başkaları tarafından sadece görüntülenebilmesini ama değiştirileme-
//mesini sağlamak için bu class'ı oluşturduk. Query'lerimiz aynı zamanda Conf.prop'da var.
    private String querySabah = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) < 12";
    private String queryAksam = "SELECT count(*) FROM heallife_hospitaltraining.appointment WHERE HOUR(time) > 12";


    private String languagesQuery = "SELECT language From heallife_hospitaltraining.languages Where short_code ='yi'";
    public String getQuerySabah() {
        return querySabah;
    }

    public String getQueryAksam() {
        return queryAksam;
    }

    public String getLanguagesQuery() {
        return languagesQuery;
    }
}
