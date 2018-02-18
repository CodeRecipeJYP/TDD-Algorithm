from array import array
from functools import reduce

from prob02_algospot_pi.pi_integratedLevel import integratedLevel


INF = 9999


def minimumLevel(numbers):
    # print("numbers=" + numbers)
    localOptimal = []
    for idx in range(0, len(numbers) + 1):
        localOptimal.append(0)

    localOptimal[0] = 0
    localOptimal[1] = INF
    localOptimal[2] = INF
    localOptimal[3] = integratedLevel(numbers[:3], 3)

    # vs integratedLevel(numbers[:4], 3) + localOptimal[4-3]
    localOptimal[4] = integratedLevel(numbers[:4], 4) + localOptimal[4-4]
    # vs integratedLevel(numbers[:4], 5) + localOptimal[4-5]

    # vs integratedLevel(numbers[:5], 3) + localOptimal[5-3]
    # vs integratedLevel(numbers[:5], 4) + localOptimal[5-4]
    localOptimal[5] = integratedLevel(numbers[:5], 5)

    for idx in range(6, len(numbers) + 1):
        minimum = INF
        for sublength in [3, 4, 5]:
            candidate = integratedLevel(numbers[:idx], sublength) + localOptimal[idx - sublength]
            if minimum > candidate:
                minimum = candidate


        localOptimal[idx] = minimum
        # print("localOptimal= " + str(minimum))

    return localOptimal[-1]

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

    flag = True
    for each in numbersAsIntArr[2:]:
        if (buff - diff) != each:
            flag = False
            break

        buff = each
        diff = -diff

    return flag

def arithmeticSequence(numbers: str):
    numbersAsIntArr = asIntArr(numbers)

    buff = numbersAsIntArr[1]
    diff = buff - numbersAsIntArr[0]

    flag = True
    for each in numbersAsIntArr[2:]:
        if (buff + diff) != each:
            flag = False
            break

        buff = each

    return flag

def subArithmeticSequence(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, arithmeticSequence)

#todo refactor increase+decrease in one time
def subSimpleIncrease(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, simpleIncrease)

def subSimpleDecrease(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, simpleDecrease)

def subPredicate(numbers: str, sublength:int, predicater):
    return predicater(numbers[-sublength:])

def subRotate(numbers: str, sublength: int):
    return subPredicate(numbers, sublength, rotate)