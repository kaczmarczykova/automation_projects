import sys
#FizzBuzz
#Print numbers 1-100, replace multiples of 3 with "Fizz", multiples of 5 with "Buzz", and multiples of both with "FizzBuzz".

def fizzbuzz():
    for number in (1, 101):
        if number % 3 == 0 and number % 5 == 0:
            print("FizzBuzz")
        elif number % 3 == 0 and number % 5 != 0:
            print("Fizz")
        elif number % 3 != 0 and number % 5 == 0:
            print("Buzz")
        else:
            print(number)

#############################################################################################
#Two Sum
#Find two numbers in an array that add up to a specific target.

def two_sum(array, target):
    array_to_list = list(array)
    for i in range (0, len(array_to_list)):
        if array_to_list[i] + array_to_list[i + 1] == target:
            return target


#############################################################################################
#Palindrome Check
#Check if a given string reads the same forwards and backwards.

def palindrome_check(word):
    from_left = word
    from_right = ""
    for i in range (len(word) - 1, 0, -1):
        from_right += word[i]
    if from_left == from_right:
        return True

#############################################################################################
#Reverse a String
#Write a function that returns the reverse of a given string.

def reverse_string(word):
    from_right = ""
    for i in range (len(word) - 1, 0, -1):
        from_right += word[i]
    return from_right

#############################################################################################
#Valid Parentheses
#Determine if a string with brackets like (), {}, [] is valid (each opening bracket has a corresponding closing one).

def valid_parentheses(string):
    count_round_brackets_left = 0
    count_round_brackets_right = 0
    count_square_brackets_left = 0
    count_square_brackets_right = 0
    count_complex_brackets_left = 0
    count_complex_brackets_right = 0
    for i in range (0, len(string)):
        if string[i] == "(":
            count_round_brackets_left += 1
        if string[i] == ")":
            count_round_brackets_right += 1
        if string[i] == "[":
            count_square_brackets_left += 1
        if string[i] == "]":
            count_square_brackets_right += 1
        if string[i] == "{":
            count_complex_brackets_left += 1
        if string[i] == "}":
            count_complex_brackets_right += 1
    if count_round_brackets_left == count_round_brackets_right:
        return True
    if count_square_brackets_left == count_square_brackets_right:
        return True
    if count_complex_brackets_left == count_complex_brackets_right:
        return True

#############################################################################################
#Find Maximum in Array
#Write a function that finds the largest number in an array.

def longest_length(array):
    array_to_list = list(array)
    the_largest = array_to_list[0]
    for number in array_to_list:
        if number > the_largest:
            the_largest = number
    return the_largest

#############################################################################################
#Count Vowels
#Count the number of vowels (a, e, i, o, u) in a string.

def count_vowels(word):
    vowels = ["a", "e", "i", "o", "u"]
    count = 0
    for letter in word:
        if letter in vowels:
            count += 1
    return count

#############################################################################################
#Sum of Positive Numbers
#Find the sum of all positive numbers in an array.

def positive_sum(array):
    array_to_list = list(array)
    sum_positive = 0
    for number in array_to_list:
        if number > 0:
            sum_positive += number
    return sum_positive

#############################################################################################
#Find Missing Number
#Find a missing number in an array of integers from 1 to n.

def missing_number(array):
    array_to_list = list(array)
    missing_numbers = []
    for i in range (1, len(array_to_list)):
        if array_to_list[i] - array_to_list[i-1] != 1:
            missing_numbers.append(array_to_list[i]-1)
    return missing_numbers
