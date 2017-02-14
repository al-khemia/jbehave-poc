package com.jbehavepoc.utils;

        import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by linfante on 2/8/2017.
 */
public class RegistrationUtils {
    public static String randomUser() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String getHobbySelector(String hobby){

        if (hobby.equals("dancing")){
            return "(//input[@name='checkbox_5[]'])[1]";
        }else if (hobby.equals("reading")){
            return "(//input[@name='checkbox_5[]'])[2]";
        }else if (hobby.equals("cricket")){
            return "(//input[@name='checkbox_5[]'])[3]";
        }else {
            return "";
        }
    }

}
