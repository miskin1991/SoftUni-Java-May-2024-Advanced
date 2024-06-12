package Labs.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String instruction = scanner.nextLine();
        String page = "empty";
        ArrayDeque<String> pageStack = new ArrayDeque<>();

        while (!"Home".equals(instruction)) {
            if (instruction.equals("back")) {
                if (pageStack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    page = pageStack.pop();
                    System.out.println(page);
                }
            } else {
                if(!page.equals("empty")) {
                    pageStack.push(page);
                }
                page = instruction;
                System.out.println(page);
            }
            instruction = scanner.nextLine();
        }
    }
}