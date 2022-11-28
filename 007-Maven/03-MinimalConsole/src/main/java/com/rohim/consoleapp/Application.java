package com.rohim.consoleapp;

import com.rohim.consoleapp.loggers.ILogger;

public class Application {
    private ILogger logger;

    public Application(ILogger logger) {
        super();
        this.logger = logger;
    }

    public void Start() {
        logger.sayHi();
    }
}
