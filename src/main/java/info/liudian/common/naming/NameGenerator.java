package info.liudian.common.naming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface NameGenerator {
    String generate(List<String> nameComponents);
}

class CamelCaseGenerator implements NameGenerator {
    @Override
    public String generate(List<String> nameComponents) {
        boolean firstLetter = true;
        List<String> temp = new ArrayList<>(nameComponents.size());
        for (String comps : nameComponents) {
            if (firstLetter) {
                firstLetter = false;
                temp.add(comps.toLowerCase());
            } else {
                char[] chars = comps.toLowerCase().toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                temp.add(new String(chars));
            }
        }
        return temp.stream().collect(Collectors.joining(""));
    }
}

class PascalCaseGenerator implements NameGenerator {
    @Override
    public String generate(List<String> nameComponents) {
        List<String> temp = new ArrayList<>(nameComponents.size());
        for (String comps : nameComponents) {
            char[] chars = comps.toLowerCase().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            temp.add(new String(chars));
        }
        return temp.stream().collect(Collectors.joining(""));
    }
}

class LowercaseHyphenGenerator implements NameGenerator {
    @Override
    public String generate(List<String> nameComponents) {
        return nameComponents.stream().map(String::toLowerCase).collect(Collectors.joining("-"));
    }
}

class LowercaseUnderscoreGenerator implements NameGenerator {
    @Override
    public String generate(List<String> nameComponents) {
        return nameComponents.stream().map(String::toLowerCase).collect(Collectors.joining("_"));
    }
}

class UppercaseUnderscoreGenerator implements NameGenerator {
    @Override
    public String generate(List<String> nameComponents) {
        return nameComponents.stream().map(String::toUpperCase).collect(Collectors.joining("_"));
    }
}
