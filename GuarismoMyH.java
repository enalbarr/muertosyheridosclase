
package objetoguarismo;
import java.util.Random;

public class GuarismoMyH {
    
  private static byte posibles[][] = new byte[5040][5];
  private static  int nposibles=0, ntotal=0;
  private static  byte muertos=0, heridos=0, digitos=4, digitoMaximo=9;
  private static String caracter="";
  
  public GuarismoMyH(){//Constructor
      for (byte i=0; i<=digitoMaximo; i++){
       for (byte j=0; j<=digitoMaximo; j++){
           for (byte k=0; k<=digitoMaximo; k++){
               for(byte l=0; l<=digitoMaximo; l++){
                   if((i != j) && (i != k) && (i!=l) && (j !=k) && (j != l) && (k != l)){
                   posibles[nposibles][0]=i;
                   posibles[nposibles][1]=j;
                   posibles[nposibles][2]=k;
                   posibles[nposibles][3]=l;
                   posibles[nposibles][4]=1;
                   nposibles++;
                   
                   //System.out.println("Disponible: " + i + j + k + l);
                   }
               }
           }
       }
   }
      ntotal=nposibles;
                       
                   
          
    }
  
  public byte muertosEntre (byte v11, byte v12, byte v13, byte v14, byte v21, byte v22, byte v23, byte v24){
      byte dead=0;
      if(v11==v21) dead++;
      if(v12==v22) dead++;
      if(v13==v23) dead++;
      if(v14==v24) dead++; 
      return dead;
      
  }
  
   public byte heridosEntre (byte v11, byte v12, byte v13, byte v14, byte v21, byte v22, byte v23, byte v24){
      byte wounded=0;
      if((v11==v22)||(v11==v23)||(v11==v24)) wounded++;
      if((v12==v21)||(v12==v23)||(v12==v24)) wounded++;
      if((v13==v21)||(v13==v22)||(v13==v24)) wounded++;
      if((v14==v21)||(v14==v22)||(v14==v23)) wounded++;
      return wounded;
      
  }
  


public void descartar (byte d1, byte d2, byte d3, byte d4, byte nmuertos,byte nheridos){
    int misposibles=0, misdescartados=0;
    for (int i=0; i<5040 ; i++){
        if(posibles[i][4]==1){
            int dead=muertosEntre(d1,d2,d3,d4,posibles[i][0],posibles[i][1],posibles[i][2],posibles[i][3]);
            int wounded=heridosEntre(d1,d2,d3,d4,posibles[i][0],posibles[i][1],posibles[i][2],posibles[i][3]);
            if((dead==nmuertos)&&(wounded==nheridos)){
                misposibles++;
            }else{
                misdescartados++;
                posibles[i][4]=0;
            }
        }
    }
    nposibles=misposibles;
    
}
  
public void descartarPorIndice (int indice, byte nmuertos,byte nheridos){
    int misposibles=0, misdescartados=0;
    byte d1=posibles[indice][0],d2=posibles[indice][1],d3=posibles[indice][2],d4=posibles[indice][3];
    for (int i=0; i<5040 ; i++){
        if(posibles[i][4]==1){
            int dead=muertosEntre(d1,d2,d3,d4,posibles[i][0],posibles[i][1],posibles[i][2],posibles[i][3]);
            int wounded=heridosEntre(d1,d2,d3,d4,posibles[i][0],posibles[i][1],posibles[i][2],posibles[i][3]);
            if((dead==nmuertos)&&(wounded==nheridos)){
                misposibles++;
            }else{
                misdescartados++;
                posibles[i][4]=0;
            }
        }
    }
    nposibles=misposibles;
    
}
  
  public int getPosibles(){
      return nposibles;
  }
  
  public int getIndiceDesdePosibles(int lugarEnLaListaDePosibles){
      int contados=0, i=0, stop=0;
      do{
          if(posibles[i][4]== 1){//esta disponible
             contados++; 
          } 
          i++;
          if(contados==lugarEnLaListaDePosibles){//es el buscado
            stop=1;  
          }
          //System.out.println(i + " revisados, "+ contados + " contados.");  
      }while(stop == 0);
      return i-1;
      
  }
  
  public String getStrElemento(int indice){
      String cadena="";
        for (int i=0; i<digitos; i++){
        cadena=cadena+posibles[indice][i];
        }
      return cadena;
  }
  
  public boolean esPosible(int indice){
      return (posibles[indice][4] == 1);
          
  }
  
  public void mostrarListaDePosibles(){
      for(int i=0; i<ntotal; i++){
          if (this.esPosible(i)){
              System.out.println(this.getStrElemento(i));
          }
      }
  }
  
  public int getProximoPosible(){
      Random r = new Random();
      int misposibles=this.getPosibles();
      int indice1 = r.nextInt(misposibles)+1;//obtiene un numero aleatorio entre 1 y el numero de elementos posibles
      int indice2= this.getIndiceDesdePosibles(indice1);//obtiene el indice de fila de la matriz posibles en la que se encuentra el enesimo elemento posible
      System.out.println("hay "+ misposibles + " opciones posibles, se escogio la numero "+ indice1 + " la cual es el indice "+ indice2 +" en la tabla general" );

      return (indice2);//
  }
  
  public byte getDigito(int indice, int digito){
    return posibles[indice][digito-1];
    
}
  
      
  }  

