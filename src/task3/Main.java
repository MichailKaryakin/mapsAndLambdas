package task3;

import java.util.*;

public class Main {
    private final HashMap<String, List<WebPage>> webPages = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();
    }

    public void runProgram() {
        List<WebPage> pagesToIndex = new ArrayList<>();

        pagesToIndex.add(
                new WebPage(
                        "something.ru",
                        "Texas Flood",
                        "Flooding down in texas, all of the telephone lines are down"
                )
        );

        pagesToIndex.add(
                new WebPage(
                        "something-else.ru",
                        "Texas Blues",
                        "They call it stormy Monday, but Tuesday’s just as bad"
                )
        );

        addToMap(pagesToIndex);
        runSearch();
    }

    public void addToMap(List<WebPage> pagesToIndex) {
        for (WebPage webPage : pagesToIndex) {
            String[] titleWords = webPage.getTitle().split(" ");

            for (String titleWord : titleWords) {
                if (webPages.containsKey(titleWord)) {
                    webPages.get(titleWord).add(webPage);
                } else {
                    webPages.put(titleWord, new ArrayList<>());
                    webPages.get(titleWord).add(webPage);
                }
            }
        }
    }

    public void runSearch() {
        System.out.println("Введите ключевое слово для поиска: ");
        String key = scanner.nextLine();
        List<WebPage> pagesByKey = webPages.get(key);

        for (WebPage webPage : pagesByKey) {
            System.out.println("Ключ: " + key);
            System.out.println(webPage);
        }
    }
}
