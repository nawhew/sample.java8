package com.book.realworld.software.development.bank.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankTransactionTest {

    @Test
    @DisplayName("주어진 문자열배열을 통해 은행거래 생성")
    void of() {
        // given
        String[] datas = new String[]{"30-01-2017", "-100", "Deliveroo"};

        // when
        BankTransaction bankTransaction = BankTransaction.of(datas);

        // then
        assertThat(bankTransaction).isNotNull();
    }
}