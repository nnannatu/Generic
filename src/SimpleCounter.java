import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class SimpleCounter {

    // Method to count elements that satisfy the condition (predicate)
    public static <T> int countElements(Collection<T> collection, Predicate<T> condition) {
        int count = 0;  // Initialize counter
        for (T item : collection) {  // Loop through each item in the collection
            if (condition.test(item)) {  // Check if the item satisfies the condition
                count++;  // If true, increase the count
            }
        }
        return count;  // Return the total count
    }

    public static void main(String[] args) {
        // Example 1: Count odd numbers
        Collection<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> isOdd = number -> number % 2 != 0;  // Define the condition for odd numbers
        System.out.println("Odd Numbers: " + countElements(numbers, isOdd));  // Output: 5

        // Example 2: Count prime numbers
        Predicate<Integer> isPrime = number -> {
            if (number <= 1) return false;  // Numbers less than or equal to 1 are not prime
            for (int i = 2; i <= Math.sqrt(number); i++) {  // Loop from 2 to sqrt(number)
                if (number % i == 0) return false;  // If divisible by any number, not prime
            }
            return true;  // If no divisors, it's prime
        };
        System.out.println("Prime Numbers: " + countElements(numbers, isPrime));  // Output: 4

        // Example 3: Count palindromes (words that read the same forward and backward)
        Collection<String> words = List.of("madam", "racecar", "hello", "world", "level");
        Predicate<String> isPalindrome = word -> word.equals(new StringBuilder(word).reverse().toString());  // Define palindrome condition
        System.out.println("Palindromes: " + countElements(words, isPalindrome));  // Output: 3
    }
}