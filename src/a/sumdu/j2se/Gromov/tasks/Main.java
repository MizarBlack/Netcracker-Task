package a.sumdu.j2se.Gromov.tasks;

public class Main {

    public static void main(String[] args) {
	Task One = new Task();
    Task Second = new Task("Second", 15);
    Task Third = new Task("Third", 12, 24, 0);
    One.Next = Second;
    Second.Next = Third;

    }
}
