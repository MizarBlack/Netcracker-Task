package a.sumdu.j2se.Gromov.tasks;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.SortedMap;

public class Tasks {
    Iterable <Task> incoming (Iterable <Task> tasks, LocalDateTime start, LocalDateTime end){
            if ((start.isAfter(tasks.iterator().next().getStartTime())) && (end.isBefore(tasks.iterator().next().getEndTime()))){
                return tasks;
            } else {
                return null;
            }
    }

    SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        boolean sorting = false;
        LocalDateTime temp;
        while (!sorting){
            sorting = true;
            while (tasks.iterator().hasNext()){
                if (start.isAfter(tasks.iterator().next().getStartTime()) && end.isBefore(tasks.iterator().next().getEndTime())){
                    // найти наименьшую дату удовлетворяющую условию и занести её в set
                }
            }
        }
        return null;
    }
}
