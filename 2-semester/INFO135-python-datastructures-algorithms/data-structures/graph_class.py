
class Graph:
    def __init__(self):  # Initialize a new 'Graph' object.
        self.graph = {}

    def bfs(self, start):  # Breadth First Search
        visited = [start]
        queue = [start]

        while queue:
            vertex = queue.pop(0)
            for neighbor in self.graph[vertex]:
                if neighbor not in visited:
                    visited.append(neighbor)
                    queue.append(neighbor)
        return visited

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

    def get_vertices(self):  # Get all vertices in the graph.
        return list(self.graph.keys())

    def get_adjacency(self, vertex):  # Get all vertices adjacent to a given vertex.
        return self.graph.get(vertex, [])

    def get_vertex(self, vertex):  # Get a vertex from the graph.
        return self.graph.get(vertex, None)

    def __contains__(self, vertex):  # Check if a vertex is in the graph.
        return vertex in self.graph

    def print_graph(self):  # Print the graph.
        for vertex, edges in self.graph.items():
            print(vertex + ": " + str(edges))


graph = Graph()

vertices = [
    "Alice",
    "Bob",
    "Cindy",
    "David",
    "Eve",
    "Frank",
    "Grace",
    "Hannah",
    "Ivan",
    "Jack",
    "Katie",
    "Liam",
    "Mia",
    "Nathan",
    "Olivia",
    "Peter",
    "Quinn",
    "Rachel",
    "Steve",
    "Tina",
    "Ulysses",
    "Victoria",
    "Walter",
    "Xena",
    "Yvonne",
    "Zach",
]
for vertex in vertices:
    graph.add_vertex(vertex)

edges = [
    ("Alice", "Bob"),
    ("Alice", "Cindy"),
    ("Alice", "David"),
    ("Bob", "Eve"),
    ("Cindy", "Frank"),
    ("David", "Grace"),
    ("Eve", "Hannah"),
    ("Frank", "Ivan"),
    ("Grace", "Jack"),
    ("Hannah", "Katie"),
    ("Ivan", "Liam"),
    ("Jack", "Mia"),
    ("Katie", "Nathan"),
    ("Liam", "Olivia"),
    ("Mia", "Peter"),
    ("Nathan", "Quinn"),
    ("Olivia", "Rachel"),
    ("Peter", "Steve"),
    ("Quinn", "Tina"),
    ("Rachel", "Ulysses"),
    ("Steve", "Victoria"),
    ("Tina", "Walter"),
    ("Ulysses", "Xena"),
    ("Victoria", "Yvonne"),
    ("Walter", "Zach"),
]
for from_vertex, to_vertex in edges:
    graph.add_edge(from_vertex, to_vertex)

print("\n-------- Graph structure --------")
graph.print_graph()

print("\n-------- Vertices --------")
vertices = graph.get_vertices()
print("Vertices in the graph:", vertices)

print("\n-------- Vertices and Edges for Alice --------")
vertex_key = "Alice"
print("Edges for Alice:", graph.get_adjacency(vertex_key))
print("Vertex_key in graph", vertex_key in graph)

print("\n-------- Breadth First Search --------")
bfs_order = graph.bfs("Alice")
print("BFS order starting from 'Alice'", bfs_order)

print("\n-------- Depth First Search --------")
dfs_order = graph.dfs("Alice")
print("DFS order starting from 'Alice'", dfs_order)
