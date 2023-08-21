def isPalindrome(x: int) -> bool:
    x_str = str(x)
    x_str = x_str[::-1]
    return str(x) == x_str


test = isPalindrome(-121)
print(test)
