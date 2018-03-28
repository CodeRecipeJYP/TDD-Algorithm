package probs.prob10_bubblesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    /**
     * 문제
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 수의 개수 N(1<=N<=1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절대값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     *
     * 출력
     * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int currentCount = 0; currentCount < numberCount; currentCount++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        printList(bubbleSort(numbers));
    }

    public static List<Integer> bubbleSort(List<Integer> numbers) {
        int numberCount = numbers.size();
        List<Integer> numbersAsLocalVar = numbers;

        for (int formerIdx = 0; formerIdx < numberCount - 1; formerIdx++) {
            for (int latterIdx = formerIdx + 1; latterIdx < numberCount; latterIdx++) {
                int former = numbersAsLocalVar.get(formerIdx);
                int latter = numbersAsLocalVar.get(latterIdx);
                if (former > latter) {
                    numbersAsLocalVar = swap(numbersAsLocalVar, formerIdx, latterIdx);
                }
            }
        }

        return numbersAsLocalVar;
    }

    private static List<Integer> swap(List<Integer> numbers, int formerIdx, int latterIdx) {
        ArrayList<Integer> copy = new ArrayList<>(numbers);

        int former = copy.get(formerIdx);

        copy.set(formerIdx, copy.get(latterIdx));
        copy.set(latterIdx, former);

        return copy;
    }

    private static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
