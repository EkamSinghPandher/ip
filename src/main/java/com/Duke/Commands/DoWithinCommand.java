package com.Duke.Commands;

import com.Duke.TaskManager.TaskList;
import com.Duke.TaskManager.UI;
import com.Duke.Tasks.DoWithin;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DoWithinCommand extends Command{
    private final String[] splitList;
    private final TaskList taskList;

    public DoWithinCommand(String[] splitList, TaskList taskList) {
        this.splitList = splitList;
        this.taskList = taskList;
    }

    /**
     * Simulates Duke executing the Deadline Command
     * @return The response to the command "deadline"
     */
    public String execute() {
        try {
            String[] splitList2 = splitList[1].split("/within ", 2);
            String[] splitList3 = splitList2[1].split(":", 2);
            if(LocalDate.parse(splitList3[0].trim()).isBefore(LocalDate.parse(splitList3[1].trim()))) {
                DoWithin doWithin = new DoWithin(splitList2[0], LocalDate.parse(splitList3[0].trim()), LocalDate.parse(splitList3[1].trim()), false);
                return UI.doWithinCalled(taskList, doWithin);
            }else{
                return UI.printError("\u2639 OOPS!!! It appears the start date is after the end date");
            }
        } catch (DateTimeParseException e) {
            return UI.printError("\u2639 OOPS!!! The do within is not of the proper format, make sure you enter the start or end date as YYYY-MM-dd");
        } catch (Exception e) {
            return UI.printError("\u2639 OOPS!!! The description is empty or you have not entered a proper do within period.");
        }
    }
}
