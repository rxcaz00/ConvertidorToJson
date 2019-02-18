package controlador;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class Metodos {

    String cadena;

    public String convertidorJAVA(String texto) {
        try {
            Gson gson = new Gson();
            cadena = gson.toJson(texto);
        }
        catch (Exception e) {
            cadena = "no";
        }
        finally {
            return cadena;
        }
    }

    public String convertidorXML(String texto) {
        try {
            JSONObject xml = XML.toJSONObject(texto);
            cadena = xml.toString();
        }
        catch (Exception e) {
            cadena = "no";
        }
        finally {
            return cadena;
        }
    }
}
