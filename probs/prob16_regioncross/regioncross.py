# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean


"""
@description
  하나의 점(좌표)를 나타내는 클래스
"""


SMALL = 0
LARGE = 1


class point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


"""
@description
  두 사각형을 이루는 네 점을 파라미터로 받아 교차하는 영역의 넓이를 반환하는 함수
	각 점은 point class의 객체로 주어진다

@param p	첫 번째 사각형의 한 점, q와 대각선상에 존재한다.
@param q	첫 번째 사각형의 한 점, p와 대각선상에 존재한다.
@param r	두 번째 사각형의 한 점, s와 대각선상에 존재한다.
@param s	두 번째 사각형의 한 점, r과 대각선상에 존재한다.
@return   두 직사각형이 교차하는 영역의 넓이
"""


def sort_two_value(p, q):
    if p < q:
        return p, q
    else:
        return q, p


def get_cross_length(p, q, r, s):
    rect_first = sort_two_value(p, q)
    rect_second = sort_two_value(r, s)

    if rect_first[0] > rect_second[0]:
        temp = rect_first
        rect_first = rect_second
        rect_second = temp

    if rect_second[SMALL] <= rect_first[LARGE] <= rect_second[LARGE]:
        return rect_first[LARGE] - rect_second[SMALL]

    if rect_first[LARGE] <= rect_second[SMALL]:
        return 0

    if rect_second[LARGE] <= rect_first[LARGE]:
        return rect_second[SMALL] - rect_second[LARGE]

    assert ValueError("Unexpected cases")


def get_duplicated_area(p, q, r, s):
    x_cross_length = get_cross_length(p.x, q.x, r.x, s.x)
    y_cross_length = get_cross_length(p.y, q.y, r.y, s.y)

    area = x_cross_length * y_cross_length

    return area


def main():
    # 네 점의 좌표를 입력받는다
    px, py = [int(word) for word in input().split()]
    qx, qy = [int(word) for word in input().split()]
    rx, ry = [int(word) for word in input().split()]
    sx, sy = [int(word) for word in input().split()]

    # 각 점의 정보를 객체화한다
    p = point(px, py)
    q = point(qx, qy)
    r = point(rx, ry)
    s = point(sx, sy)

    # 주어진 함수를 통해 교차하는 영역의 넓이를 계산한다
    answer = get_duplicated_area(p, q, r, s)

    # 정답을 형식에 맞게 출력한다
    print(answer)


"""
메인 함수에는 테스트케이스와 입출력에 대한 기본적인 뼈대 코드가 작성되어 있습니다. 
상단의 함수만 완성하여도 문제를 해결할 수 있으며, 
메인 함수를 제거한 후 스스로 코드를 모두 작성하여도 무방합니다.
단, 스스로 작성한 코드로 인해 발생한 에러 등은 모두 참가자에게 책임이 있습니다.
"""
if __name__ == "__main__":
    main()

"""
입력 1

-7 5
0 0
-3 -3
4 2


출력 1
6

입력 2
1 1
0 0
2 2
1 1
출력 2
0

"""
