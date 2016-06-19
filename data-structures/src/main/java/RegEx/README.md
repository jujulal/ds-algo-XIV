http://www.careercup.com/question?id=62221
Identify the regular expression in a given string such that the pattern does not repeat. 
For example, to identify the pattern 'foo' only once in an input; 'jhkh(foo)jkkj' should be identified, 'kjh(foo)aaaaa(foo)' should not be.

ans : (.*)(foo)(.*)(fo[^o])(.*)


http://www.careercup.com/question?id=16388662
Given a file using regex find all the ip address in a text file.

\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}
  (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b

Greedy quantifiers
X?	X, once or not at all

Special constructs (named-capturing and non-capturing)
(?:X)	X, as a non-capturing group

eg. ([0-9]+)(?:st|nd|rd|th)?
That will match numbers in the form 1, 2, 3... or in the form 1st, 2nd, 3rd,... but it will only capture the numeric part.

http://stackoverflow.com/a/3512530/432903


^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}
 (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$

https://www.safaribooksonline.com/library/view/regular-expressions-cookbook/9780596802837/ch07s16.html

^(?:[0-9]{1,3}\.){3}
 [0-9]{1,3}$

Boundary matchers
$	The end of a line (in linux terminal, Shift+$ makes you go to the end of line)

Predefined character classes
.	Any character (may or may not match line terminators)

References
--------------

http://www.careercup.com/question?id=16388662#stq=regex&stp=6

