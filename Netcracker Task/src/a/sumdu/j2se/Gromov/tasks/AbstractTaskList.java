package a.sumdu.j2se.Gromov.tasks;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable {

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract void printTaskList();
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    @Override
    public abstract String toString();
    @Override
    public abstract Task clone();
    public abstract Stream<Task> getStream();

}
