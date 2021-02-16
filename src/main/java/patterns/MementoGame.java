package patterns;

/**
 * працює як збереження в грі))))
 */
public class MementoGame {
    public static void main(String[] args) {
        Game game = new Game();

        game.set("LVL_1", 30000);
        System.out.println(game);

        System.out.println("Saving");
        File file = new File();
        file.setSave(game.save());

        System.out.println("Continue playing");
        game.set("LVL_2", 55000);
        System.out.println(game);

        System.out.println("Load saves game");
        game.load(file.getSave());
        System.out.println(game);

    }

}

/** CLASS */
class Game {
    private String level;
    private int ms;
    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }
    public Save save() {
        return new Save(level, ms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}
/** MEMENTO */
class Save {
    private final String level;
    private final int ms;
    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public String getLevel() {
        return level;
    }
    public int getMs() {
        return ms;
    }
}
/** Caretaker */
class File {
    Save save;
    public Save getSave() {
        return save;
    }
    public void setSave(Save save) {
        this.save = save;
    }
}