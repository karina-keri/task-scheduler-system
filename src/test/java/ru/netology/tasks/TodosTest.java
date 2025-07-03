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
}
