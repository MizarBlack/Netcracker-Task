package a.sumdu.j2se.Gromov.tasks;

public class Main {

    public static void main(String[] args) {

        LinkedTaskList list = new LinkedTaskList();
        list.addLinkedTaskList(new Task());
        list.addLinkedTaskList(new Task("Second", 15));
        list.addLinkedTaskList(new Task("Third", 12, 24, 0));

        Task task = new Task();

        list.printLinkedTaskList();

        list.remove(("Second"));

        System.out.println();

        list.addLinkedTaskList(new Task("Fourth", 18));

        list.printLinkedTaskList();

        System.out.println();

        System.out.println(task);
    }
}
