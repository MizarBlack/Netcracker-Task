package a.sumdu.j2se.Gromov.tasks;

public class TaskListFactory {

    AbstractTaskList createTaskList (ListTypes.ListType type){

        if (type == ListTypes.ListType.LINKED){
            return new LinkedTaskList();
        } else if (type == ListTypes.ListType.ARRAY) {
            return new ArrayTaskList();
        } else {
            throw new RuntimeException(type + " is unknown list");
        }

    }

}
