
def minimum_level(numbers):


    return 0

def sameNumber(numbers):
    first = numbers[0]
    sameFlag = True
    for each in numbers[1:]:
        if each != first:
            sameFlag = False
            break

    return sameFlag

def subSameNumber(numbers: str, sublength):
    return sameNumber(numbers[-sublength:])

def simpleIncrease(numbers):
    buff = numbers[0]
    flag = True
    for each in numbers[1:]:
        if int(each) != (int(buff) + 1):
            flag = False
            break

        buff = each

    return flag

def simpleDecrease(numbers):
    buff = numbers[0]
    flag = True
    for each in numbers[1:]:
        if int(each) != (int(buff) - 1):
            flag = False
            break

        buff = each

    return flag