class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        // encode the size of each string and a separator so that decode can extract it
        for (String s: strs) {
            str.append(s.length() + "#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int start = 0;
        while (start < str.length()) {
            int end = start;
            while (str.charAt(end) != '#') end++;
            int len = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + len;
            list.add(str.substring(start, end));
            start = end;
        }
        return list;
    }
}
