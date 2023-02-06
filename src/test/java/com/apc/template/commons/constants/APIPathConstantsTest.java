package com.apc.template.commons.constants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class APIPathConstantsTest {
    @Test
    void success_paths(){
        assertThat(new APIPathConstants()).isInstanceOf(APIPathConstants.class);
        assertThat(APIPathConstants.API_VERSION_1).isEqualTo("/v1/api");
        assertThat(APIPathConstants.CUSTOMER_BASE_PATH).isEqualTo("/customer");
        assertThat(APIPathConstants.USER_BASE_PATH).isEqualTo("/user");
    }
}
