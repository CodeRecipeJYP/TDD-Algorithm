

"""
예제 입력

1
7 14
0 1 1.3
0 2 1.1
0 3 1.24
3 4 1.17
3 5 1.24
3 1 2
1 2 1.31
1 2 1.26
1 4 1.11
1 5 1.37
5 4 1.24
4 6 1.77
5 6 1.11
2 6 1.2

예제 출력

1.3200000000
"""


def str2int_or_float_array(string):
    splitted = string.split(" ")
    array = []
    for each_splitted in splitted:
        if each_splitted.find(".") == -1:
            array.append(int(each_splitted))
        else:
            array.append(float(each_splitted))

    return array


def str2int_array(string):
    splitted = string.split(" ")
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(w, h):
    return [[0 for x in range(w)] for y in range(h)]


def lowest_route_noiseratio(graph_table):
    return ""


def main():
    count_cases = int(input())

    for case_idx in range(0, count_cases):
        [count_computers, count_edges] = str2int_array(input())
        graph_table = empty_2darr(count_computers, count_computers)
        for edge_idx in range(0, count_edges):
            [st, dst, weight] = str2int_or_float_array(input())
            graph_table[st][dst] = weight

        print(lowest_route_noiseratio(graph_table))


if __name__ == '__main__':
    main()
