package application.command;

import application.command.commands.*;
import application.util.Design;
import application.util.Inputs;

import java.util.HashMap;
import java.util.Map;

//the CommandHandler class acts as the central controller for registering and executing user commands
public class CommandHandler {
    private final Map<Integer, Command> commands;
    private final Command listOfCommands;

    public CommandHandler() {
        this.commands = new HashMap<>();
        init();
        listOfCommands = new AllCommands(this.commands);
    }

    //registers the commands with corresponding keys
    private void init() {
        commands.put(1, new EncryptCommand());
        commands.put(2, new DecryptCommand());
        commands.put(3, new CalculateCommand());
        commands.put(4, new ExitCommand());
    }

    //executes the command tied to the provided choice, wraps execution with design lines, and checks whether the user wants to continue
    public void commandsExecuted(int userChose) {
        try {
            Design.dividingLinesUpper(commands.get(userChose).getCommandName());
            commands.get(userChose).execute();
            Design.dividingLinesLower(commands.get(userChose).getCommandName());

            if (!Inputs.askToContinue())
                commands.get(4).execute();
        } catch (Exception e) {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    //invokes the command to print all available commands
    public void getListOfCommands() {
        listOfCommands.execute();
    }
}
