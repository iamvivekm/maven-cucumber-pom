package com.vivek.automation;

import com.vivek.automation.api.Service;
import io.cucumber.java.After;

public class GlobalHook {

    @After
    public void tearDown() {
        System.out.println("Inside after");
        TestState.destroy();
        Service.reset();
    }

}
