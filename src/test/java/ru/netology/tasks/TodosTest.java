package ru.netology.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555, "Выкатка", "НетоБанк", "Вторник");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        assertArrayEquals(expected, todos.findAll());
    }

    @Test
    public void searchShouldReturnMatchingTasksOnly() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить маме");
        Epic task2 = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting task3 = new Meeting(3, "Встреча", "Проект", "Понедельник");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Хлеб");
        assertArrayEquals(new Task[]{task2}, result);
    }

    @Test
    public void searchShouldReturnEmptyArrayIfNoMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));

        Task[] result = todos.search("купить");
        assertArrayEquals(new Task[0], result);
    }

    // ✅ Новые тесты:

    @Test
    public void searchShouldReturnMultipleMatchingTasks() {
        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        Epic task2 = new Epic(2, new String[]{"Молоко", "Яйца"});
        Meeting task3 = new Meeting(3, "Совещание", "Молочный проект", "Утро");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Мол");
        Task[] expected = {task1, task2, task3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldReturnExactlyOneMatchingTask() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить маме");
        Epic task2 = new Epic(2, new String[]{"Хлеб", "Яйца"});
        Meeting task3 = new Meeting(3, "Встреча", "Проект Альфа", "Понедельник");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("Хлеб");
        Task[] expected = {task2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void searchShouldReturnEmptyArrayWhenNoTasksMatch() {
        SimpleTask task1 = new SimpleTask(1, "Прочитать книгу");
        Epic task2 = new Epic(2, new String[]{"Завтрак", "Обед"});
        Meeting task3 = new Meeting(3, "Стратегия", "Проект Омега", "Вечер");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] result = todos.search("спорт");
        assertArrayEquals(new Task[0], result);
    }
}
