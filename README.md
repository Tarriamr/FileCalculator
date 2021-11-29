# FileCalculator
 
    Write a program that returns the result obtained from the instruction set. Instructions consist of a word
    key and number separated by a space. Instructions are separated by a newline. Instruction set to be downloaded
    is from a file and the result of the calculation should be written to the screen. The file can contain any number of statements.
    The instructions can be any operation that takes two arguments (e.g., add, subtract, multiply, divide, etc.).
    Instructions should be interpreted in the order they were introduced (the order of operations in math should be ignored).
    The last statement should be apply and a number. For example apply 3. This number should be used in creation
    calculator instance. Then FileCalculator should perform all previously given operations sequentially.


    entry:
    add 2
    multiply 3
    apply 10
    output: 36
    explanation: ((10 + 2) * 3) = 36

    entry:
    multiply 3
    add 2
    apply 10
    output: 32
    explanation: ((10 * 3) + 2) = 32

    entry:
    apply 1
    output: 1
