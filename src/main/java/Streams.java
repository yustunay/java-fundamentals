import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        //printNamesAsUppercaseWithStartX("j");
        //printSumOfIntegers();
        //printAgeCountMap();
        //sortListItemsByName();
        //printFlattenedList();
        printSumEvenNumbersWithUsingParallelStream();
    }

    private static void printNamesAsUppercaseWithStartX(String prefix){
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");
        names.stream()
                .filter(name -> name.toLowerCase().startsWith(prefix.toLowerCase()))
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }

    private static void printSumOfIntegers(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0,Integer::sum);
        //int sum = numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
    }

    private static void printAgeCountMap(){
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Adam", 25),
                new Person("Eve", 30)
        );

        persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.counting())).forEach((name,count)-> System.out.println(name+" - "+count));
    }

    private static void sortListItemsByName(){
        List<String> fruits = Arrays.asList("Pineapple", "Apple", "Orange", "Banana");
        List<String> sortedFruits = fruits.stream().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
        System.out.println(sortedFruits);
    }

    private static void printFlattenedList(){
        List<List<Integer>> numberList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );
        List<Integer> flattenedList = numberList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flattenedList);
    }

    private static void printSumEvenNumbersWithUsingParallelStream(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int sum = numbers.parallelStream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }

    private static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
