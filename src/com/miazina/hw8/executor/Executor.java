package com.miazina.hw8.executor;

import com.miazina.hw8.tasks.*;

public class Executor {
    public static void start() {
        new TaskWithUsers().printResults();
    }
}
