import math
from heuristic import Heuristic
from make_grid import SIZE

class PythagorasH(Heuristic):
    """
    Heuristic using Euclidean distance to the goal.
    Goal is at (SIZE-1, SIZE-1).
    """
    def h(self, node):
        di = (SIZE - 1) - node.i
        dj = (SIZE - 1) - node.j
        return math.sqrt(di * di + dj * dj)