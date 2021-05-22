package com.example.sample.thisandthat;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Encode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String data = "A3BFA3BFA3BFA3BFA3BFA3BFA3BFA3DCA3BFA3BFA3BFA3BFA3BFA3BF";
        String kor1 = "한글";
        String kor_utf8 = new String("한글ABC".getBytes(StandardCharsets.UTF_8));
        String kor_euc = new String("한글ABC".getBytes("EUC-KR"));
        String kor_ascii = new String("한글ABC".getBytes(), StandardCharsets.US_ASCII);
        String kor_ascii2 = new String("한글ABC".getBytes(StandardCharsets.US_ASCII));
        String kor_ascii3 = new String("한글ABC".getBytes("8859_1"));
        String kor_ascii4 = new String("한글ABC".getBytes(), "8859_1");



        print(kor_utf8);
        print(kor_euc);
        print(kor_ascii2);
        System.out.println("\n\n------------------ ascii!!!!!!!!!!! 111");
        print(kor_ascii);
        System.out.println("\n\n------------------ ascii!!!!!!!!!!! 333");
        print(kor_ascii3);
        System.out.println("\n\n------------------ ascii!!!!!!!!!!! 444");
        print(kor_ascii4);
    }

    private static void print(String input) {
        System.out.println("==================================\norigin : " + input);

        try {
            String usascii = new String(input.getBytes(), StandardCharsets.US_ASCII);
            System.out.println("usascii : " + usascii);

            String usascii_to_utf8 = new String(input.getBytes(StandardCharsets.US_ASCII), StandardCharsets.UTF_8);
            System.out.println("usascii_to_utf8 : " + usascii_to_utf8);


            String usascii_to_euc = new String(input.getBytes(StandardCharsets.US_ASCII), "EUC-KR");
            System.out.println("usascii_to_euc : " + usascii_to_euc);

            String euc_kr1 = new String(input.getBytes("8859_1"), "EUC_KR");
            System.out.println("euckr : " + euc_kr1);


            String utf8 = new String(input.getBytes(), StandardCharsets.UTF_8);
            System.out.println("utf8 : " + utf8);

            String euc_kr = new String(input.getBytes("8859_1"), StandardCharsets.UTF_8);
            System.out.println("8859 : " + euc_kr);


            String euc_to_utf8 = new String(input.getBytes("EUC-KR"), StandardCharsets.UTF_8);
            System.out.println("euc_to_utf8 : " + euc_to_utf8);

            byte[] euckrStringBuffer = input.getBytes(Charset.forName("euc-kr"));
            System.out.print("euc-kr - length : " + euckrStringBuffer.length);
            String decodedFromEucKr = new String(euckrStringBuffer, "euc-kr");
            System.out.println(", String from euc-kr : " + decodedFromEucKr);

            byte[] utf8StringBuffer = decodedFromEucKr.getBytes(StandardCharsets.UTF_8);
            System.out.print("utf-8 - length : " + utf8StringBuffer.length);
            String decodedFromUtf8 = new String(utf8StringBuffer, StandardCharsets.UTF_8);
            System.out.println(", String from utf-8 : " + decodedFromUtf8);

            String ksc5601 = new String(input.getBytes("KSC5601"), "8859_1");
            String ksc56011 = new String(input.getBytes("8859_1"), "KSC5601");
            System.out.println("ksc5601 1: " + ksc5601);
            System.out.println("ksc5601 2: " + ksc56011);

            String ksc56013 = new String(input.getBytes("KSC5601"), StandardCharsets.UTF_8);
            String ksc560114 = new String(input.getBytes("8859_1"), StandardCharsets.UTF_8);
            System.out.println("ksc5601 3 : " + ksc56013);
            System.out.println("ksc5601 4 : " + ksc560114);


            String ksc560115 = new String(ksc56011.getBytes("KSC5601"), StandardCharsets.UTF_8);
            System.out.println("ksc5601 5 : " + ksc560115);

//            byte[] bytes = Hex.decodeHex(input.toCharArray());
//            System.out.println("hex : " + new String(bytes, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
