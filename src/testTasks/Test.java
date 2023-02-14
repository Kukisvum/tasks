package testTasks;

import java.util.*;
import java.util.stream.Collectors;


/*
China 32 28 34
England 12 34 22
France 23 33 2
Japan 12 34 25
Russia 23 43 0
 */

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < count+1; i++) {
            String row = sc.nextLine();
            String[] rows = row.split(" ");
            if (i>0) {
            Country country = new Country(rows[0], Integer.parseInt(rows[1]), Integer.parseInt(rows[2]), Integer.parseInt(rows[3]));
            countries.add(country);
            }
        }
        sc.close();

        Comparator<Country> comparator = Comparator
                .comparing(Country::getGold)
                .thenComparing(Country::getSilver)
                .thenComparing(Country::getBronze)
                .thenComparing(Country::getName);
        List<Country> resultList = countries.stream().sorted(comparator).collect(Collectors.toList());

        Collections.reverse(resultList);
        for (Country c: resultList) {
            System.out.println(c.getName());
        }

    }
}
