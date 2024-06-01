package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;

public class TodosTest {
    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingAndEpic() { //поиск в Epic и Meeting по элементу названия во всех
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("задач");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() { //поиск в Simple по элементу названия во всех
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-листы");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("чек-листы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() { //поиск в Epic по элементу названия во всех
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("дефект");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingFirst() { //поиск в Meeting по задаче во всех
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingSecond() { //поиск в Meeting по проекту во всех
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingThird() { //поиск в Meeting по началу времени по всем
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskTrue() { //положительный поиск в Simple
        Task simpleTask = new SimpleTask(1, "Написать чек-лист");

        boolean expected = true;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() { //отрицательный поиск в Simple
        Task simpleTask = new SimpleTask(1, "Написать чек-лист");

        boolean expected = false;
        boolean actual = simpleTask.matches("написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() { //положительный поиск в Epic
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Task epic = new Epic(31, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("дефект");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() { //отрицательный поиск в Epic
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Task epic = new Epic(31, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("баг репорт");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTrue() { //положительный поиск в Meeting
        Task meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        boolean expected = true;
        boolean actual = meeting.matches(" в ");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() { //отрицательный поиск в Meeting
        Task meeting = new Meeting(
                17,
                "Поиск ошибок в обновлении",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        boolean expected = false;
        boolean actual = meeting.matches("утра");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() { //отрицательный поис в Task
        Task task = new Task(31);

        boolean expected = false;
        boolean actual = task.matches("дефект");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() { //Task сравнение ID
        String[] subtasks = {"Написать чек-лист", "Найти дефект", "Завести баг-репорт", "Отправить баг-репорт", "Закрыть задачу"};
        Task epic = new Epic(31, subtasks);
        Task task = new Task(31);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);

    }

}