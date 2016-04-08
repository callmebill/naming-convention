#A Naming Convention Formatter for Java
##Run Demo([mainClass](src/main/java/info/liudian/common/naming/demo/Demo.java "Demo.java").)
    >mvn package
    >java -jar target/naming-convention-1.1.jar
    CAMEL_CASE:
    camelCase -> camelCase
    PascalCase -> pascalCase
    lowercase-hyphen -> lowercaseHyphen
    lowercase_underscore -> lowercaseUnderscore
    UPPERCASE_UNDERSCORE -> uppercaseUnderscore

    PASCAL_CASE:
    camelCase -> CamelCase
    PascalCase -> PascalCase
    lowercase-hyphen -> LowercaseHyphen
    lowercase_underscore -> LowercaseUnderscore
    UPPERCASE_UNDERSCORE -> UppercaseUnderscore

    LOWERCASE_UNDERSCORE:
    camelCase -> camel_case
    PascalCase -> pascal_case
    lowercase-hyphen -> lowercase_hyphen
    lowercase_underscore -> lowercase_underscore
    UPPERCASE_UNDERSCORE -> uppercase_underscore

    LOWERCASE_HYPHEN:
    camelCase -> camel-case
    PascalCase -> pascal-case
    lowercase-hyphen -> lowercase-hyphen
    lowercase_underscore -> lowercase-underscore
    UPPERCASE_UNDERSCORE -> uppercase-underscore

    UPPERCASE_UNDERSCORE:
    camelCase -> CAMEL_CASE
    PascalCase -> PASCAL_CASE
    lowercase-hyphen -> LOWERCASE_HYPHEN
    lowercase_underscore -> LOWERCASE_UNDERSCORE
    UPPERCASE_UNDERSCORE -> UPPERCASE_UNDERSCORE

    camelCase <getter> getCamelCase
    camelCase <setter> setCamelCase
    PascalCase <getter> getPascalCase
    PascalCase <setter> setPascalCase
    lowercase-hyphen <getter> getLowercaseHyphen
    lowercase-hyphen <setter> setLowercaseHyphen
    lowercase_underscore <getter> getLowercaseUnderscore
    lowercase_underscore <setter> setLowercaseUnderscore
    UPPERCASE_UNDERSCORE <getter> getUppercaseUnderscore
    UPPERCASE_UNDERSCORE <setter> setUppercaseUnderscore
