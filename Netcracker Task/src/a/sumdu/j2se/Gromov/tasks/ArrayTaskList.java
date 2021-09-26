package a.sumdu.j2se.Gromov.tasks;

public class ArrayTaskList extends AbstractTaskList implements Collection {

    final int numberTask = 10;
    private static int count = 0;
    Task[] TaskList = new Task[numberTask];
//    Task[] TaskList;
//    public ArrayTaskList(){
//         TaskList = new Task[numberTask];
//    }

    @Override
    public void add(Task task){
        if (count < numberTask) {
            TaskList[count] = task;
            count++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Переполнение массива");
        }
    }

    @Override
    public boolean remove(Task task){//удаляет задачу, если задача была return True;
        int num = 0;
        while (TaskList[num] != task){
            if (num == count-1){
                return false;
            }
            num++;
        }
        for (int num2 = num; num2 < count-1; num2++){// проверить
            TaskList [num2] = null;
            TaskList [num2] = TaskList [num2+1];
        }
        TaskList[count] = null;
        count--;
        return true;
    }

    Task getTask (int index){
        if ( index >= count )
            throw new IndexOutOfBoundsException();
        else
            return TaskList [index];
    }

    @Override
    public void incoming(int from, int to){

        for (int num = 0; num < numberTask; num++){
            if ((TaskList[num].getStartTime() < from) && (TaskList[num].getEndTime() > to)) {
                System.out.println(TaskList[num].getTitle());
            }
        }

    }

    @Override
    public void printTaskList() {
        for (int i = 0; i < count; i++){
            System.out.println(TaskList[i]);
        }
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    public boolean Hashcode() {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Task clone() {
        return null;
    }

    @Override
    public int size(){
        return count;
    }



// Итераторы ↓↓↓

    @Override
    public Iterator getIterator() {
        return new ArrayIteration();
    }

    private class ArrayIteration implements Iterator{
        int index;
        @Override
        public boolean hasNext() {
            if (index < count){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            return TaskList[index++];
        }
    }
}
