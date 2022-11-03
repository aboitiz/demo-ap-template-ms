package com.apc.template.services.helpers;

import com.apc.template.exceptions.APException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeHelperTest {

    Date date;

    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        date = cal.getTime();
    }

    @Test
    void formatDateToTimestamp() throws APException {
        String UTC_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        TimeZone PST = TimeZone.getTimeZone("Asia/Manila");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(UTC_DATE_FORMAT);
        sdf.setTimeZone(PST);
        String expectedReturn = sdf.format(date);
        assertEquals(expectedReturn, DateTimeHelper.formatDateToTimestamp(date, UTC_DATE_FORMAT, PST));

    }

    @Test
    public void testFormatDateWithEmptyTimeZone() throws APException {
        assertNotEquals("Success Formatting",
                LocalDate.now().toString(), DateTimeHelper.formatDateToTimestamp(new Date(), "yyyy-MM-dd", null));
    }

    @Test
    public void testFormatDateWithEmptyFormat() throws APException {
        assertEquals(DateTimeHelper.formatDateToTimestamp(new Date(), "", TimeZone.getDefault()),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }

    @Test
    public void testFormatDateThrowsException() throws APException {
        try {
            DateTimeHelper.formatDateToTimestamp(null, "", null);
            APException thrown = assertThrows(APException.class,
                    Mockito::doNothing, "Error @ convertDateToCalendar:String :: date=");
            assertTrue(thrown.getMessage().contains("convertDateToCalendar"));
        } catch (Exception ignored) {
        }

    }
}