# Oppgave 1.
print("Oppgave 1.")
print("")
import math


def pi(d=2):
    if d > 15:  # Pi fra "import math" kan ikke ha mer enn 15 desimaler
        print("Too many decimals")
        return round(math.pi, 15)
    return round(math.pi, d)


# Eksempler
print(pi(10))
print(pi(5))
print(pi(13))
print(pi(40))

# Oppgave 2.
print("Oppgave 2.")
print("")


def temperature_convert(temp, skala="C"):
    # (skala = 'C'), Hvis ingen skala er oppgitt, bruker den 'C'
    if skala == "C":
        # Hvis skalaen er 'C', konverter fra C til F
        converted_temp = (temp * 9 / 5) + 32
    elif skala == "F":
        # Ellers, hvis skalaen er 'F', konverter fra C til F
        converted_temp = (temp - 32) * 5 / 9
    else:
        # Hvis det er gitt en skala som ikke eksisterer, får man ikke svar.
        print("Undefined scale, use 'C', or 'F'.")
        return None
    return converted_temp


# Eksempler
print(temperature_convert(34, "C"))
print(temperature_convert(93.2, "F"))
print(temperature_convert(34))

# Oppgave 3a)
print("Oppgave 3a)")
print("")
balance = 500
interest_rate = 0.01  # Standard interest
transaction_history = []  # 3c) Liste for transaction history


# Funksjon for deposit
def deposit(amount):
    global balance
    balance += amount
    transaction_history.append(f"+{amount}")  # 3c) Legger til i listen


# Funksjon for withdraw
def withdraw(amount):
    global balance
    if amount <= balance:
        balance -= amount
        transaction_history.append(f"-{amount}")  # 3c)
    else:
        print("Overdraft.")


# Funksjon to calculate interest for given balance
def calculate_interest():
    global balance
    return balance * interest_rate


# Funksjon for årlig rente (annual interest)


def annual_interest():
    global balance, interest_rate
    interest_rate = balance * interest_rate
    balance += interest_rate
    if balance > 1000000:
        interest_rate = 0.02
        print("Congratulations, you get a bonus interest rate of 0.02%!")
    else:
        print("You now have the regular interest rate of 0.01%")
    transaction_history.append(f"+{interest_rate}")


# Eksempler
print(balance)
print(interest_rate)

deposit(300)
print(balance)

withdraw(100)
print(balance)

interest = calculate_interest()
print(interest)

annual_interest()
print(balance)
print(interest_rate)

deposit(1000000)
print(balance)

withdraw(500000)
print(balance)
print(interest_rate)

withdraw(1000000)
print(balance)

# Oppgave 3b) og 3c)
print("Oppgave 3b) og 3c)")
print("")


# Funksjon for transaction history
def show_transaction_history():
    print("\n".join(transaction_history[-3:]))


# Funksjon for å vise meny og valg av brukeren
def velg():
    while True:
        print("- - - - - - - - - - - - - - - - - - - - ")
        print("1 - View balance")
        print("2 - Deposit")
        print("3 - Withdraw")
        print("4 - Annual interest settlement")
        print("5 - Last transactions")
        print("- - - - - - - - - - - - - - - - - - - - ")

        user_choice = input("Choose an action: ")
        if user_choice == "1":
            print(f"Balance: {balance}")
        elif user_choice == "2":
            amount = float(input("Amount: "))
            deposit(amount)
        elif user_choice == "3":
            amount = float(input("Amount: "))
            if amount <= balance:
                withdraw(amount)
                print(f"Balance: {balance}")
            else:
                print("Insufficient funds.")
                print(f"Balance: {balance}")
        elif user_choice == "4":
            annual_interest()
        elif user_choice == "5":
            show_transaction_history()
        else:
            print("Invalid choice. Please select a valid option")


velg()
