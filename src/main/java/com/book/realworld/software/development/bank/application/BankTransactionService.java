package com.book.realworld.software.development.bank.application;

import com.book.realworld.software.development.bank.domain.BankTransaction;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class BankTransactionService {

    private final List<BankTransaction> bankTransactions;

    public BankTransactionService(String filePath) throws IOException {
        this.bankTransactions = CSVDataFileReader.read(filePath);
    }

    public double calculateIncoming() {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        this.bankTransactions.stream().filter(BankTransaction::isIncoming)
                .forEach(bankTransaction -> total.set(total.get() + bankTransaction.getAmount()));
        return total.get();
    }

    public double calculateOutgoing() {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        this.bankTransactions.stream().filter(BankTransaction::isOutgoing)
                .forEach(bankTransaction -> total.set(total.get() + bankTransaction.getAmount()));
        return total.get();
    }

    public double calculateTotal() {
        return this.calculateIncoming() + this.calculateOutgoing();
    }

    public long countByMatchedMonth(int month) {
        return this.bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getDate().getMonthValue() == month)
                .count();
    }

    public List<String> findTopSpendOutgoing(int count) {
        return this.bankTransactions.stream()
                .filter(BankTransaction::isOutgoing)
                .sorted((o1, o2) -> (int) (o1.getAmount() - o2.getAmount()))
                .map(BankTransaction::getDescription)
                .collect(Collectors.toList()).subList(0, count);
    }

    public Set<String> findLargestSpendItem() {
        Map<String, Double> spendByItem = this.getSpendByItem();
        double max = this.calculateMinBySpendByItem(spendByItem);

        return spendByItem.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private Map<String, Double> getSpendByItem() {
        Map<String, Double> spendByItem = new HashMap<>();

        this.bankTransactions.stream()
                .forEach(bankTransaction
                        -> spendByItem.put(bankTransaction.getDescription()
                            , spendByItem.getOrDefault(bankTransaction.getDescription(), bankTransaction.getAmount())));

        return spendByItem;
    }

    private double calculateMinBySpendByItem(Map<String, Double> spendByItem) {
        var ref = new Object() {
            double min = 0;
        };
        spendByItem.keySet().stream().forEach(key -> {
            double spend = spendByItem.get(key);
            if(spend < ref.min) {
                ref.min = spend;
            }
        });
        return ref.min;
    }
}
