"""Fruit Shop
Create a Python dictionary that contains a bunch of fruits and their prices.
Write a program that checks if a certain fruit is available or not."""
fruit_shop = {
    "apple": 100,
    "banana": 40,
    "orange": 50}

key_to_check = input("Type a fruit which you want? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, Fruit is available")
else:
    print("No, Fruit is not available")