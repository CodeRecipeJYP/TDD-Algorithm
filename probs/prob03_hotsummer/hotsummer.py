

"""
3
90
10 10 10 10 10 10 10 10 10
1000
77 77 70 11 34 35 41 83 54
50
10 20 30 40 50 60 50 40 30
"""


def str2int_array(string):
    splitted = string.split(" ")
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def main():
    count_cases = int(input())

    given_cases_limit = [0] * count_cases
    given_cases_usage = [0] * count_cases

    for case_idx in range(0, count_cases):
        given_cases_limit[case_idx] = int(input())
        given_cases_usage[case_idx] = str2int_array(input())

    for case_idx in range(0, count_cases):
        print(is_lower_than_or_equal_to_limit(given_cases_limit[case_idx],
                                              given_cases_usage[case_idx]))


def is_lower_than_or_equal_to_limit(limit, usage):
    if limit >= sum(usage):
        return "YES"
    else:
        return "NO"


if __name__ == '__main__':
    main()
