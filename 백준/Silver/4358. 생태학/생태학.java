import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> treeMap = new HashMap<>();
        String tree;
        int total = 0;

        while ((tree = br.readLine()) != null) {
            if (tree.isEmpty()) continue;
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            total++;
        }

        // 사전순 정렬
        TreeMap<String, Integer> sorted = new TreeMap<>(treeMap);

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double percentage = (count * 100.0) / total;
            sb.append(String.format("%s %.4f\n", name, percentage));
        }

        System.out.print(sb.toString());
    }
}
