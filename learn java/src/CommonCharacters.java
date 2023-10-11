import java.util.*;

public class CommonCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> array = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter string " + i + ": ");
            String inputString = scanner.nextLine();
            array.add(inputString);
        }

        Map<Character, Integer> dict = new HashMap<>();

        // Initialize dict with the characters from the first string
        for (char c : array.get(0).toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < array.size(); i++) {
            String now = array.get(i);
            Map<Character, Integer> d = new HashMap<>();

            for (char c : now.toCharArray()) {
                d.put(c, d.getOrDefault(c, 0) + 1);
            }

            // Update dict to find the common characters
            for (char key : dict.keySet()) {
                if (d.containsKey(key)) {
                    dict.put(key, Math.min(dict.get(key), d.get(key)));
                } else {
                    dict.put(key, 0);
                }
            }
        }

        List<Character> ans = new ArrayList<>();

        for (char c : dict.keySet()) {
            int total = dict.get(c);
            for (int i = 0; i < total; i++) {
                ans.add(c);
            }
        }

        if (ans.isEmpty()) {
            System.out.println("No common characters found.");
        } else {
            System.out.print("Common characters: " + ans);
        }
    }
}
