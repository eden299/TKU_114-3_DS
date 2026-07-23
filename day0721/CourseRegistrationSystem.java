package day0721;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courseList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 選課管理系統 ===");
            System.out.println("1. 新增課程");
            System.out.println("2. 學生選課 (增加人數)");
            System.out.println("3. 學生退選 (減少人數)");
            System.out.println("4. 搜尋課程");
            System.out.println("5. 刪除課程");
            System.out.println("6. 輸出課程總體統計與額滿名單");
            System.out.println("7. 離開系統");
            System.out.print("請選擇操作 (1-7): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addCourse(scanner, courseList);
                    break;
                case "2":
                    enrollCourse(scanner, courseList);
                    break;
                case "3":
                    dropCourse(scanner, courseList);
                    break;
                case "4":
                    searchCourse(scanner, courseList);
                    break;
                case "5":
                    deleteCourse(scanner, courseList);
                    break;
                case "6":
                    printStatistics(courseList);
                    break;
                case "7":
                    System.out.println("感謝使用選課管理系統！");
                    scanner.close();
                    return;
                default:
                    System.out.println("【錯誤】無效選項，請重新選擇！");
            }
        }
    }
    private static Course findById(String id, ArrayList<Course> courseList) {
        for (Course c : courseList) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    private static void addCourse(Scanner scanner, ArrayList<Course> courseList) {
        System.out.print("請輸入課程代碼: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("【錯誤】代碼不可為空白！");
            return;
        }

        if (findById(id, courseList) != null) {
            System.out.println("【錯誤】課程代碼 「" + id + "」 已存在！");
            return;
        }

        System.out.print("請輸入課程名稱: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("【錯誤】名稱不可為空白！");
            return;
        }

        System.out.print("請輸入課程容量上限: ");
        int capacity = readInt(scanner);
        if (capacity <= 0) {
            System.out.println("【錯誤】容量必須大於 0！");
            return;
        }

        courseList.add(new Course(id, name, capacity));
        System.out.println("成功新增課程: " + name + " (容量: " + capacity + " 人)");
    }

    private static void enrollCourse(Scanner scanner, ArrayList<Course> courseList) {
        System.out.print("請輸入要選課的課程代碼: ");
        String id = scanner.nextLine().trim();
        Course course = findById(id, courseList);

        if (course == null) {
            System.out.println("【選課失敗】找不到該課程！");
        } else if (course.isFull()) {
            System.out.println("【選課失敗】課程 「" + course.getName() + "」 已額滿，無法再加選！");
        } else {
            course.enroll();
            System.out.println("成功加選課程: " + course.getName() + " (目前人數: " + course.getEnrolledCount() + "/" + course.getCapacity() + ")");
        }
    }

    private static void dropCourse(Scanner scanner, ArrayList<Course> courseList) {
        System.out.print("請輸入要退選的課程代碼: ");
        String id = scanner.nextLine().trim();
        Course course = findById(id, courseList);

        if (course == null) {
            System.out.println("【退選失敗】找不到該課程！");
        } else if (course.getEnrolledCount() <= 0) {
            System.out.println("【退選失敗】該課程目前選課人數為 0，無法再退選！");
        } else {
            course.drop();
            System.out.println("成功退選課程: " + course.getName() + " (目前人數: " + course.getEnrolledCount() + "/" + course.getCapacity() + ")");
        }
    }

    private static void searchCourse(Scanner scanner, ArrayList<Course> courseList) {
        System.out.print("請輸入要搜尋的課程代碼或名稱關鍵字: ");
        String keyword = scanner.nextLine().trim();

        boolean found = false;
        for (Course c : courseList) {
            if (c.getId().equalsIgnoreCase(keyword) || c.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("【找到課程】" + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到與 「" + keyword + "」 相關的課程。");
        }
    }

    private static void deleteCourse(Scanner scanner, ArrayList<Course> courseList) {
        System.out.print("請輸入要刪除的課程代碼: ");
        String id = scanner.nextLine().trim();
        Course course = findById(id, courseList);

        if (course == null) {
            System.out.println("【刪除失敗】找不到該課程！");
        } else {
            courseList.remove(course);
            System.out.println("成功刪除課程: " + course.getName());
        }
    }

    private static void printStatistics(ArrayList<Course> courseList) {
        System.out.println("\n=== 課程系統統計報告 ===");
        System.out.println("總課程數: " + courseList.size() + " 門");

        int totalEnrolled = 0;
        ArrayList<Course> fullCourses = new ArrayList<>();

        for (Course c : courseList) {
            totalEnrolled += c.getEnrolledCount();
            if (c.isFull()) {
                fullCourses.add(c);
            }
        }

        System.out.println("總選課人次: " + totalEnrolled + " 人次");
        System.out.println("額滿課程數: " + fullCourses.size() + " 門");

        if (!fullCourses.isEmpty()) {
            System.out.println("--- 額滿課程明細 ---");
            for (Course fc : fullCourses) {
                System.out.println(" * " + fc.getName() + " (代碼: " + fc.getId() + ")");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
