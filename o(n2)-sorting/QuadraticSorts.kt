package com.example.myapplication.example

import java.util.concurrent.ThreadLocalRandom

fun main() {
//    val list = intArrayOf(2, 4, 5, 6, 1, 3)
    val a = ThreadLocalRandom.current().let { random ->
        (0..100000).map { random.nextInt(100000) }.toIntArray()
    }
    val startTime = System.currentTimeMillis()
//    insertionSort(a)
    insertionSortUsingBinarySearch(a)
    val totalTime = System.currentTimeMillis() - startTime
    println("total time: $totalTime ms")
    printList(a)

    val size = a.size
    println("size of list : $size")
}

fun selectionSort(list: IntArray) {
    val size = list.size - 1
    for (i in list.indices) {
        var minI = i
        for (j in i + 1 until size) {
            if (list[minI] > list[j]) {
                minI = j
            }
        }
        if (minI != i) {
            swap(list, minI, i)
        }
    }
}

fun swap(list: IntArray, first: Int, second: Int) {
    list[first] = list[first] xor list[second]
    list[second] = list[second] xor list[first]
    list[first] = list[first] xor list[second]

}

fun insertionSort(list: IntArray) {
    val size = list.size
    for (i in 1 until size) {
        val key = list[i]
        var j = i - 1
        while (j >= 0 && list[j] > key) {
            list[j + 1] = list[j]
            --j
        }
        list[j + 1] = key
    }
}

fun insertionSortUsingBinarySearch(list: IntArray) {
    val size = list.size
    for (i in 1 until size) {
        val key = list[i]
        var j = i - 1
        val index = binSearch(key, list, l = 0, r = i - 1)
        while (j >= index) {
            list[j + 1] = list[j]
            j--
        }
        list[index] = key
    }
}

fun binSearch(key: Int, list: IntArray, l: Int, r: Int): Int {
    var left = l
    var right = r
    while (left <= right) {
        var mid = left + (right - left) / 2
        if (list[mid] == key) {
            return mid
        }
        if (key < list[mid]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

fun bubbleSort(list: IntArray) {
    //assume array is sorted
    var shouldContinue = true
    for (i in 0 until list.size - 1) {
        if (list[i] > list[i + 1]) {
            //swapping without third valuable
            // but for large integers may produces overflow
            list[i] = list[i] + list[i + 1]
            list[i + 1] = list[i] - list[i + 1]
            list[i] = list[i] - list[i + 1]
            shouldContinue = false
        }

        if (!shouldContinue) {
            bubbleSort(list)
        }
    }
}

fun printList(list: IntArray) {
    list.forEach { print("$it ") }
    println()
}
