
try:
    num = int(input("Enter a multiple of 5 between 1 and 100: "))

    
    if 1 <= num <= 100 and num % 5 == 0:
        print(f"Valid! {num} is a multiple of 5 within the range.")
    else:
        print(f"Invalid entry. {num} is not a multiple of 5 between 1 and 100.")

except ValueError:
    print("Invalid input. Please enter a whole number.")