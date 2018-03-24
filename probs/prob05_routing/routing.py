

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


INF = 999999


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
    count_computers = len(graph_table)

    visited_s = [0]
    noise_d = [INF] * count_computers
    noise_d[0] = 1
    notvisited_q = [computer for computer in range(0, count_computers)]

    while len(notvisited_q) != 0:
        minimum = INF
        minimum_q_computer = -1
        for q_computer in notvisited_q:
            if minimum > noise_d[q_computer]:
                minimum = noise_d[q_computer]
                minimum_q_computer = q_computer

        for dst_computer, weight in enumerate(graph_table[minimum_q_computer]):
            if weight == 0:
                continue

            found_noise = noise_d[minimum_q_computer] * weight
            if noise_d[dst_computer] > found_noise:
                noise_d[dst_computer] = found_noise

        visited_s.append(minimum_q_computer)
        notvisited_q.remove(minimum_q_computer)

    return noise_d[-1]


def main():
    count_cases = int(input())

    for case_idx in range(0, count_cases):
        [count_computers, count_edges] = str2int_array(input())
        graph_table = empty_2darr(count_computers, count_computers)
        for edge_idx in range(0, count_edges):
            [st, dst, weight] = str2int_or_float_array(input())
            if graph_table[st][dst] != 0 \
                    and graph_table[st][dst] <= weight:
                continue
            else:
                graph_table[st][dst] = weight
                graph_table[dst][st] = weight

        print("{0:0.10f}".format(lowest_route_noiseratio(graph_table)))


if __name__ == '__main__':
    main()
