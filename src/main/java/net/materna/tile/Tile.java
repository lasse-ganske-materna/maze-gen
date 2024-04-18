package net.materna.tile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Tile {
    // Unicodes: https://www.compart.com/de/unicode/block/U+2500

    EMPTY(' '),
    //    LEFT_MID('╡', TileConnection.LEFT),
//    TOP_MID('╨', TileConnection.TOP),
//    RIGHT_MID('╞', TileConnection.RIGHT),
//    BOTTOM_MID('╥', TileConnection.BOTTOM),
    LEFT_TOP('╝', TileConnection.LEFT, TileConnection.TOP),
    LEFT_RIGHT('═', TileConnection.LEFT, TileConnection.RIGHT),
    LEFT_BOTTOM('╗', TileConnection.LEFT, TileConnection.BOTTOM),
    TOP_RIGHT('╚', TileConnection.TOP, TileConnection.RIGHT),
    TOP_BOTTOM('║', TileConnection.TOP, TileConnection.BOTTOM),
    RIGHT_BOTTOM('╔', TileConnection.RIGHT, TileConnection.BOTTOM),
    CROSSROAD_RIGHT('╠', TileConnection.RIGHT, TileConnection.BOTTOM, TileConnection.TOP),
    CROSSROAD_BOTTOM('╦', TileConnection.RIGHT, TileConnection.BOTTOM, TileConnection.LEFT),
    CROSSROAD_LEFT('╣', TileConnection.BOTTOM, TileConnection.TOP, TileConnection.LEFT),
    CROSSROAD_TOP('╩', TileConnection.RIGHT, TileConnection.TOP, TileConnection.LEFT),
    CROSSROAD('╬', TileConnection.RIGHT, TileConnection.BOTTOM, TileConnection.TOP, TileConnection.LEFT);


    private final char zeichen;
    private final Set<TileConnection> tileConnections;


    Tile(char zeichen, TileConnection... tileConnection) {
        this.zeichen = zeichen;
        tileConnections = new HashSet<>(List.of(tileConnection));
    }


    @Override
    public String toString() {
        return String.valueOf(zeichen);
    }

    public boolean hasConnection(TileConnection tileConnection) {
        return this.tileConnections.contains(tileConnection);
    }

    public boolean hasLeftConnection() {
        return hasConnection(TileConnection.LEFT);
    }

    public boolean hasRightConnection() {
        return hasConnection(TileConnection.RIGHT);
    }

    public boolean hasTopConnection() {
        return hasConnection(TileConnection.TOP);
    }

    public boolean hasBottomConnection() {
        return hasConnection(TileConnection.BOTTOM);
    }

    public enum TileConnection {
        LEFT, RIGHT, TOP, BOTTOM
    }
}
