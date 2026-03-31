class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
         for (String s: strs) {
            int size = s.length();
            str.append(size +"#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        int j = i;

        while (i < str.length()) {
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
