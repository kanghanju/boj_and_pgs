class Solution {
    public String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9\\-_.]","");
        newId = newId.replaceAll("\\.{2,}",".");
        newId = newId.replaceAll("^\\.|\\.$","");
        if(newId.isEmpty())newId += "a";
        if(newId.length() >= 16) {
            newId = newId.substring(0,15);
            newId = newId.replaceAll("\\.+$","");
        }
        while (newId.length() <= 2) {
            newId += newId.charAt(newId.length() - 1);
        }
        
        return newId;
    }
}