package Excercise;

import Excercise.Person.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> personMap = new HashMap<>();

        collectBuyers(scanner, personMap);

        buyFood(scanner, personMap);

        System.out.println(personMap.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum());

    }

    private static void buyFood(Scanner scanner, Map<String, Buyer> personMap) {
        String name = scanner.nextLine();
        while (!name.equals("End")) {

            if (personMap.containsKey(name)) {
                personMap.get(name)
                        .buyFood();
            }

            name = scanner.nextLine();
        }
    }

    private static void collectBuyers(Scanner scanner, Map<String, Buyer> personList) {
        int number = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < number; index++) {
            String[] input = scanner.nextLine().split(" ");

            switch (input.length) {
                case 3:
                    Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                    personList.putIfAbsent(input[0], rebel);
                    break;
                case 4:
                    Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                    personList.putIfAbsent(input[0], citizen);
                    break;
            }
        }
    }
}
