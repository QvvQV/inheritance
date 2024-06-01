package ru.netology;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Ниже находятся вспомогательные методы для корректной работы equals
    // Переопределять их в наследниках не нужно


    //     * Метод, проверяющий подходит ли эта задача поисковому запросу.
//     * @param query Поисковый запрос
//     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
    public boolean matches(String query) {
        return false;
    }
}
