"""Tuple Number Checker
Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5
Bonus points if you can make the user enter their own tuple."""
num_tuple = tuple(int(x) for x in input("Enter a sequence of number with space: ").split(" "))
print("Given list is ", num_tuple)

print("Numbers which are divisible by 5 are:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)