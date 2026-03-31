class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (String s: strs) {
            str.append(s.length());
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = start;
        while (end < str.length()) {
            while (str.charAt(end) != '#') end++;
            int sLength = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + sLength;
            list.add(str.substring(start, end));
            start = end;
            end = start;
        }
        return list;
    }
}
