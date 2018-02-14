from prob02_algospot_pi.pi import *


def integratedLevel(numbers: str, sublength: int):
    if (subSameNumber(numbers, sublength)):
        return 1

    if (subSimpleIncrease(numbers, sublength)):
        return 2

    if (subSimpleDecrease(numbers, sublength)):
        return 2

    if (subRotate(numbers, sublength)):
        return 4

    if (subArithmeticSequence(numbers, sublength)):
        return 5

    return 10