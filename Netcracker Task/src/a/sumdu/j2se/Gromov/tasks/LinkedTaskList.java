package a.sumdu.j2se.Gromov.tasks;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedTaskList extends AbstractTaskList implements Serializable {

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void setCount(int count) {
        LinkedTaskList.count = count;
    }

    public int getCount(){
        return count;
    }

    private Node head;
    private static int count;

    public LinkedTaskList () {
        head = null;
        count = 0;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private Node currentNode = getHead();

            @Override
            public boolean hasNext() {
                return currentNode.hasNext();
            }

            @Override
            public Task next() throws IndexOutOfBoundsException {
                Task result = currentNode.getTask();
                if (!currentNode.hasNext()) {
                    throw new IndexOutOfBoundsException("End of list.");
                }
                currentNode = currentNode.getNext();
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static class Node {
        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        private final Task task;
        private Node next;
        private Node (Task task){
            this.task = task;
            this.next = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

    public void add (Task task){
        Node newNode = new Node(task);
        Node currentNode = head;
        currentNode.getTask().setActive(true);
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
        while (currentNode.hasNext()){
            if (currentNode.task.getTitle().equals(task.getTitle())){
                del_task = true;
                if (currentNode == getHead()){
                    setHead(currentNode.next);
                } else {
                    prevNode.setNext(currentNode.getNext());// как поправить?
                }
            } else{
                del_task = false;
            }
            prevNode  = currentNode;
            currentNode = currentNode.getNext();
        }
        return del_task;
    }

    @Override
    public int size(){
        return getCount();
    }

    @Override
    public void printTaskList() {
        Node currentNode = getHead();

        if (getHead() != null){
            System.out.println(currentNode.getTask().toString());
        } else {
            System.out.println("Список задач пуст.");
            return;
        }

        while (currentNode.hasNext()){
            currentNode = currentNode.getNext();
            System.out.println(currentNode.getTask().toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        return Objects.equals(getHead(), that.getHead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "Head=" + getHead() +
                '}';
    }

    @Override
    public Task clone() {
        return null;
    }

    @Override
    public Stream<Task> getStream() {
        return StreamSupport.stream(spliterator(), false);
    }

}
