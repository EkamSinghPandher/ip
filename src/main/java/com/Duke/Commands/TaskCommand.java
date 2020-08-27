package com.Duke.Commands;

import com.Duke.TaskManager.DukeException;
import com.Duke.TaskManager.TaskList;
import com.Duke.TaskManager.UI;
import com.Duke.Tasks.Task;

public class TaskCommand extends Command{
    private final TaskList ls;
    private final String task;

    public TaskCommand(TaskList ls, String task) {
        this.ls = ls;
        this.task = task;
    }

    @Override
    public void execute() {
        try {
            Task task = new Task(this.task, false);
            UI.taskCalled(ls,task);
        }catch(DukeException e){
            UI.printError(e.toString());
        }
    }
}