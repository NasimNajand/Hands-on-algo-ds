{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fmodern\fcharset0 Courier;\f1\fmodern\fcharset0 Courier-Oblique;\f2\fmodern\fcharset0 Courier-Bold;
}
{\colortbl;\red255\green255\blue255;\red153\green168\blue186;\red32\green32\blue32;\red191\green100\blue38;
\red254\green187\blue91;\red86\green132\blue173;\red109\green109\blue109;\red133\green96\blue154;\red88\green118\blue71;
}
{\*\expandedcolortbl;;\csgenericrgb\c60000\c65882\c72941;\csgenericrgb\c12549\c12549\c12549;\csgenericrgb\c74902\c39216\c14902;
\csgenericrgb\c99608\c73333\c35686;\csgenericrgb\c33725\c51765\c67843;\csgenericrgb\c42745\c42745\c42745;\csgenericrgb\c52157\c37647\c60392;\csgenericrgb\c34510\c46275\c27843;
}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0

\f0\fs26 \cf2 \cb3 \
\cf4 fun \cf5 main\cf2 () \{\
    \cf4 val \cf2 list = 
\f1\i arrayListOf
\f0\i0 (\cf6 5\cf4 ,\cf6 4\cf4 ,\cf6 3\cf4 ,\cf6 2\cf4 ,\cf6 1\cf4 ,\cf6 20\cf4 ,\cf6 6\cf4 ,\cf6 12\cf4 ,\cf2 -\cf6 100\cf2 )\
    
\f1\i sort
\f0\i0 (list)\
    
\f1\i printList
\f0\i0 (list)\
\}\
\
\cf4 fun \cf5 sort\cf2 (list: ArrayList<Int>) \{\
    \cf7 //assume array is sorted\
    \cf4 var \cf2 shouldContinue = \cf4 true\
    for \cf2 (i \cf4 in \cf6 0 
\f1\i \cf5 until 
\f0\i0 \cf2 list.\cf8 size\cf2 -\cf6 1\cf2 ) \{\
        \cf4 if \cf2 (list[i] > list[i+\cf6 1\cf2 ]) \{\
            \cf7 //swapping without third valuable\
            \cf2 list [i] = list[i] + list[i+\cf6 1\cf2 ]\
            list[i+\cf6 1\cf2 ] = list [i] - list[i+\cf6 1\cf2 ]\
            list [i] = list[i] - list[i+\cf6 1\cf2 ]\
            shouldContinue = \cf4 false\
        \cf2 \}\
\
        \cf4 if \cf2 (!shouldContinue) \{\
            
\f1\i sort
\f0\i0 (list)\
        \}\
    \}\
\}\
\
\cf4 fun \cf5 printList\cf2 (list: ArrayList<Int>) \{\
    list.
\f1\i \cf5 forEach 
\f2\i0\b \cf2 \{ 
\f1\i\b0 print
\f0\i0 (\cf9 "\cf4 $
\f2\b \cf2 it 
\f0\b0 \cf9 "\cf2 ) 
\f2\b \}\

\f0\b0 \}\
}