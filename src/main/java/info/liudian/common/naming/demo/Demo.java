package info.liudian.common.naming.demo;

import info.liudian.common.naming.Convention;
import static java.lang.System.out;

public class Demo {
    public static void main(String[] args) {
        String[] demos = {
                "demoName",
                "demo-name",
                "DemoName",
                "demo_name",
                "DEMO_NAME"
        };

        for (String demo : demos) {

            out.printf("%-21s %-9s -> %-9s\n", Convention.CAMEL_CASE + ":", demo, Convention.CAMEL_CASE.format(demo));
            out.printf("%-21s %-9s -> %-9s\n", Convention.PASCAL_CASE + ":", demo, Convention.PASCAL_CASE.format(demo));
            out.printf("%-21s %-9s -> %-9s\n", Convention.LOWERCASE_HYPHEN + ":", demo, Convention.LOWERCASE_HYPHEN.format(demo));
            out.printf("%-21s %-9s -> %-9s\n", Convention.LOWERCASE_UNDERSCORE + ":", demo, Convention.LOWERCASE_UNDERSCORE.format(demo));
            out.printf("%-21s %-9s -> %-9s\n", Convention.UPPERCASE_UNDERSCORE + ":", demo, Convention.UPPERCASE_UNDERSCORE.format(demo));
            out.printf("\n");
        }
        String property = "propertyName";
        out.printf("%-21s %-9s -> %-9s\n", "prefix:", property, Convention.CAMEL_CASE.format(property, "set"));

    }
}
