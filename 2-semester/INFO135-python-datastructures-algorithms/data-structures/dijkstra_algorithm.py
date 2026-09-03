class Graph2:
    def __init__(self):
        self.graph = {}  # Initialize with a Python dictionary to store the graph

    def add_vertex(self, vertex):  # Adding a vertex to the graph if it doesn't exist
        if vertex not in self.graph:
            self.graph[vertex] = {}

    def add_edge(self, from_vertex, to_vertex, cost): # # Adding an edge from from_vertex to to_vertex with a given cost (weight or distance)
        self.add_vertex(from_vertex)
        self.add_vertex(to_vertex)
        self.graph[from_vertex][to_vertex] = cost

    def get_vertices(self):  # Getting all vertices in the graph
        return list(self.graph.keys())
    
    def get_adjacency(self, vertex):  # Get all vertices adjacent to a given vertex.
        return self.graph.get(vertex, [])
    
    def get_vertex(self, vertex):  # Get a vertex from the graph.
        return self.graph.get(vertex, None)

    def __contains__(self, vertex):  # checking whether or not a vertex is in the graph
        return vertex in self.graph

    def print_graph(self):  # Printing the graph with its vertices and its edges
        for vertex, edges in self.graph.items():
            print(vertex + ": " + str(edges))

    # Preparing the graph for Dijkstra's algorithm by initializing the distance and previous dictionaries
    def prepare_dijkstra(self, start):
        # Initializing weights (distances) with ‘infinite’ values
        dist = {vertex: float("inf") for vertex in self.graph}
        prev = {vertex: None for vertex in self.graph}
        dist[start] = 0  # Initializing the previous vertices with ‘None’ values
        return dist, prev

    # Building the shortest path (route) from the starting vertex to the ending vertex, based on the previous vertices
    def build_path(self, prev, start, end):
        path = []
        vertex = end
        while vertex != start:
            if prev[vertex] is None:  # If there's no path to the vertex
                return None
            path.insert(0, vertex)  # Insert the vertex at the beginning of the path
            vertex = prev[vertex]
        path.insert(0, start)
        return path

    def dijkstra(self, start, end):
        # Initializing weights (distances) and the previous vertices
        dist, prev = self.prepare_dijkstra(start)
        visited = set()  # Creating a set to store visited varices
        current_vertex = start
        # Loop until no vertices are left or the ending vertex is visited
        while current_vertex and current_vertex != end:
            visited.add(current_vertex)
            neighbors = self.graph.get(current_vertex, {}) # Getting the neighbors of the current vertex
            for neighbor, cost in neighbors.items(): # Loop through vertices in each neighbourhood
                if neighbor not in visited: # Only consider neighbors that are not visited
                    new_cost = dist[current_vertex] + cost # Calculate the new cost
                    if new_cost < dist[neighbor]:   # If the new cost is less than the current cost
                        dist[neighbor] = new_cost   # Update the cost
                        prev[neighbor] = current_vertex # Update the previous vertex

            next_vertex = None
            lowest = float("inf")
            for vertex in dist:   # Loop through the vertices to find the vertex with the lowest distance
                if vertex not in visited and dist[vertex] < lowest:
                    lowest = dist[vertex]
                    next_vertex = vertex
                current_vertex = next_vertex
        return self.build_path(prev, start, end), dist[end] # Return the shortest path and its cost(distances)

graph = Graph2()
graph.add_edge('atlanta', 'boston', 100)
graph.add_edge('atlanta', 'denver', 160)
graph.add_edge('boston', 'chicago', 120)
graph.add_edge('boston', 'denver', 180)
graph.add_edge('chicago', 'el paso', 80)
graph.add_edge('denver', 'chicago', 40)
graph.add_edge('denver', 'el paso', 140)
graph.add_edge('el paso', 'boston', 100)

print("\n-----------------Graph structure-----------------")
graph.print_graph()

vertex_key = 'atlanta'
print("\n-------------Vertices and edges for Atlanta--------------")
print("Edges for Atlanta:", graph.get_vertex(vertex_key))
print("Vertex'" + vertex_key + "' in graph: ", end='')
print(vertex_key in graph)

path, cost = graph.dijkstra('atlanta', 'el paso')
print("\n-------------Shortest path from Atlanta to El Paso-------------")
print("Cheapest flight path:", path)
print("Cost: $", cost)