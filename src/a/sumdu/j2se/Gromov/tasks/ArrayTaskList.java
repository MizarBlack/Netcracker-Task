package a.sumdu.j2se.Gromov.tasks;

public class ArrayTaskList {

    private static int count = 0;
    private  Task TaskList [] = new Task[10];

    public void add(Task task){
        if (count < 10) {
            TaskList[count] = task;
            count++;
        }
        else
            System.out.println("Переполнение массива");
    }

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

    public int size (){
        return count;
    }

    Task getTask (int index){
        if ( index >= count )
            throw new IndexOutOfBoundsException();
        else
            return TaskList [index];
    }

//    void ArrayTaskList_incoming (int from, int to){
//
//    }
}
