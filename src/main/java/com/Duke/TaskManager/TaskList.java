package com.Duke.TaskManager;

import com.Duke.Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    public final List<Task> ls;

    public TaskList(List<Task> ls) {
        this.ls = ls;
    }

    public int length(){
        return ls.size();
    }

    public void setDone(int task) throws DukeException {
        assert task > 0 : "Invalid task entered";
        if(task>ls.size()){
            throw new DukeException("You don't have that many tasks");
        }else {
            ls.set(task, ls.get(task).done());
        }
    }

    public TaskList findTask(String hint) {
        TaskList containsHint = new TaskList(new ArrayList<>());
        for(Task task: ls) {
            if(task.getTask().contains(hint)) {
                containsHint.add(task);
            }
        }
        return containsHint;
    }

    public List<Task> getListOfTasks() {
        return this.ls;
    }

    public String delete(int task) throws DukeException {
        if(task>ls.size()) {
            throw new DukeException("You don't have that many tasks");
        }else{
            System.out.println("     Noted. I've removed this task: ");
            System.out.println("       " + ls.get(task-1).toString());
            String deleted = ls.get(task-1).toString();
            ls.remove(task-1);
            return "Noted. I've removed this task: \n"+deleted;
        }
    }

    public void add(Task task) {
        ls.add(task);
    }


}
