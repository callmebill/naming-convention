#A Naming Convention Formatter for Java
##Run Demo ([mainClass](src/main/java/info/liudian/common/naming/demo/Demo.java "Demo.java"))
    >mvn package
    >java -jar target/naming-convention-1.1.jar

    CAMEL_CASE:           demoName  -> demoName
    PASCAL_CASE:          demoName  -> DemoName
    LOWERCASE_HYPHEN:     demoName  -> demo-name
    LOWERCASE_UNDERSCORE: demoName  -> demo_name
    UPPERCASE_UNDERSCORE: demoName  -> DEMO_NAME

    CAMEL_CASE:           demo-name -> demoName
    PASCAL_CASE:          demo-name -> DemoName
    LOWERCASE_HYPHEN:     demo-name -> demo-name
    LOWERCASE_UNDERSCORE: demo-name -> demo_name
    UPPERCASE_UNDERSCORE: demo-name -> DEMO_NAME

    CAMEL_CASE:           DemoName  -> demoName
    PASCAL_CASE:          DemoName  -> DemoName
    LOWERCASE_HYPHEN:     DemoName  -> demo-name
    LOWERCASE_UNDERSCORE: DemoName  -> demo_name
    UPPERCASE_UNDERSCORE: DemoName  -> DEMO_NAME

    CAMEL_CASE:           demo_name -> demoName
    PASCAL_CASE:          demo_name -> DemoName
    LOWERCASE_HYPHEN:     demo_name -> demo-name
    LOWERCASE_UNDERSCORE: demo_name -> demo_name
    UPPERCASE_UNDERSCORE: demo_name -> DEMO_NAME

    CAMEL_CASE:           DEMO_NAME -> demoName
    PASCAL_CASE:          DEMO_NAME -> DemoName
    LOWERCASE_HYPHEN:     DEMO_NAME -> demo-name
    LOWERCASE_UNDERSCORE: DEMO_NAME -> demo_name
    UPPERCASE_UNDERSCORE: DEMO_NAME -> DEMO_NAME

    prefix:               propertyName -> setPropertyName

