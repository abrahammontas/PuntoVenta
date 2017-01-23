package es.upm.miw.puntoventa;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Comanda extends AbstractProduct{
    
    private List<AbstractProduct> childs = new ArrayList<AbstractProduct>();
    
    public Comanda(String name) {
        super(name);
    }

    public void add(AbstractProduct aP) {
        this.childs.add(aP);
    }

    public void remove(AbstractProduct aP) {
        this.childs.remove(aP);
    }

    public boolean isComposite() {
        return true;
    }

    public double getPrice() {
        double price = 0d;
        for (AbstractProduct child : childs) {
            price += child.getPrice();
        }
        return price;
    }
    
    public void setPrice(double price) {
        throw new UnsupportedOperationException();
    }
    
    public String view() {
        return String.valueOf(this.getPrice());
    }    
}
 

