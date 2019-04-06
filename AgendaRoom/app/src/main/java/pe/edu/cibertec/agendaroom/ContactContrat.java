package pe.edu.cibertec.agendaroom;

public class ContactContrat {
    //static ---> es para noc rear instancias a cada rato
    //final --> que no va a varidad , se convierte en una constante


    // CONTENT PROVIDER --> QUE INF SE COMPARTE --> NECESITA ALGUNOS DATOS PARA SABER QUE COMPARTE

    public static final  String AUTHORITY = "pe.edu.cibertec.agendaroom.provider";

    // que vas a compartir

    public static  final  String CONTENT_PATH = "contact";

    // URI como acceder a la informacion
    public  static final String CONTENT_URI = "content://"+AUTHORITY + "/" + CONTENT_PATH;

    //Para obtener multiples filas
    public static final String MULTIPLE_ITEMS = "vnd.android.cursor.dir/vnd."
            + AUTHORITY
            + "."
            + CONTENT_PATH;

    //Para obtener una unica fila
    public static final String SIGLE_ITEM = "vnd.android.cursor.item/vnd."
            + AUTHORITY
            + "."
            + CONTENT_PATH;;



}
