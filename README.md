# Small RegExp Engine 

Implementation of Thompson NFA 
 
# Supported features

 1. '^a' not 'a'
 2. 'a?' maybe 'a'
 3. 'a+' one or more 'a'
 4. 'a*' zero or more 'a'
 5. '[09]' '[aZ]' '[0z]' ... any symbol in range 
 6. '(a)' 
 7. 'abc' sequence of symbols
 8. '.' any symbol
 
# Api

```$xslt
"aab".match("aab")
true

"aab".match("aab")
false
```

```$xslt
"aab".matchInside("aab")
true

"aab".matchInside("aab")
true
```

```$xslt
"aabb".findFirst("ab+")
ab
```

```$xslt
"aabb".findLast("ab+")
abb
```

```$xslt
"ab  ab a      b".patternSplit(" +")
listOf("ab","ab","a","b")
```