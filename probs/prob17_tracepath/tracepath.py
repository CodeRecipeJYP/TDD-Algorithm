# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

"""
@description
로봇 방문 순서에 따라 배열 m을 채워주는 함수

@param m 로봇 방문 순서를 저장할 r행 c열의 배열, m[i][j] := (i행 j열)칸의 로봇의 방문 순서 번호
@param r 행의 수
@param c 열의 수
"""


def is_out_of_range(exp_nowR, exp_nowC, max_r, max_c):
    if 0 <= exp_nowR < max_r and \
            0 <= exp_nowC < max_c:
        return False
    else:
        return True


def simulate(m, y, x):
    # begin of function
    nowX = 0
    nowY = 0
    length = y * x

    direction = [
        (1, 0),
        (0, 1),
        (-1, 0),
        (0, -1)
    ]

    curr_direction_idx = 0
    iteration = 1

    x_diff, y_diff = direction[curr_direction_idx]
    m[nowY][nowX] = iteration

    while iteration < length:
        exp_nowX = nowX + x_diff
        exp_nowY = nowY + y_diff

        if is_out_of_range(exp_nowX, exp_nowY, x, y) or \
                m[exp_nowY][exp_nowX] > 0:
            curr_direction_idx = (curr_direction_idx + 1) % 4
            x_diff, y_diff = direction[curr_direction_idx]
            continue

        nowX = exp_nowX
        nowY = exp_nowY
        iteration += 1
        m[nowY][nowX] = iteration


# end of function


def main():
    # 테스트케이스의 수를 입력받는다
    case_num = int(input())

    # 각 테스트케이스에 대해 순서대로 데이터를 입력받고 정답을 출력한다
    for case_index in range(1, case_num + 1):

        # 행과 열의 수를 입력받는다
        r, c = [int(e) for e in input().split()]

        # 0으로 초기화 된 r행 c열의 리스트를 생성한다
        m = [[0] * c for row_index in range(r)]

        # 주어진 함수를 실행하여 각 칸을 로봇 청소기가 방문하는 순서를 리스트에 저장한다
        simulate(m, r, c)

        # 케이스 번호를 출력한다
        print('Case #%d' % case_index)

        # 각 칸의 방문 순서를 출력 형식에 맞게 출력한다
        for i in range(r):
            print(*m[i], sep=' ')


if __name__ == '__main__':
    main()
