

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


def get_adjacent_count(iceberg_map, row_idx, col_idx):
    count = 0
    if row_idx > 0 and iceberg_map[row_idx - 1][col_idx] == 0:
        count += 1

    if col_idx < (len(iceberg_map[0]) - 1)\
            and iceberg_map[row_idx][col_idx + 1] == 0:
        count += 1

    if row_idx < (len(iceberg_map) - 1)\
            and iceberg_map[row_idx + 1][col_idx] == 0:
        count += 1

    if col_idx > 0 and iceberg_map[row_idx][col_idx - 1] == 0:
        count += 1

    return count


def execute_melt(iceberg_map):
    map_as_local_variable = copy_2darr(iceberg_map)
    row_count = len(iceberg_map)
    col_count = len(iceberg_map[0])
    will_be_melted_stack = []

    for row_idx in range(row_count):
        for col_idx in range(col_count):
            if map_as_local_variable[row_idx][col_idx] == 0:
                continue

            will_be_melted_stack.append([
                    get_adjacent_count(map_as_local_variable,
                                       row_idx,
                                       col_idx),
                    row_idx,
                    col_idx])

    for count, row_idx, col_idx in will_be_melted_stack:
        map_as_local_variable[row_idx][col_idx] =\
            max(0, map_as_local_variable[row_idx][col_idx] - count)

    return map_as_local_variable


def get_first_iceberg(iceberg_map):
    for row_idx, each_row in enumerate(iceberg_map):
        for col_idx, each in enumerate(each_row):
            if each != 0:
                return [row_idx, col_idx]

    assert False, "Do not call this function, when sum_2darr(iceberg_map) == 0"


def get_separated_count(iceberg_map):
    map_as_local_variable = copy_2darr(iceberg_map)
    row_count = len(map_as_local_variable)
    col_count = len(map_as_local_variable[0])

    separated_count = 0
    while True:
        if sum_2darr(map_as_local_variable) == 0:
            break

        separated_count += 1
        same_piece_stack = [get_first_iceberg(map_as_local_variable)]
        while True:
            if len(same_piece_stack) == 0:
                break

            check_row_idx, check_col_idx = same_piece_stack.pop()
            map_as_local_variable[check_row_idx][check_col_idx] = 0

            check_lists = []
            if check_row_idx > 0:
                check_lists.append([check_row_idx - 1, check_col_idx])

            if check_col_idx < (col_count - 1):
                check_lists.append([check_row_idx, check_col_idx + 1])

            if check_row_idx < (row_count - 1):
                check_lists.append([check_row_idx + 1, check_col_idx])

            if check_col_idx > 0:
                check_lists.append([check_row_idx, check_col_idx - 1])

            for row_idx, col_idx in check_lists:
                if map_as_local_variable[row_idx][col_idx] != 0:
                    same_piece_stack.append([row_idx, col_idx])
                    map_as_local_variable[row_idx][col_idx] = 0

    return separated_count


def get_first_year_separated_into_twopieces(iceberg_map):
    map_as_local_variable = copy_2darr(iceberg_map)
    passed_year = 0
    while True:
        if get_separated_count(map_as_local_variable) >= 2:
            break

        if sum_2darr(map_as_local_variable) == 0:
            return 0

        map_as_local_variable = execute_melt(map_as_local_variable)
        passed_year += 1

    return passed_year


def main():
    row_count, _ = str2int_array(input())
    iceberg_map = empty_2darr(row_count, 1)

    for row_idx in range(row_count):
        iceberg_map[row_idx] = str2int_array(input())

    print(get_first_year_separated_into_twopieces(iceberg_map))


if __name__ == '__main__':
    main()
