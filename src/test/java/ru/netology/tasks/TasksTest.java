package ru.netology.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void simpleTaskMatchesWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить маме");
        assertTrue(task.matches("маме"));
    }

    @Test
    public void epicMatchesWhenQueryInSubtasks() {
        Epic epic = new Epic(2, new String[]{"Сыр", "Хлеб", "Молоко"});
        assertTrue(epic.matches("Хлеб"));
    }

    @Test
    public void meetingMatchesWhenQueryInTopicOrProject() {
        Meeting meeting = new Meeting(3, "Релиз", "Проект Х", "Завтра");
        assertTrue(meeting.matches("Релиз"));
        assertTrue(meeting.matches("Проект"));
        assertFalse(meeting.matches("Среда"));
    }
}
