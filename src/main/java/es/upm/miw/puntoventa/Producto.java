package es.upm.miw.puntoventa;

public class Producto extends AbstractProduct{

    protected double price;
    
    public Producto(String name, double price) {
        super(name);
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void add(AbstractProduct cc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractProduct cc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String view() {
        return this.getName()+"="+this.getPrice();
    }
}
