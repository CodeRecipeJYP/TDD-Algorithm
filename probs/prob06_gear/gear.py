

def str2digit_array(string):
    int_array = []
    for each in string:
        int_array.append(int(each))

    return int_array


def str2int_array(string):
    splitted = string.split(" ")
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def roll_gears(gear_states, roll_methods):
    return []


def sum_gear_scores(gear_states):
    return 0


GEAR_COUNT = 4


def main():
    initial_gear_states = []
    for _ in range(GEAR_COUNT):
        initial_gear_states.append(str2digit_array(input()))

    method_count = int(input())
    roll_methods = []

    for _ in range(method_count):
        roll_methods.append(str2int_array(input()))

    final_gear_states = roll_gears(initial_gear_states, roll_methods)
    print(sum_gear_scores(final_gear_states))


if __name__ == '__main__':
    main()
