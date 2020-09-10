package com.Duke.Commands;

import com.Duke.TaskManager.DukeException;
import com.Duke.TaskManager.TaskList;
import com.Duke.TaskManager.UI;

public class FindCommand extends Command{
    private final TaskList ls;
    private final String hint;

    public FindCommand(TaskList ls, String hint) {
        this.ls = ls;
        this.hint = hint;
    }

    @Override
    public String execute() {
        try {
            return UI.findCalled(ls, hint);
        }catch (DukeException e){
            return UI.printError(e.toString());
        }
    }
}