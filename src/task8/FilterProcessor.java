package task8;

import java.util.function.Function;

public class FilterProcessor {
    public void applyFilter(Image image, Function<Image, Image> function) {
        function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> secondFunction) {
        return function.andThen(secondFunction);
    }
}
