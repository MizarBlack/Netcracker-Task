package a.sumdu.j2se.Gromov.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList {

    final int numberTask = 10;
    private static int count = 0;
    public final Task[] taskList ;

    public ArrayTaskList(){
        this.taskList = new Task[numberTask];
    }


    @Override
    public void add(Task task){
        if (count < numberTask) {
            taskList[count] = task;
            count++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Переполнение массива");
        }
    }

    @Override//Проверить
    public boolean remove(Task task){//удаляет задачу, если задача была return True;
        int num = 0;
        while ((this.taskList[num] == task) && (num != count) ){
            num++;
        }
        for (int num2 = num; num2 <= count--; num2++){// проверить
            this.taskList[num2] = this.taskList[num2++];
        }
        this.taskList[count--] = null;
        count--;
        return true;
    }

    Task getTask (int index){
        if ( index >= count )
            throw new IndexOutOfBoundsException();
        else
            return taskList[index];
    }

    @Override
    public void printTaskList() {
        int _count = 0;
        while (taskList[_count] != null) {
            System.out.println(taskList[_count].getTitle());
            _count++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return Arrays.equals(taskList, that.taskList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberTask);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "numberTask=" + numberTask +
                ", taskList=" + Arrays.toString(taskList) +
                '}';
    }

    @Override
    public Task clone() {
        return null;
    }

    @Override
    public Stream<Task> getStream() {
       return Arrays.stream(taskList) ;
    }

    @Override
    public int size(){
        return count;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < count && taskList[currentIndex] != null;
            }
            @Override
            public Task next() {
                return taskList[currentIndex++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }
}
