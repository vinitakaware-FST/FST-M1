import pytest

# Additon test
def test_addition():

    # Initialize two numbers
    num1 = 40
    num2 = 35

    # Add them
    sum = num1 + num2

    # Assertion
    assert sum == 75

# Subtraction test
def test_subtraction():

    # Initialize two numbers
    num1 = 50
    num2 = 10

    # Subtract them
    diff = num1 - num2

    # Assertion
    assert diff == 40

# Multiplication test
def test_multiplication():

    # Initialize two numbers
    num1 = 4
    num2 = 10

    # Multiply them
    prod = num1 * num2

    # Assertion
    assert prod == 44

# Division test
def test_division():

    # Initialize two numbers
    num1 = 50
    num2 = 5

    # Divide them
    quot = num1 / num2

    # Assertion
    assert quot == 10