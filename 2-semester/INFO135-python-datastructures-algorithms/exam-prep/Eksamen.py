def fun2(n):
    memo = [0] * max(4, n + 1)
    memo[0] = 1
    memo[1] = 1
    memo[2] = 1
    memo[3] = 3
    for i in range(4, n + 1):
        memo[i] = memo[i - 1] + i * memo[i - 2] + memo[i - 3]
    return memo[n]

for n in range(1, 6):
    print(fun2(n))