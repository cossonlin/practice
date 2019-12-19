package learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username {
    private static Pattern usrNamePtrn = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-]{5,15}$");
    public static boolean validate(String username) {
        if (username.indexOf("-") != username.lastIndexOf("-")){
            return false;
        }
        Matcher match = usrNamePtrn.matcher(username);
        if(match.matches()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike-Standish")); // Valid username
        System.out.println(validate("Mike Standish")); // Invalid username
    }
}