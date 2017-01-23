package es.upm.miw.puntoventa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.puntoventa.AbstractProduct;

public class PuntoVentaTest {
    private AbstractProduct Bebidas, Refrescos, Desayunos, Tapas, Comanda1, 
    Cafe, Te, Cocacola, Fanta, Tostada, Cacahuetes, Patatas;
    

    @Before
    public void ini() {
        Bebidas = FactoriaFamilia.getFactoria().get("Bebidas");
        Refrescos = FactoriaFamilia.getFactoria().get("Refrescos");
        Desayunos = FactoriaFamilia.getFactoria().get("Desayunos");
        Tapas = FactoriaFamilia.getFactoria().get("Tapas");
        
        Cafe = new Producto("Cafe", 2.5);
        Te = new Producto("Te", 2.5);
        Cocacola = new Producto("Cocacola", 1.75);
        Fanta = new Producto("Fanta", 1.75);
        Patatas = new Producto("Patatas", 1.5);
        Tostada = new Producto("Tostada", 3);
        Cacahuetes = new Producto("Cacahuetes", 2);
        
        Comanda1 = new Comanda("Order#1");
    }

    @Test
    public void testFamily() {
        assertSame(Bebidas, FactoriaFamilia.getFactoria().get("Bebidas"));
    }

    @Test
    public void testFamilyAddFamily() {
        Bebidas.add(Refrescos);
    }
    
    @Test
    public void testFamilyAddProduct() {
        Bebidas.add(Cafe);
        Bebidas.add(Te);
        Refrescos.add(Cocacola);
        Refrescos.add(Fanta);
        Desayunos.add(Cafe);
        Desayunos.add(Te);
        Desayunos.add(Tostada);
        Tapas.add(Cacahuetes);
        Tapas.add(Patatas);
    }
    
    @Test
    public void testComandaAddProduct() {
        Comanda1.add(Te);
        Comanda1.add(Tostada);
    }

    @Test
    public void testComandaGetTotal() {
        Comanda1.add(Te);
        Comanda1.add(Tostada);
        assertEquals(Comanda1.getPrice(),5.5, 0.01);
    }
    
    @Test
    public void testFamilyNoAddPrice() {
        try {
            Bebidas.setPrice(2);
            fail("");
        } catch (UnsupportedOperationException ignored) {
            ignored.toString();
        }
    }
    
    @Test
    public void testComandaNoAddPrice() {
        try {
            Comanda1.setPrice(2);
            fail("");
        } catch (UnsupportedOperationException ignored) {
            ignored.toString();
        }
    }
    
    @Test
    public void testProductNoAddProduct() {
        try {
            Tostada.add(Cafe);
            fail("");
        } catch (UnsupportedOperationException ignored) {
            ignored.toString();
        }
    }
    
    @Test
    public void testViewProduct() {
        assertEquals("Cafe=2.5" , Cafe.view());
    }

    @Test
    public void testViewFamilia() {

        Bebidas.add(Refrescos);
        
        assertEquals("Bebidas\nRefrescos\n", Bebidas.view());
    }
}
