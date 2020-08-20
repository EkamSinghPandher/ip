import java.util.Scanner;

public class DukeBot{
    //This class handles the simulation of the Duke chat bot
    public static void simulate(){
        TaskList ls= new TaskList();
        boolean hasBye = false;
        String input;
        String[] splitList;

        String line = "     ___________________________________________________________________";
        String introText1 = "     Hello! I'm Duke";
        String introText2 = "     What can I do for you?";

        System.out.println(line);
        System.out.println(introText1);
        System.out.println(introText2);
        System.out.println(line);

        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();


        while(!hasBye){
            splitList = input.split(" ", 2);
            System.out.println(line);
            if(input.equals("bye")){
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println(line);
                hasBye = true;
            }else if(input.equals("list")){
                try {
                    ls.printTask();
                }catch(DukeException e){
                    System.out.println(e.toString());
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else if(splitList[0].equals("done")){
                try{
                    ls.setDone(Integer.parseInt(splitList[1]) - 1);
                }catch (DukeException e){
                    System.out.println(e.toString());
                }catch(Exception e){
                    System.out.println("     ☹ OOPS!!! There arent that many tasks in your list");
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else if(splitList[0].equals("todo")){
                try {
                    ToDo todo = new ToDo(splitList[1], false);
                    System.out.println("     Got it I've now added this Task:");
                    System.out.println("       " + todo.toString());
                    ls.add(todo);
                    System.out.println("     Now you have " + ls.length() + " tasks in the list.");
                }catch (Exception e){
                    System.out.println("     \u2639 OOPS!!! The description of a todo cannot be empty.");
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else if(splitList[0].equals("deadline")){
                try {
                    String[] splitList2 = splitList[1].split("/by", 2);
                    Deadline deadline = new Deadline(splitList2[0], splitList2[1], false);
                    System.out.println("     Got it I've now added this Task:");
                    System.out.println("       " + deadline.toString());
                    ls.add(deadline);
                    System.out.println("     Now you have " + ls.length() + " tasks in the list.");
                } catch (Exception e){
                    System.out.println("     \u2639 OOPS!!! The description or the time to complete by of a deadline cannot be empty.");
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else if(splitList[0].equals("event")){
                try {
                    String[] splitList2 = splitList[1].split("/at", 2);
                    String[] splitList3 = splitList2[1].split("-", 2);
                    Event event = new Event(splitList2[0], splitList3[0], splitList3[1], false);
                    System.out.println("     Got it I've now added this Task:");
                    System.out.println("       " + event.toString());
                    ls.add(event);
                    System.out.println("     Now you have " + ls.length() + " tasks in the list.");
                }catch(Exception e){
                    System.out.println("     \u2639 OOPS!!! The description or the time duration of a event cannot be empty.");
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else if(input.equals("blah")){
                try{
                    Blah.blahCreated();
                }catch (DukeException e){
                    System.out.println(e.toString());
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }else{
                try {
                    Task task = new Task(input, false);
                    ls.add(task);
                    System.out.println("     added: " + input);
                }catch(DukeException e){
                    System.out.println(e.toString());
                }finally {
                    System.out.println(line);
                    input = sc.nextLine();
                }
            }
        }
    }
}
