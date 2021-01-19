#Concatenates words if Divisible
#returns the value if the number isnt divisible
def CheckNumber(number):
    temp = ""
    if IsDivisible(number,3): temp += "Fizz"
    if IsDivisible(number,5): temp += "Buzz"
    return temp if temp!="" else number

#checks if number is divisible
def IsDivisible(number, denominator):
    return True if number%denominator == 0 else False

for number in range(1,100):
    print(CheckNumber(number))