# Grade

### Conditions of the problem
There is an expression given by a string, for example:
`y / 5 + (6 - x) * 2 - 1`
Restrictions:
- there can only be digit characters and `-`, `+`, `*`, `/`, `(`, `)`
- variable names consist of the 1st latin letter
- the operation is not reducible (there is no such that `x (2 + y) => x * (2 + y)`)
- no unary minus

Output the value of the expression for the given values of the variables.
