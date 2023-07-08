package Control;

import Extra.Utils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public final class InputController {
    private static final String DEFAULT_ERROR = "Insira uma entrada válida";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputController() {
    }

    public static String getValidInput(List<String> options, String customError) {
        String errorMessage = (customError == null) ? DEFAULT_ERROR : customError;
        String userInput;
        Optional<String> result;

        do {
            userInput = SCANNER.nextLine().trim().toUpperCase();
            result = Utils.getFromList(userInput, options);

            if (result.isEmpty())
                System.out.println(errorMessage);
        } while (result.isEmpty());

        return result.get();
    }

}
