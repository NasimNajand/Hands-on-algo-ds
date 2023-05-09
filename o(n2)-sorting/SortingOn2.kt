{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;\f1\fmodern\fcharset0 Courier-Oblique;\f2\fmodern\fcharset0 Courier-Bold;
}
{\colortbl;\red255\green255\blue255;\red191\green100\blue38;\red32\green32\blue32;\red153\green168\blue186;
\red254\green187\blue91;\red109\green109\blue109;\red86\green132\blue173;\red88\green118\blue71;\red133\green96\blue154;
\red55\green101\blue209;}
{\*\expandedcolortbl;;\csgenericrgb\c74902\c39216\c14902;\csgenericrgb\c12549\c12549\c12549;\csgenericrgb\c60000\c65882\c72941;
\csgenericrgb\c99608\c73333\c35686;\csgenericrgb\c42745\c42745\c42745;\csgenericrgb\c33725\c51765\c67843;\csgenericrgb\c34510\c46275\c27843;\csgenericrgb\c52157\c37647\c60392;
\csgenericrgb\c21569\c39608\c81961;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs26 \cf2 \cb3 import \cf4 java.util.concurrent.ThreadLocalRandom\
\
\cf2 fun \cf5 main\cf4 () \{\
\cf6 //    val list = intArrayOf(2, 4, 5, 6, 1, 3)\
    \cf2 val \cf4 a = ThreadLocalRandom.current().
\f1\i \cf5 let 
\f2\i0\b \cf4 \{ 
\f0\b0 random 
\f2\b ->\
        
\f0\b0 (\cf7 0\cf4 ..\cf7 100000\cf4 ).
\f1\i \cf5 map 
\f2\i0\b \cf4 \{ 
\f0\b0 random.nextInt(\cf7 100000\cf4 ) 
\f2\b \}
\f0\b0 .
\f1\i \cf5 toIntArray
\f0\i0 \cf4 ()\
    
\f2\b \}\
    
\f0\b0 \cf2 val \cf4 startTime = System.currentTimeMillis()\
\cf6 //    insertionSort(a)\
    
\f1\i \cf4 insertionSortUsingBinarySearch
\f0\i0 (a)\
    \cf2 val \cf4 totalTime = System.currentTimeMillis() - startTime\
    
\f1\i println
\f0\i0 (\cf8 "total time: \cf2 $\cf4 totalTime\cf8  ms"\cf4 )\
    
\f1\i printList
\f0\i0 (a)\
\
    \cf2 val \cf4 size = a.\cf9 size\
    
\f1\i \cf4 println
\f0\i0 (\cf8 "size of list : \cf2 $\cf4 size\cf8 "\cf4 )\
\}\
\
\
\cf2 fun \cf5 selectionSort\cf4 (list: IntArray) \{\
    \cf2 val \cf4 size = list.\cf9 size \cf4 - \cf7 1\
    \cf2 for \cf4 (i \cf2 in \cf4 list.
\f1\i \cf9 indices
\f0\i0 \cf4 ) \{\
        \cf2 var \cf4 minI = i\
        \cf2 for \cf4 (j \cf2 in \cf4 i + \cf7 1 
\f1\i \cf5 until 
\f0\i0 \cf4 size) \{\
            \cf2 if \cf4 (list[minI] > list[j]) \{\
                minI = j\
            \}\
        \}\
        \cf2 if \cf4 (minI != i) \{\
            
\f1\i swap
\f0\i0 (list\cf2 , \cf4 minI\cf2 , \cf4 i)\
        \}\
    \}\
\}\
\
\cf2 fun \cf5 swap\cf4 (list: IntArray\cf2 , \cf4 first: Int\cf2 , \cf4 second: Int) \{\
    list[first] = list[first] xor list[second]\
    list[second] = list[second] xor list[first]\
    list[first] = list[first] xor list[second]\
\
\}\
\
\cf2 fun \cf5 insertionSort\cf4 (list: IntArray) \{\
    \cf2 val \cf4 size = list.\cf9 size\
    \cf2 for \cf4 (i \cf2 in \cf7 1 
\f1\i \cf5 until 
\f0\i0 \cf4 size) \{\
        \cf2 val \cf4 key = list[i]\
        \cf2 var \cf4 j = i - \cf7 1\
        \cf2 while \cf4 (j >= \cf7 0 \cf4 && list[j] > key) \{\
            list[j + \cf7 1\cf4 ] = list[j]\
            --j\
        \}\
        list[j + \cf7 1\cf4 ] = key\
    \}\
\}\
\
\cf2 fun \cf5 insertionSortUsingBinarySearch\cf4 (list: IntArray) \{\
    \cf2 val \cf4 size = list.\cf9 size\
    \cf2 for \cf4 (i \cf2 in \cf7 1 
\f1\i \cf5 until 
\f0\i0 \cf4 size) \{\
        \cf2 val \cf4 key = list[i]\
        \cf2 var \cf4 j = i - \cf7 1\
        \cf2 val \cf4 index = 
\f1\i binSearch
\f0\i0 (key\cf2 , \cf4 list\cf2 , \cf10 l = \cf7 0\cf2 , \cf10 r = \cf4 i - \cf7 1\cf4 )\
        \cf2 while \cf4 (j >= index) \{\
            list[j + \cf7 1\cf4 ] = list[j]\
            j--\
        \}\
        list[index] = key\
    \}\
\}\
\
\cf2 fun \cf5 binSearch\cf4 (key: Int\cf2 , \cf4 list: IntArray\cf2 , \cf4 l: Int\cf2 , \cf4 r: Int): Int \{\
    \cf2 var \cf4 left = l\
    \cf2 var \cf4 right = r\
    \cf2 while \cf4 (left <= right) \{\
        \cf2 var \cf4 mid = left + (right - left) / \cf7 2\
        \cf2 if \cf4 (list[mid] == key) \{\
            \cf2 return \cf4 mid\
        \}\
        \cf2 if \cf4 (key < list[mid]) \{\
            right = mid - \cf7 1\
        \cf4 \} \cf2 else \cf4 \{\
            left = mid + \cf7 1\
        \cf4 \}\
    \}\
    \cf2 return \cf4 left\
\}\
\
\cf2 fun \cf5 bubbleSort\cf4 (list: IntArray) \{\
    \cf6 //assume array is sorted\
    \cf2 var \cf4 shouldContinue = \cf2 true\
    for \cf4 (i \cf2 in \cf7 0 
\f1\i \cf5 until 
\f0\i0 \cf4 list.\cf9 size \cf4 - \cf7 1\cf4 ) \{\
        \cf2 if \cf4 (list[i] > list[i + \cf7 1\cf4 ]) \{\
            \cf6 //swapping without third valuable\
            // but for large integers may produces overflow\
            \cf4 list[i] = list[i] + list[i + \cf7 1\cf4 ]\
            list[i + \cf7 1\cf4 ] = list[i] - list[i + \cf7 1\cf4 ]\
            list[i] = list[i] - list[i + \cf7 1\cf4 ]\
            shouldContinue = \cf2 false\
        \cf4 \}\
\
        \cf2 if \cf4 (!shouldContinue) \{\
            
\f1\i bubbleSort
\f0\i0 (list)\
        \}\
    \}\
\}\
\
\cf2 fun \cf5 printList\cf4 (list: IntArray) \{\
    list.
\f1\i \cf5 forEach 
\f2\i0\b \cf4 \{ 
\f1\i\b0 print
\f0\i0 (\cf8 "\cf2 $
\f2\b \cf4 it 
\f0\b0 \cf8 "\cf4 ) 
\f2\b \}\
    
\f1\i\b0 println
\f0\i0 ()\
\}\
}