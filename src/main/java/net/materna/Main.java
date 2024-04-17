package net.materna;

import net.materna.maze.Maze;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Requires 2 arguments for x and y.");
            System.exit(1);
        }
        if (!args[0].matches("\\d+") || !args[1].matches("\\d+")) {
            System.err.println("Both arguments must be a digit.");
            System.exit(1);
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if (x < 1 || y < 1) {
            System.err.println("Both arguments must be >= 0.");
            System.exit(1);
        }
        Maze maze = new Maze(x, y);
        System.out.printf("Maze(%d,%d)%n", x, y);
        System.out.println(maze);
    }
}
