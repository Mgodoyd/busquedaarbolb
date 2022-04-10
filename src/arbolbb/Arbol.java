/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbb;

/**
 *
 * @author godoy
 */
public class Arbol {
    NodoB root;
    int t;

    //Constructor
    public Arbol(int t) {
        this.t = t;
        root = new NodoB(t); //inicaliza el arbol
    }

 
    public void insertar(int key) {
        NodoB r = root;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoB s = new NodoB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r); //dividimos
            nonFullInsert(s, key); //insertamos
        } else {
            nonFullInsert(r, key);
        }
    }
    
    // Caso cuando la raiz se divide
    // x =          | | | | | |
    //             /
    //      |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoB x, int i, NodoB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoB z = new NodoB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        y.n = (t - 1);                                                          //               /   \
                                                                                //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        x.child[(i + 1)] = z;                                                   //               /   \
                                                                                //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        x.key[i] = y.key[(t - 1)];                                              //               /    \
        x.n++;                                                                  //  |10|20| | | |      |40|50| | | |
    }

    private void nonFullInsert(NodoB x, int key) {
        //Si es una hoja
        if (x.leaf) {
            int i = x.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                int temp= x.key[i - 1];
                x.key[i] = x.key[i - 1];//Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;//asigna el valor al nodo
            x.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

             
                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }
    public void imprimir(){
        imprimir(this.root);
    }
 //imprimir nodos   
     private void imprimir(NodoB n) {
     n.imprimir();
     //Si no es hoja
       if (!n.leaf) {
           //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
               if (n.child[j] != null) {
                   System.out.println();
                     imprimir(n.child[j]);
   }
  }
 }
}
//buscar nodo
 public void buscar(int elemento) {
        NodoB r = root;
        buscar(elemento,r);
    }
    
    private void buscar(int elemento,NodoB n){
        
        int v=n.find(elemento);
        if(v!=-1){
            System.out.println("El nodo "+elemento+" esta en la posicion "+v);
        }
        n.find(elemento);
        if(!n.leaf){
            for(int j=0; j<=n.n;j++){
                if(n.child[j]!=null){
                    buscar(elemento,n.child[j]);
                }
            }
        }
    }
    

/*
*   La solucion seria ejecutar un if que cuando se ingrese el 5(child) y el 4(child) en este caso
*   la primer condicion seria eliminarlos de las posiciones anteriores he insertarlos al lado izquierdo
*   si no insertalos al lado izquierda 
*/

//if()

/* BUSQUEDA(array, valor){
* for(i=0; i<longitud(array); i++){
*If (valor==array[i]{
*return i
* }
* }
* return null
 }*/

/* boolean insertado =false;
   
    while(n!=null & insertado==false){
      if(n!=null){
             System.out.println("\nExiste nodo"); 
      } else{
             System.out.println("\nExiste nodo"); 
      } 
       insertado=true;  
    }*/
