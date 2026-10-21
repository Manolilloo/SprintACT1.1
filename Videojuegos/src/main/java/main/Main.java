/**
 * @author ManuelPerez, CarlosSimoes, YerayDuran, AlvaroRodriguez
 * @version 1.0
 */

package main;

import models.Videojuego;
import java.util.ArrayList;
import java.util.List;


public class Main{
    static void main() {
        List<Videojuego> videojuegos = new ArrayList<>();
        añadirVideojuego(videojuegos, new Videojuego("The Last of Us: Part II", "Accion, Disparos, Terror", "PC, PS3, PS4, PS5, XBOX ONE, XBOX Series X/S", 2020 ,10));
    }
    private static void añadirVideojuego(List<Videojuego> videojuegos, Videojuego videojuego){
        videojuegos.add(videojuego);
    }
}



