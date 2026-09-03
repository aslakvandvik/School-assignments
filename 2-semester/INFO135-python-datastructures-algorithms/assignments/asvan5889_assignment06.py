# Question 1. 
"""Which of the following sequences determines the order in which the elements
would be accessed during a Pre-order traversal:
"""
# Answer: a) A B D G H E I C F J 

# Question 2.
"""Write a class called QuizGift that has a method compute_result() to
solve the following problem and to compute the result. Then, write another
method called print_result() that prints out the result.
Sara is going to attend a written quiz where she can receive a prize based
on the number of points she obtains. The written quiz has 6 questions each
of them is worth different points and each takes a different amount of time
to answer. Sara will have 100 minutes and can choose which subset of
questions to answer from the following question set:
• Question 1 has 120 points and it takes 15 minutes to answer
• Question 2 has 200 points and it takes 20 minutes to answer
• Question 3 has 150 points and it takes 40 minutes to answer
• Question 4 has 350 points and it takes 50 minutes to answer
• Question 5 has 100 points and it takes 20 minutes to answer
• Question 6 has 90 points and it takes 10 minutes to answer
Sara will receive a watch if she obtains up to 250 points, a smartphone if
she obtains 250 - 750 points, and, a laptop if she obtains more than 750
points. Sara would like to have a Python program, based on Dynamic
Programming, to compute the maximum number of points she can obtain (in
the given time) and to print it out. The program should also print the gift
that she will receive as the result of answering the quiz. Please help her!
Note: You can write more methods in the QuizGift class if needed."""

class QuizGift:    
    def __init__(self):
        self.questions = [(120, 15), (200, 20), (150, 40), (350, 50), (100, 20), (90, 10)]
        self.total_time = 100
        self.dp = [[0 for _ in range(self.total_time + 1)] for _ in range(len(self.questions) + 1)]
        self.max_points = 0

    def compute_result(self):
        for i in range(1, len(self.questions) + 1):
            points, time = self.questions[i - 1]
            for j in range(1, self.total_time + 1):
                if time <= j:
                    self.dp[i][j] = max(self.dp[i - 1][j], points + self.dp[i - 1][j - time])
                else:
                    self.dp[i][j] = self.dp[i - 1][j]
        self.max_points = self.dp[-1][-1]

    def print_result(self):
        self.compute_result()
        print(f"Maximum points: {self.max_points}")
        if self.max_points <= 250:
            print("Gift: Watch")
        elif 250 < self.max_points <= 750:
            print("Gift: Smartphone")
        else:
            print("Gift: Laptop")

quiz = QuizGift()
quiz.print_result()

# Question 3.
"""Write an interface called Shape that has an abstract method called
compute_area(self). Then, write the following classes, all of them
implementing the Shape interface:

a) Square class that has a constructor which receives as a parameter the
side of the square and sets it as an instance variable. This class should
implement compute_area() method to compute and print the area
of the square (area of square = side * side)

b) Circle class that has a constructor which receives as the parameter
radius of the circle and sets it as an instance variable. This class should
implement compute_area() method to compute and print the area
of the circle (area of circle = 3.14 * radius * radius)

c) Triangle class that has a constructor which receives as parameters
the values of the 3 sides of the triangle and sets them as instance
variables. This class should implement compute_area() method to
compute and print the area of triangle, based on the following formula:
s = (a + b + c) / 2
area = √s(s - a)(s - b)(s - c)
"""
