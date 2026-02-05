package utils;

public class Regex {

    private static String pattern = "^\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*$";

    public static String getPattern() {
        return pattern;
    }


}
