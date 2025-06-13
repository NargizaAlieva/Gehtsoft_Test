package application.command.commands;

import application.model.CaesarCipher;
import application.command.Command;
import application.util.Inputs;

//this class extends the abstract Command class and used to for Caesar cipher encryption functionality
public class EncryptCommand extends Command {

    public EncryptCommand() {
        super("Caesar Cipher Encryption");
    }

    @Override
    public void execute() {
        String text = Inputs.getInput();
        int shift = Inputs.getShiftValue();
        String result = CaesarCipher.encrypt(text, shift);
        System.out.println("\nResult: " + result);
    }
}
