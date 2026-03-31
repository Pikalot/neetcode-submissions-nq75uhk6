class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s: strs) {
            str.append(s.length() + "#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> list = new ArrayList<>();
        // int start = 0;
        int start = 0;
        while (start < str.length()) {
            int end = start;
            while (str.charAt(end) != '#') {
                end++;
            }
            int length = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + length;
            list.add(str.substring(start, end));
            start = end;

        }
        return list;
    }
}
