

def str2int_array(string):
    splitted = string.split(" ")
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def get_first_year_separated_into_twopieces(map):
    return 0


def main():
    [row_count, _] = str2int_array(input())
    iceberg_map = empty_2darr(row_count, 1)

    for row_idx in range(row_count):
        iceberg_map[row_idx] = str2int_array(input())

    print(get_first_year_separated_into_twopieces(iceberg_map))


if __name__ == '__main__':
    main()
