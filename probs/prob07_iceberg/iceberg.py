

def str2int_array(string):
    splitted = string.split(" ")
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


def execute_melt(iceberg_map):
    return []


def get_seperated_count(iceberg_map):
    return 0


def get_first_year_separated_into_twopieces(iceberg_map):
    map_as_local_variable = iceberg_map.copy()
    passed_year = 0
    while True:
        if get_seperated_count(map_as_local_variable) >= 2:
            break

        if sum_2darr(map_as_local_variable) == 0:
            return 0

        map_as_local_variable = execute_melt(map_as_local_variable)
        passed_year += 1

    return passed_year


def main():
    [row_count, _] = str2int_array(input())
    iceberg_map = empty_2darr(row_count, 1)

    for row_idx in range(row_count):
        iceberg_map[row_idx] = str2int_array(input())

    print(get_first_year_separated_into_twopieces(iceberg_map))


if __name__ == '__main__':
    main()
