package com.book.realworld.software.development.bank.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTransactionServiceTest {

    private String testFilePath = "C:\\Users\\we hwan\\Documents\\workspaces\\sample.java8\\src\\main\\resources\\data\\sample\\BankTransactionSampleData";
    BankTransactionService bankTransactionService;

    @BeforeEach
    public void before() throws IOException {
        this.bankTransactionService = new BankTransactionService(testFilePath);
    }

    @Test
    @DisplayName("은행내역에서 수입의 합을 계산")
    void calculateIncoming() {
        // when
        double incoming = this.bankTransactionService.calculateIncoming();

        // then
        assertEquals(incoming, 11000);
    }

    @Test
    @DisplayName("은행내역에서 지출의 합을 계산")
    void calculateOutgoing() {
        // when
        double outgoing = this.bankTransactionService.calculateOutgoing();

        // then
        assertEquals(outgoing, -4180);
    }

    @Test
    @DisplayName("은행내역의 전체 합계를 계산")
    void calculateTotal() {
        // when
        double total = this.bankTransactionService.calculateTotal();

        // then
        assertEquals(total, 6820);
    }

    @Test
    @DisplayName("해당 월에 해당하는 은행 내역의 수를 계산")
    void countByMatchedMonth() {
        // when
        long count = this.bankTransactionService.countByMatchedMonth(2);

        // then
        assertEquals(count, 5);
    }

    @Test
    @DisplayName("가장 지출이 큰 순서대로 항목 찾기")
    void findTopSpendOutgoing() {
        // when
        List<String> topSpendOutgoing = this.bankTransactionService.findTopSpendOutgoing(3);

        // then
        assertThat(topSpendOutgoing.size()).isEqualTo(3);
        assertThat(topSpendOutgoing).contains("Rent", "Deliveroo", "Tesco");
        assertThat(topSpendOutgoing.get(0)).isEqualTo("Rent");
    }

    @Test
    @DisplayName("가장 지출이 큰 항목들 찾기")
    void findLargestSpendItem() {
        // when
        Set<String> largestSpendItem = this.bankTransactionService.findLargestSpendItem();

        // then
        assertThat(largestSpendItem.size()).isEqualTo(1);
        assertThat(largestSpendItem.contains("Rent")).isTrue();
    }
}