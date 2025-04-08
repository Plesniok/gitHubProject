package com.dlesniok.githubproject.models.api;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESULT_OK = "OK";
    public static final String RESULT_BAD_REQUEST = "BAD REQUEST";
    public static final String RESULT_INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";
    public static final String RESULT_CONFLICT = "CONFLICT";
    public static final String RESULT_NOT_FOUND = "NOT FOUND";

    public static final String GIT_HUB_PROJECT
 = "GITHUB_PROJECT-";

    final public static Map<String, String> getProductsResponsesHashMap() {
        return Stream.of(
                Map.entry(GIT_HUB_PROJECT + "1", "Success"),
                Map.entry(GIT_HUB_PROJECT + "2", "Success"),
                Map.entry(GIT_HUB_PROJECT + "3", "Category does not exist"),
                Map.entry(GIT_HUB_PROJECT + "4", "Error during github connection"),
                Map.entry(GIT_HUB_PROJECT + "5", "User not found"),
                Map.entry(GIT_HUB_PROJECT + "6", "Internal server error")

        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}