package application;

import application.command.CommandHandler;
import application.util.Inputs;

public class Application {
    private final CommandHandler commandHandler;

    public Application() {
        this.commandHandler = new CommandHandler();
    }

    public void run() {
        System.out.println("Welcome to Gehtsoft Technical Assessment");

        while (true) {
            commandHandler.getListOfCommands();
            int choice = Inputs.getUserChoice();
            commandHandler.commandsExecuted(choice);
        }
    }
}
