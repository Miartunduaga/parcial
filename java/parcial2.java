package java;
import java.util.Scanner;
public class parcial2 {

    public static class Persona {

        private String Nombre;
        private String Apellido;
        private int CC;
        private int Ht;
        private int Sala;

        public Persona(String Nombre, String Apellido, int CC, int Ht, int Sala) {
            this.Nombre = Nombre;
            this.Apellido = Apellido;
            this.CC = CC;
            this.Ht = Ht;
            this.Sala = Sala;
        }

        @Override
        public String toString() {
            return "Nombre: " + Nombre + "\nApellido: " + Apellido + "\nCC: " + CC + "\nHt: " + Ht + "\nSala: " + Sala;
        }

    }

    public static class Nodo {

        Persona p1;
        Nodo siguiente;

        public Nodo(Persona n) {
            p1 = n;
            siguiente = null;
        }
    }

    public static class Cola {

        private Nodo inicicola, finalcola;
        private int tamanio;

        public Cola() {
            inicicola = null;
            finalcola = null;
            tamanio = 0;
        }

        public boolean colavacia() {
            if (inicicola == null) {
                return true;
            } else {
                return false;
            }
        }

        public void insertar(Persona nuevo) {
            Nodo nuevonodo = new Nodo(nuevo);
            if (colavacia()) {
                inicicola = nuevonodo;
                finalcola = nuevonodo;
            } else {
                finalcola.siguiente = nuevonodo;
                finalcola = nuevonodo;
            }
            tamanio++;
        }

        public Persona extraer() {
            if (!colavacia()) {
                Persona tem = inicicola.p1;
                if (inicicola == finalcola) {
                    inicicola = null;
                    finalcola = null;
                } else {
                    inicicola = inicicola.siguiente;
                }
                tamanio--;
                return tem;
            } else {
                return null;
            }

        }
        public int tam(){
            return tamanio;
        }

    }

    public static void main(String[] args) {
        Cola x = new Cola();
        int opc;
        Scanner leer=new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido al Banco JP");
            System.out.println("Que desea hacer:"+"\n1.entrar en la cola"+"\n2.cuantas personas hay en la cola"+"\n3.Siguiente turno"+"\n4.salir");
            opc =leer.nextInt();
            switch (opc) {
                case 1:
                 String nom="";
                 String ap="";
                 int c=0;
                 int h=0;
                 int s=0;
                 System.out.println("Digite su nombre:");
                 nom=leer.next();
                 System.out.println("Digite su Apellido:");
                 ap=leer.next();
                 System.out.println("Digite su identificacion:");
                 c=leer.nextInt();
                 System.out.println("Digite cuantas horas trabaja:");
                 h=leer.nextInt();
                 System.out.println("Digite su salirio:");
                 s=leer.nextInt();
                 x.insertar(new Persona(nom,ap,c,h,s));
                    break;
                 case 2:
                 System.out.println(x.tamanio);
                 break;
                 case 3:
                 System.out.println(x.extraer());
                 break;
                default:
                 System.exit(0);
                    break;
            }
        }

    }
}