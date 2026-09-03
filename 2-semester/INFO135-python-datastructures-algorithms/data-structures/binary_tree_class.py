class Binarytree:
    def __init__(self, value):
        self.value = value
        self.left_child = None
        self.right_child = None
    
    def insert_left(self, value):
        if self.left_child is None:
            self.left_child = Binarytree(value)
        else:
            new_node = Binarytree(value)
            new_node.left_child = self.left_child
            self.left_child = new_node

    def insert_right(self, value):
        if self.right_child is None:
            self.right_child = Binarytree(value)
        else:
            new_node = Binarytree(value)
            new_node.right_child = self.right_child
            self.right_child = new_node

    def search(self, value):
        if self.value == value:
            return True
        if self.left_child and self.left_child.search(value):
            return True
        if self.right_child and self.right_child.search(value):
            return True
        return False
    
    def print_tree(self, level = 0):
        print(' ' * level * 2 + str(self.value))
        if self.left_child is not None:
            self.left_child.print_tree(level + 1)
        if self.right_child is not None:
            self.right_child.print_tree(level + 1)
            
book = Binarytree('Book')
book.insert_left('Chapter 1')
book.insert_right('Chapter 2')

node_chap1 = book.left_child
node_chap1.insert_left('Section 1.1')
node_chap1.insert_right('Section 1.2')

node_chap2 = book.right_child
node_chap2.insert_left('Section 2.1')

node_sec1_2 = node_chap1.right_child
node_sec1_2.insert_left('Section 1.2.1')

book.print_tree()

print('Section 1.2 exists?', book.search('Section 1.2'))
print('Section 2.2 exists?', book.search('Section 2.2'))
      