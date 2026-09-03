def bubble_sort(arr):
    size = len(arr)
    for i in range(size):
        for j in range(0, size - i - 1):
            if arr[j] > arr[j + 1]:
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp


# Testing
music_count = [156, 141, 35, 94, 88, 61, 111]
bubble_sort(music_count)
print(music_count)
