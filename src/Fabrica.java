



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Fabrica tipo de implementacion
 * @author Estuardo Ureta
 */

public class Fabrica{
    /**
     * Metodo que devuelve un tipo de set segun lo indicado por el usuario
     * @param tipoSet Es el tipo de set que se desea
     * @return Devuelve un Set
     */
    public static <K,V> Map<K,V> getMap(String tipoSet) {

        if (tipoSet.equalsIgnoreCase("HM")) {
            return new HashMap<K,V>();

        } else if (tipoSet.equalsIgnoreCase("TM")) {
            return new TreeMap<K,V>();

        } else if (tipoSet.equalsIgnoreCase("LHM")) {
            return new LinkedHashMap<K,V>();
        }
        return null;
    }
}