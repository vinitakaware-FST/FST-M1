"""Given a list of numbers, return True if first and last number of a list is same.
Bonus points if you can make the user enter their own list."""

numbersList = list(input("Enter a sequence of number with space: ").split(" "))
print("Check if first and last element are equal from list:", numbersList)

# Get first element in list
firstElement = numbersList[0]
# Get last element in list
lastElement = numbersList[-1]

if (firstElement == lastElement):
    print(True)
else:
    print(False)
