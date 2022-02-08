package com.marc7n.PropertyForRent.controller;

import com.marc7n.PropertyForRent.service.ReservationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@WebMvcTest(value = ReservationController.class)

class ReservationControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationServiceImpl reservationService;


    @Test
    void getAllReservationsByName() {
    }

    @Test
    void addReservation() {

    }

}