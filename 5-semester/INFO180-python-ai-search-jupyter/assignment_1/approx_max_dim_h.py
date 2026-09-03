from heuristic import Heuristic
from make_grid import SIZE

class ApproxMaxDimH(Heuristic):
    """
    Heuristic that returns three times the maximum of the absolute differences
    in row and column to the goal.
    """
    def h(self, node):
        di = abs((SIZE - 1) - node.i)
        dj = abs((SIZE - 1) - node.j)
        return 3 * max(di, dj)