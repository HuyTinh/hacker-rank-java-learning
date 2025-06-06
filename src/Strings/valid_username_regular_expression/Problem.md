You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:

*   The username consists of to characters inclusive. If the username consists of less than or greater than characters, then it is an invalid username.
*   The username can only contain alphanumeric characters and underscores (`_`). Alphanumeric characters describe the character set consisting of _lowercase_ characters , _uppercase_ characters , and digits .
*   The _first_ character of the username must be an _alphabetic_ character, i.e., either _lowercase_ character or _uppercase_ character .

For example:

| Username | Validity |
| --- | --- |
|     | INVALID; Username length < 8 characters |
|     | VALID |
|     | VALID |
|     | INVALID; Username begins with non-alphabetic character |
|     | INVALID; '?' character not allowed |

Update the value of _regularExpression_ field in the _UsernameValidator_ class so that the regular expression only matches with valid usernames.

**Input Format**

The first line of input contains an integer , describing the total number of usernames. Each of the next lines contains a string describing the username. The locked stub code reads the inputs and validates the username.

**Constraints**

*   The username consists of any printable characters.

**Output Format**

For each of the usernames, the locked stub code prints `Valid` if the username is valid; otherwise `Invalid` each on a new line.

**Sample Input 0**

8
Julia
Samantha
Samantha\_21
1Samantha
Samantha?10\_2A
JuliaZ007
Julia@007
\_Julia007

**Sample Output 0**

Invalid
Valid
Valid
Invalid
Invalid
Valid
Invalid
Invalid

**Explanation 0**

Refer diagram in the challenge statement.