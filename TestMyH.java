package objetoguarismo;
import java.util.Scanner;
/**
 *
 * @author Ing. Enrique Barrera
 */
public class TestMyH {
    public static void main(String[] args){
        int cantidad, indice; 
        byte nmuertos=0, nheridos=0;
        String cifraJugada="";
        GuarismoMyH numero = new GuarismoMyH();
        Scanner teclado = new Scanner(System.in);
        do{
        cantidad = numero.getPosibles();
        if (cantidad > 0){
        int indiceDeCifraJugada=numero.getProximoPosible();
        cifraJugada=numero.getStrElemento(indiceDeCifraJugada);
        System.out.println("Pienso que tu cifra puede ser: " + cifraJugada);
        System.out.print("Introduce la cantidad de muertos para la cifra "+ cifraJugada + " : ");
        nmuertos = (byte) teclado.nextInt();
        System.out.print("Introduce la cantidad de heridos para la cifra "+ cifraJugada + " : ");
        nheridos = (byte) teclado.nextInt();
        numero.descartarPorIndice( indiceDeCifraJugada, nmuertos, nheridos);
        }else
                System.out.println("Alguna de las respuestas suministradas carece de lógica");
        }while((nmuertos!=4)&&(cantidad >0));
        
        
        
    }
    
    
    
}

