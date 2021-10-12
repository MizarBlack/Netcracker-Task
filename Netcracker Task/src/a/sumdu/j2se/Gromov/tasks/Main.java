package a.sumdu.j2se.Gromov.tasks;

import java.util.*;
import java.time.*;

public class Main implements ListTypes {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int menuInt = 0;
        String menu ="";
        LinkedTaskList list = new LinkedTaskList();

        while (!"6".equals(menu)){
            System.out.println("1. Для создания новой задачи введите 1");
            System.out.println("2. Для изменения задачи введите 2");
            System.out.println("3. Для удаления задачи введите 3");
            System.out.println("4. Для просмотра существующих задач введите 4");
            System.out.println("5. Для просмотра календаря введите 5");
            System.out.println("6. Для выхода введите 6");
            menu = in.next();

            try {
                menuInt = Integer.parseInt(menu);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (menuInt){
                case 1:
                    System.out.println("Введите название задачи: ");
                    String title = in.next();
                    System.out.println("Введите время начала задачи, часы и минуты: ");
                    int h, m;
                    h = in.nextInt();
                    m = in.nextInt();
                    LocalTime startTime = LocalTime.of(h,m);
                    LocalDate startDate = LocalDate.now();
                    LocalDateTime start = LocalDateTime.of(startDate, startTime);
                    System.out.println("Введите время завершения задачи: ");
                    h = in.nextInt();
                    m = in.nextInt();
                    LocalTime endTime =  LocalTime.of(h,m);
                    LocalDate endDate = LocalDate.now();
                    LocalDateTime end = LocalDateTime.of(endDate, endTime);
                    System.out.println("Через сколько повторить задачу(не понимаю что делать): ");
                    LocalDateTime interval = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                    list.add(new Task(title, start, end, interval));
                    break;
                case 2:
                    String menu2 = "";
                    int menuInt2 = 0;
                    while (!"5".equals(menu2)) {
                        System.out.println("Что хотите изменить?");
                        System.out.println("1. Для изменения Title 1");
                        System.out.println("2. Для изменения Start и End 2");
                        System.out.println("3. Для изменения Start, End и Interval 3");
                        System.out.println("4. Для изменения Active 4");
                        System.out.println("5. Для выхода введите 5");
                        menu2 = in.next();

                        try {
                            menuInt2 = Integer.parseInt(menu2);
                        } catch (NumberFormatException e){
                            System.out.println("Неверный ввод");
                        }

                        switch (menuInt2){
                            case 1:
                                System.out.println("Введите название задачи: ");
                                String titleSet = in.next();

                        }
                    }

                    break;
                case 3:
                    System.out.println("Введите название задачи: ");
                    title = in.nextLine();
                    System.out.println("Введите время начала задачи, часы и минуты: ");
                    h = in.nextInt();
                    m = in.nextInt();
                    LocalTime startTimeDel =  LocalTime.of(h,m);
                    LocalDate startDateDel = LocalDate.now();
                    LocalDateTime startDel = LocalDateTime.of(startDateDel, startTimeDel);
                    System.out.println("Введите время завершения задачи: ");
                    h = in.nextInt();
                    m = in.nextInt();
                    LocalTime endTimeDel =  LocalTime.of(h,m);
                    LocalDate endDateDel = LocalDate.now();
                    LocalDateTime endDel = LocalDateTime.of(endDateDel, endTimeDel);
                    System.out.println("Через сколько повторить задачу(не понимаю что делать): ");
                    LocalDateTime intervalDel = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                    list.remove(new Task(title, startDel, endDel, intervalDel));
                    break;
                case 4:
                    list.printTaskList();
                    break;
                case 5:
                    // календарь
            }
        }
        System.out.println("До свидания!");

    }

}
