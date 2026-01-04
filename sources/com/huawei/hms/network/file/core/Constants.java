package com.huawei.hms.network.file.core;

import android.util.Pair;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public interface Constants {

    public enum ErrorCode {
        SUCCESS(10041000, "success"),
        REQUEST_NULL(10041001, "request is null"),
        REQUEST_ID_EXIST(10041002, "requestId already exist, can not start again"),
        REQUEST_NO_EXIST(10041003, "requestId not exist or finished"),
        REQUEST_URL_EMPTY(10041004, "url and backupUrls can not be empty,must start with http"),
        REQUEST_TASKS_EMPTY(10041005, "tasks can not be empty"),
        REQUEST_STATUS_ERROR(10041006, "status error"),
        REQUEST_UPDATE_REQUEST_ERROR(10041007, "onStart can not change the requestID"),
        SERVER_EXCEPTION(10041008, "server exception"),
        REQUEST_PATH_ERROR(10041009, "request filePath and fileRootDir cannot all be null"),
        REQUEST_OFFSET_ERROR(10041010, "offset can not smaller than 0"),
        TASK_UNCACHED_EXCEPTION(10042001, "task unCached exception"),
        TASK_PAUSE_EXCEPTION(10042002, "task is paused"),
        TASK_CANCEL_EXCEPTION(10042003, "task is canceled"),
        TASK_SUBMIT_EXCEPTION(10042004, "task submit exception"),
        TASK_COMPOSE_TMPFILE_ERROR(10043001, "download tmpfile not exist"),
        UNKNOW_ERROR(10043002, "unknown error"),
        CHECK_FILE_HASH_FAILED(10043003, "check file hash failed"),
        CREATE_DOWNLOAD_FILE_FAILED(10043004, "create download file failed"),
        WRITE_FILE_EXCEPTION(10043005, "write file exception"),
        FILE_IO_EXCEPTION(10043006, "file io exception"),
        FILE_NO_EXIST(10043007, "file not exist"),
        FILE_SIZE_ERROR(10043008, "file length error"),
        TASK_DOWNLOAD_PARAMS_COMMON_ERROR(10043009, "download params error:"),
        NOT_MODIFIED(10043010, "code 304, not modified"),
        TASK_UPLOAD_PARAMS_ERROR(10044001, "uploadTask pos + upload length outof filesize"),
        FILE_UPLOAD_NO_EXIST(10044002, "upload file not exist"),
        TASK_UPLOAD_PARAMS_COMMON_ERROR(10044003, "upload params error"),
        TASK_UPLOAD_UNKNOWN_ERROR(10044004, "unknown error"),
        TASK_UPLOAD_INPUT_STREAM_ERROR(10044005, "inputStream error");

        private int errorCode;
        private String errorMessage;

        ErrorCode(int i10, String str) {
            this.errorCode = i10;
            this.errorMessage = str;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }
    }

    /* renamed from: com.huawei.hms.network.file.core.Constants$a */
    public static class C6222a {

        /* renamed from: a */
        public static final Pair<Integer, Integer> f29366a = new Pair<>(20, Integer.MAX_VALUE);

        /* renamed from: b */
        public static final Pair<Integer, Integer> f29367b = new Pair<>(1000, Integer.MAX_VALUE);

        /* renamed from: c */
        public static final Pair<Integer, Integer> f29368c = new Pair<>(0, Integer.MAX_VALUE);

        /* renamed from: d */
        public static final Pair<Integer, Integer> f29369d = new Pair<>(0, Integer.MAX_VALUE);

        /* renamed from: e */
        public static final Pair<Integer, Integer> f29370e = new Pair<>(10, Integer.MAX_VALUE);

        /* renamed from: f */
        public static final Pair<Integer, Integer> f29371f = new Pair<>(0, 50);

        /* renamed from: g */
        public static final Pair<Integer, Integer> f29372g = new Pair<>(100, 2000);

        /* renamed from: h */
        public static final Pair<Integer, Integer> f29373h = new Pair<>(1, 100);

        /* renamed from: i */
        public static final Map<String, HashMap<Pair<Integer, Integer>, Integer>> f29374i = Collections.unmodifiableMap(new a());

        /* renamed from: com.huawei.hms.network.file.core.Constants$a$a */
        public class a extends HashMap<String, HashMap<Pair<Integer, Integer>, Integer>> {

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$a, reason: collision with other inner class name */
            public class C14444a extends HashMap<Pair<Integer, Integer>, Integer> {
                public C14444a(a aVar) {
                    put(C6222a.f29366a, 0);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$b */
            public class b extends HashMap<Pair<Integer, Integer>, Integer> {
                public b(a aVar) {
                    put(C6222a.f29367b, 10000);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$c */
            public class c extends HashMap<Pair<Integer, Integer>, Integer> {
                public c(a aVar) {
                    put(C6222a.f29368c, 10000);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$d */
            public class d extends HashMap<Pair<Integer, Integer>, Integer> {
                public d(a aVar) {
                    put(C6222a.f29369d, 10000);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$e */
            public class e extends HashMap<Pair<Integer, Integer>, Integer> {
                public e(a aVar) {
                    put(C6222a.f29370e, 0);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$f */
            public class f extends HashMap<Pair<Integer, Integer>, Integer> {
                public f(a aVar) {
                    put(C6222a.f29371f, 1);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$g */
            public class g extends HashMap<Pair<Integer, Integer>, Integer> {
                public g(a aVar) {
                    put(C6222a.f29372g, 500);
                }
            }

            /* renamed from: com.huawei.hms.network.file.core.Constants$a$a$h */
            public class h extends HashMap<Pair<Integer, Integer>, Integer> {
                public h(a aVar) {
                    put(C6222a.f29373h, -100);
                }
            }

            public a() {
                put("call_timeout", new C14444a(this));
                put(C6148x2.CONNECT_TIMEOUT, new b(this));
                put(C6148x2.WRITE_TIMEMEOUT, new c(this));
                put("read_timeout", new d(this));
                put("ping_interval", new e(this));
                put("retry_time", new f(this));
                put("concurrentConnectDelay", new g(this));
                put("threadPoolSize", new h(this));
            }
        }
    }

    /* renamed from: a */
    static boolean m36171a(int i10) {
        return i10 == ErrorCode.SUCCESS.getErrorCode() || (i10 >= 200 && i10 < 300);
    }
}
