package com.myassignment.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbTimeTest {
    @Test
    @DisplayName("Given Valid Time input then should create DbTime instance")
    public void validDateInput() {
        DbTime dbTime = new DbTime((byte) 10, (byte) 12, (byte) 55);
        Assertions.assertNotNull(dbTime);
    }
}
