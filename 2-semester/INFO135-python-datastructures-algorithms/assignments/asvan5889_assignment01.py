# Question 1.
""" 1. Imagine that you’re looking for a word in the following dictionaries. In the worst case, how
many steps do you think the search will take with Binary Search? """

print("Question 1: ")


def big_O_complexity(number):
    iterations = 0

    while number > 1:
        number /= 2
        iterations += 1

    return iterations


print(f"Italian dictionary: {big_O_complexity(102400)}")  # 17
print(f"French dictionary: {big_O_complexity(480000)}")  # 19

# Question 2.
""" 2. Given the following Linked-list class, write a method called print_list() that loops
over and prints all the items (elements) of a Linked-list starting from the head """

print("Question 2: ")


class Node:  # Making a class for the individual nodes in a linked list.
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return self.head is None

    def add(self, data):
        temp = Node(data)
        temp.next = self.head
        self.head = temp

    def search(self, data):
        current = self.head
        found = False
        while current and found is False:
            if current.data == data:
                found = True
            else:
                current = current.next
        return found

    def print_list(self):
        # current represents which node the loop is currently at.
        current = self.head
        while current:
            print(current.data, end=" ")
            current = current.next
        print()


# Creating a linked list
node1 = Node("Bananas")
node2 = Node("Eggs")
node3 = Node("Cookies")

shopping_list = LinkedList()
shopping_list.head = node1
node1.next = node2
node2.next = node3

# Lets run it
shopping_list.print_list()

# Question 3.
""" 3. Write a function reverse_list() that receives a Python list, builds a Stack with the
same elements, and prints the reversed list."""

print("Question 3. ")


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


def reverse_list(input_list):
    reversed_stack = Stack()
    for item in input_list:
        reversed_stack.push(item)
    reversed_list = []
    while not reversed_stack.is_empty():
        reversed_list.append(reversed_stack.pop())
    return reversed_list


# Test

my_list = [1, 2, 3, 4, 5]
reversed_list = reverse_list(my_list)
print("Original list:", my_list)
print("Reversed list also made into a stack:", reversed_list)
