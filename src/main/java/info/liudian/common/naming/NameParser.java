package info.liudian.common.naming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface NameParser {
    List<String> parse(String name);
}

//CAMEL_CASE
class CamelCaseParser implements NameParser {
    private final Pattern LOWERCASE_REGEX = Pattern.compile("[a-z][a-z0-9]*");
    private final Pattern TITLE_REGEX = Pattern.compile("[A-Z][a-z0-9]*");

    @Override
    public List<String> parse(String name) {
        List<String> result = new ArrayList<>();
        Matcher m = LOWERCASE_REGEX.matcher(name);
        if (!m.find()) throw new IllegalStateException();
        result.add(name.substring(m.start(0), m.end(0)));
        name = name.substring(m.end());
        m = TITLE_REGEX.matcher(name);
        while (m.find()) {
            result.add(name.substring(m.start(0), m.end(0)));
        }

        return result;
    }
}

//PASCAL_CASE
class PascalCaseParser implements NameParser {
    private final Pattern TITLE_REGEX = Pattern.compile("[A-Z][a-z0-9]*");

    @Override
    public List<String> parse(String name) {
        List<String> result = new ArrayList<>();
        Matcher m = TITLE_REGEX.matcher(name);
        while (m.find()) {
            result.add(name.substring(m.start(), m.end()));
        }

        return result;
    }
}

//LOWERCASE_UNDERSCORE
class LowercaseUnderscoreParser implements NameParser {
    @Override
    public List<String> parse(String name) {
        return Arrays.asList(name.split("_"));
    }
}

//LOWERCASE_HYPHEN
class LowercaseHyphenParser implements NameParser {
    @Override
    public List<String> parse(String name) {
        return Arrays.asList(name.split("-"));
    }
}

//UPPERCASE_UNDERSCORE
class UppercaseUnderscoreParser implements NameParser {
    @Override
    public List<String> parse(String name) {
        return Arrays.asList(name.split("_"));
    }
}
