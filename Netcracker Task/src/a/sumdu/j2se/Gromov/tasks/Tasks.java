package a.sumdu.j2se.Gromov.tasks;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {
    static Iterable <Task> incoming (Iterable <Task> tasks, LocalDateTime start, LocalDateTime end) {
        LinkedTaskList list = new LinkedTaskList();
        while (tasks.iterator().hasNext()){
            Task task = tasks.iterator().next();
            if ((start.isAfter(task.getStartTime())) && (end.isBefore(task.getEndTime()))) {
                return tasks;
            }
            tasks.iterator().next();
        }
        return null;
    }

    static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        Set<Task> set = new HashSet<>();
        SortedMap<LocalDateTime, Set<Task>> sortedMap = new TreeMap<>();
        while (tasks.iterator().hasNext()){
            Task task = (Task) tasks;
            if (start.isAfter(task.getStartTime()) && end.isBefore(task.getEndTime())){
                set.add(task);
            }
            tasks.iterator().next();
        }
        Set<Task> setSorted = new HashSet<>();
        while (set.iterator().hasNext()){
            Task temp;
            temp = set.iterator().next();
            while (set.iterator().hasNext()){
                int result = temp.getStartTime().compareTo(set.iterator().next().getStartTime());
                if (result > 0){
                    temp = set.iterator().next();
                }
            }
            set.remove(temp);
            setSorted.add(temp);
        }
        sortedMap.put(start, setSorted);

        return sortedMap;
    }
}
