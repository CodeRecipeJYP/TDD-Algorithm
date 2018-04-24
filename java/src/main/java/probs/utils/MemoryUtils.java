package probs.utils;

import java.text.DecimalFormat;

public class MemoryUtils {
    public static void showMemoryUsage() {
        DecimalFormat format = new DecimalFormat("###,###,###.##");

        //JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.
        Runtime runtime = Runtime.getRuntime();
        long maxByte = runtime.maxMemory();
        long maxMb = maxByte / 1024 / 1024;

        //JVM이 현재 시스템에 얻어 쓴 메모리의 총량
        long totalMb = runtime.totalMemory() / 1024 / 1024;

        //JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리
        long freeMb = runtime.freeMemory() / 1024 / 1024;

        System.out.println("Max:" + format.format(maxMb) + ", Total:" + format.format(totalMb) + ", Used:"+format.format(totalMb - freeMb));
    }
}
