package a.sumdu.j2se.Gromov.tasks;

import java.util.*;
import java.time.*;

public class Main implements ListTypes {

    public static void main(String[] args) {



        ListType typeLinked = ListType.LINKED; // При создании LINKED - list, при ARRAY - array
        TaskListFactory taskListFactoryLinked = new TaskListFactory();
        AbstractTaskList list = taskListFactoryLinked.createTaskList(typeLinked);
        LocalDateTime interval = LocalDateTime.of(2021, Month.OCTOBER, 14, 11, 6, 22);
        //list.add(new Task());
        LocalDateTime thisData = LocalDateTime.of(2021, Month.OCTOBER, 8, 11, 6, 22);
        list.add(new Task("Second list", thisData, thisData.plusDays(1), interval));
        thisData = LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 6, 22);
        list.add(new Task("Third list", thisData, thisData.plusDays(1), interval));
        thisData = LocalDateTime.of(2021, Month.OCTOBER, 12, 17, 56, 42);
        list.add(new Task("Fourth list", thisData, thisData.plusDays(1), interval));
        list.printTaskList();
        System.out.println(list.size());

        LocalDateTime chekStart = LocalDateTime.of(2021, Month.OCTOBER, 8, 11, 6, 22);
        LocalDateTime chekEnd = LocalDateTime.of(2021, Month.OCTOBER, 11, 11, 6, 22);
        Tasks.incoming(list, chekStart, chekEnd);

    }

}
