package net.materna.tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TileHelper {
    static final Set<Tile> TILES_ALL = new HashSet<>(List.of(Tile.values()));

    static final Set<Tile> TILES_WITH_TOP_CONNECTION = getTilesWithConnection(Tile.TileConnection.TOP);
    static final Set<Tile> TILES_WITH_BOTTOM_CONNECTION = getTilesWithConnection(Tile.TileConnection.BOTTOM);
    static final Set<Tile> TILES_WITH_LEFT_CONNECTION = getTilesWithConnection(Tile.TileConnection.LEFT);
    static final Set<Tile> TILES_WITH_RIGHT_CONNECTION = getTilesWithConnection(Tile.TileConnection.RIGHT);

    static final Set<Tile> TILES_WITHOUT_TOP_CONNECTION = getTilesWithoutConnection(Tile.TileConnection.TOP);
    static final Set<Tile> TILES_WITHOUT_BOTTOM_CONNECTION = getTilesWithoutConnection(Tile.TileConnection.BOTTOM);
    static final Set<Tile> TILES_WITHOUT_LEFT_CONNECTION = getTilesWithoutConnection(Tile.TileConnection.LEFT);
    static final Set<Tile> TILES_WITHOUT_RIGHT_CONNECTION = getTilesWithoutConnection(Tile.TileConnection.RIGHT);

    private static Set<Tile> getTilesWithConnection(Tile.TileConnection tileConnection) {
        return Arrays.stream(Tile.values()).filter(t -> t.hasConnection(tileConnection)).collect(Collectors.toUnmodifiableSet());
    }

    private static Set<Tile> getTilesWithoutConnection(Tile.TileConnection tileConnection) {
        return Arrays.stream(Tile.values()).filter(t -> !t.hasConnection(tileConnection)).collect(Collectors.toUnmodifiableSet());
    }

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
