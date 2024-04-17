package net.materna.tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static net.materna.tile.Tile.TILES_ALL;
import static net.materna.tile.Tile.TILES_WITHOUT_BOTTOM_CONNECTION;
import static net.materna.tile.Tile.TILES_WITHOUT_LEFT_CONNECTION;
import static net.materna.tile.Tile.TILES_WITHOUT_RIGHT_CONNECTION;
import static net.materna.tile.Tile.TILES_WITHOUT_TOP_CONNECTION;
import static net.materna.tile.Tile.TILES_WITH_BOTTOM_CONNECTION;
import static net.materna.tile.Tile.TILES_WITH_LEFT_CONNECTION;
import static net.materna.tile.Tile.TILES_WITH_RIGHT_CONNECTION;
import static net.materna.tile.Tile.TILES_WITH_TOP_CONNECTION;

public class TileHelper {

    public static List<Tile> getPossibleTiles(Tile left, Tile top, Tile right, Tile bottom) {
        Set<Tile> compatibilityLeft;
        if (Objects.isNull(left)) {
            compatibilityLeft = TILES_ALL;
        } else {
            compatibilityLeft = left.hasRightConnection() ? TILES_WITH_LEFT_CONNECTION : TILES_WITHOUT_LEFT_CONNECTION;
        }

        Set<Tile> compatibilityTop;
        if (Objects.isNull(top)) {
            compatibilityTop = TILES_ALL;
        } else {
            compatibilityTop = top.hasBottomConnection() ? TILES_WITH_TOP_CONNECTION : TILES_WITHOUT_TOP_CONNECTION;
        }

        Set<Tile> compatibilityRight;
        if (Objects.isNull(right)) {
            compatibilityRight = TILES_ALL;
        } else {
            compatibilityRight = right.hasLeftConnection() ? TILES_WITH_RIGHT_CONNECTION : TILES_WITHOUT_RIGHT_CONNECTION;
        }

        Set<Tile> compatibilityBottom;
        if (Objects.isNull(bottom)) {
            compatibilityBottom = TILES_ALL;
        } else {
            compatibilityBottom = bottom.hasTopConnection() ? TILES_WITH_BOTTOM_CONNECTION : TILES_WITHOUT_BOTTOM_CONNECTION;
        }

        Set<Tile> possibleTiles = new HashSet<>(List.of(Tile.values()));
        possibleTiles.retainAll(compatibilityLeft);
        possibleTiles.retainAll(compatibilityTop);
        possibleTiles.retainAll(compatibilityRight);
        possibleTiles.retainAll(compatibilityBottom);
        return new ArrayList<>(possibleTiles);
    }
}
