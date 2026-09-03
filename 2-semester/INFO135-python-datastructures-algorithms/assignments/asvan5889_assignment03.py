# Question 1.
""" Suppose a hash table of size m = 13 is created using the hash function h(key) = key % m.
Which index (slot) in the hash table would the following two keys map to?
Keys: 27, 130 """

# For key 27: h(27) = 27 % 13 = 1
# For key 130: h(130) = 130 % 13 = 0

# Answer: b) 1, 0

# Question 2.
"""
Suppose you are given the following sequence of keys to put (insert) into a hash table with
the size m = 11:
Keys: 11, 12, 14, 17, 18, 19, 20, 21, 25

Consider the following hash function: h(key) = key % m and answer these questions:
Q1: What is the Load Factor after all the keys have been inserted?

n = 9, m = 11
load factor = n/m = 9/11

Q2: Which of the following options represents the contents of the hash table after all
the keys have been inserted using Linear Probing (see Lecture 5)?

Answer: c)
"""

# Question 3.
print("Question 3")
"""Write a class HashClass that has:
a constructor method to receive the id number of a person as parameter. 
a method called hash_it() that generates a random integer number called salt
(ranging from 1 to 1000), adds the value of salt to the id number, and then hashes the
result using SHA algorithm (see Lecture 5).
a method called print_it()that prints out the generated hash number.
Use random.randint() to generate a random integer number. """

import hashlib as hl
import random

class HashClass:
    def __init__(self, id_num):
        self.id_num = id_num
        self.hash_pass = None

    def hash_it(self):
        salt = random.randint(1, 1000)
        self.hash_pass = hl.sha1(str(self.id_num + salt).encode()).hexdigest()

    def print_it(self):
        self.hash_it()
        print(self.hash_pass)


my_hash = HashClass(11011999)
my_hash.print_it()

# Question 4.
print("Question 4")

"""Write a function called most_frequent_integer() that receives a list of integer
numbers as input and uses hash table data structure (such as Python dictionary) to find one
integer number that occurs most frequently among all the list. See the following example: """

def most_frequent_integer(my_list):
    hash_table = {}
    for num in my_list:
        if num in hash_table:
            hash_table[num] += 1
        else:
            hash_table[num] = 1
    max_count = 0
    max_num = 0
    for key, value in hash_table.items():
        if value > max_count:
            max_count = value
            max_num = key
    return max_num


my_list = [10, 2, 5, 2, 0, 5, 6, 8, 5, 10]
result = most_frequent_integer(my_list)
print(result)
