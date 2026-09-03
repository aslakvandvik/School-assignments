def quick_sort(arr):
    if len(arr) < 2:
        return arr

    pivot = arr[0]
    left = [i for i in arr[1:] if i <= pivot]
    right = [i for i in arr[1:] if i > pivot]

    return quick_sort(left) + [pivot] + quick_sort(right)


# Testing
music_count = [156, 141, 35, 94, 88, 61, 111]
music_sorted = quick_sort(music_count)

print(music_sorted)
