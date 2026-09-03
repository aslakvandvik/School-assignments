import hashlib as hl


"""class Password:

    def __init__(self):
        user_pass = input("Enter your password: ")
        self.hash_pass = self.hash_it(user_pass)

    def hash_it(self, user_pass):
        self.hash_pass = h1.sha1(user_pass.encode()).hexdigest()
        return self.hash_pass
"""


class MiniBank:
    def __init__(self, balance=0):
        self.balance = balance
        self.bills = []

    def deposit(self, amount):
        self.balance += amount
        print(f"Deposited {amount}. New balance: {self.balance}")

    def add_bill(self, name, amount):
        self.bills.append((name, amount))

    def pay_bill(self, name):
        for i, bill in enumerate(self.bills):
            if bill[0] == name:
                if self.balance >= bill[1]:
                    self.balance -= bill[1]
                    self.bills.pop(i)
                    print(f"Paid bill {name}. New balance: {self.balance}")
                    return
                else:
                    print("Insufficient balance to pay bill.")
                    return
        print("Bill not found.")

    def merge_sort(self, bills):
        if len(bills) <= 1:
            return bills

        mid = len(bills) // 2
        left = self.merge_sort(bills[:mid])
        right = self.merge_sort(bills[mid:])

        merged = []
        while left and right:
            if left[0][1] > right[0][1]:
                merged.append(left.pop(0))
            else:
                merged.append(right.pop(0))

        merged.extend(left if left else right)
        return merged

    def print_bills(self):
        self.bills = self.merge_sort(self.bills)
        for bill in self.bills:
            print(f"{bill[0]}: {bill[1]}")

    def transfer(self, friend, amount):
        if self.balance >= amount:
            self.balance -= amount
            friend.balance += amount
            print(f"Transferred {amount} to {friend}. New balance: {self.balance}")
        else:
            print("Insufficient balance to transfer.")


# Test the system
joe = MiniBank()
joe.deposit(10000)
joe.add_bill("electric", 5000)
joe.add_bill("water", 2200)
joe.add_bill("wolfram alpha", 150)
joe.pay_bill("electric")
bob = MiniBank()
joe.transfer(bob, 1000)
joe.print_bills()
