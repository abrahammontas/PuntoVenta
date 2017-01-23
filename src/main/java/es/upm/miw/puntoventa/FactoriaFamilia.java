package es.upm.miw.puntoventa;

import java.util.HashMap;
import java.util.Map;

public class FactoriaFamilia {

    private static FactoriaFamilia factoria = null;

    private Map<String, AbstractProduct> productMap;
    
    private AbstractProduct aP;

    private FactoriaFamilia() {
        productMap = new HashMap<String, AbstractProduct>();
    }

    public AbstractProduct get(String key) {
        if (productMap.containsKey(key)) {
            return productMap.get(key);
        } else {
            AbstractProduct aP = new Familia(key);
            productMap.put(key, aP);
            return aP;
        }
    }

    public static FactoriaFamilia getFactoria() {
        if (FactoriaFamilia.factoria == null) {
            FactoriaFamilia.factoria = new FactoriaFamilia();
        }
        return FactoriaFamilia.factoria;
    }
    
}
