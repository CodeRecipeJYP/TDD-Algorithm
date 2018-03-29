

def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def sum_2darr(arr):
    result = 0
    for each_row in arr:
        result += sum(each_row)

    return result


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def copy_2darr(arr):
    copy = []
    for each in arr:
        copy.append(each.copy())

    return copy


RESULT_IMPOSSIBLE = -1
STATE_UNRIPE = 0
STATE_RIPEN = 1
STATE_RIPEN_CANNOT_AFFECT_OTHERS = 2


def get_days_everytomato_gonnabe_ripen(tomato_map):
    elapsed_days = 0

    while True:
        will_be_ripen_tomatos = get_will_be_ripen_tomatos(tomato_map)

        if len(will_be_ripen_tomatos) == 0:
            if is_everytomato_ripen(tomato_map):
                break
            else:
                return RESULT_IMPOSSIBLE

        tomato_map = update_ripen_tomatos(tomato_map, will_be_ripen_tomatos)
        elapsed_days += 1

    return elapsed_days


def update_ripen_tomatos(tomato_map, will_be_ripen_tomatos):
    return tomato_map


def is_everytomato_ripen(tomato_map):
    return False


def get_will_be_ripen_tomatos(tomato_map):
    will_be_ripen_tomatos = []
    row_count = len(tomato_map)
    col_count = len(tomato_map[0])

    for row_idx in range(row_count):
        for col_idx in range(col_count):
            if tomato_map[row_idx][col_idx] == STATE_RIPEN:
                around_tomatos_will_be_ripen =\
                    get_around_tomatos_will_be_ripen(tomato_map,
                                                     [row_idx, col_idx])

                if len(around_tomatos_will_be_ripen) == 0:
                    tomato_map[row_idx][col_idx] =\
                        STATE_RIPEN_CANNOT_AFFECT_OTHERS
                else:
                    will_be_ripen_tomatos += around_tomatos_will_be_ripen

    return will_be_ripen_tomatos


def get_around_tomatos_will_be_ripen(given_map, tomato):
    results = []
    row_idx, col_idx = tomato

    if row_idx > 0 and given_map[row_idx - 1][col_idx] == STATE_UNRIPE:
        results.append([row_idx - 1, col_idx])

    if col_idx < (len(given_map[0]) - 1) \
            and given_map[row_idx][col_idx + 1] == STATE_UNRIPE:
        results.append([row_idx, col_idx + 1])

    if row_idx < (len(given_map) - 1) \
            and given_map[row_idx + 1][col_idx] == STATE_UNRIPE:
        results.append([row_idx + 1, col_idx])

    if col_idx > 0 and given_map[row_idx][col_idx - 1] == STATE_UNRIPE:
        results.append([row_idx, col_idx - 1])

    return results


def main():
    col_count, row_count = str2int_array(input())
    tomato_map = empty_2darr(row_count, 1)

    for row_idx in range(row_count):
        tomato_map[row_idx] = str2int_array(input())

    print(get_days_everytomato_gonnabe_ripen(tomato_map))


if __name__ == '__main__':
    main()
