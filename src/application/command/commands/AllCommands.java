package application.command.commands;

import application.command.Command;
import java.util.Map;

//this class extends the abstract Command class and is responsible for
//displaying a list of all available command options in a numbered format
public class AllCommands extends Command {
    private final Map<Integer, Command> commands;

    public AllCommands(Map<Integer, Command> commands) {
        super("All Commands");
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("\nPlease choose an option: ");
        for (int i = 1; i <= this.commands.size(); i++) {
            System.out.println(i + ": " + commands.get(i).getCommandName());
        }
        System.out.print("\nEnter your choice: ");
    }
}
