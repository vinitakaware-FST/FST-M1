"""Combining Lists
Given a two list of numbers create a new list such that
new list should contain only odd numbers from the first list and even numbers from the second list"""
listOne = [15, 19, 30, 29, 32, 97]
listTwo = [10, 72, 13, 10]

print("First List:", listOne)
print("Second List:", listTwo)

thirdList = []
for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)
for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("Combined List is:",thirdList)
