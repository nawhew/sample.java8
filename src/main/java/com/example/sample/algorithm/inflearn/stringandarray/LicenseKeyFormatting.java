package com.example.sample.algorithm.inflearn.stringandarray;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("8F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("8-5g-3-J", 4));
        System.out.println(licenseKeyFormatting("8F3Z-2e-9-w", 3));
        System.out.println(licenseKeyFormatting("8F3Z-2e-9-w-AF2SD", 3));
    }

    public static String licenseKeyFormatting(String S, int K) {
        String regex = "-";
        String[] keyGroups = S.split(regex);
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        // first group
        result.append(keyGroups[0].toUpperCase());

        for (int index = 1; index < keyGroups.length; index++) {
            String[] keyGroupUnits = keyGroups[index].split("");
            for (String keyGroupUnit : keyGroupUnits) {
                sb.append(keyGroupUnit.toUpperCase());
                if(sb.length() == K) {
                    result.append(regex).append(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if(sb.length() > 0) {
            result.append(regex).append(sb.toString());
        }
        return result.toString();
    }

    public static String licenseKeyFormatting2(String S, int K) {

        String S1 = S.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            sb.append(S1.charAt(i));
        }
        int len = sb.toString().length();
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
