package a.sumdu.j2se.Gromov.tasks;

//Нужно добавить итератор?

public abstract class AbstractTaskList {

    static private int count;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public int size(){return count;}
    public abstract void ArrayTaskList_incoming (int from, int to);

    // Нужно самому реализовать Stream? Или этот метод можно взять откуда то..?

}
