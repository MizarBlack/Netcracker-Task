package a.sumdu.j2se.Gromov.tasks ;

public class Task {

    private String title;
    private int time;
    private int start, end;
    private int interval;
    private boolean Active;

    public Task (String title, int time){
        this.title = title;
        this.time = time;
        this.Active = false;
            if (time < 0)
                throw new IllegalArgumentException();
    }

    public Task (String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.Active = false;

        if ((start < 0) | (end < 0) | (interval < 0))
            throw new IllegalArgumentException ();
    }

    public Task() {
        this.title = "None";
        this.time = 0;
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

    public int getTime (){
            return this.time;
    }

    public void setTime(int time){ //Или как сдвинуть время end?
        this.start = time;
        if (this.interval > 0) {
            this.end = this.start + this.interval;
            this.interval = 0;
        }
    }

    public int getStartTime (){
        return this.start;
    }

    public int getEndTime (){
        if (this.interval > 0) {
            return 0;
        }
        else
            return this.end;
    }

    public int getRepeatInterval (){
        if (this.interval == 0) {
            return 0;
        }
        else
            return this.interval;
    }

    public void setTime(int start, int end, int interval){
        if ((start < 0) | (end < 0) | (interval < 0))
            throw new IllegalArgumentException ();
        this.time = 0;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public  boolean isRepeated(){
        return interval > 0;
    }

    public int nextTimeAfter ( int current){
        if (this.interval > 0)
            return (this.interval - current);
        else
            return -1;
    }

}
