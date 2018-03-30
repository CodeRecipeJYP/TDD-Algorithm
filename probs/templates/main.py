# -*- coding: utf-8 -*-


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def print_list_on_multi_line(lst):
    for each_row in lst:
        print(each_row)


def main():
    vertex_count, edge_count = str2int_array(input())
    start_vertex_number = int(input())
    edges = []

    for _ in range(edge_count):
        st, dst, weight = str2int_array(input())
        edges.append((
            (st, dst), weight
        ))

    result = []
    print_list_on_multi_line(result)


if __name__ == '__main__':
    main()
