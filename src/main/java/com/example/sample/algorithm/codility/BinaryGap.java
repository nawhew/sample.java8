package com.example.sample.algorithm.codility;

import org.springframework.util.StopWatch;

import java.util.Arrays;

public class BinaryGap {

    private int length = 0;
    private int before = 2;
    private int maxLength = 0;

    /**
     * 10진수를 2진수로 변환합니다.
     * @param integerNumber
     * @return
     */
    private String integerToBinary(int integerNumber) {
        return Integer.toBinaryString(integerNumber);
    }

    /**
     * 숫자0의 최대 길이를 구합니다.
     * @param binaryNumber
     * @return
     */
    private int calculateMaxLengthZeros(String binaryNumber) {
        System.out.println("binaryNumber: " + binaryNumber);
        Arrays.stream(binaryNumber.split(""))
                .mapToInt(Integer::parseInt)
                .forEach(this::compareNumbers);
        return this.maxLength;
    }

    @Deprecated
    private int calculateMaxLengthZeros2(String binaryNumber) {
        System.out.println("binaryNumber: " + binaryNumber);
        Arrays.stream(binaryNumber.split(""))
                .mapToInt(Integer::parseInt)
                .reduce((left, right) -> {
                    this.length = right == 0
                            ? (left == 1 ? 0 : this.length++)
                            : this.length;
                    if(this.length > this.maxLength) {
                        this.maxLength = this.length;
                    }
                    return right;
                });

        return this.maxLength;
    }

    /**
     * 숫자를 비교합니다.
     * @param now
     */
    private void compareNumbers(int now) {
        this.validateFirstZero(now);
        this.validateAgainZero(now);

        if(this.isNewMaxLength(now)) {
            this.maxLength = this.length;
        }
        this.before = now;
    }

    /**
     * 처음 만나는 0인지 검증합니다.
     * @param now
     */
    private void validateFirstZero(int now) {
        if(now == 0 && this.before == 1) {
            this.length = 1;
        }
    }

    /**
     * 처음 이후로 만나는 0인지 검증합니다.
     * @param now
     */
    private void validateAgainZero(int now) {
        if(now == 0 && this.before == 0) {
            this.length++;
        }
    }

    private boolean isNewMaxLength(int now) {
        return this.length > this.maxLength && now == 1 && this.before == 0;
    }

    public static int solution(int input) {
        BinaryGap binaryGap = new BinaryGap();
        return binaryGap.calculateMaxLengthZeros(binaryGap.integerToBinary(input));
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(BinaryGap.solution(15));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());;
    }

}
