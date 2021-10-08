package a.sumdu.j2se.Gromov.tasks;

import java.util.Arrays;
import java.util.stream.Stream;
import java.time.*;

public class Main implements ListTypes {

    public static void main(String[] args) {

        ListType typeLinked = ListType.LINKED; // При создании LINKED - list, при ARRAY - array
        TaskListFactory taskListFactoryLinked = new TaskListFactory();
        AbstractTaskList list = taskListFactoryLinked.createTaskList(typeLinked);
        list.add(new Task());
        LocalDateTime thisData = LocalDateTime.of(2021, Month.SEPTEMBER, 30, 11, 6, 22);
        list.add(new Task("Second list", thisData));
        thisData = LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 6, 22);
        LocalDateTime interval = LocalDateTime.of(2021, Month.OCTOBER, 14, 11, 6, 22);
        list.add(new Task("Third list", thisData, thisData.plusDays(5), interval));
        thisData = LocalDateTime.of(2021, Month.OCTOBER, 12, 17, 56, 42);
        list.add(new Task("Fourth list", thisData));
        list.printTaskList();
        System.out.println(list.size());
    }

}
