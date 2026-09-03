# Question 1.
"""1. Suppose you have the following list of numbers to sort:
[ 1502, 1560, 1600, 1540, 100, 1660, 1700, 2024 ]
What will be the partially sorted list after 3 passes of Selection Sort?"""

# 1st pass: [100, 1560, 1600, 1540, 1502, 1660, 1700, 2024]
# 2nd pass: [100, 1502, 1600, 1540, 1560, 1660, 1700, 2024]
# 3rd passs: [100, 1502, 1540, 1600, 1560, 1660, 1700, 2024]

# Question 2.
"""2. Suppose you have the following list of numbers to sort:
[ 400, 10, 210, 160, 70, 220, 280, 380, 180, 260, 540 ]
What will be the partially sorted list after 3 passes of Bubble Sort?"""

# 1st pass: [10, 210, 160, 70, 220, 280, 380, 180, 260, 400, 540]
# 2nd pass: [10, 160, 70, 210, 220, 280, 180, 260, 380, 400, 540]
# 3rd pass: [10, 70, 160, 210, 180, 220, 260, 280, 380, 400, 540]

# Question 3.
"""Write a function called sort_and_rem_dup() that receives a list of numbers and
returns a sorted list where the duplicates in the numbers are removed."""
print("Question 3.")


def sort_and_rem_dup(list):
    # Bubble sort
    size = len(list)
    for i in range(size):
        for j in range(0, size - i - 1):
            if list[j] > list[j + 1]:
                temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp

    # Remove duplicates
    i = 0
    while i < len(list) - 1:
        if list[i] == list[i + 1]:
            del list[i]
        else:
            i += 1

    return list


my_list = [5, 4, 3, 2, 1, 2, 3, 4, 5]
new_list = sort_and_rem_dup(my_list)
print(new_list)

# Question 4.
"""Write a function check_palindrome(word) that receives a string variable called
word as an input parameter and builds a Stack and a Queue where their elements are the
letters (characters) of that word. Then, the function should check and print if the word is
a Palindrome or not."""
print("Question 4.")


class Queue:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.items.pop(0)

    def size(self):
        return len(self.items)


class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return len(self.items) == 0

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if self.is_empty():
            return None
        return self.items.pop()

    def peek(self):
        if self.is_empty():
            return None
        return self.items[-1]

    def size(self):
        return len(self.items)


def check_palindrome(word):
    stack = Stack()
    queue = Queue()
    word = word.lower()

    for letter in word:
        stack.push(letter)
        queue.enqueue(letter)

    is_palindrome = True

    while not queue.is_empty() and is_palindrome:
        if queue.dequeue() != stack.pop():
            is_palindrome = False
    if is_palindrome:
        print(f"{word} is a palindrome")
    else:
        print(f"{word} is not a palindrome")


result = check_palindrome("racecar")
result = check_palindrome("hello")
