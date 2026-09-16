while True:
    x = float(input("Enter value of x: "))
    y = float(input("Enter value of y: "))

    result = 0.0

    print("\nVariable values:")
    print("x =", x)
    print("y =", y)
    print("result =", result)

    print("\nArithmetic Operation:")

    result = x + y
    print("Addition: x + y =", result)

    result = x - y
    print("Subtraction: x - y =", result)

    result = x * y
    print("Multiplication: x * y =", result)

    result = x / y
    print("Division: x / y =", result)

    result = x % y
    print("Modulus: x % y =", result)

    x += 1
    result = x
    print("Increment: x++ =", result)

    result = x - 2
    print("Decrement: x-- =", result)

    choice = input("Do you want to continue : YES / NO: ")
    if choice.lower() != "yes":
        break