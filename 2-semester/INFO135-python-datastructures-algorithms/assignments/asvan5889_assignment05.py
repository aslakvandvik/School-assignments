# Assignment 5.
# Question 1.
# Which of the following Trees are Full Binary Tree.
# Answer: All of them

# Question 2.
# Which of the following matrices correctly displays the adjacency matrix of the graph?
# Answer: (ii)

# Question 3.
print("Question 3.")
"""Use the implementation of Binary Tree (based on List of Lists) provided in Lecture
notes and write a function called make_tree() that builds the following tree and prints it
in the output."""
def binary_tree(r): # Create a binary tree.
    return [r, [], []]

def get_left_child(root):   # Get the left child.
    return root[1]

def get_right_child(root):  # Get the right child.
    return root[2]

def insert_left_child(root, new_branch):    # Insert a left child.
    t = root.pop(1)
    if len(t) > 1:
        root.insert(1, [new_branch, t, []])
    else:
        root.insert(1, [new_branch, [], []])
    return root

def insert_right_child(root, new_branch):   # Insert a right child.
    t = root.pop(2)
    if len(t) > 1:
        root.insert(2, [new_branch, [], t])
    else:
        root.insert(2, [new_branch, [], []])
    return root

def make_tree():    # Build the tree.
    my_tree = binary_tree('1')
    insert_left_child(my_tree, '2')
    insert_right_child(my_tree, '3')
    insert_left_child(get_left_child(my_tree), '4')
    insert_left_child(get_right_child(my_tree), '5')   
    insert_right_child(get_right_child(my_tree), '6')  
    return my_tree

print(make_tree())

# Question 4.
print("Question 4.")
"""4. Write a function build_my_graph2() that:
a) creates the following Graph.
b) runs Depth First Search (DFS) algorithm starting from node b and prints all the
visited vertices (nodes).
What is printed in the output when you run this function?
Answer: ['b', 'a', 'c', 'd', 'e']
Note: you can use implementation of Graph class and DFS algorithm (in Lecture notes)."""

class Graph:
    def __init__(self):  # Initialize a new 'Graph' object.
        self.graph = {}

    def dfs(self, start):  # Depth First Search
        visited = []
        stack = [start]

        while stack:
            vertex = stack.pop()
            if vertex not in visited:
                visited.append(vertex)
                for x in self.graph.get(vertex, []):
                    if x not in visited:
                        stack.append(x)
        return visited

    def add_vertex(self, vertex):  # Add a vertex to the graph.
        if vertex not in self.graph:
            self.graph[vertex] = []

    def add_edge(self, from_vertex, to_vertex):  # Add an edge between two vertices.
        if from_vertex not in self.graph:
            self.graph[from_vertex] = []
        self.graph[from_vertex].append(to_vertex)
        if to_vertex not in self.graph:
            self.add_vertex(to_vertex)

    def get_vertex(self, vertex):  # Get a vertex from the graph.
        return self.graph.get(vertex, None)

def build_my_graph2():
    graph = Graph()
    graph.add_edge('a', 'c')
    graph.add_edge('c', 'b')
    graph.add_edge('b', 'a')
    graph.add_edge('a', 'd')
    graph.add_edge('d', 'e')
    graph.add_edge('e', 'a')

    return print(graph.dfs('b'))

build_my_graph2()

# Question 5.
print("Question 5.")
"""Use the Binary Search Tree (BST) class (provided in Lecture notes) and write two new
methods that are described in the following:
 - compute_sum() that computes the sum of all the node (vertex) values in BST.
 - compute_count() that computes the total number of nodes (vertices).
Note: you can assume the values of the nodes (vertices) within the tree are all numerical."""
class BinarySearchTree:

    def __init__(self, value = None):
        # Initialize the tree with a value, if provided.
        self.value = value
        if self.value:
            self.left_child = BinarySearchTree()
            self.right_child = BinarySearchTree()
        else:
            self.left_child = None
            self.right_child = None

    def is_empty(self):
        # Check if the tree is empty.
        return self.value == None
    
    def insert(self, value):
        # Insert a value into the tree.
        if self.is_empty():
            self.value = value
            self.left_child = BinarySearchTree()
            self.right_child = BinarySearchTree()
        elif value < self.value:
            self.left_child.insert(value)
        elif value > self.value:
            self.right_child.insert(value)
        
    def compute_sum(self):
        # Compute the sum of all values in the tree.
        if self.is_empty():
            return 0
        else:
            return self.value + self.left_child.compute_sum() + self.right_child.compute_sum()
        
    def compute_count(self):
        # Compute the total number of nodes in the tree.
        if self.is_empty():
            return 0
        else:
            return 1 + self.left_child.compute_count() + self.right_child.compute_count()
    
my_tree = BinarySearchTree()
my_tree.insert(2)
my_tree.insert(4)
my_tree.insert(6)
my_tree.insert(8)
my_tree.insert(10)
my_tree.insert(12)

print('Sum:', my_tree.compute_sum()) 
print('Number of nodes:', my_tree.compute_count()) 
