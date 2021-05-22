package com.book.realworld.software.development.bank.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter @ToString @EqualsAndHashCode(of = "id")
@Builder @NoArgsConstructor @AllArgsConstructor
public class BankTransaction {
    public static final String DATE_FORMAT_PATTERN = "dd-MM-yyyy";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double amount;
    private String description;

    public static BankTransaction of(String[] data) {
        return BankTransaction.builder()
                .date(LocalDate.parse(data[0], DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN)))
                .amount(Double.parseDouble(data[1]))
                .description(data[2])
                .build();
    }

    public boolean isIncoming() {
        return amount > 0;
    }

    public boolean isOutgoing() {
        return amount < 0;
    }
}
