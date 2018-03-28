

CONNECTED = 1


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def convert_raw_into_coloring_graph(raw_inputs, connection_count):
    color_count = connection_count + 1
    graph_table = empty_2darr(color_count, color_count)

    for node_idx in range(connection_count):
        each_raw = raw_inputs[node_idx]
        connected_node_first, connected_node_second = str2int_array(each_raw)
        idx_first, idx_second\
            = connected_node_first - 1, connected_node_second - 1
        graph_table[idx_first][idx_second] \
            = CONNECTED
        graph_table[idx_second][idx_first] \
            = CONNECTED

    return graph_table


def minimum_coloring_cost(graph_table, node_count):
    return 0


def main():
    color_count = int(input())
    connection_count = color_count - 1

    raw_inputs = []
    for _ in range(connection_count):
        raw_inputs.append(input())

    graph_table = convert_raw_into_coloring_graph(raw_inputs, connection_count)

    print(minimum_coloring_cost(graph_table, color_count))


if __name__ == '__main__':
    main()
