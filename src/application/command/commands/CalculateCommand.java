package application.command.commands;

import application.model.ArithmeticCalculator;
import application.command.Command;
import application.util.Inputs;

//this class extends the abstract Command class and used to evaluate arithmetic expressions entered by the user
public class CalculateCommand extends Command {

    public CalculateCommand() {
        super("Arithmetic Expression Evaluation");
    }

    @Override
    public void execute() {
        String expression = Inputs.getExpressionInput();
        try {
            double result = ArithmeticCalculator.evaluate(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
