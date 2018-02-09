
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

def subSameNumber(numbers, sublength):
    pass