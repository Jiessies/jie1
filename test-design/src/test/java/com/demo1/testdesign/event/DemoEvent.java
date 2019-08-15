package com.demo1.testdesign.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
