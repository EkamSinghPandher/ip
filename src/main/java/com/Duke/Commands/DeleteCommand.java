package com.Duke.Commands;

import com.Duke.TaskManager.DukeException;
import com.Duke.TaskManager.TaskList;
import com.Duke.TaskManager.UI;

public class DeleteCommand extends Command{
    private final TaskList ls;
    private final int taskIndex;

    public DeleteCommand(TaskList ls, int taskIndex) {
        this.ls = ls;
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute() {
        try{
            return UI.deleteCalled(ls, taskIndex);
        }catch(DukeException e){
            return UI.printError(e.toString());
        }
    }
}
