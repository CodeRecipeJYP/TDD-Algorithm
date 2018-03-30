# -*- coding: utf-8 -*-


def get_formatted_name(first_name, last_name):
    formatted_name = ''

    return formatted_name


def main():
    case_num = int(input())

    # 각 테스트케이스에 대하여 차례로 데이터를 입력받고 정답을 출력한다
    for case_index in range(1, case_num + 1):
        # 이름과 성을 차례로 입력 받는다
        first_name, last_name = input().split()

        # 주어진 함수로 포매팅된 이름을 구한다
        answer = get_formatted_name(first_name, last_name)

        # 정답을 형식에 맞게 출력한다
        print('Case #%d' % case_index)
        print(answer)


if __name__ == '__main__':
    main()
