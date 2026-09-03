"""Exercise 1
Write a function that performs exactly one pass of selection sort on any given list of
integers.
Example:
selection_sort_one_pass([5, 2, 3, 4, 0, 1])
>>> [0, 2, 3, 4, 5, 1]"""


def selection_sort_one_pass(arr):
    min_index = 0
    # Find the minimum element in the array
    for i in range(1, len(arr)):
        if arr[i] < arr[min_index]:
            min_index = i

    # Swap the minimum element with the first element
    arr[0], arr[min_index] = arr[min_index], arr[0]

    return arr


array = [5, 2, 3, 4, 0, 1]
print(array)
print(selection_sort_one_pass(array))

"""Exercise 2
The file large_list.py contains a list of 104.6 tuples each containing 3 numbers. Write an
algorithm that iterates through each tuple and creates a new list containing each tuple
where the sum of index 0 and 1 equal index 2.
Sort the new list containing only valid tuples so that the last elements of the tuples are in
ascending order. Use a sorting algorithm of your choice.
Example:
>>> tuples = [(0,0,1), (0,1,1), (0,1,2), (1,1,2), (1,2,3)]
>>> tuples = filter_tuples(tuples)
>>> selection_sort(tuples)
> [(0,1,1), (1,1,2), (1,2,3)]"""

from large_list import liste
import time

start_time = time.time()

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        merge_sort(left)
        merge_sort(right)

        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1
        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1


def filter_tuples(arr):
    new_list = []
    for i in arr:
        if i[0] + i[1] == i[2]:
            new_list.append(i)
    return new_list

tuples = filter_tuples(liste)
merge_sort(tuples)
print(tuples)
end_time = time.time()
print("Runtime: ", end_time - start_time, "seconds")
