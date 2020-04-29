package dev.pinter;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named("helloWorld")
public class HelloWorld {
    private String message;

    @PostConstruct
    public void init() {
        message = Msg.get("helloWorld.message");
    }

    public String getMessage() {
        System.err.println(message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
