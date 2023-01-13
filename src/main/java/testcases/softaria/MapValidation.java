package testcases.softaria;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.regex.Pattern;

public class MapValidation implements Validation {

    private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

    /**
     * Метод проверяет, что ключом хэш-таблицы является URL-ссылка, а значением HTML-код.
     */
    @Override
    public void validate(Map<String, String> map) {
        Pattern pattern = Pattern.compile(HTML_PATTERN);
        for (String key : map.keySet()) {
            try {
                new URL(key);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(String.format(
                        "Map must consist of url as key: %s", key
                ));
            }
            if (!pattern.matcher(map.get(key)).find()) {
                throw new IllegalArgumentException(String.format("Map must consist of html as value: %s",
                        map.get(key)));
            }
        }
    }
}
