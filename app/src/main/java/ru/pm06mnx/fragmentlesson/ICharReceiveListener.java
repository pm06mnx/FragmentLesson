package ru.pm06mnx.fragmentlesson;

/**
 * Слушатель для получаемых символов
 */
public interface ICharReceiveListener {

    /**
     * Обрабатывает получение сообщения
     *
     * @param ch символы из сообщения
     */
    void onCharsReceive(String ch);
}
