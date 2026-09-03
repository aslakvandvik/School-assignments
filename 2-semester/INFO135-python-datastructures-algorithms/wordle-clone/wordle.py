from tkinter import *
from words import get_word
from tkinter import messagebox, Entry
from collections import Counter
from words import five_letter_words_list

root = Tk()
root.title("Wordle")
root.geometry("500x500")

GREEN = "#85bb65"
YELLOW = "#fff200"
BLACK = "#000000"
WHITE = "#ffffff"

# Initialize entries as an empty list
entries = []

def startGame():
    global word
    global guessnum
    global entries
    global guessFrame

    word = get_word()  # get a new random 5-letter word
    guessnum = 0

    # Clear the guessFrame and recreate it
    if 'guessFrame' in globals():
        guessFrame.destroy()
    guessFrame = Frame(root)
    guessFrame.pack()

    # Clear the entries and recreate them
    for entry in entries:
        entry.destroy()
    entries = [Entry(guessFrame, width=2, font=("Courier", 24)) for _ in range(5)]
    for i, entry in enumerate(entries):
        entry.grid(row=0, column=i, padx=5, pady=5)
        entry.bind('<KeyRelease>', lambda event, i=i: keyRelease(event, i))  # bind the KeyRelease event to the keyRelease function

def keyRelease(event, i):
    # If the key released was the Enter key, call the getGuess function
    if event.keysym == 'Return':
        getGuess()
    # If a letter was entered and there's a next Entry widget, set the focus to the next Entry widget
    elif event.char.isalpha() and i + 1 < len(entries):
        entries[i + 1].focus()

# Create a label for error messages
# Create a label for the rules
rulesLabel = Label(root, text="Rules\n5 characters\nYellow = In the word, wrong spot\nGreen = In the word, correct spot\nBlack = Not in the word", font=("Courier", 18))
rulesLabel.pack(side=TOP, pady=10)
correctLabel = Label(root, text = "", fg="green")
correctLabel.pack(side=BOTTOM, pady=10)
errorLabel = Label(root, text="", fg="red")
errorLabel.pack(side=BOTTOM, pady=10)

def clearEntries(event=None):
    for entry in entries:
        entry.delete(0, 'end')
        entry.icursor(0)  # set the insertion cursor at the beginning
    errorLabel.config(text="")  # clear the error message

# Bind the Backspace key to the clearEntries function
root.bind('<BackSpace>', clearEntries)

def getGuess():
    global word
    global guessnum
    guess = ''.join(entry.get().lower() for entry in entries)  # get the guess from the Entry widgets

    if guess not in five_letter_words_list:
        errorLabel.config(text="Word is not in our dictionary.")  # update the error message
        return

    if len(guess) != len(word):
        errorLabel.config(text=f"Please use exactly {len(word)} characters in your guess.")  # update the error message
        return  # return early to avoid executing the rest of the function

    guessnum += 1
    for entry in entries:
        entry.delete(0, 'end')  # clear the Entry widgets
        entry.icursor(0)  # set the insertion cursor at the beginning
    errorLabel.config(text="")  # clear the error message

    word_counter = Counter(word.lower())
    guess_counter = Counter(guess)

    if guessnum <= 5:
        if word.lower() == guess:  # convert word to lowercase before comparing
            correctLabel.config(text=f"Correct! The word was {word.title()}")
            for i, letter in enumerate(guess):  # iterate over each letter in the guess
                label = Label(guessFrame, text=letter.upper(), font=("Courier", 24), width=2, height=1, bd=2, relief="solid", bg=GREEN, fg=BLACK)  # create a label with a green background
                label.grid(row=guessnum, column=i, padx=5, pady=5)
        else:             #INCORRECT
            for i, letter in enumerate(guess):
                label = Label(guessFrame, text=letter.upper(), font=("Courier", 24), width=2, height=1, bd=2, relief="solid")
                label.grid(row=guessnum, column=i, padx=5, pady=5)

                if letter == word[i].lower():  # convert word[i] to lowercase before comparing
                    label.config(bg=GREEN, fg=BLACK)

                elif letter in word_counter and guess_counter[letter] <= word_counter[letter]:
                    label.config(bg=YELLOW, fg=BLACK)
                
                else:
                    label.config(bg=BLACK, fg=WHITE)
    else:
        errorLabel.config(text=f"You didn't guess the word in 5 tries. The correct word was {word}.")
        startGame()  # start a new game)

# Create a Play Again button
playAgainButton = Button(root, text="Play Again", command=startGame)
playAgainButton.pack(side=BOTTOM, pady=10)

startGame()
root.mainloop()