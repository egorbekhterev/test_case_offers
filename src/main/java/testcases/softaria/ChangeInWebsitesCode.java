package testcases.softaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangeInWebsitesCode implements Letter {

    /**
     * Метод принимает на вход 2 хэш-таблицы, содержащие состояния сайтов на вчера и сегодня соответственно.
     * Производится добавление URL-ов в соответствующие хранилища для записи изменений по
     * заданному множеству веб-сайтов.
     */
    private UrlList specification(Map<String, String> y, Map<String, String> t) {
        Validation validation = new MapValidation();
        validation.validate(y);
        validation.validate(t);
        List<String> listAdded = new ArrayList<>();
        List<String> listChanged = new ArrayList<>();
        for (Map.Entry<String, String> entry : t.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!y.containsKey(key)) {
                listAdded.add(key);
            }
            y.forEach((s1, s2) -> {
                if (s1.equals(key) && !s2.equals(value)) {
                    listChanged.add(key);
                }
            });
            y.remove(key);
        }
        List<String> listLost = new ArrayList<>(y.keySet());
        return new UrlList(listLost, listChanged, listAdded);
    }

    /**
     * @param y Список веб-сайтов за вчера.
     * @param t Список веб-сайтов за сегодня.
     * @return Возвращает строку в виде письма в формате, представленном в ТЗ.
     */
    @Override
    public String writeLetter(Map<String, String> y, Map<String, String> t) {
        var url = specification(y, t);
        Appender appender = new StringAppender();
        return appender.append(url);
    }
}
