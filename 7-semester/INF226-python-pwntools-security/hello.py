from pwn import *

context.log_level = 'debug'

io = remote('inf226.puffling.no', 6001)

print(str(io.recvline(), 'utf8'))   # "Please enter the secret sign"
io.sendline(b'infA')                # secret sign

print(str(io.recvline(), 'utf8'))   # "Rumors say that a hacker can complete..."

for i in range(1024):
    question = io.recvuntil(b'?', drop=True).decode()  # e.g. "1359 + 1516 = "
    expr = question.split('=')[0].strip()               # "1359 + 1516"
    answer = safeeval.expr(expr)
    io.sendline(str(answer).encode())

print(io.recvall(timeout=5).decode())