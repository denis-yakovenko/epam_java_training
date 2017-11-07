package Task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Task7.Operation.getAllowableOperationByOrdinal;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }

    public static Operation askOperation() {
        while (true) {
            writeMessage("choose operation:");
            for (Operation operation : Operation.values()
                    ) {
                writeMessage(operation.ordinal() + " - " + operation);
            }
            writeMessage(Arrays.toString(Operation.values()));
            try {
                return getAllowableOperationByOrdinal(Integer.parseInt(readString().trim()));
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}