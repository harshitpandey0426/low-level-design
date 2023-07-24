import java.util.*;

class Person {
    String name;
    int debt;

    public Person(String name, int debt) {
        this.name = name;
        this.debt = debt;
    }
}

public class SimplifyDebtAlgo {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        //taking input directly as (incoming - outgoing)
        people.add(new Person("Harshit", -50));
        people.add(new Person("Mayank", 30));
        people.add(new Person("Abhinav", 20));
        people.add(new Person("Gaurav", -10));
        people.add(new Person("Richa", 10));

        List<Person> owedList = new ArrayList<>();
        List<Person> owesList = new ArrayList<>();

        for (Person person : people) {
            if (person.debt < 0) {
                owedList.add(person);
            } else if (person.debt > 0) {
                owesList.add(person);
            }
        }

        Collections.sort(owedList, (p1, p2) -> p1.debt - p2.debt);
        Collections.sort(owesList, (p1, p2) -> p1.debt - p2.debt);

        int i = 0, j = 0;
        while (i < owedList.size() && j < owesList.size()) {
            int owed = owedList.get(i).debt;
            int owes = owesList.get(j).debt;

            if (owed == -owes) {
                System.out.println(owedList.get(i).name + " pays " + owesList.get(j).name + " " + Math.abs(owed));
                i++;
                j++;
            } else if (owed < -owes) {
                System.out.println(owedList.get(i).name + " pays " + owesList.get(j).name + " " + Math.abs(owed));
                owesList.get(j).debt = owes + owed;
                i++;
            } else {
                System.out.println(owedList.get(i).name + " pays " + owesList.get(j).name + " " + Math.abs(owes));
                owedList.get(i).debt = owed + owes;
                j++;
            }
        }
    }
}
