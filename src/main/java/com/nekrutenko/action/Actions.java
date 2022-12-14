package com.nekrutenko.action;

import lombok.Getter;

import java.io.IOException;

@Getter
public enum Actions {
    CREATE("Create cars", new CreateAction()),
    SHOW_ALL("Show all cars", new ShowAllAction()),
    EXIT("Finish program", new ExitAction());

    private String name;
    private Action action;

    Actions(String name, Action action) {
        this.name = name;
        this.action = action;
    }
    public void execute()  {
        action.execute();
    }
}
