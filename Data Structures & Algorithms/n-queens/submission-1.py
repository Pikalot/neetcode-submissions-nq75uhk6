class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        cols = set()
        posDia = set()
        negDia = set()
        grid = [['.'] * n for _ in range(n)]

        def backtrack(r: int) -> None:
            if r == n:
                clone = ["".join(grid[row]) for row in range(n)]
                res.append(clone)
                return
            
            for c in range(n):
                pos = r + c
                neg = r - c

                if (
                    c in cols or
                    pos in posDia or
                    neg in negDia):
                    continue
                
                grid[r][c] = 'Q'
                cols.add(c)
                posDia.add(pos)
                negDia.add(neg)
                backtrack(r + 1)
                grid[r][c] = '.'
                cols.remove(c)
                posDia.remove(pos)
                negDia.remove(neg)

        backtrack(0)
        return res