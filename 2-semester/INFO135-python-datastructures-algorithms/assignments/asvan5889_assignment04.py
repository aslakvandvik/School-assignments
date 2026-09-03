# Question 1. 
"""Given the following Graph, which set represents the Edge set of the Graph?"""
#Answer: d) { (v0,v1), (v1,v2), (v2,v3), (v3,v4), (v4,v0), (v0,v5), (v5,v4), (v3,v5), (v5,v2) }
# Question 2. 
"""What is the shortest path from vertex A to vertex E according to Dijkstra's algorithm,
considering the given edge weights (distances)? Additionally, what is the total distance of that
shortest path?"""
#Answer: 1) Shortest Path: A -> C -> D -> E, Distance: 19

#Question 3.
print("Question 3.")
"""Extend the implementation of the solver for the N-queen problem by adding a new function
called is_solution(candidate_solution)that receives a candidate solution as a
parameter and checks if the solution is valid or not. The candidate solution is in the form of a
list of strings indicating the position of the queens on the chessboard.
Note 1: You can find an implementation of a solver for the N-queen problem in lecture 4.
Note 2: You can assume N=5.
Here is an example output for two candidate solutions."""

COLUMNS = "abcde"
NUM_QUEENS = len(COLUMNS)
ACCEPT = 1
CONTINUE = 2
ABANDON = 3
all_solutions = []

def solve(partial_sol):
    exam = examine(partial_sol)
    if exam == ACCEPT:
        all_solutions.append(partial_sol)
    elif exam != ABANDON:
        for p in extend(partial_sol):
            solve(p)
    return all_solutions

def examine(partial_sol):
    for i in range(len(partial_sol)):
        for j in range(i + 1, len(partial_sol)):
            
            if attacks(partial_sol[i], partial_sol[j]):
                return ABANDON
    
    if len(partial_sol) == NUM_QUEENS:
        return ACCEPT
    else:
        return CONTINUE

def attacks(p1, p2):
    column1 = COLUMNS.index(p1[0]) + 1
    row1 = int(p1[1])
 
    column2 = COLUMNS.index(p2[0]) + 1
    row2 = int(p2[1])
 
    return (row1 == row2 or
            column1 == column2 or
            abs(row1-row2) == abs(column1-column2))

def extend(partial_sol):
    results = []
    row = len(partial_sol) + 1
    
    for column in COLUMNS:
        new_solution = list(partial_sol)
        new_solution.append(column + str(row))
        results.append(new_solution)
    return results

def is_solution(candidate_solution):    # Check if the solution is valid or not.
    if len(candidate_solution) != NUM_QUEENS:
        return "Invalid!"
    for i in range(len(candidate_solution)): 
        for j in range(i + 1, len(candidate_solution)): 
            if attacks(candidate_solution[i], candidate_solution[j]):
                return "Invalid!"
    return "Valid!"


candidate_solution1 = ['d3', 'c1', 'e5', 'b4', 'a2']
candidate_solution2 = ['e4', 'a1', 'c5', 'd2', 'b1']

result1 = is_solution(candidate_solution1)
result2 = is_solution(candidate_solution2)

print("Candidate Solution 1:", result1)
print("Candidate Solution 2:", result2)

#Question 4.
print("Question 4.")
"""Consider the following implementation of the Graph class. Write a method called
remove_vertex(self, vertex) that receives a vertex (node) as a parameter and
removes edges connected to that vertex. """

class Graph:
    def __init__(self):  # Initialize a new 'Graph' object.
        self.graph = {}

    def add_vertex(self, vertex):  # Add a vertex to the graph.
        if vertex not in self.graph:
            self.graph[vertex] = []

    def add_edge(self, from_vertex, to_vertex):  # Add an edge between two vertices.
        if from_vertex not in self.graph:
            self.graph[from_vertex] = []
        self.graph[from_vertex].append(to_vertex)
        if to_vertex not in self.graph:
            self.add_vertex(to_vertex)

    def print_graph(self):  # Print the graph.
        for vertex, edges in self.graph.items():
            print(vertex + ": " + str(edges))

    def remove_vertex(self, vertex):    # Remove a vertex from the graph.
        if vertex in self.graph:
            del self.graph[vertex]
            for v in self.graph:
                if vertex in self.graph[v]:
                    self.graph[v].remove(vertex)

graph = Graph()
graph.add_edge('a', 'b')
graph.add_edge('a', 'c')
graph.add_edge('b', 'c')
graph.add_edge('b', 'd')
graph.add_edge('c', 'd')
graph.add_edge('d', 'e')

print("Before removal of vertex:")
graph.print_graph()
graph.remove_vertex('a')

print("After removal of vertex:")
graph.print_graph()