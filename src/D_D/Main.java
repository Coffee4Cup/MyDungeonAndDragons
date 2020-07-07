package D_D;

import D_D.RandomGenerator.RandomGenerator;

public class Main {

    private static RandomGenerator trueRandom;

    public static void main(String[] args) {
        System.out.println("HelloWorld This is my D&D game!");
        Game.Level level = Game.Level.constructLevelFromText("C:\\Users\\itay8\\JavaProjects\\MyDungeonAndDragons\\Levels\\level 1.txt", trueRandom);
        System.out.println(level.toString());
    }
}
