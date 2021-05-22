package com.book.realworld.software.development.bank.application;

import com.book.realworld.software.development.bank.domain.BankTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataFileReader {
    public static final String REGEX_CSV_DATA = ",";

    public static List<BankTransaction> read(String filePath) throws IOException {
        Reader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);

        List<BankTransaction> bankTransactions = new ArrayList<>();

        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            bankTransactions.add(BankTransaction.of(line.split(REGEX_CSV_DATA)));
        }

        return bankTransactions;
    }
}
