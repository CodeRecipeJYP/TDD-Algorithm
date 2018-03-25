

def str2int_array(string):
    splitted = string.split(" ")
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(w, h):
    return [[0 for x in range(w)] for y in range(h)]


def roll_gears():
    return []


def sum_gear_scores():
    return 0


def main():
    initial_gear_states = []
    roll_methods = []
    final_gear_states = roll_gears(initial_gear_states, roll_methods)
    print(sum_gear_scores(final_gear_states))


if __name__ == '__main__':
    main()
