package es.upm.miw.puntoventa;

public abstract class AbstractProduct extends Component{
    
    protected String name;
 
    public AbstractProduct(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void add(AbstractProduct cc);

    public abstract void remove(AbstractProduct cc);

    public abstract boolean isComposite();

    public abstract String view();
    
    public abstract double getPrice();
 
    public abstract void setPrice(double price);
}