package com.jbehavepoc.utils;

import java.util.HashMap;

/**
 * Created by linfante on 2/20/2017.
 */
public class InteractionUtils {

    private static HashMap<String, String> productMap = new HashMap<String, String>();
    private static HashMap<String, String> categoryMap = new HashMap<String, String>();

    public InteractionUtils() {
        productMap.put("Lolcat Shirt","//div[@id='ui-id-7']/ul/li");
        productMap.put("Cheezeburger Shirt","//div[@id='ui-id-7']/ul/li[2]");
        productMap.put("Buckit Shirt","//div[@id='ui-id-7']/ul/li[3]");
        productMap.put("Zebra Striped","//div[@id='ui-id-9']/ul/li");
        productMap.put("Black Leather","//div[@id='ui-id-9']/ul/li[2]");
        productMap.put("Alligator Leather","//div[@id='ui-id-9']/ul/li[3]");
        productMap.put("iPhone","//div[@id='ui-id-11']/ul/li");
        productMap.put("iPod","//div[@id='ui-id-11']/ul/li[2]");
        productMap.put("iPad","//div[@id='ui-id-11']/ul/li[3]");

        categoryMap.put("Lolcat Shirt","T-Shirts");
        categoryMap.put("Cheezeburger Shirt","T-Shirts");
        categoryMap.put("Buckit Shirt","T-Shirts");
        categoryMap.put("Zebra Striped","Bags");
        categoryMap.put("Black Leather","Bags");
        categoryMap.put("Alligator Leather","Bags");
        categoryMap.put("iPhone","Gadgets");
        categoryMap.put("iPod","Gadgets");
        categoryMap.put("iPad","Gadgets");
    }

    public static String getProductSelector(String productName) {
        return productMap.get(productName);
    }

    public static String getCategoryName(String productName) {
        return categoryMap.get(productName);
    }
}
