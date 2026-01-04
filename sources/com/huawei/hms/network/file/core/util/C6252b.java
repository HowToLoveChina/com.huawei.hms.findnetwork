package com.huawei.hms.network.file.core.util;

import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.network.file.api.exception.HttpException;
import com.huawei.hms.network.file.api.exception.InternalException;
import com.huawei.hms.network.file.api.exception.InterruptedException;
import com.huawei.hms.network.file.api.exception.NetWorkErrorException;
import com.huawei.hms.network.file.api.exception.NetWorkIOException;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.api.exception.ParamsCheckException;
import com.huawei.hms.network.file.api.exception.ServerException;
import com.huawei.hms.network.file.api.exception.UnKnownErrorException;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.huawei.hms.network.file.core.util.b */
/* loaded from: classes8.dex */
public class C6252b {

    /* renamed from: a */
    private static final List<Integer> f29509a = Collections.unmodifiableList(new a());

    /* renamed from: b */
    private static final List<Integer> f29510b = Collections.unmodifiableList(new b());

    /* renamed from: c */
    private static final List<Integer> f29511c = Collections.unmodifiableList(new c());

    /* renamed from: d */
    private static final List<Integer> f29512d = Collections.unmodifiableList(new d());

    /* renamed from: e */
    private static final List<Integer> f29513e = Collections.unmodifiableList(new e());

    /* renamed from: com.huawei.hms.network.file.core.util.b$a */
    public class a extends ArrayList<Integer> {
        public a() {
            add(Integer.valueOf(Constants.ErrorCode.TASK_UPLOAD_PARAMS_COMMON_ERROR.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.TASK_DOWNLOAD_PARAMS_COMMON_ERROR.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.FILE_SIZE_ERROR.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.TASK_UPLOAD_PARAMS_ERROR.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.CHECK_FILE_HASH_FAILED.getErrorCode()));
        }
    }

    /* renamed from: com.huawei.hms.network.file.core.util.b$b */
    public class b extends ArrayList<Integer> {
        public b() {
            add(Integer.valueOf(Constants.ErrorCode.CREATE_DOWNLOAD_FILE_FAILED.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.WRITE_FILE_EXCEPTION.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.FILE_IO_EXCEPTION.getErrorCode()));
        }
    }

    /* renamed from: com.huawei.hms.network.file.core.util.b$c */
    public class c extends ArrayList<Integer> {
        public c() {
            add(Integer.valueOf(Constants.ErrorCode.SERVER_EXCEPTION.getErrorCode()));
        }
    }

    /* renamed from: com.huawei.hms.network.file.core.util.b$d */
    public class d extends ArrayList<Integer> {
        public d() {
            add(Integer.valueOf(Constants.ErrorCode.TASK_PAUSE_EXCEPTION.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.TASK_CANCEL_EXCEPTION.getErrorCode()));
        }
    }

    /* renamed from: com.huawei.hms.network.file.core.util.b$e */
    public class e extends ArrayList<Integer> {
        public e() {
            add(Integer.valueOf(Constants.ErrorCode.UNKNOW_ERROR.getErrorCode()));
            add(Integer.valueOf(Constants.ErrorCode.TASK_UPLOAD_UNKNOWN_ERROR.getErrorCode()));
        }
    }

    /* renamed from: a */
    public static int m36358a(IOException iOException) {
        if (iOException == null) {
            return -1;
        }
        int errorCodeFromException = ExceptionCode.getErrorCodeFromException(iOException);
        FLogger.m36354v("ExceptionUtil", "getErrorCodeFromException errorcode from resclient: " + errorCodeFromException + ",message:" + iOException.getMessage());
        return errorCodeFromException;
    }

    /* renamed from: a */
    public static NetworkException m36359a(FileManagerException fileManagerException) {
        int errorCode = fileManagerException.getErrorCode();
        if (m36360a(fileManagerException.getCause())) {
            return new NetWorkErrorException("network error(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        if (f29509a.contains(Integer.valueOf(fileManagerException.getErrorCode()))) {
            return new ParamsCheckException("params check error(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        if (f29510b.contains(Integer.valueOf(fileManagerException.getErrorCode()))) {
            return new NetWorkIOException("io exception(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        if (f29511c.contains(Integer.valueOf(fileManagerException.getErrorCode()))) {
            return new HttpException("http exception(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        if (f29512d.contains(Integer.valueOf(fileManagerException.getErrorCode()))) {
            return new InterruptedException(errorCode, "interrupted exception(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        if (f29513e.contains(Integer.valueOf(fileManagerException.getErrorCode()))) {
            return new UnKnownErrorException("unknown error(" + fileManagerException.getErrorCode() + ")", fileManagerException);
        }
        String str = "inner exception(" + errorCode + ")";
        if (errorCode >= 1000) {
            return new InternalException(str, fileManagerException);
        }
        return new ServerException(fileManagerException.getErrorCode(), "server exception(" + errorCode + ")", fileManagerException);
    }

    /* renamed from: a */
    public static boolean m36360a(Throwable th2) {
        if (th2 instanceof FileManagerException) {
            th2 = th2.getCause();
        }
        return (th2 == null || (th2 instanceof IllegalArgumentException) || (th2 instanceof com.huawei.hms.network.exception.NetworkException) || (th2 instanceof CancellationException) || (th2 instanceof RejectedExecutionException) || (th2 instanceof FileNotFoundException)) ? false : true;
    }
}
