package testcases.softaria;

public class StringAppender implements Appender {

    private static final String LOST = "Исчезли следующие страницы: ";
    private static final String ADDED = "Появились следующие новые страницы: ";
    private static final String CHANGED = "Изменились следующие страницы: ";
    private static final String LS = System.lineSeparator();

    /**
     * Метод позволяет произвести преобразования строк к виду, заявленному в ТЗ.
     * @return возвращает строку, которая впоследствии будет перенесена в текстовый файл.
     */
    @Override
    public String append(UrlList urlList) {
        return new StringBuilder("Здравствуйте, дорогая и.о. секретаря").append(LS)
                .append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:").append(LS)
                .append(ADDED).append(urlList.listAdded()).append(LS)
                .append(CHANGED).append(urlList.listChanged()).append(LS)
                .append(LOST).append(urlList.listLost()).append(LS)
                .append("С уважением, автоматизированная система мониторинга.").toString();
    }
}
