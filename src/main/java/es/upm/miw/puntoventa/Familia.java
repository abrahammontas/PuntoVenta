package es.upm.miw.puntoventa;

import java.util.ArrayList;
import java.util.List;

public class Familia extends AbstractProduct{
    
    private List<AbstractProduct> childs = new ArrayList<AbstractProduct>();
    
    public Familia(String name) {
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
    
    public String view() {
        String result = "";
        result += this.getName() + "\n";
        for (AbstractProduct item : childs) {
            result += item.view();
        }
        return result;
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void setPrice(double price) {
        throw new UnsupportedOperationException();
    }
}
