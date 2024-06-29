package org.example.implementation.normal;

public class MonteCarlo {

    private static final int Max = 10000;
    private Coordenadas[] plano;
    private int count;

    private int regionCuadradaX;
    private int regionCuadradaY;

    public MonteCarlo() {
        this.plano = new Coordenadas[Max];
        this.count = 0;
        this.regionCuadradaX = 1;
        this.regionCuadradaY = 1;
    }

    public void setRegionCuadradaX(int regionCuadradaX) {
        this.regionCuadradaX = regionCuadradaX;
    }

    public void setRegionCuadradaY(int regionCuadradaY) {
        this.regionCuadradaY = regionCuadradaY;
    }

    public void agregarCoordenadas(Coordenadas corde){
        if (corde.getX() >= 0 && corde.getX()<= regionCuadradaX && corde.getY() >= 0 && corde.getY()<= regionCuadradaY) {
            if (count == Max){
                throw new RuntimeException("Muchos elementos");
            }
            for (int i = 0; i< count;i++){
                if (plano[i].getX() == corde.getX() && plano[i].getY() == corde.getY()){
                    return;
                }
            }
            plano[count] = corde;
            count++;
        }
    }

    public double aproximarPi(){
        int dentroDelCirculo = 0;
        for (Coordenadas coordenada : plano){
            if (coordenada != null){
                if (Math.pow(coordenada.getX(),2) + Math.pow(coordenada.getY(),2) <= 1) {
                    dentroDelCirculo++;
                }
            }
        }
        return 4.0 * dentroDelCirculo / count;
    }
}



