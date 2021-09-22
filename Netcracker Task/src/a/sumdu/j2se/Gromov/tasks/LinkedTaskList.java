package a.sumdu.j2se.Gromov.tasks;

//Не понимаю что делать с итераторами... Задание 5 не совсем понятно...

public class LinkedTaskList  { // добавить extends AbstractTaskList. Конфликт с remove

    private Node head;
    private static int count;

    public LinkedTaskList () {
        head = null;
        count = 0;
    }

    static class Node {
        public final Task task;
        public Node next;
        public  Node (Task task){
            this.task = task;
            next = null;
        }
    }

    public void addLinkedTaskList (Task task){
        Node newNode = new Node(task);
        Node currentNode = head;
        count++;

        if (head == null) {
            head = newNode;
        }
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void remove (String title){ // Сделать как с массивами? При удалении возвращается true?
        // Как удалять? По названию(title)? Как можно сделать через класс Task? Чтобы подавать что-то вроде (Task task)
        Node currentNode = head;
        Node prevNode = null;
        count--;
        //boolean del_task;
        while (currentNode.next != null){

            if (currentNode.task.getTitle().equals(title)){
                //del_task = true;
                if (currentNode == head){
                    head = currentNode.next;
                }
                else {
                    prevNode.next = currentNode.next;// Пишет, что лучше использовать Assert Добвать перед этой строкой (assert prevNode != null;)
                }
            }
//            else{
//                del_task = false;
//            }

            prevNode  = currentNode;
            currentNode = currentNode.next;
        }
        //return del_task;
    }

    public void printLinkedTaskList() {
        Node currentNode = head;

        if (head != null){
            System.out.println(head.task.getTitle());
        }

        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.println(currentNode.task.getTitle());
        }
    }

    public int size (){
        return count;
    } // пока тут, позже уберу т.к. делается через родительский класс

//    void ArrayTaskList_incoming (int from, int to) как реализовать? Просто выводить на экран как в ArrayTaskList?

}
