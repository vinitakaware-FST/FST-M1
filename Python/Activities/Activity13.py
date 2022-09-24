"""Adding List Numbers
Write a function sum() such that it can accept a list of elements and print the sum of all elements"""
def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

numList = [20, 40, 60]
result = calculate_sum(numList)
print("The sum of all elements: " + str(result))