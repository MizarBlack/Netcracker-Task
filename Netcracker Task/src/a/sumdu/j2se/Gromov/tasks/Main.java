package a.sumdu.j2se.Gromov.tasks;

import java.util.List;

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

//        И что с этим делать? Итератор я создал, но зачем он тут нужен?
//        Iterator iterator = list.getIterator;
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().);
//        }

//        Проблема с массивами, выводит непонятно что, кажеься проблема в конструкторе массива, но не уверен
        ListType typeArray = ListType.ARRAY;
        TaskListFactory taskListFactoryArray = new TaskListFactory();
        AbstractTaskList array = taskListFactoryArray.createTaskList(typeArray);
        array.add(new Task());
        array.add(new Task("Second array", 12));
        array.add(new Task("Third array", 15, 19, 0));
        array.add(new Task("Fourth array", 20));
        array.printTaskList();
        System.out.println();
    }
}
