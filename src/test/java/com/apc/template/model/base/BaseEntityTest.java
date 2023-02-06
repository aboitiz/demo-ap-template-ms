package com.apc.template.model.base;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseEntityTest {
    @Test
    void success() {
        Long id = 1L;
        Date date = new Date();
        BaseEntity model = new BaseEntity();
        model.setId(id);
        model.setCreatedAt(date);

        assertThat(model.getId()).isEqualTo(id);
        assertThat(model.getCreatedAt()).isInstanceOf(Date.class);
    }
}
