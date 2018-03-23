def plus(a, b):
    return a+b


def decode_with_encodeds(encoded_arr1, encoded_arr2):
    result = []

    for idx, eachline in enumerate(encoded_arr1):
        result.append(decode_with_singleline(eachline, encoded_arr2[idx]))


    return result

def decode_with_singleline(line1, line2):
    result = ""
    for idx, each in enumerate(line1):
        result += "#" if each == "#" or line2[idx] == "#" else " "

    return result


def decode(n, arr1, arr2):
    encoded_arr1 = encode_all(arr1, n)
    encoded_arr2 = encode_all(arr2, n)
    return decode_with_encodeds(encoded_arr1, encoded_arr2)


def encode_singleline(decimal, n = 5):
    result = ""
    for idx in range(n, 0, -1):
        result += "#" if int((decimal % (2**idx)) / (2**(idx-1))) else " "


    return result

def encode_all(decimals, n = 5):

    result = list()
    for decimal in decimals:
        result.append(encode_singleline(decimal, n))

    return result
