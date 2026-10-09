package main;

import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

public class Main {

    public static void main(String[] args) {
        RegistroPrototipos registro = new RegistroPrototipos();

        // Configuración de los prototipos base
        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Poción de vida");
        registro.registrarPrototipo("Guerrero", new Personaje("Guerrero", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Poción de maná");
        registro.registrarPrototipo("Mago", new Personaje("Mago", "Mago", invMago));

        // Clonaciones a partir del registro
        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        // Modificación del inventario de una copia
        guerreroCopia.getInventario().agregarItem("Escudo");

        System.out.println("=== Copias ===");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        System.out.println("\n=== Prototipos originales ===");
        System.out.println(registro.consultarPrototipo("Guerrero"));
        System.out.println(registro.consultarPrototipo("Mago"));

        // Prototipo inexistente: no se clona
        System.out.println("\n=== Prototipo inexistente ===");
        registro.obtenerCopia("Arquero");
    }
}
