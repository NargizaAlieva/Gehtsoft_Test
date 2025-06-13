package application.command.commands;

import application.model.CaesarCipher;
import application.command.Command;
import application.util.Inputs;

//this class extends the abstract Command class and used to for Caesar cipher decryption functionality
public class DecryptCommand extends Command {

    public DecryptCommand() {
        super("Caesar Cipher Decryption");
    }

    @Override
    public void execute() {
        String text = Inputs.getInput();
        int shift = Inputs.getShiftValue();
        if (shift == 0) {
            CaesarCipher.autoDecrypt(text);
        } else {
            String result = CaesarCipher.decrypt(text, shift);
            System.out.println("\nResult: " + result);
        }
    }
}
