package com.example.sample.algorithm.inflearn.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+james@coding.com"
                                                , "test.e.mail+toto.jane@coding.com"
                                                , "testemail+tom@cod.ing.com"}));

    }

    public static int numUniqueEmails(String[] emails){
        Set<String> filteredEmails = new HashSet<>();

        for (String email : emails) {
            String[] splitEmail = email.split("@");
            String localName = splitEmail[0];
            String domainName = splitEmail[1];

            if(localName.contains("+")) {
                localName = localName.split("\\+")[0];
            }

            if(localName.contains(".")) {
                localName = localName.replace(".", "");
            }

            filteredEmails.add(localName + "@" + domainName);
        }

        filteredEmails.stream().forEach(System.out::println);
        return filteredEmails.size();
    }

}
