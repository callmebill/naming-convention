package info.liudian.common.naming.demo;

import info.liudian.common.naming.Convention;

public class Demo {
    public static void main(String[] args) {
        String[] demos = {"camelCase", "PascalCase", "lowercase-hyphen", "lowercase_underscore", "UPPERCASE_UNDERSCORE"};

        for (Convention convention : Convention.values()) {
            System.out.println(convention + ":");
            for (String demo : demos) {
                System.out.println(demo + " -> " + convention.format(demo));
            }
            System.out.println();
        }
        for (String demo : demos) {
            System.out.println(demo + " <getter> " + Convention.CAMEL_CASE.format(demo, "get"));
            System.out.println(demo + " <setter> " + Convention.CAMEL_CASE.format(demo, "set"));
        }

    }
}
