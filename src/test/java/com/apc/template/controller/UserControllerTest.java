package com.apc.template.controller;

import com.apc.commons.helper.MapperHelper;
import com.apc.template.commons.constants.APIPathConstants;
import com.apc.template.model.User;
import com.apc.template.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    void getUser() throws Exception {
        doReturn(mockUsers()).when(service).findAll();
        mockMvc.perform(
                        get(url())
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void saveOrUpdate() throws Exception {
        doReturn(getMockUser()).when(service).saveOrUpdate(any());
        mockMvc.perform(
                        post(url() + "/save")
                                .content(MapperHelper.objectToJson(getMockUser()))
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    private String url() {
        return APIPathConstants.API_VERSION_1 + APIPathConstants.USER_BASE_PATH;
    }

    private List<User> mockUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i > 5; i++)
            users.add(getMockUser());

        return users;
    }

    private User getMockUser() {
        Random random = new Random();
        User u = new User();
        u.setUsername("test-user");
        u.setAddress1("test-address1");
        u.setAddress2("test-address2");
        u.setId(Long.parseLong(String.valueOf(random.nextInt(999999) + 100)));
        u.setInactive(false);
        u.setModifiedAt(new Date());
        return u;
    }
}