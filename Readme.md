# Mail Service

A simple spring boot application to send email using

1. gmail smtp
2. amazon ses

## Execution Steps

By default, the application will run the gmail profile. If you want to run ses profile specify it as vm argument.

### Run in cli

```
mvn spring-boot:run -Dspring-boot.run.profiles=<gmail or ses>
```

### Run in intellij

```
Run -> Run -> Edit Configurations -> + application 
-> enter some name in name field and enter `com.javachip.demo.mail.MailApplication` in Main class field.
-> enter `spring-boot.run.profiles=<gmail or ses>` in vm arguments
```

