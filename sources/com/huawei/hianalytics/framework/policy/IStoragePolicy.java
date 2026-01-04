package com.huawei.hianalytics.framework.policy;

/* loaded from: classes5.dex */
public interface IStoragePolicy {

    public interface PolicyType {
        public static final String NETWORK = "NETWORK";
        public static final String PARAMS = "PARAMS";
        public static final String STORAGE_CYCLE = "STORAGE_CYCLE";
        public static final String STORAGE_LENGTH = "STORAGE_LENGTH";
        public static final String STORAGE_SIZE = "STORAGE_SIZE";
    }

    boolean decide(String str, String str2);

    boolean decide(String str, String str2, long j10);

    int getDecryptBatchSize(String str);

    int getDecryptBatchSleepTime(String str);

    int getDecryptMaxBatchSize(String str);
}
