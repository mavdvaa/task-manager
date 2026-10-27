
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTASK MANAGER");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Показать все задачи");
            System.out.println("3. Завершить задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Показать выполненные задачи");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Введите название задачи: ");
                        String title = scanner.nextLine();

                        TaskManager.Task task = manager.addTask(title);
                        System.out.println(
                                "Задача добавлена. ID: " + task.getId()
                        );
                        break;

                    case "2":
                        if (manager.getAllTasks().isEmpty()) {
                            System.out.println("Список задач пуст.");
                        } else {
                            for (TaskManager.Task item : manager.getAllTasks()) {
                                printTask(item);
                            }
                        }
                        break;

                    case "3":
                        System.out.print("Введите ID задачи: ");
                        int completeId = Integer.parseInt(scanner.nextLine());

                        manager.completeTask(completeId);
                        System.out.println("Задача завершена.");
                        break;

                    case "4":
                        System.out.print("Введите ID задачи: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        manager.deleteTask(deleteId);
                        System.out.println("Задача удалена.");
                        break;

                    case "5":
                        if (manager.getCompletedTasks().isEmpty()) {
                            System.out.println("Выполненных задач пока нет.");
                        } else {
                            for (TaskManager.Task item : manager.getCompletedTasks()) {
                                printTask(item);
                            }
                        }
                        break;

                    case "0":
                        System.out.println("Завершение работы");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неизвестная команда. Попробуйте снова.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void printTask(TaskManager.Task task) {
        String status = task.isCompleted() ? "выполнена" : "не выполнена";

        System.out.println(
                task.getId() + ". " + task.getTitle() + " — " + status
        );
    }
}
