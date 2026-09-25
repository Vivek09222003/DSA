import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression, new int[]{0});
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s, int[] i) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i[0] < s.length() && s.charAt(i[0]) != '}') {
            if (s.charAt(i[0]) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i[0]++;
            } else {
                Set<String> next = new HashSet<>();

                if (s.charAt(i[0]) == '{') {
                    i[0]++;
                    next = parse(s, i);
                    i[0]++;
                } else {
                    next.add(String.valueOf(s.charAt(i[0])));
                    i[0]++;
                }

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : next) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }
        }

        result.addAll(current);
        return result;
    }
}