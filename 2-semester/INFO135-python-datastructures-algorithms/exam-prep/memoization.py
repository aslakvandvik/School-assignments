def fact_func2(n):
    # This function calculates the factorial of n using memoization.
    memo = [0] * (n + 1)    # Create a list to store the results of subproblems
    memo[0], memo[1] = 1, 1 # Initialize the base cases
    
    for i in range(2, n + 1):
        memo[i] = i * memo[i - 1] # Calculate the factorial using the previously stored results
    return memo[n] # Return the result for n

for i in range(1, 21):
    print(fact_func2(i))


