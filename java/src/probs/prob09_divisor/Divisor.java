package probs.prob09_divisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Divisor {
    /**
     * 양의 정수를 입력 받고 그 수의 약수를 모두 출력하는 프로그램을 작성하십시오.
     *
     * 입력
     *
     * 양의 정수
     *
     * 출력
     *
     * 입력된 수의 약수를 공백으로 구분하여 출력
     *
     *
     *
     *
     * 입/출력 예시
     * ⋇ 입출력 형식을 잘 지켜주세요.
     * ␣ : 공백↵ : 줄바꿈
     * 보기 입력 1
     * 20
     * 출력 1
     * 1 2 4 5 10 20
     *
     * 보기 입력 2
     * 100
     * 출력 2
     * 1 2 4 5 10 20 25 50 100
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        printList(getDivisors(number));
    }

    private static void printList(List<Integer> divisors) {
        divisors.stream()
                .map(it -> it + " ")
                .forEach(System.out::print);
    }

    public static List<Integer> getDivisors(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        double sqrt = Math.sqrt(number);
        for (int divisorCandidate = 1; divisorCandidate <= sqrt; divisorCandidate++) {
            int quotient = number / divisorCandidate;
            int remainder = number - quotient * divisorCandidate;
            if (remainder == 0) {
                result.add(divisorCandidate);
                if (divisorCandidate != quotient) {
                    result.add(quotient);
                }
            }
        }

        return result.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
