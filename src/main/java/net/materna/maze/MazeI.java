package net.materna.maze;

public interface MazeI {


    /**
     @return Gesamtbreite des Labyrinths.
     */
    int getDimX();

    /**
     *
     * @return Gesamthöhe des Labyrinths.
     */
    int getDimY();

    /**
     * Gibt die Kachel an der jeweiligen Position zurück.
     * @param x X-Position des Tiles
     * @param y Y-Position des Tiles
     * @return Unicode-Zeichen der Kachel
     */
    String getTile(int x, int y);

//    /**
//     * Erzeugt ein neues Labyrinth.
//     * @param x Gesamtbreite des Labyrinths.
//     * @param y Gesamthöhe des Labyrinths.
//     * @return Neues Labyrinth
//     */
//    default MazeI create(int x, int y) {
//        return this(x,y);
//    }


}
