import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberToBinary {

    public static void main(String[] args) {
        String input = "452";
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            indexMap.put(i, Character.getNumericValue(input.charAt(i)));
        }
        List<String> listOfNumber = new ArrayList<>();
        while (indexMap.values().stream().distinct().count() > 1) {
            List<Integer> eachItem = new ArrayList<>();
            indexMap.entrySet().stream().forEach(
                    (x) -> {
                        eachItem.add(x.getKey(), x.getValue() > 0 ? 1 : 0);
                        x.setValue(x.getValue() > 0 ? x.getValue() - 1 : 0);
                    }
            );
            listOfNumber.add(eachItem.stream().map(n -> String.valueOf(n))
                    .collect(Collectors.joining("")));
        }
        System.out.println(listOfNumber);
    }
}
