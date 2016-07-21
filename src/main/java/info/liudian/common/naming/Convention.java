package info.liudian.common.naming;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum Convention {
    CAMEL_CASE,
    PASCAL_CASE,
    LOWERCASE_UNDERSCORE,
    LOWERCASE_HYPHEN,
    UPPERCASE_UNDERSCORE;

    static Map<Convention, Pattern> conventionPatternMap = new EnumMap<>(Convention.class);
    static Map<Convention, NameParser> conventionNameParserMap = new EnumMap<>(Convention.class);
    static Map<Convention, NameGenerator> conventionNameGeneratorMap = new EnumMap<>(Convention.class);

    static {
        String lower = "[a-z][a-z0-9]*";
        String upper = "[A-Z][A-Z0-9]*";
        String title = "[A-Z][a-z0-9]*";

        conventionPatternMap.put(Convention.CAMEL_CASE, Pattern.compile(String.format("^%s(%s)*$", lower, title)));
        conventionPatternMap.put(Convention.PASCAL_CASE, Pattern.compile(String.format("^(%s)+$", title)));
        conventionPatternMap.put(Convention.LOWERCASE_HYPHEN, Pattern.compile(String.format("^%s(-%s)*$", lower, lower)));
        conventionPatternMap.put(Convention.LOWERCASE_UNDERSCORE, Pattern.compile(String.format("^%s(_%s)*$", lower, lower)));
        conventionPatternMap.put(Convention.UPPERCASE_UNDERSCORE, Pattern.compile(String.format("^%s(_%s)*$", upper, upper)));
    }

    static {
        conventionNameParserMap.put(Convention.CAMEL_CASE, new CamelCaseParser());
        conventionNameParserMap.put(Convention.PASCAL_CASE, new PascalCaseParser());
        conventionNameParserMap.put(Convention.LOWERCASE_HYPHEN, new LowercaseHyphenParser());
        conventionNameParserMap.put(Convention.LOWERCASE_UNDERSCORE, new LowercaseUnderscoreParser());
        conventionNameParserMap.put(Convention.UPPERCASE_UNDERSCORE, new UppercaseUnderscoreParser());
    }

    static {
        conventionNameGeneratorMap.put(Convention.CAMEL_CASE, new CamelCaseGenerator());
        conventionNameGeneratorMap.put(Convention.PASCAL_CASE, new PascalCaseGenerator());
        conventionNameGeneratorMap.put(Convention.LOWERCASE_HYPHEN, new LowercaseHyphenGenerator());
        conventionNameGeneratorMap.put(Convention.LOWERCASE_UNDERSCORE, new LowercaseUnderscoreGenerator());
        conventionNameGeneratorMap.put(Convention.UPPERCASE_UNDERSCORE, new UppercaseUnderscoreGenerator());

    }

    public static List<String> parse(String name) {
        for (Map.Entry<Convention, Pattern> entry : conventionPatternMap.entrySet())
            if (entry.getValue().matcher(name).matches())
                return conventionNameParserMap.get(entry.getKey()).parse(name);
        throw new IllegalArgumentException("not a clear info: " + name);
    }

    public static String normalize(String name) {
        return parse(name).stream().map(String::toLowerCase).collect(Collectors.joining());
    }

    public String format(String name) {
        return conventionNameGeneratorMap.get(this).generate(parse(name));
    }

    public String format(String name, String prefix) {
        List<String> comps = parse(name);
        List<String> withPrefix = new ArrayList<>(comps.size() + 1);
        withPrefix.add(prefix);
        withPrefix.addAll(comps);
        return conventionNameGeneratorMap.get(this).generate(withPrefix);
    }

    public String format(List<String> nameComponents) {
        return conventionNameGeneratorMap.get(this).generate(nameComponents);
    }
}
