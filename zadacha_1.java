// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
// Пример:
// Иванов 1231234
// Иванов 3456345
// Иванов 5676585
// Петров 12345
// Петров 82332
import java.util.*;
public class zadacha_1 {
    public static void phoneMenu(){
        System.out.println("Для добвавления фамилии (латиницей) и номера телефона введите цифру 1");
        System.out.println("Для вывода результата введите цифру 2");
    }
    public static ArrayList<Integer> cloneArray(ArrayList<Integer> myList){
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            tempArrayList.add(iterator.next());
        }
        return tempArrayList;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<String,ArrayList<Integer>>();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        while(true){
            System.out.println();
            phoneMenu();
            System.out.println();
            System.out.print("Введите цифру: ");
            Integer choice = input.nextInt();
            System.out.println();
            if(choice == 1){   
                System.out.print("Введите фамилию: ");
                String surname = input.next();
                System.out.println();
                System.out.print("Введите номер: ");
                Integer number = input.nextInt();
                System.out.println();
                numList.add(number);
                if(phoneBook.containsKey(surname) != true){
                    phoneBook.putIfAbsent(surname, cloneArray(numList));
                    numList.clear();
                 }
                else{  
                    numList = phoneBook.get(surname);
                    numList.add(number);
                    phoneBook.put(surname, cloneArray(numList));
                    numList.clear();
                }   
            }
            if(choice==2){
                for(var item: phoneBook.entrySet()){
                    String key = item.getKey();
                    ArrayList<Integer> numbers = item.getValue();
                    String stringNumbers = numbers.toString(); 
                    stringNumbers = stringNumbers.replace("[", "");
                    stringNumbers = stringNumbers.replace("]", "");
                    System.out.printf(key + ": " + stringNumbers );
                    System.out.println();
                }   
            }
        }
        // input.close();
    }
    
}