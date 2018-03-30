# -*- coding: utf-8 -*-


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def make_directed_graph_table(siz, weighted_edges):
    graph_table = empty_2darr(siz, siz)

    for each_edge in weighted_edges:
        ((st, dst), weight) = each_edge
        st_idx, dst_idx = st - 1, dst - 1
        if graph_table[st_idx][dst_idx] != 0 \
                and graph_table[st_idx][dst_idx] <= weight:
            continue
        else:
            graph_table[st_idx][dst_idx] = weight

    return graph_table


INF = 9999
INF_TEXT = "INF"


def shortest_path_weight(start_vertex_number, graph_table):
    vertex_count = len(graph_table)

    start_vertex_idx = start_vertex_number - 1

    visited_s = [start_vertex_idx]
    d = [INF] * vertex_count
    d[start_vertex_idx] = 0
    notvisited_q = [vertex_idx for vertex_idx in range(0, vertex_count)]

    while len(notvisited_q) != 0:
        minimum = INF + 1
        minimum_q = -1
        for q in notvisited_q:
            if minimum > d[q]:
                minimum = d[q]
                minimum_q = q

        for dst, weight in enumerate(
                graph_table[minimum_q]):
            if weight == 0:
                continue

            found_weight = d[minimum_q] + weight
            if d[dst] > found_weight:
                d[dst] = found_weight

        visited_s.append(minimum_q)
        notvisited_q.remove(minimum_q)

    return d


def fix_inf_to_textinf(lst):
    for idx, each in enumerate(lst):
        if each == INF:
            lst[idx] = INF_TEXT

    return lst


def get_solution(start_vertex_number, vertex_count, edges):
    graph_table = make_directed_graph_table(vertex_count, edges)

    results = shortest_path_weight(start_vertex_number, graph_table)
    results = fix_inf_to_textinf(results)

    return results


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

    print_list_on_multi_line(
        get_solution(start_vertex_number, vertex_count, edges))


if __name__ == '__main__':
    main()
