package info.liudian.common.naming.demo;

import info.liudian.common.naming.Convention;
import static java.lang.System.out;

public class Demo {
    public static void main(String[] args) {
        String[] demos = {
                "demoName",
                "DemoName",
                "demo-name",
                "demo_name",
                "DEMO_NAME"
        };

        for (String demo : demos) {

            out.print(Convention.CAMEL_CASE + ":\t\t");
            out.println(demo + " -> " + Convention.CAMEL_CASE.format(demo));
            out.println();
            out.print(Convention.PASCAL_CASE + ":\t\t");
            out.println(demo + " -> " + Convention.PASCAL_CASE.format(demo));
            out.println();
            out.print(Convention.LOWERCASE_HYPHEN + ":\t\t");
            out.println(demo + " -> " + Convention.LOWERCASE_HYPHEN.format(demo));
            out.println();
            out.print(Convention.LOWERCASE_UNDERSCORE + ":\t\t");
            out.println(demo + " -> " + Convention.LOWERCASE_UNDERSCORE.format(demo));
            out.println();
            out.print(Convention.UPPERCASE_UNDERSCORE + ":\t\t");
            out.println(demo + " -> " + Convention.UPPERCASE_UNDERSCORE.format(demo));
            out.println();
        }
        String property = "propertyName";
        out.print("Prefix" + ":\t\t");
        out.println(property + " -> " + Convention.CAMEL_CASE.format(property, "set"));

    }
}
