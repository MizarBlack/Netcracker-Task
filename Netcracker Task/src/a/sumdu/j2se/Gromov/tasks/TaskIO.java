package a.sumdu.j2se.Gromov.tasks;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.google.gson.*;

public class TaskIO {
    static void write (AbstractTaskList tasks, OutputStream out) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (oos != null) {
                oos.writeObject(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static void read (AbstractTaskList tasks, InputStream in) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (ois != null) {
                tasks = (AbstractTaskList) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    static void writeBinary (AbstractTaskList tasks, File file) {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    static void readBinary (AbstractTaskList tasks, File file){
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void write (AbstractTaskList tasks, Writer out){
        Gson gson = new Gson();
        try {
            out.write(gson.toJson(tasks));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void read (AbstractTaskList tasks, Reader in){
        Gson gson = new Gson();
        tasks = gson.fromJson(in, tasks.getClass());
    }
    static void writeText (AbstractTaskList tasks, File file){
        Gson gson = new Gson();
        String json = gson.toJson(tasks);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static void readText (AbstractTaskList tasks, File file){
        String json = "";
        Task task = new Task();
        Gson gson = new Gson();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {
                json = sc.next();
                task = gson.fromJson(json, Task.class);
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}

