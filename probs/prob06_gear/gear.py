

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


def main():
    initial_gear_states = empty_2darr(4, 8)
    print(initial_gear_states[3][7])

    roll_methods = []
    final_gear_states = roll_gears(initial_gear_states, roll_methods)
    print(sum_gear_scores(final_gear_states))


if __name__ == '__main__':
    main()
