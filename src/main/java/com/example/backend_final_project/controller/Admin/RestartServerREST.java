package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.BackendFinalProjectApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class RestartServerREST {

        @GetMapping("/server/restart")
        public void restart() {
            BackendFinalProjectApplication.restart();
        }
    }

