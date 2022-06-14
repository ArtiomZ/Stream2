import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long result = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(result);

        List<String> list = persons.stream()
                .filter(person -> person.getAge() < 27 && person.getAge() > 17)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        for (int i = 0; i < 20; i++) {
            System.out.println(list.get(i));
        }

        List<Person> list1 = persons.stream()
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getAge() > 17 && person.getAge() < 65)
                .filter(person -> person.getSex().equals(Sex.WOMAN) && person.getAge() < 60)
                .collect(Collectors.toList());
        for (int j = 0; j < 20; j++) {
            System.out.println(list1.get(j));
        }
    }
}
