package a.sumdu.j2se.Gromov.tasks;

public abstract class AbstractTaskList /*implements Iterator*/ {

    public Iterator getIterator;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract void incoming (int from, int to);
    public abstract void printTaskList();
    public abstract boolean equals();
    public abstract boolean Hashcode();
    @Override
    public abstract String toString();
    @Override
    public abstract Task clone();

}
