import string

def calculate_passwords():
    letters = string.ascii_letters.replace('æ', '').replace('ø', '').replace('å', '')
    digits = string.digits

    password_count = 0

    for first_char in letters:
        for second_char in letters + digits:
            for third_char in letters + digits:
                for fourth_char in letters + digits:
                    for fifth_char in letters + digits:
                        for sixth_char in letters + digits:
                            for seventh_char in letters + digits:
                                for eighth_char in letters + digits:
                                    password = first_char + second_char + third_char + fourth_char + fifth_char + sixth_char + seventh_char + eighth_char
                                    if any(char.isdigit() for char in password):
                                        password_count += 1

    return password_count

num_passwords = calculate_passwords()
print(num_passwords) 

