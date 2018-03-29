# -*- coding: utf-8 -*-


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


RESULT_IMPOSSIBLE = ["IMPOSSIBLE"]
DIRECTED_EDGE = 1
EDGE_NOT_EXISTS = 0


def make_graph_table(prev_ranks):
    team_count = len(prev_ranks)

    table = empty_2darr(team_count, team_count)

    lower_ranked_teams = []

    for team_number in reversed(prev_ranks):
        team_idx = team_number - 1
        for lower_team_idx in lower_ranked_teams:
            table[team_idx][lower_team_idx] = DIRECTED_EDGE

        lower_ranked_teams.append(team_idx)

    return table


def update_diffs(graph_table, diffs):
    for diff in diffs:
        team1, team2 = diff
        team1_idx, team2_idx = team1 - 1, team2 - 1
        if graph_table[team1_idx][team2_idx] == DIRECTED_EDGE:
            graph_table[team1_idx][team2_idx] = EDGE_NOT_EXISTS
            graph_table[team2_idx][team1_idx] = DIRECTED_EDGE
        else:
            graph_table[team1_idx][team2_idx] = DIRECTED_EDGE
            graph_table[team2_idx][team1_idx] = EDGE_NOT_EXISTS

    return graph_table


def get_curr_ranks(team_count, prev_ranks, diffs):
    graph_table = make_graph_table(prev_ranks)
    curr_graph_table = update_diffs(graph_table, diffs)

    curr_ranks = [0] * team_count
    for team_idx, each_row in enumerate(curr_graph_table):
        team_number = team_idx + 1
        curr_rank_idx = (team_count - 1) - sum(each_row)
        if curr_ranks[curr_rank_idx] != 0:
            return RESULT_IMPOSSIBLE
        else:
            curr_ranks[curr_rank_idx] = team_number

    return curr_ranks


def print_list_on_single_line(lists):
    copy = lists.copy()

    last = copy.pop(-1)
    for each in copy:
        print(each, end=" ")

    print(last)


def main():
    case_count = int(input())

    for _ in range(case_count):
        team_count = int(input())
        prev_ranks = str2int_array(input())

        diff_count = int(input())
        diffs = []
        for _ in range(diff_count):
            diffs.append(str2int_array(input()))

        print_list_on_single_line(get_curr_ranks(team_count, prev_ranks, diffs))


if __name__ == '__main__':
    main()
