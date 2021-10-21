package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rules {

    private static final List<String> ruleList = new ArrayList<>(Arrays.asList(
            "Call", "Check", "Raise"
    ));

    public static boolean allowedInput(String choice) {
        return ruleList.contains(choice);
    }

}
