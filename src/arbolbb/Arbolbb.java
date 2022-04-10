/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbb;

/**
 *
 * @author godoy
 */
public class Arbolbb {

  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     int t = 3;
        //Se crea el arbol B segun t
        Arbol arbolB = new Arbol(t);
        
        //Valores a ingresar primera ronda
        int[] valoresUno = {20,10,50,25,40,75,5,4}; //    inge  20, 10, 50, 25, 40,75,55
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }
      arbolB.imprimir();
      arbolB.buscar(25);
    }
    
    
}
