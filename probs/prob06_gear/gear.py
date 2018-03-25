

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


def roll_once(gear, roll_direction):
    rolled_gear = gear.copy()
    length = len(gear)
    for idx, val in enumerate(gear):
        new_idx = (idx + roll_direction) % length
        rolled_gear[new_idx] = gear[idx]

    return rolled_gear


def number2idx(number):
    return number - 1


def roll_gear(gear_states, roll_method):
    result_gear_states = gear_states.copy()
    gear_idx = number2idx(roll_method[0])
    roll_direction = roll_method[1]
    will_be_rolled_stack = []
    will_be_rolled_stack.append([gear_idx, roll_direction])

    right_rolling_idx = gear_idx
    curr_roll_direction = roll_direction
    while True:
        right_rolling_idx = right_rolling_idx + 1
        curr_roll_direction = -curr_roll_direction
        if right_rolling_idx == GEAR_COUNT:
            break

        origin = gear_states[right_rolling_idx-1][2]
        dest = gear_states[right_rolling_idx][6]

        if origin != dest:
            will_be_rolled_stack.append(
                [right_rolling_idx, curr_roll_direction])

    left_rolling_idx = gear_idx
    curr_roll_direction = roll_direction
    while True:
        left_rolling_idx = left_rolling_idx - 1
        curr_roll_direction = -curr_roll_direction
        if left_rolling_idx == -1:
            break

        origin = gear_states[left_rolling_idx + 1][6]
        dest = gear_states[left_rolling_idx][2]

        if origin == dest:
            break
        else:
            will_be_rolled_stack.append(
                [right_rolling_idx, curr_roll_direction])

    for each_roll in will_be_rolled_stack:
        idx = each_roll[0]
        direction = each_roll[1]
        result_gear_states[idx] = \
            roll_once(result_gear_states[idx], direction)

    return result_gear_states


def roll_gears(gear_states, roll_methods):
    result_gear_states = []

    for each_method in roll_methods:
        result_gear_states = roll_gear(gear_states, each_method)

    return result_gear_states


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
