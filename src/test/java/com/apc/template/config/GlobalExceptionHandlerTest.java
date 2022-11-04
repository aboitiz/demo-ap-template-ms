package com.apc.template.config;

import com.apc.commons.helper.DateHelper;
import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.BaseAPIErrorResponse;
import com.apc.template.commons.enums.APIResponse;
import com.apc.template.exceptions.APException;
import com.apc.template.services.helpers.DateTimeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTest {

    @Spy
    @InjectMocks
    private GlobalExceptionHandler handler;

    HttpServletRequest httpServletRequest;

    BaseResponse<Map<String, String>> response = new BaseResponse<>();

    private final String STATUS = "status";
    private final String ERROR = "ERROR";
    private final String MESSAGE = "Something went wrong";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        httpServletRequest = mock(HttpServletRequest.class);


        response.setMessage(MESSAGE);
        response.setStatusCode(STATUS);
        response.setTimestamp(DateHelper.getLocalDateTimeNow().toString());
        Map<String, String> data = new HashMap<>();
        data.put("error", MESSAGE);
        response.setData(data);
    }

    @Test
    void getTimestamp() throws APException {
        when(handler.getTimestamp())
                .thenReturn(DateTimeHelper.formatDateToTimestamp(new Date(), "", null));
        assertThat(handler.getTimestamp()).hasSize(14);
    }

    @Test
    void buildErrorResponse() throws APException {
        when(handler.buildErrorResponse(STATUS, APIResponse.SUCCESS, httpServletRequest, HttpStatus.OK))
                .thenReturn(null);
        assertThat(handler.buildErrorResponse(STATUS, APIResponse.SUCCESS, httpServletRequest, HttpStatus.OK))
                .isEqualTo(null);
    }

    @Test
    void handleUnexpectedException() throws APException {
        APException exception = new APException(ERROR, MESSAGE, HttpStatus.CONFLICT);
        ResponseEntity<?> response =
                handler.handleUnexpectedException(exception, httpServletRequest);
        assertThat(response.getBody()).isExactlyInstanceOf(BaseAPIErrorResponse.class);
    }

}