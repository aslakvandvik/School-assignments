def selection_sort(arr):
    size = len(arr)
    for pass_num in range(size):
        min_index = pass_num

        for i in range(pass_num + 1, size):
            if arr[i] < arr[min_index]:
                min_index = i

        temp = arr[pass_num]
        arr[pass_num] = arr[min_index]
        arr[min_index] = temp
