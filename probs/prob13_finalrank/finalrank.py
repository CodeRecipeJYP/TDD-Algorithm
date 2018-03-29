# -*- coding: utf-8 -*-


def str2int_array(string):
    splitted = string.split()
    int_array = []
    for each_splitted in splitted:
        int_array.append(int(each_splitted))

    return int_array


def empty_2darr(num_row, num_col):
    return [[0 for _ in range(num_col)] for _ in range(num_row)]


def get_curr_ranks(team_count, prev_ranks, diffs):
    return prev_ranks


def print_list_on_single_line(lists):
    last = lists.pop(-1)
    for each in lists:
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
