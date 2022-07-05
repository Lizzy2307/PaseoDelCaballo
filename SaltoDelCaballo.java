import java.text.DecimalFormat;

public class SaltoDelCaballo {

	int[][] solucion;
	int paso = 1; // iniciamos en 1 el paso para mostrar las posiciones del caballo en la solución

	public SaltoDelCaballo(int n) { //Matriz solución de nxn
        solucion = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solucion[i][j] = 0;
            }
        }
	}
    
	public void resuelve() { 
        if (encontrarPosicion(0, 0, 0, solucion.length))
            mostrarResultado();
        else {
            System.out.println("NO HAY SOLUCIÓN POSIBLE");
        }
	}

	private boolean encontrarPosicion(int fila, int columna, int index, int n) {
        if (solucion[fila][columna]!=0){
            return false; // si esta posición es distinta de 0, entonces está ocupada
        }
        solucion[fila][columna] = paso++; // si no lo está, entonces la marcamos como ocupada
        if (index==n*n-1){ 
            return true;
        }
        
        if (esMovimientoPosible(fila + 2, columna + 1, n) && encontrarPosicion(fila + 2, columna + 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila + 1, columna + 2, n) && encontrarPosicion(fila + 1, columna + 2, index + 1, n)) 
            return true; 
        if (esMovimientoPosible(fila - 1, columna + 2, n) && encontrarPosicion(fila - 1, columna + 2, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 2, columna + 1, n) && encontrarPosicion(fila - 2, columna + 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 2, columna - 1, n) && encontrarPosicion(fila - 2, columna - 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 1, columna - 2, n) && encontrarPosicion(fila - 1, columna - 2, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila + 1, columna - 2, n) && encontrarPosicion(fila + 1, columna - 2, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila + 2, columna - 1, n) && encontrarPosicion(fila + 2, columna - 1, index + 1, n))
            return true; 
        // si no funciona vuelta atrás
        solucion[fila][columna] = 0;
        paso--;
        return false;
	}

	private boolean esMovimientoPosible(int fila, int col, int N){
        if (fila>=0 && col>=0 && fila<N && col<N){ // si la fila y la columna son mayores que cero y además menor que n
            return true; // entonces podemos desplazar el caballo
        }
        return false; // si no, devolvemos false, que indica que está ocupado
	}

	private void mostrarResultado() { // para imprimir el resultado, damos un formato especial de dos cifras
        DecimalFormat dosDigitos = new DecimalFormat("00"); // es útil para los números del 0 al 9, para que no se desvirtúe la matriz
        for (int i=0; i<solucion.length; i++){ 
            for (int j=0; j<solucion.length; j++){
                System.out.print("   " + dosDigitos.format(solucion[i][j]));
            }
            System.out.println();
        }
	}

public static void main	(String[] args) {
        int n = 8; // aquí especificamos la dimensión de nuestro tablero.
        SaltoDelCaballo i = new SaltoDelCaballo(n);
        i.resuelve();
	}{
    System.out.println("**********************************************************************************************************************");
        System.out.println("Este programa muestra el recorrido del Caballo en las 64 casillas del tablero, sin que la posición sea aleatoria");
        System.out.println("******************************************************************************************************************");
    }
}
