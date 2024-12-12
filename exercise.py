import sys
#FizzBuzz
#Print numbers 1-100, replace multiples of 3 with "Fizz", multiples of 5 with "Buzz", and multiples of both with "FizzBuzz".

def fizzbuzz(first, last):
    for number in (first, last + 1):
        if number % 15 == 0:
            print("FizzBuzz")
        elif number % 3 == 0 and number % 5 != 0:
            print("Fizz")
        elif number % 3 != 0 and number % 5 == 0:
            print("Buzz")
        else:
            print(number)

fizzbuzz(1,100)

#############################################################################################
#Two Sum
#Find two numbers in an array that add up to a specific target.

def two_sum(array, target):
    array_to_list = list(array)
    for i in range (0, len(array_to_list)):
        for j in range (i + 1, len(array_to_list)):
            if array_to_list[i] + array_to_list[j] == target:
                return array_to_list[i], array_to_list[j]


#############################################################################################
#Palindrome Check
#Check if a given string reads the same forwards and backwards.

def palindrome_check(word):
    for i in range (0, len(word)//2):
        if word[i] != word[len(word) - 1 - i]:
            return False
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

def valid_parentheses(opening, closing, string):
    open_in_total = 0
    for character in string:
        if character == opening:
            open_in_total = open_in_total + 1
        if character == closing:
            open_in_total = open_in_total - 1
        if open_in_total < 0:
            return False
    return open_in_total == 0

round_brackets = valid_parentheses("(", ")", string)
square_brackets = valid_parentheses("[", "]", string)
curly_brackets = valid_parentheses("{", "}", string)

#############################################################################################
#Find Maximum in Array
#Write a function that finds the largest number in an array.

def longest_length(array):
    the_largest = array[0]
    for number in array:
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
    sum_positive = 0
    for number in array:
        if number > 0:
            sum_positive += number
    return sum_positive

#############################################################################################
#Find Missing Number
#Find a missing number in an array of integers from 1 to n.

def missing_number(array):
    missing_numbers = []
    for i in range (1, len(array)):
        if array[i] - array[i-1] != 1:
            missing_numbers.append(array[i]-1)
    return missing_numbers
