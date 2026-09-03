def heap_sort(arr):     
    size = len(arr)

    for i in range(size, 0, -1):    # Build a max heap
        heapify(arr, size, i)

    for i in range(size - 1, 0 , -1):   # Swap the first and last element
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

def heapify(arr, n, i):     # Heapify the array
    maximum = i     # Initialize the largest element as the root
    left = 2 * i + 1        
    right = 2 * i + 2

    if left < n and arr[i] < arr[left]:   # If the left child is larger than the root,  set the largest element as the left child
        maximum = left

    if right < n and arr[maximum] < arr[right]:  # If the right child is larger than the root, set the largest element as the right child
        maximum = right

    if maximum != i:    # If the largest element is not the root, swap the largest element with the root
        arr[i], arr[maximum] = arr[maximum], arr[i]

        heapify(arr, n, maximum) 
    
my_array = [100, 84, 71, 60, 23, 12, 29, 1, 37, 4]
heap_sort(my_array)
print(my_array)