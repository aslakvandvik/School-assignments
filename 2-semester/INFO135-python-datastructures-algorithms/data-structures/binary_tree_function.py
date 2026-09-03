# Way more simple than creating a class for a binary tree
def binary_tree(r):
    return [r, [], []]

def get_left_child(root):
    return root[1]

def get_right_child(root):
    return root[2]

def insert_left_child(root, new_branch):
    t = root.pop(1)
    if len(t) > 1:
        root.insert(1, [new_branch, t, []])
    else:
        root.insert(1, [new_branch, [], []])
    return root

def insert_right_child(root, new_branch):
    t = root.pop(2)
    if len(t) > 1:
        root.insert(2, [new_branch, [], t])
    else:
        root.insert(2, [new_branch, [], []])
    return root

my_tree = binary_tree('a')

insert_left_child(my_tree, 'b')
insert_right_child(my_tree, 'c')

insert_left_child(get_left_child(my_tree), 'd')
insert_right_child(get_left_child(my_tree), 'e')

print(my_tree)