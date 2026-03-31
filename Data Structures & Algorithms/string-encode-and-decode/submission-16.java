class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s: strs) {
            int length = s.length();
            str.append(length + "#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        int start = 0;
        List<String> list = new ArrayList<>();

        while (start < str.length()) {
            int end = start;
            while (str.charAt(end) != '#') end++;
            int length = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + length;
            list.add(str.substring(start, end));
            start = end;
        }
        return list;
    }
}
