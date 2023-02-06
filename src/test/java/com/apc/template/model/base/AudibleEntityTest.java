package com.apc.template.model.base;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AudibleEntityTest {
    @Test
    void success() {
        Long id = 1L;
        Date date = new Date();
        AuditableEntity model = new AuditableEntity();
        model.setId(id);
        model.setModifiedAt(null);
        model.setCreatedAt(date);

        assertThat(model.getId()).isEqualTo(id);
        assertThat(model.getModifiedAt()).isNull();
        assertThat(model.getCreatedAt()).isInstanceOf(Date.class);
    }

    @Test
    void success_equalsTo_hashCode() {
        Date date = new Date();
        AuditableEntity model = new AuditableEntity();
        model.setModifiedAt(null);
        model.setCreatedAt(date);

        AuditableEntity model2 = new AuditableEntity();
        model2.setModifiedAt(null);
        model2.setCreatedAt(date);

        assertThat(model.equals(model2)).isTrue();
        assertThat(model.hashCode()).hasSameHashCodeAs(model2);
    }
}
