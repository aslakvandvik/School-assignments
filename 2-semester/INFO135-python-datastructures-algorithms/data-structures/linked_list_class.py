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
