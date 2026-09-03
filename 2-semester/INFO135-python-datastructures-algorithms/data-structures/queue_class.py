class Queue:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.items.pop(0)

    def size(self):
        return len(self.items)


# Building a queue

my_queue = Queue()
my_queue.enqueue(1)
my_queue.enqueue(2)
my_queue.enqueue(3)
my_queue.enqueue(4)

print("Size of the queue: ", my_queue.size())
print("First element:", my_queue.dequeue())
print("Second element:", my_queue.dequeue())
print("Third element:", my_queue.dequeue())
