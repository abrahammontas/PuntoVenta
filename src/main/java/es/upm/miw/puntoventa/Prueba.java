package es.upm.miw.puntoventa;

import es.upm.miw.puntoventa.utils.IO;

public class Prueba {
    
    private AbstractProduct Bebidas, Refrescos, Desayunos, Tapas, Comanda1, 
    Cafe, Te, Cocacola, Fanta, Tostada, Cacahuetes, Patatas;

    private IO io;

    public Prueba() {
        io = new IO();
        setup();
        makeRelationships();
        printRealtionships();
        printComanda();
    }
    
    public void setup() {
        this.Bebidas = FactoriaFamilia.getFactoria().get("Bebidas");
        this.Refrescos = FactoriaFamilia.getFactoria().get("Refrescos");
        this.Desayunos = FactoriaFamilia.getFactoria().get("Desayunos");
        this.Tapas = FactoriaFamilia.getFactoria().get("Tapas");
        
        this.Cafe = new Producto("Cafe", 2.5);
        this.Te = new Producto("Te", 2.5);
        this.Cocacola = new Producto("Cocacola", 1.75);
        this.Fanta = new Producto("Fanta", 1.75);
        this.Patatas = new Producto("Patatas", 1.5);
        this.Tostada = new Producto("Tostada", 3);
        this.Cacahuetes = new Producto("Cacahuetes", 2);
        
        this.Comanda1 = new Comanda("Order#1");
    }
    
    public void makeRelationships() {
        this.Bebidas.add(Refrescos);
        this.Bebidas.add(Cafe);
        this.Bebidas.add(Te);
        this.Refrescos.add(Cocacola);
        this.Refrescos.add(Fanta);
        this.Desayunos.add(Cafe);
        this.Desayunos.add(Te);
        this.Desayunos.add(Tostada);
        this.Tapas.add(Cacahuetes);
        this.Tapas.add(Patatas);
        this.Comanda1.add(Te);
        this.Comanda1.add(Tostada);
    }
    
    public void printRealtionships() {
        io.writeln(this.Bebidas.view());
    }
    
    public void printComanda() {
        io.writeln(this.Comanda1.view());
    }
    
    public static void main(String[] args) {
        new Prueba();
    }
}
