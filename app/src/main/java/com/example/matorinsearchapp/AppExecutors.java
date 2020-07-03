package com.example.matorinsearchapp;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private final Executor mDiskIO;
    private final Executor mNetworkIO;

    private static  AppExecutors mAppExecutors = new AppExecutors();
    public static AppExecutors getInstance() {
        return mAppExecutors;
    }

    private AppExecutors(Executor diskIO, Executor networkIO) {
        this.mDiskIO = diskIO;
        this.mNetworkIO = networkIO;
    }

    private AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3));
    }

    public Executor diskIO() {
        return mDiskIO;
    }

    public Executor networkIO() {
        return mNetworkIO;
    }



}
