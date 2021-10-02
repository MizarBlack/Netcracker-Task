package a.sumdu.j2se.Gromov.tasks;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main implements ListTypes {

    public static void main(String[] args) {

        ListType typeLinked = ListType.LINKED; // При создании LINKED - list, при ARRAY - array
        TaskListFactory taskListFactoryLinked = new TaskListFactory();
        AbstractTaskList list = taskListFactoryLinked.createTaskList(typeLinked);
        list.add(new Task());
        list.add(new Task("Second list", 15));
        list.add(new Task("Third list", 12, 24, 0));
        list.add(new Task("Fourth list", 18));
        list.printTaskList();
        System.out.println(list.size());

        Arrays[] array_1 = new Arrays[10];
        Arrays.stream(array_1);
        ListType typeArray = ListType.ARRAY;
        TaskListFactory taskListFactoryArray = new TaskListFactory();
        AbstractTaskList array = taskListFactoryArray.createTaskList(typeArray);
        array.add(new Task());
        array.add(new Task("Second array", 12));
        array.add(new Task("Third array", 15, 19, 0));
        array.add(new Task("Fourth array", 20));
        array.remove(new Task("Third array", 15, 19, 0));
        array.printTaskList();
        System.out.println(array.size());
        System.out.println();
    }

}
