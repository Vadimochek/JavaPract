package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pr28 {
    private Pattern pattern;
    private Matcher matcher;

    //Задание 2
    private static final String IPADDRESS81016 =
        "^(0([xX]|0[0-7]{10,11})[0-9a-fA-F]{8}|(\\b4\\d{8}[0-5]\\b|\\b[1-3]?\\"+
                "d{8}\\d?\\b)|((2[0-5][0-5]|1\\d{2}|[1-9]\\d?)|(0([xX])[0-9a-fA-F]{2})|(0[0-7]{3}))"+
                "(\\.((2[0-5][0-5]|1\\d{2}|\\d\\d?)|(0([xX])[0-9a-fA-F]{2})|(0[0-7]{3}))){3})$";
//Задание 3
    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public pr28(){
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    public boolean validate(final String ip){
        matcher = pattern.matcher(ip);
        return matcher.matches();
    }
    private static boolean check(String s) {
        return 0 == s.chars()
                .mapToObj(Character::toString)
                .filter("()"::contains)
                .map("("::equals)
                .mapToInt(b -> b ? 1 : -1)
                .reduce(0, (x, y) -> (x >= 0 && x + y >= 0) ? x + y : -1);
    }
    public static void main(String[] args) {
        pr28 pr = new pr28();
        System.out.println(pr.validate("299.201.100.50"));
        System.out.println(pr.validate("254.201.100.50"));
        System.out.println(check("192+(50-20)*(5-10)"));
        System.out.println(check("192+(50-20)*(((5)))"));
        System.out.println(check("192+(50-20)*5("));
    }
}
