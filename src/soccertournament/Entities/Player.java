package soccertournament.Entities;

public class Player {
    private final String name;
    private final String surname;
    private final String number;
    private int level;

    public Player(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.level = getRandom(10, 1);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public int getLevel() {
        return level;
    }

    public void newLevel() {
        this.level = (int) (Math.random() * 10);
    }

    public static int getRandom(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }
}
