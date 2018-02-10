
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

def subSameNumber(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, sameNumber)

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

def asIntArr(numbers: str):
    numbersAsIntArr = []
    for each in numbers:
        numbersAsIntArr.append(int(each))

    return numbersAsIntArr

def rotate(numbers: str):
    numbersAsIntArr = asIntArr(numbers)

    buff = numbersAsIntArr[1]
    diff = buff - numbersAsIntArr[0]
    if abs(diff) != 1:
        return False

    flag = True
    for each in numbersAsIntArr[2:]:
        if (buff - diff) != each:
            flag = False
            break

        buff = each
        diff = -diff

    return flag


#todo refactor increase+decrease in one time
def subSimpleIncrease(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, simpleIncrease)

def subSimpleDecrease(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, simpleDecrease)

def subPredicate(numbers: str, sublength:int, predicater):
    return predicater(numbers[-sublength:])

def subRotate(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, rotate)