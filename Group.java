package com.trckstr;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Group {

    private String courseName;
    private String courseStart;
    private int numberOfLessons;
    private int lessonsPerWeek;
    private ArrayList<Person> students;

    {
        students = new ArrayList<>();
        students.add(new Person("Владислав", "Заугольный"));
        students.add(new Person("Андрей", "Фефелов"));
        students.add(new Person("Антон", "Щипицин"));
        students.add(new Person("Андрей", "Киряхно"));
        students.add(new Person("Артур", "Кваде"));
        students.add(new Person("Дмитрий", "Лошкарев"));
        students.add(new Person("Серж", "Гарашенко"));
    }

    public Group(String courseName, String courseStart, int numberOfLessons, int lessonsPerWeek) {
        this.courseName = courseName;
        this.courseStart = courseStart;
        this.numberOfLessons = numberOfLessons;
        this.lessonsPerWeek = lessonsPerWeek;
    }

    public void printGroupName() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        try {
            Date date = df.parse(courseStart);
            DateFormat newFormat = new SimpleDateFormat("ddMMMyyyy", Locale.US);
            String newFormatDate = newFormat.format(date);
            String groupName = courseName + newFormatDate;
            System.out.println("Название группы - " + groupName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date lastStudyWeek() {
        DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        try {
            Date date1 = df1.parse(courseStart);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            calendar.add(Calendar.DAY_OF_WEEK, (7 * (numberOfLessons / lessonsPerWeek - 1) - 2));
            date1 = calendar.getTime();
            System.out.println("Дата последней недели занятий: " + date1);
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printList() {
        System.out.println("");
        System.out.println("Список студентов группы:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". " + students.get(i));
        }
    }

    public Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Введите имя:");
        String nameStr = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastNameStr = scanner.nextLine();
        students.add(new Person(nameStr, lastNameStr));
    }

    public void lastNameCheck() {
        System.out.println("Введите фамилию");
        int count = 0;
        String checkLastName = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equals(checkLastName)) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Есть такой");
        } else {
            System.out.println("Нету такого");
        }
    }

    public void removePersonByIndex() {
        System.out.println("Введите индекс студента");
        int index = scanner.nextInt();
        students.remove(index);
        printList();
    }
    public void removePersonByLastName() {
        System.out.println("Введите фамилию студента");
        String lastnameOfPerson = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equals(lastnameOfPerson)) {
                students.remove(students.get(i));
                printList();
            }
        }
    }

        @Override
    public String toString() {
        return "Group{" +
                "students=" + students +
                '}';
    }
}
