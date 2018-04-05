# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math

ONE_G_QUANTITY = 50

"""
@description
  약품 개발에 필요한 정보를 파라미터로 받아 약품 개발에 필요한 최소의 특수 광물의 수를 계산하여 반환해주는 함수

@param n      광물 X에서 얻을 수 있는 기본 물질의 가짓수
@param g      약품 개발에 필요한 특수 합성 물질의 양
@param needs  약품 개발에 필요한 N가지 기본 물질의 양
@return       약품 개발에 필요한 최소의 특수 광물 X의 갯수
"""


def get_least_quantities(n, g, needs):
    prepared_g = 0

    # 시간복잡도 while문 g만큼 소요 O(nlogn * g)
    # 공간복잡도 O(needs만큼 소요 sizeof(int)*n => O(n))
    while True:
        if prepared_g >= g:
            break

        # sort에 소요되는 Time Complexity O(nlogn)
        needs.sort()
        needs[0] += 1
        needs[1] += 1
        needs[2] += 1

        prepared_g += 1

    needs.sort()
    least_quantities = math.ceil(needs[-1] / ONE_G_QUANTITY)

    return least_quantities


def main():
    # 테스트케이스의 수를 입력받는다
    case_num = int(input())

    # 차례로 테스트케이스 별로 데이터를 입력받고 정답을 출력한다
    for case_index in range(1, case_num + 1):
        # 기본 물질의 종류의 수 N과 필요한 특수 합성 물질의 양 G를 입력받는다
        n, g = [int(word) for word in input().split()]

        # N가지 기본 물질의 각각의 필요한 양을 차례로 입력받아 리스트에 저장한다
        needs = [int(word) for word in input().split()]

        # 주어진 함수를 호출하여 정답을 계산한다
        answer = get_least_quantities(n, g, needs)

        # 출력 형식에 맞게 정답을 출력한다
        print('Case #%d' % case_index)
        print(answer)


"""
메인 함수에는 테스트케이스와 입출력에 대한 기본적인 뼈대 코드가 작성되어 있습니다.
상단의 함수만 완성하여도 문제를 해결할 수 있으며,
메인 함수를 제거한 후 스스로 코드를 모두 작성하여도 무방합니다.
단, 스스로 작성한 코드로 인해 발생한 에러 등은 모두 참가자에게 책임이 있습니다.
"""
if __name__ == "__main__":
    main()
