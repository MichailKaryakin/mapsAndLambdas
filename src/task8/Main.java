package task8;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image image = new Image("Behistun Inscription", "Is a multilingual Achaemenid royal inscription and large rock relief on a cliff at Mount Behistun in the Kermanshah Province of Iran.");
        Image image1 = new Image("Ruins of the Temple of Artemis", "The original temple was among the Seven Wonders of the World and was burnt down in 356 by Herostratos on the eve of the birth of Alexander the Great.");
        Image image2 = new Image("The Last Judgement, Sistine chapel", "The Last Judgement was painted by Michelangelo from 1535 to 1541, between two important historic events: the Sack of Rome by mercenary forces of the Holy Roman Empire in 1527, and the Council of Trent which commenced in 1545.");
        Image image3 = new Image("The Gate of All Nations", "Also known as the Gate of Xerxes, is located in the ruins of the ancient city of Persepolis, Iran.");

        Function<Image, Image> addingGlyph = (img -> {
            String[] words = img.getDescription().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                String glyph = Character.toString(0x12070);
                builder.append(word).append(glyph);
            }
            Image newImage = new Image(img.getFileName(), builder.toString());
            System.out.println(newImage);
            return newImage;
        });

        Function<Image, Image> allToLower = (img -> {
            Image newImage = new Image(img.getFileName(), img.getDescription().toLowerCase());
            System.out.println(newImage);
            return newImage;
        });

        Function<Image, Image> allToUpper = (img -> {
            Image newImage = new Image(img.getFileName(), img.getDescription().toUpperCase());
            System.out.println(newImage);
            return newImage;
        });

        filterProcessor.applyFilter(image, addingGlyph);

        filterProcessor.applyFilter(image1, allToLower);

        filterProcessor.applyFilter(image2, allToUpper);

        filterProcessor.applyFilter(image3, filterProcessor.combineFilters(addingGlyph, allToUpper));
    }
}
