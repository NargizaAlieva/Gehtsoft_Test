# Gehtsoft Entrance Test Assignment

## Project Description

This Java console application is developed as a solution to the Gehtsoft Training Program Entrance Test. It includes two main functionalities:

1. **Caesar Cipher**  
   Encrypts and decrypts text using the Caesar cipher algorithm. It supports both English (Latin) and Russian (Cyrillic) alphabets, preserves letter casing, handles both positive and negative shifts, and leaves non-alphabet characters unchanged.

2. **Arithmetic Expression Evaluator**  
   Parses and evaluates arithmetic expressions with support for operator precedence (PEMDAS/BODMAS), parentheses, decimals, and negative numbers.

## How to Compile and Run

### Requirements
- Java 8 or higher
- Terminal/Command Prompt

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/gehtsoft-entrance-test.git
   cd gehtsoft-entrance-test

2. Compile the program:

   ```bash
   javac -d out src/application/Main.java
   ```

3. Run the application:

   ```bash
   java -cp out application.Main
   ```

---

## Application Menu

```
Welcome to Gehtsoft Technical Assessment
Please choose an option:
1. Caesar Cipher Encryption
2. Caesar Cipher Decryption
3. Arithmetic Expression Evaluation
4. Exit

Enter your choice:
```

---

## Usage Examples

### Caesar Cipher

#### English Encryption

```
Input: Hello World
Shift: 3
Output: Khoor Zruog
```

#### Russian Encryption

```
Input: Привет Мир
Shift: 5
Output: Хумёзй Рну
```

#### English Decryption

```
Input: Khoor Zruog
Shift: 3
Output: Hello World
```

---

### Arithmetic Expression Evaluation

#### Example 1

```
Input: 2 + 3 * 4
Output: 14
```

#### Example 2

```
Input: (10 + 5) / 3
Output: 5
```

#### Example 3

```
Input: -5 + 3
Output: -2
```

---

## Project Structure

```
src/
├── Main.java // Entry point of the application
├── command/
│ ├── Command.java // Interface for all commands
│ ├── CommandHandler.java // Manages and executes commands
│ └── commands/
│ ├── EncryptCommand.java // Handles Caesar cipher encryption
│ ├── DecryptCommand.java // Handles Caesar cipher decryption
│ ├── ArithmeticCalculator.java // Expression evaluator logic
│ ├── AllCommands.java // Displays all available commands
│ └── ExitCommand.java // Exits the application
├── model/
│ ├── CaesarCipher.java // Caesar cipher logic
│ └── ArithmeticCalculator.java // Arithmetic expression evaluator
├── application/
│ └── Application.java // Core logic for console interaction
```

---

## Approach and Assumptions

* Caesar Cipher:

  * Handles both English and Russian alphabets.
  * Maintains case sensitivity.
  * Ignores non-alphabetic characters.
  * Properly handles wrap-around and negative shifts.

* Arithmetic Expression Evaluator:

  * Implements operator precedence using stacks.
  * Supports nested parentheses and decimals.
  * Validates expressions and throws descriptive errors for invalid input.

---

## Contact

**Name**: Alieva Nargiza
**Email**: \[[nargizaalieva46@gmail.com](mailto:nargizaalieva46@gmail.com)]
**GitHub**: [https://github.com/NargizaAlieva](https://github.com/NargizaAlieva)
