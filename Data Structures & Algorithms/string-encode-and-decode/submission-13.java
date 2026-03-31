class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s: strs){
            int length = s.length();
            str.append(length + "#" + s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        System.out.println(str);
        while (start < str.length()){
            int end = start;
            while (str.charAt(end) != '#') end++;
            System.out.println(str.substring(start, end));
            int length = Integer.parseInt(str.substring(start, end));
            System.out.println("length " + length);
            start = end + 1;
            end = start + length;
            System.out.println("start " + start + " end " + end);
            System.out.println("string " + str.substring(start, end));
            list.add(str.substring(start, end));
            start = end;
        }
        return list;
    }
}
