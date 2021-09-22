package a.sumdu.j2se.Gromov.tasks;

public class ArrayTaskList extends AbstractTaskList {

    private static int count = 0;
    private final Task[] TaskList = new Task[10];

    @Override
    public void add(Task task){
        if (count < 10) {
            TaskList[count] = task;
            count++;
        }
        else
            System.out.println("Переполнение массива");
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
        for (int num2 = num; num2 < count-1; num2++){
            TaskList [num2] = null;
            TaskList [num2] = TaskList [num2+1];
        }
        TaskList[count] = null;
        count--;
        return true;
    }

//    public int size (){ //В AbstractTaskList
//        return count;
//    }

    Task getTask (int index){
        if ( index >= count )
            throw new IndexOutOfBoundsException();
        else
            return TaskList [index];
    }

    public void ArrayTaskList_incoming(int from, int to){

        for (int num = 0; num < 10; num++){
            if ((TaskList[num].getStartTime() < from) && (TaskList[num].getEndTime() > to)) {
                System.out.println(TaskList[num].getTitle());
            }
        }

    }

//    public boolean equals (ArrayTaskList taskList){ // Нужно реализовать свои методы equals, hashCode, toString и clone?
////Это нужно сделать в ArrayTaskList и LinkedTaskList? Можно реализовать в AbstractTaskList как в родительском классе?
//        for (int _count = 0; _count < 10; _count++){
//            this[_count] == taskList[_count];
//        }
//
//    }

}
