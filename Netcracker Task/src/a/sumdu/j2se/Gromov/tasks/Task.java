package a.sumdu.j2se.Gromov.tasks ;

import java.io.Serializable;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Task implements Serializable {

    private String title;
    private LocalDateTime  time;
    private LocalDateTime  start, end;
    private LocalDateTime interval;
    private boolean Active;

    public Task (String title, LocalDateTime  time){
        this.title = title;
        this.time = time;
        this.Active = false;
    }

    public Task (String title, LocalDateTime  start, LocalDateTime  end, LocalDateTime interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.Active = false;
    }

    public Task() {
        this.title = "None";
        this.time = LocalDateTime.now();
        this.Active = false;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public boolean isActive(){
        return this.Active;
    }

    public void setActive (boolean Active){
            this.Active = Active;
    }

    public LocalDateTime getTime (){
            return this.time;
    }

    public void setTime(LocalDateTime start, LocalDateTime end){
        this.start = start;
        this.time = null;
        this.end = end;
        this.interval = null;
    }

    public LocalDateTime getStartTime (){
        return this.start;
    }

    public LocalDateTime getEndTime (){
        if (this.interval == null) {
            return null;
        }
        else
            return this.end;
    }

    public LocalDateTime getRepeatInterval (){
        if (this.interval == null) {
            return null;
        }
        else
            return this.interval;
    }

    public void setTime(LocalDateTime start, LocalDateTime end, LocalDateTime interval){
        this.time = null;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public  boolean isRepeated(){
        return interval != null;
    }

    public long nextTimeAfter ( int current){
        if (this.interval != null) {
            LocalDateTime today = LocalDateTime.now();
            return (ChronoUnit.DAYS.between(this.interval, today));
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Active == task.Active && Objects.equals(title, task.title) && Objects.equals(time, task.time) && Objects.equals(start, task.start) && Objects.equals(end, task.end) && Objects.equals(interval, task.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, Active);
    }

    @Override// Если значение =null, его выводить не надо?
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", Active=" + Active +
                '}';
    }

    @Override
    public Task clone() {
        return null;
    }

}
