package DammAutomationFramework.utils;

public class Validation {
    public static boolean areStringsEqual(String currentString, String expectedString) {
        return currentString.equalsIgnoreCase(expectedString);
    }

    public static boolean doesString1ContainString2(String string1, String string2) {
        return string1.toLowerCase().contains(string2.toLowerCase());
    }
}
