package day0729;

public class Contestant {
    private String id;
    private String name;
    private int score;
    private double seconds;

    public Contestant(String id, String name, int score, double seconds) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.seconds = seconds;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public double getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-10s | Score: %-3d | Time: %-5.2fs", id, name, score, seconds);
    }
}
