class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStringBldr = new StringBuilder();
        for (String str: strs) {
            encodedStringBldr.append(str.length());
            encodedStringBldr.append("#");
            encodedStringBldr.append(str);
        }
        return encodedStringBldr.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder stringLengthStr;
        Integer stringLength;

        stringLengthStr = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '#') {
                stringLength = Integer.parseInt(stringLengthStr.toString());
                decodedStrings.add(str.substring(i+1, i+1+stringLength));
                i+=stringLength;
                stringLengthStr = new StringBuilder();
                continue;
            }
            stringLengthStr.append(str.charAt(i));
        }
        return decodedStrings;
    }
}
