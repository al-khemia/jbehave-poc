package com.jbehavepoc.utils;

        import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by linfante on 2/8/2017.
 */
public class UtilsSteps {
    public static String randomUser() {
        return RandomStringUtils.randomAlphabetic(8);
    }

}
