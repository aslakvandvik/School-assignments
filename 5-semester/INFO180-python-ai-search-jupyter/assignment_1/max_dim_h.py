from heuristic import Heuristic
from make_grid import SIZE

class MaxDimH(Heuristic):
    """
    Heuristic that returns the maximum of the absolute differences
    in row and column to the goal.
    Goal is assumed to be at (SIZE-1, SIZE-1).
    """

    def h(self, node):
        # node.i is row, node.j is column
        di = abs((SIZE - 1) - node.i)
        dj = abs((SIZE - 1) - node.j)
        return max(di, dj)