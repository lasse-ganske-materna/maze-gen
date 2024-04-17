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

        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                Tile left = y > 0 ? tiles[x][y - 1] : Tile.EMPTY;
                Tile top = x > 0 ? tiles[x - 1][y] : Tile.EMPTY;
                Tile right = y < dimY - 1 ? tiles[x][y + 1] : Tile.EMPTY;
                Tile bottom = x < dimX - 1 ? tiles[x + 1][y] : Tile.EMPTY;

                List<Tile> possibleTiles = TileHelper.getPossibleTiles(left, top, right, bottom);
                Tile tile = possibleTiles.get(random.nextInt(possibleTiles.size()));
                tiles[x][y] = tile;
            }
        }
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
