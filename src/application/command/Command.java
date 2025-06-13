package application.command;

//This is an abstract base class for defining executable commands
public abstract class Command {
    private final String commandName;

    public Command(String commandName) {
        this.commandName = commandName;
    }

    public abstract void execute();

    public String getCommandName() {
        return this.commandName;
    }
}
