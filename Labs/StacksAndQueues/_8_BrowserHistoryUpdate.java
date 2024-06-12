package Labs.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String instruction = scanner.nextLine();
        String page = "empty";
        ArrayDeque<String> backwardStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        while (!"Home".equals(instruction)) {
            if (instruction.equals("back")) {
                if (backwardStack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    if(!page.equals("empty")) {
                        forwardStack.push(page);
                    }
                    page = backwardStack.pop();
                    System.out.println(page);
                }
            } else if (instruction.equals("forward")) {
                  if (!forwardStack.isEmpty()) {
                      page = forwardStack.pop();
                      System.out.println(page);
                  } else {
                      System.out.println("no next URLs");
                  }
            } else {
                if(!page.equals("empty")) {
                    backwardStack.push(page);
                }
                page = instruction;
                forwardStack.clear();
                System.out.println(page);
            }
            instruction = scanner.nextLine();
        }
    }
}
