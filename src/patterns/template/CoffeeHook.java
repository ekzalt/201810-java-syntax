package patterns.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeHook extends Coffee {
    public CoffeeHook(String[] condiments) {
        super(condiments);
    }

    private String getUserInput() {
        String answer = null;
        System.out.print("Would you like milk and sugar? (y/n) ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer == null) return "n";

        return answer;
    }

    // реализация хука
    @Override
    protected boolean needCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) return true;

        return false;
    }
}
