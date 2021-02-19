package com.myassignment.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbDateTest {
    @Test
    @DisplayName("Given Valid Date input then should create DbDate instance")
    public void validDateInput() {
        DbDate dbDate = new DbDate((short) 11, DbMonth.Aug, "2020");
        Assertions.assertNotNull(dbDate);
    }
}
