package net.materna.maze;

import net.materna.tile.Tile;
import net.materna.tile.TileHelper;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Maze implements MazeI {

    private final int dimX;
    private final int dimY;
    private final Tile[][] tiles;
    private static final Random random = ThreadLocalRandom.current();

    public Maze(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        tiles = new Tile[dimX][dimY];
        
        fillTile(0, 0);
    }

    private boolean fillTile(int x, int y) {
        boolean reachedBorderLeft = y == 0;
        boolean reachedBorderRight = y == dimY - 1;
        boolean reachedBorderTop = x == 0;
        boolean reachedBorderBottom = x == dimX - 1;


        Tile left = reachedBorderLeft ? Tile.EMPTY : tiles[x][y - 1];
        Tile top = reachedBorderTop ? Tile.EMPTY : tiles[x - 1][y];
        Tile right = reachedBorderRight ? Tile.EMPTY : tiles[x][y + 1];
        Tile bottom = reachedBorderBottom ? Tile.EMPTY : tiles[x + 1][y];

        List<Tile> possibleTiles = TileHelper.getPossibleTiles(left, top, right, bottom);
        while (!possibleTiles.isEmpty()) {
            Tile tile = possibleTiles.get(random.nextInt(possibleTiles.size()));
            tiles[x][y] = tile;

            boolean nextFillWasSuccessful;
            if (reachedBorderBottom && reachedBorderRight) {
                // Abbruchbedingung: Ende wurde erreicht
                return true;
            } else if (reachedBorderRight) {
                // Rechter Rand wurde erreicht: Beginne bei nächster Zeile
                nextFillWasSuccessful = fillTile(x + 1, 0);
            } else {
                //Weiter in der aktuellen Zeile
                nextFillWasSuccessful = fillTile(x, y + 1);
            }

            if (!nextFillWasSuccessful) {
                // Backtracking
                possibleTiles.remove(tile);
                tiles[x][y] = null;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getDimX() {
        return dimX;
    }

    @Override
    public int getDimY() {
        return dimY;
    }

    @Override
    public String getTile(int x, int y) {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                sb.append(tiles[x][y]);
            }
            sb.append("\n");
        }
        return sb.toString();

    }
}
