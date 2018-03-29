

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
    return []


def get_around_tomatos_will_be_ripen(tomato_map, tomato):
    return []


def main():
    col_count, row_count = str2int_array(input())
    tomato_map = empty_2darr(row_count, 1)

    for row_idx in range(row_count):
        tomato_map[row_idx] = str2int_array(input())

    print(get_days_everytomato_gonnabe_ripen(tomato_map))


if __name__ == '__main__':
    main()
