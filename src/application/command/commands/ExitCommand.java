package application.command.commands;

import application.command.Command;
import application.util.Inputs;

//this class extends the abstract Command class and used to terminate the application
public class ExitCommand extends Command {
    public ExitCommand() {
        super("Exit");
    }

    @Override
    public void execute() {
        Inputs.closeScanner();
        System.out.println("Good bye!");
        System.exit(1);
    }
}
