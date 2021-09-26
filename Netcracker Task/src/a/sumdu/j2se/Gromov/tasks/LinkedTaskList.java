package a.sumdu.j2se.Gromov.tasks;

public class LinkedTaskList extends AbstractTaskList implements Collection {

    private Node head;
    private static int count;
    public int getCount(){
        return count;
    }

    public LinkedTaskList () {
        head = null;
        count = 0;
    }

    private static class Node {
        private final Task task;// get/set
        private Node next;
        private Node (Task task){
            this.task = task;
            this.next = null;
        }
        public Node getNext(){
            return this.next;
        }
        public Task getTask(){
            return this.task;
        }
    }

    public void add (Task task){
        Node newNode = new Node(task);
        Node currentNode = head;
        count++;

        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    @Override
    public boolean remove (Task task){
        Node currentNode = head;
        Node prevNode = null;
        count--;
        boolean del_task = false;
        while (currentNode.next != null){
            if (currentNode.task.getTitle().equals(task.getTitle())){
                del_task = true;
                if (currentNode == head){
                    head = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;// как поправить?
                }
            } else{
                del_task = false;
            }
            prevNode  = currentNode;
            currentNode = currentNode.next;
        }
        return del_task;
    }

    @Override
    public int size(){
        return count;
    }

    @Override
    public void printTaskList() {
        Node currentNode = head;

        if (head != null){
            System.out.println(head.task.getTitle());
        }

        while (currentNode.next != null){//?
            currentNode = currentNode.next;
            System.out.println(currentNode.task.getTitle());
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
    public void incoming (int from, int to) {}


// Итераторы ↓↓↓


    @Override
    public Iterator getIterator() {
        return new LinkedIteration();
    }

    private class LinkedIteration implements Iterator{ // можно было создавать такой класс? Аналогичный вопрос к Array
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
            Node currentNode = head;
            for (int num = 1; num < index; num++){
                currentNode = currentNode.next;
            }
            return currentNode;
        }

    }

}
