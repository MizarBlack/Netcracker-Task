package a.sumdu.j2se.Gromov.tasks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedTaskList extends AbstractTaskList {

    private Node head;
    private static int count;

    public int getCount(){
        return count;
    }

    public LinkedTaskList () {
        head = null;
        count = 0;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private Node currentNode = head;

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
                currentNode = currentNode.next;
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

        private final Task task;// get/set
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                '}';
    }

    @Override
    public Task clone() {
        return null;
    }

    @Override//доделать
    public Stream<Task> getStream() {
        return StreamSupport.stream(spliterator(), false);
    }

}
