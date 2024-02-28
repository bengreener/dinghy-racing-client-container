package com.bginfosys.dinghyracingclientcontainer.remoteconections.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller.DinghyRacingPropertiesController;

@WebMvcTest(DinghyRacingPropertiesController.class)
public class DinghyRacingPropertiesControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithMockUser
	void when_connectionURLsRequested_then_returnsConnectionURLs() throws Exception {
		mockMvc.perform(get("/dinghyracingproperties/connectionurls")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.httpRootURL", is("http://localhost:8081/dinghyracing/api")))
		.andExpect(jsonPath("$.wsRootURL", is("ws://localhost:8081/dinghyracingws")));
	}
}
