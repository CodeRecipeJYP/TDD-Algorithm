# -*- coding: utf-8 -*-
import heapq


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


INF = 9999
INF_TEXT = "INF"
NONE_PREVIOUS_VERTEX = -1


def shortest_path_weight(start_vertex_number, edges):
    vertex_count = len(edges)

    start_vertex_idx = start_vertex_number - 1

    d = [INF] * vertex_count
    d[start_vertex_idx] = 0

    pq = [(d[start_vertex_idx], start_vertex_idx, NONE_PREVIOUS_VERTEX)]

    heapq.heapify(pq)

    while len(pq) != 0:
        distance, vertex_idx, prev_vertex_idx = heapq.heappop(pq)
        if distance > d[vertex_idx]:
            continue

        for dst, weight in edges[vertex_idx]:
            found_weight = d[vertex_idx] + weight
            if d[dst] > found_weight:
                pq_item = (found_weight, dst, vertex_idx)
                heapq.heappush(pq, pq_item)
                d[dst] = found_weight

    return d


def get_solution(start_vertex_number, graph_table):
    results = shortest_path_weight(start_vertex_number, graph_table)

    return results


def print_list_on_multi_line(lst):
    for each_row in lst:
        if each_row == INF:
            print(INF_TEXT)
        else:
            print(each_row)


def main():
    vertex_count, edge_count = str2int_array(input())
    start_vertex_number = int(input())

    edges = [[] for _ in range(vertex_count)]

    for _ in range(edge_count):
        st, dst, weight = str2int_array(input())

        st_idx, dst_idx = st - 1, dst - 1
        edges[st_idx].append((dst_idx, weight))

    print_list_on_multi_line(
        get_solution(start_vertex_number, edges))


if __name__ == '__main__':
    main()
