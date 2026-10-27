
import java.util.*;

public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public static class Task {
        private final int id;
        private final String title;
        private boolean completed;

        public Task(int id, String title) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException(
                        "Название задачи не может быть пустым"
                );
            }

            this.id = id;
            this.title = title;
            this.completed = false;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void complete() {
            completed = true;
        }
    }

    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void completeTask(int id) {
        Task task = tasks.get(id);

        if (task == null) {
            throw new IllegalArgumentException(
                    "Задача не найдена"
            );
        }

        task.complete();
    }

    public void deleteTask(int id) {
        if (tasks.remove(id) == null) {
            throw new IllegalArgumentException(
                    "Задача не найдена"
            );
        }
    }

    public List<Task> getCompletedTasks() {
        return tasks.values().stream()
                .filter(Task::isCompleted)
                .toList();
    }
}
