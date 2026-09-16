while True:
    java_score = float(input("Enter your Java Score: "))
    c_score = float(input("Enter your C Score: "))
    database_score = float(input("Enter your Database Handling score: "))

    average = (java_score + c_score + database_score) / 3

    if 90 <= average <= 100:
        grade = "A"
    elif average >= 80:
        grade = "B"
    elif average >= 75:
        grade = "C"
    else:
        grade = "F"

    print("Output:")
    print(grade)
    print(f"Explanation:\nThe average of the student is {average:.3f}, so the student's grade is {grade}.")

    choice = input("Do you want to continue : YES / NO: ")
    if choice.upper() != "YES":
        break