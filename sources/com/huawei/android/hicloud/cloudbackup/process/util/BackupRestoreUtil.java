package com.huawei.android.hicloud.cloudbackup.process.util;

import am.InterfaceC0275i1;
import android.content.Context;
import android.content.p017pm.IPackageDataObserver;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.p018os.IBackupSessionCallback;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.network.embedded.C5863b6;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0221j;
import p015ak.C0241z;
import p495nm.C11733n;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12586r;

/* loaded from: classes2.dex */
public class BackupRestoreUtil {
    private static final String HONOR_R_ROOT_CACHE = "/data/media/";
    private static final Object LOCK = new Object();
    private static final int LOG_OUTPUT_TIME_INTERVAL = 2000;
    private static final long M_TO_MS = 1000;
    private static final long PMS_BRIEFFILE_PROGRESS_WAIT_TIME = 1000;
    public static final long PMS_DEFAULT_TXT_SPEED = 300000000;
    private static final int SLEEP_TIME = 100;
    private static final String TAG = "BackupRestoreUtil";
    private static final int WAIT_DATA_TIMEOUT = 3600000;
    private boolean cleanAppDataResult;
    private boolean isCompleted;
    private long logStartTime;
    private Context mContext;
    private boolean mGetFdFinsh;
    private String mLocation;
    protected ICallback mProgressCallback;
    private final IBackupSessionCallback mSessionCallback;
    private int mSessionId;
    private int mTaskId;
    private boolean mTaskIdException;
    private boolean mTaskIdFinish;
    private long pmsBriefFileSpeed;
    private InterfaceC0275i1 pmsCopyProgressCallback;
    private C11733n pmsFileModel;
    private long pmsProgressUpdateTime;
    private long receiveTime;
    private long receivedAppendData;
    protected CacheTask task;

    public interface BriefSupplier {
        void checkExists(List<String> list) throws C9721b;

        void close();

        String getResultFilePath();

        boolean isSupport();

        boolean isValid();

        void traverse(Consumer<String[]> consumer) throws C9721b;
    }

    public static class MyPrivilegedAction implements PrivilegedAction {
        private Method method;

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.method.setAccessible(true);
            return null;
        }

        private MyPrivilegedAction(Method method) {
            this.method = method;
        }
    }

    public class PackageDataObserver extends IPackageDataObserver.Stub {
        public PackageDataObserver() {
        }

        @Override // android.content.p017pm.IPackageDataObserver
        public void onRemoveCompleted(String str, boolean z10) throws RemoteException {
            BackupRestoreUtil.this.isCompleted = true;
            BackupRestoreUtil.this.cleanAppDataResult = z10;
        }
    }

    public static class SimpleBriefSupplier implements BriefSupplier {
        private final String parentPath;
        private final int resultCode;
        private final String resultFilePath;

        public SimpleBriefSupplier(int i10, String str, String str2) {
            this.resultCode = i10;
            this.resultFilePath = str;
            this.parentPath = str2;
        }

        private boolean isPmsValid(String[] strArr) {
            if (strArr == null) {
                C11839m.m70689w(BackupRestoreUtil.TAG, "Pms data is invalid!");
                return false;
            }
            if (strArr.length == 5) {
                return true;
            }
            C11839m.m70689w(BackupRestoreUtil.TAG, "Pms data is invalid!");
            return false;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public void checkExists(List<String> list) throws C9721b, IOException {
            if (list.isEmpty()) {
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(this.resultFilePath);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                String[] strArrSplit = line.split(";");
                                ArrayList arrayList = new ArrayList();
                                if (isPmsValid(strArrSplit)) {
                                    for (String str : list) {
                                        if (str != null && strArrSplit[0].startsWith(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                }
                                list.removeAll(arrayList);
                                if (list.isEmpty()) {
                                    break;
                                }
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e10) {
                C11839m.m70687e(BackupRestoreUtil.TAG, "SimpleBriefSupplier traverse FileNotFoundException: " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "SimpleBriefSupplier checkExists FileNotFoundException  error " + e10.getMessage());
            } catch (IOException e11) {
                C11839m.m70687e(BackupRestoreUtil.TAG, "SimpleBriefSupplier traverse IOException: " + e11.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "SimpleBriefSupplier checkExists IOException  error " + e11.getMessage());
            } catch (Exception e12) {
                C11839m.m70687e(BackupRestoreUtil.TAG, "unknown error: " + e12.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error: " + e12.getMessage());
            }
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public void close() {
            if (TextUtils.isEmpty(this.parentPath)) {
                return;
            }
            C11835i.m70643g(this.parentPath);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public String getResultFilePath() {
            return this.resultFilePath;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public boolean isSupport() {
            return this.resultCode != -3;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public boolean isValid() {
            if (this.resultCode != 0) {
                return false;
            }
            return C10278a.m63442h(this.resultFilePath).exists();
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.BriefSupplier
        public void traverse(Consumer<String[]> consumer) throws C9721b, IOException {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.resultFilePath);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                final String[] strArrSplit = line.split(";");
                                if (isPmsValid(strArrSplit)) {
                                    Optional.of(consumer).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.e
                                        @Override // java.util.function.Consumer
                                        public final void accept(Object obj) {
                                            ((Consumer) obj).accept(strArrSplit);
                                        }
                                    });
                                } else {
                                    C11839m.m70687e(BackupRestoreUtil.TAG, "SimpleBriefSupplier traverse custArray invalid !");
                                }
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e10) {
                C11839m.m70687e(BackupRestoreUtil.TAG, "SimpleBriefSupplier traverse FileNotFoundException: " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "SimpleBriefSupplier traverse FileNotFoundException  error " + e10.getMessage());
            } catch (IOException e11) {
                C11839m.m70687e(BackupRestoreUtil.TAG, "SimpleBriefSupplier traverse IOException: " + e11.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "SimpleBriefSupplier traverse IOException  error " + e11.getMessage());
            }
        }
    }

    public BackupRestoreUtil(Context context, ICallback iCallback, String str) {
        this.mGetFdFinsh = false;
        this.mTaskId = -1;
        this.mSessionId = -1;
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.receiveTime = 0L;
        this.pmsProgressUpdateTime = 0L;
        this.logStartTime = 0L;
        this.receivedAppendData = 0L;
        this.isCompleted = false;
        this.cleanAppDataResult = false;
        this.pmsBriefFileSpeed = 0L;
        this.mSessionCallback = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.1
            @Override // android.p018os.IBackupSessionCallback
            public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                C11839m.m70688i(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fileSize: " + j10 + " modifiedTime: " + j11);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    BackupRestoreUtil.this.pmsFileModel.m70026h(parcelFileDescriptor);
                    BackupRestoreUtil.this.pmsFileModel.m70024f(j10);
                    BackupRestoreUtil.this.pmsFileModel.m70025g(j11 * 1000);
                } else if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e10) {
                        C11839m.m70687e(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fd close error: " + e10.toString());
                    }
                }
                BackupRestoreUtil.this.mGetFdFinsh = true;
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str2) {
                C11839m.m70686d(BackupRestoreUtil.TAG, "onTaskStatusChanged:sessionId = " + BackupRestoreUtil.this.mSessionId + "/" + i10 + ",taskId = " + BackupRestoreUtil.this.mTaskId + "/" + i11 + ",statusCode = " + i12 + ",appendData = " + str2);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.receiveTime = System.currentTimeMillis();
                    long jM1688f = C0241z.m1688f(str2);
                    if (i12 == 3 && jM1688f > BackupRestoreUtil.this.receivedAppendData) {
                        BackupRestoreUtil.this.receivedAppendData = jM1688f;
                    }
                    if (i12 != -1) {
                        if (i12 == 0) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file success.");
                            BackupRestoreUtil backupRestoreUtil = BackupRestoreUtil.this;
                            backupRestoreUtil.updatePmsProgress(String.valueOf(backupRestoreUtil.receivedAppendData));
                            BackupRestoreUtil.this.mTaskIdFinish = true;
                            if (BackupRestoreUtil.this.pmsFileModel != null) {
                                BackupRestoreUtil.this.pmsFileModel.m70023e(true);
                                return;
                            }
                            return;
                        }
                        if (i12 == 1) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file begin.");
                            BackupRestoreUtil backupRestoreUtil2 = BackupRestoreUtil.this;
                            backupRestoreUtil2.logStartTime = backupRestoreUtil2.receiveTime;
                            BackupRestoreUtil.this.receivedAppendData = 0L;
                            return;
                        }
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 != 6) {
                                    return;
                                }
                                BackupRestoreUtil.this.updatePmsProgress(str2);
                                return;
                            } else {
                                if (BackupRestoreUtil.this.receiveTime - BackupRestoreUtil.this.logStartTime >= RippleView.SINGLE_RIPPLE_TIME) {
                                    BackupRestoreUtil backupRestoreUtil3 = BackupRestoreUtil.this;
                                    backupRestoreUtil3.logStartTime = backupRestoreUtil3.receiveTime;
                                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS running, statusCode: " + i12 + ";appendData: " + str2);
                                    BackupRestoreUtil.this.updatePmsProgress(str2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (BackupRestoreUtil.this.pmsFileModel == null) {
                        BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    }
                    BackupRestoreUtil.this.pmsFileModel.m70023e(!str2.contains(String.valueOf(-22)));
                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file error, statusCode: " + i12);
                    BackupRestoreUtil.this.mTaskIdFinish = true;
                    BackupRestoreUtil.this.mTaskIdException = true;
                }
            }
        };
        this.mContext = context;
        this.mProgressCallback = iCallback;
        this.mLocation = checkLocation(str);
    }

    private String adapteHonorRPath(int i10, String str) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strM1512v)) {
            return str;
        }
        if (str.startsWith(strM1512v)) {
            return str.replaceFirst(strM1512v, getHonorRRoot(0));
        }
        String strM1504n = C0221j.m1504n(i10);
        return TextUtils.isEmpty(strM1504n) ? str : str.replaceFirst(strM1504n, getHonorRRoot(i10));
    }

    private void convertPmsTxt(String str, String str2, File file, int i10, int i11, String[] strArr) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        if (!file.exists()) {
            C11839m.m70687e(TAG, "convertTwinPmsTxt: " + str + " not exist");
            return;
        }
        File fileM63443i = C10278a.m63443i(this.mLocation, str2 + ".txt");
        if (i10 == i11 && strArr == null) {
            renamePmsTxt(str, str2, file, fileM63443i);
            return;
        }
        C11839m.m70688i(TAG, "convertTwinPmsTxt start: " + str);
        File fileM63441g = C10278a.m63441g(C10278a.m63437c(file), "tempfile");
        if (fileM63441g.exists() && !fileM63441g.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "convertTwinPmsTxt tempFile delete error");
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                } catch (FileNotFoundException e10) {
                    e = e10;
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = null;
                }
            } catch (FileNotFoundException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    String line = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(line) && line.startsWith(BackupRestoreConstans.getUserPath(i10))) {
                        stringBuffer.append(line.replaceFirst(BackupRestoreConstans.getUserPath(i10), BackupRestoreConstans.getUserPath(i11)));
                        stringBuffer.append(System.lineSeparator());
                        int i12 = 0;
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null) {
                                C0209d.m1263i(bufferedReader2);
                                C0209d.m1263i(inputStreamReader);
                                C0209d.m1263i(fileInputStream);
                                if (stringBuffer.length() > 0) {
                                    matchAndWriteString(fileM63441g, stringBuffer);
                                }
                                boolean zDelete = file.delete();
                                if (zDelete && fileM63441g.renameTo(fileM63443i)) {
                                    C11839m.m70688i(TAG, "convertTwinPmsTxt end");
                                    return;
                                }
                                throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "convertTwinPmsTxt delete error or rename error = " + zDelete);
                            }
                            if (isAbort()) {
                                throw new C9721b(1999, "convertTwinPmsTxt task abort");
                            }
                            i12++;
                            if (strArr != null) {
                                int length = strArr.length;
                                int i13 = 0;
                                while (i13 < length) {
                                    int i14 = length;
                                    if (line2.contains(strArr[i13])) {
                                        break;
                                    }
                                    i13++;
                                    length = i14;
                                }
                            }
                            String strReplaceFirst = i11 != i10 ? line2.replaceFirst(BackupRestoreConstans.getUserPath(i10), BackupRestoreConstans.getUserPath(i11)) : line2;
                            if (i12 >= 1000 && line2.startsWith(BackupRestoreConstans.getUserPath(i10))) {
                                matchAndWriteString(fileM63441g, stringBuffer);
                                stringBuffer.delete(0, stringBuffer.length());
                                i12 = 0;
                            }
                            stringBuffer.append(strReplaceFirst);
                            stringBuffer.append(System.lineSeparator());
                        }
                    }
                    C11839m.m70689w(TAG, "convertTwinPmsTxt first line is invalid.");
                    renamePmsTxt(str, str2, file, fileM63443i);
                    C0209d.m1263i(bufferedReader2);
                    C0209d.m1263i(inputStreamReader);
                    C0209d.m1263i(fileInputStream);
                } catch (FileNotFoundException e14) {
                    e = e14;
                    C11839m.m70687e(TAG, "filterDataFile FileNotFoundException: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "filterDataFile FileNotFoundException delete error");
                } catch (IOException e15) {
                    e = e15;
                    C11839m.m70687e(TAG, "filterDataFile IOException: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "filterDataFile IOException delete error");
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = bufferedReader2;
                    C0209d.m1263i(bufferedReader);
                    C0209d.m1263i(inputStreamReader);
                    C0209d.m1263i(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            } catch (Throwable th5) {
                th = th5;
                C0209d.m1263i(bufferedReader);
                C0209d.m1263i(inputStreamReader);
                C0209d.m1263i(fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    public static int countStr(String str, String str2) {
        int i10 = 0;
        while (str.indexOf(str2) != -1) {
            i10++;
            str = str.substring(str.indexOf(str2) + str2.length());
        }
        return i10;
    }

    private void createFilterFile(String str, List<String> list, List<String> list2, int i10) throws C9721b, IOException {
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "v3 generatePmsByFile delete byfile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 delete cache brief file error");
        }
        try {
            if (!fileM63442h.createNewFile()) {
                C11839m.m70687e(TAG, "createFilterFile error");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createFilterFile create filter File");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileM63442h);
            try {
                PmsUtils.generatePmsFilterFileContent(list, list2, fileOutputStream, i10);
                fileOutputStream.close();
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createFilterFile create filter File IOException: " + e10.getMessage());
        }
    }

    private int execute(String str) {
        int iExecuteCmd;
        synchronized (LOCK) {
            iExecuteCmd = executeCmd(str);
        }
        return iExecuteCmd;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0079: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:23:0x0079 */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int executeCmd(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.executeCmd(java.lang.String):int");
    }

    private static final String getHonorRRoot(int i10) {
        return HONOR_R_ROOT_CACHE + i10;
    }

    private void init() {
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.mSessionId = -1;
        this.mTaskId = -1;
        this.mGetFdFinsh = false;
        this.pmsFileModel = null;
    }

    private boolean isAbort() throws InterruptedException {
        ICallback iCallback = this.mProgressCallback;
        if (iCallback != null && iCallback.onStop()) {
            C11839m.m70687e(TAG, "pmsBackup backup mProgressCallback is abort");
            return true;
        }
        try {
            CacheTask cacheTask = this.task;
            if (cacheTask == null) {
                return false;
            }
            cacheTask.isCancel();
            return false;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "pmsBackup backup task is isAbort: " + e10.getMessage());
            return true;
        }
    }

    private boolean isInValid(int i10) {
        return i10 == -4 || i10 == -3 || i10 == -2 || i10 == -1;
    }

    private void matchAndWriteString(File file, StringBuffer stringBuffer) throws Throwable {
        String string = stringBuffer.toString();
        if (TextUtils.isEmpty(string)) {
            C11839m.m70688i(TAG, "originStr is empty");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(string.getBytes(StandardCharsets.UTF_8));
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString FileNotFoundException " + e.toString());
                } catch (IOException e11) {
                    e = e11;
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString IOException " + e.toString());
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void renamePmsDir(String str, String str2) throws C9721b {
        if (str.equals(str2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mLocation);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str);
        File file = new File(sb2.toString());
        File file2 = new File(this.mLocation + str3 + str2);
        if (!file.isDirectory()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "renamePmsDir local dir not exist");
        }
        if (!file.renameTo(file2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "renamePmsDir rename error");
        }
    }

    private void renamePmsTxt(String str, String str2, File file, File file2) throws C9721b {
        if (str.equals(str2)) {
            return;
        }
        if (file2.exists() && !file2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "convertTwinPmsTxt tempFile delete error");
        }
        if (!file.renameTo(file2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "convertTwinPmsTxt rename error");
        }
    }

    private void syncGetFdLock() {
        this.receiveTime = System.currentTimeMillis();
        while (!this.mGetFdFinsh) {
            if (isAbort()) {
                C11839m.m70689w(TAG, "syncGetFdLock pms execute is abort");
                this.mTaskIdException = true;
                return;
            } else if (waitSleep()) {
                C11839m.m70689w(TAG, "syncGetFdLock pms execute time out");
                this.mTaskIdException = true;
                return;
            }
        }
    }

    private void syncLock() {
        this.receiveTime = System.currentTimeMillis();
        while (!this.mTaskIdFinish) {
            if (isAbort()) {
                C11839m.m70689w(TAG, "pms execute is abort");
                this.mTaskIdFinish = true;
                this.mTaskIdException = true;
                return;
            } else if (waitSleep()) {
                C11839m.m70689w(TAG, "pms execute time out");
                this.mTaskIdFinish = true;
                this.mTaskIdException = true;
                return;
            } else if (this.pmsCopyProgressCallback != null && this.pmsBriefFileSpeed > 0 && System.currentTimeMillis() - this.pmsProgressUpdateTime > 1000) {
                this.pmsCopyProgressCallback.mo1767a(this.pmsBriefFileSpeed);
                this.pmsProgressUpdateTime = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePmsProgress(String str) {
        if (this.pmsCopyProgressCallback != null && this.pmsBriefFileSpeed <= 0) {
            long jM1688f = C0241z.m1688f(str);
            if (jM1688f <= 0) {
                return;
            }
            this.pmsCopyProgressCallback.mo1767a(jM1688f);
        }
    }

    private boolean waitSleep() {
        SystemClock.sleep(100L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.receiveTime <= C5863b6.g.f26453g) {
            return false;
        }
        C11839m.m70687e(TAG, "Time = " + (jCurrentTimeMillis - this.receiveTime));
        return true;
    }

    public int backup(String str, String str2, String str3) {
        return execute(CloudBackupConstant.Command.PMS_CMD_BACKUP + " " + str + " " + str2 + " " + str3);
    }

    public int backupAndroid(String str, int i10, String str2, String str3) {
        if (!C0209d.m1179I1()) {
            C11839m.m70687e(TAG, "is not r version.");
            return -1;
        }
        if (!TextUtils.equals(str2, str3)) {
            String strM63452a = C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(str3)));
            if (C0209d.m1273k1()) {
                str2 = adapteHonorRPath(i10, str2);
                strM63452a = adapteHonorRPath(i10, strM63452a);
            }
            return backup(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, str2, strM63452a);
        }
        C11839m.m70688i(TAG, "appid = " + str + ", backupAndroid filepath transfer error " + str3);
        return -1;
    }

    public C11733n backupFd(String str) {
        String str2 = CloudBackupConstant.Command.PMS_CMD_BACKUP + " " + CloudBackupConstant.Command.PMS_OPTION_FD + " " + str;
        synchronized (LOCK) {
            try {
                if (executeCmd(str2) == 0) {
                    syncGetFdLock();
                    if (this.mTaskIdException) {
                        return null;
                    }
                    return this.pmsFileModel;
                }
                C11839m.m70689w(TAG, "backupFd execute result not success.");
                C11733n c11733n = this.pmsFileModel;
                if (c11733n == null || c11733n.m70022d()) {
                    return null;
                }
                return this.pmsFileModel;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String checkLocation(String str) {
        if (str == null) {
            C11839m.m70689w(TAG, "location is null");
            return "";
        }
        if (str.startsWith(BackupRestoreConstans.DATA_PATH)) {
            return str;
        }
        String str2 = BackupRestoreConstans.DATA_USER_PATH + C0209d.m1222X() + File.separator;
        return str.startsWith(str2) ? str.replace(str2, BackupRestoreConstans.DATA_PATH) : str;
    }

    public boolean cleanAppData(Context context, String str, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i(TAG, "clean Data begin:" + str + " uid: " + i10);
        if (context == null || str == null) {
            C11839m.m70687e(TAG, "releaseResource,clean this app data fail");
            return false;
        }
        this.cleanAppDataResult = false;
        this.isCompleted = false;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return this.cleanAppDataResult;
        }
        if (i10 == 0) {
            try {
                Method method = Class.forName(packageManager.getClass().getName()).getMethod("clearApplicationUserData", String.class, IPackageDataObserver.class);
                AccessController.doPrivileged(new MyPrivilegedAction(method));
                method.invoke(packageManager, str, new PackageDataObserver());
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "closeBackGroundProcess error " + e10.toString());
                return this.cleanAppDataResult;
            }
        } else {
            try {
                Method method2 = Class.forName("android.app.AppGlobals").getMethod("getPackageManager", new Class[0]);
                AccessController.doPrivileged(new MyPrivilegedAction(method2));
                PackageDataObserver packageDataObserver = new PackageDataObserver();
                Object objInvoke = method2.invoke(null, new Object[0]);
                Method method3 = Class.forName("android.content.pm.IPackageManager").getMethod("clearApplicationUserData", String.class, IPackageDataObserver.class, Integer.TYPE);
                AccessController.doPrivileged(new MyPrivilegedAction(method3));
                method3.invoke(objInvoke, str, packageDataObserver, Integer.valueOf(i10));
            } catch (Exception e11) {
                C11839m.m70688i(TAG, "cleanAppData exception happen: " + e11.getMessage());
                return this.cleanAppDataResult;
            }
        }
        waitForCallback();
        C11839m.m70688i(TAG, "clean Data end:" + str);
        return this.cleanAppDataResult;
    }

    public void delCrate() {
        if (TextUtils.isEmpty(this.mLocation)) {
            C11839m.m70687e(TAG, "delCrate fail mLocation is empty");
        } else {
            C12571m.m75547i(this.mLocation);
        }
    }

    public int getBrief(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C11839m.m70689w(TAG, "parameter is error");
            return -1;
        }
        return execute(CloudBackupConstant.Command.PMS_CMD_GET_BRIEF + " " + str + " " + str2 + " " + str3);
    }

    public int move(String str, String str2, String str3) {
        return execute(CloudBackupConstant.Command.PMS_CMD_MOVE + " " + str + " " + str2 + " " + str3);
    }

    public int pmsBackup(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70687e(TAG, "pmsBackup srcPath is empty");
            return -1;
        }
        C11839m.m70688i(TAG, "moduleName:" + str);
        delCrate();
        return backup(CloudBackupConstant.Command.PMS_OPTION_DIR, str2, this.mLocation);
    }

    public int pmsMove(String str) {
        if (!TextUtils.isEmpty(str)) {
            return pmsMove(str, str, C0209d.m1222X(), C0209d.m1222X(), true);
        }
        C11839m.m70687e(TAG, "pmsMove appId is null");
        return -1;
    }

    public int pmsRestore(String str) {
        String defaultDataPath;
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "pmsRestore mContext is null");
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "pmsRestore appId is null");
            return -1;
        }
        if (TextUtils.isEmpty(this.mLocation)) {
            C11839m.m70687e(TAG, "pmsRestore mLocation is empty");
            return -1;
        }
        if (!cleanAppData(this.mContext, str, 0)) {
            C11839m.m70687e(TAG, "pmsRestore cleanAppData failed");
            return -1;
        }
        StringBuilder sb2 = new StringBuilder("restore");
        sb2.append(" ");
        sb2.append(CloudBackupConstant.Command.PMS_OPTION_DIR);
        sb2.append(" ");
        sb2.append(this.mLocation);
        sb2.append(" ");
        if (C0209d.m1222X() == 0) {
            defaultDataPath = BackupRestoreConstans.DATA_PATH + str;
        } else {
            defaultDataPath = BackupRestoreConstans.getDefaultDataPath(str);
        }
        sb2.append(defaultDataPath);
        return execute(sb2.toString());
    }

    public void setPmsBriefFileSpeed(long j10) {
        this.pmsBriefFileSpeed = j10;
    }

    public int toTar(String str, String str2, String str3, String str4) {
        C11839m.m70686d(TAG, "toTar delete desTarFileName result: " + C11835i.m70643g(str2));
        C11839m.m70686d(TAG, "toTar delete desTarTxtPathName result: " + C11835i.m70643g(str4));
        return execute(CloudBackupConstant.Command.PMS_CMD_BACKUP + " " + CloudBackupConstant.Command.PMS_OPTION_FILE_TOTAR + " " + str + " " + str2 + " " + str3);
    }

    public void waitForCallback() {
        while (!this.isCompleted && !isAbort()) {
            SystemClock.sleep(100L);
        }
    }

    public int pmsMove(String str, String str2, int i10, int i11, boolean z10) throws Throwable {
        String defaultDataPath;
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "pmsRestore mContext is null");
            return -1;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(this.mLocation)) {
                C11839m.m70687e(TAG, "pmsRestore mLocation is empty");
                return -1;
            }
            if (z10 && !cleanAppData(this.mContext, str2, i11)) {
                C11839m.m70687e(TAG, "pmsRestore cleanAppData failed");
                return -1;
            }
            String strSrcPathCheckBeforePmsMoveExecute = RestoreUtil.srcPathCheckBeforePmsMoveExecute(z10, str, i10);
            if (TextUtils.isEmpty(strSrcPathCheckBeforePmsMoveExecute)) {
                return -1;
            }
            if (i10 != i11) {
                try {
                    convertPmsTxt(str, str2, C10278a.m63443i(this.mLocation, str + ".txt"), i10, i11, null);
                } catch (C9721b e10) {
                    C11839m.m70687e(TAG, "pmsMove convertTwinPmsTxt failed: " + e10.getMessage());
                    return -1;
                }
            }
            if (i11 == 0) {
                defaultDataPath = BackupRestoreConstans.DATA_PATH + str2;
            } else {
                defaultDataPath = BackupRestoreConstans.getDefaultDataPath(str2, i11);
            }
            return execute(CloudBackupConstant.Command.PMS_CMD_MOVE + " " + CloudBackupConstant.Command.PMS_OPTION_DIR + " " + strSrcPathCheckBeforePmsMoveExecute + " " + defaultDataPath);
        }
        C11839m.m70687e(TAG, "pmsMove appId or oriAppName is null");
        return -1;
    }

    public int backupAndroid(String str, String str2, int i10) throws C9721b {
        String strM75713d = C12586r.m75713d();
        File fileM63442h = C10278a.m63442h(strM75713d);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70689w(TAG, "backupAndroid destPath mkdir failed: " + strM75713d);
        }
        File fileM63443i = C10278a.m63443i(strM75713d, str);
        SplitAppUtil.deleteDir(fileM63443i);
        File fileM63441g = C10278a.m63441g(C10278a.m63442h(strM75713d), str2);
        C12571m.m75547i(C10279b.m63452a(fileM63441g));
        String str3 = strM75713d + str2 + ".txt";
        C12571m.m75547i(str3);
        String strM75670f = C12583q.m75670f(i10, ICBUtil.ANDROID_DATA, str2);
        if (C0209d.m1273k1()) {
            strM75670f = adapteHonorRPath(i10, strM75670f);
            strM75713d = adapteHonorRPath(i10, strM75713d);
        }
        String str4 = File.separator;
        if (strM75713d.endsWith(str4)) {
            strM75713d = strM75713d.substring(0, strM75713d.lastIndexOf(str4));
        }
        int iBackup = backup(CloudBackupConstant.Command.PMS_OPTION_DIR, strM75670f, strM75713d);
        if (iBackup == 0) {
            if (fileM63441g.exists() && fileM63441g.renameTo(fileM63443i)) {
                C11839m.m70688i(TAG, "pms copy and rename success");
            } else {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "rename file error path: " + C10279b.m63452a(fileM63441g) + " ,toPath: " + C10279b.m63452a(fileM63443i));
            }
        }
        C12571m.m75547i(str3);
        return iBackup;
    }

    public BriefSupplier getBrief(String str, List<String> list, List<String> list2, int i10, String str2) {
        if (this.mContext == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iNextInt = new Random().nextInt(ExceptionCode.CRASH_EXCEPTION);
        int size = list.size() + (list2 == null ? 0 : list2.size());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mContext.getCacheDir());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(jCurrentTimeMillis);
        sb2.append(iNextInt);
        sb2.append(size);
        String string = sb2.toString();
        String str4 = string + str3 + str2;
        String str5 = str4 + str3 + "filter.txt";
        String str6 = str4 + str3 + "result.txt";
        File fileM63442h = C10278a.m63442h(str4);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "v3 generatePmsByFile delete byfile error: " + fileM63442h.getName());
        }
        try {
            if (fileM63442h.mkdirs()) {
                createFilterFile(str5, list, list2, i10);
                return new SimpleBriefSupplier(getBrief(str, str5, str6), str6, string);
            }
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getBrief mkdirs fail ");
        } catch (C9721b | IOException e10) {
            C11839m.m70687e(TAG, "getBrief  IOException or CException: " + e10.getMessage());
            C11835i.m70643g(str4);
            C11835i.m70643g(str5);
            C11835i.m70643g(str6);
            return new SimpleBriefSupplier(-1, str6, string);
        }
    }

    public BackupRestoreUtil(Context context) {
        this.mGetFdFinsh = false;
        this.mTaskId = -1;
        this.mSessionId = -1;
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.receiveTime = 0L;
        this.pmsProgressUpdateTime = 0L;
        this.logStartTime = 0L;
        this.receivedAppendData = 0L;
        this.isCompleted = false;
        this.cleanAppDataResult = false;
        this.pmsBriefFileSpeed = 0L;
        this.mSessionCallback = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.1
            @Override // android.p018os.IBackupSessionCallback
            public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                C11839m.m70688i(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fileSize: " + j10 + " modifiedTime: " + j11);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    BackupRestoreUtil.this.pmsFileModel.m70026h(parcelFileDescriptor);
                    BackupRestoreUtil.this.pmsFileModel.m70024f(j10);
                    BackupRestoreUtil.this.pmsFileModel.m70025g(j11 * 1000);
                } else if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e10) {
                        C11839m.m70687e(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fd close error: " + e10.toString());
                    }
                }
                BackupRestoreUtil.this.mGetFdFinsh = true;
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str2) {
                C11839m.m70686d(BackupRestoreUtil.TAG, "onTaskStatusChanged:sessionId = " + BackupRestoreUtil.this.mSessionId + "/" + i10 + ",taskId = " + BackupRestoreUtil.this.mTaskId + "/" + i11 + ",statusCode = " + i12 + ",appendData = " + str2);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.receiveTime = System.currentTimeMillis();
                    long jM1688f = C0241z.m1688f(str2);
                    if (i12 == 3 && jM1688f > BackupRestoreUtil.this.receivedAppendData) {
                        BackupRestoreUtil.this.receivedAppendData = jM1688f;
                    }
                    if (i12 != -1) {
                        if (i12 == 0) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file success.");
                            BackupRestoreUtil backupRestoreUtil = BackupRestoreUtil.this;
                            backupRestoreUtil.updatePmsProgress(String.valueOf(backupRestoreUtil.receivedAppendData));
                            BackupRestoreUtil.this.mTaskIdFinish = true;
                            if (BackupRestoreUtil.this.pmsFileModel != null) {
                                BackupRestoreUtil.this.pmsFileModel.m70023e(true);
                                return;
                            }
                            return;
                        }
                        if (i12 == 1) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file begin.");
                            BackupRestoreUtil backupRestoreUtil2 = BackupRestoreUtil.this;
                            backupRestoreUtil2.logStartTime = backupRestoreUtil2.receiveTime;
                            BackupRestoreUtil.this.receivedAppendData = 0L;
                            return;
                        }
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 != 6) {
                                    return;
                                }
                                BackupRestoreUtil.this.updatePmsProgress(str2);
                                return;
                            } else {
                                if (BackupRestoreUtil.this.receiveTime - BackupRestoreUtil.this.logStartTime >= RippleView.SINGLE_RIPPLE_TIME) {
                                    BackupRestoreUtil backupRestoreUtil3 = BackupRestoreUtil.this;
                                    backupRestoreUtil3.logStartTime = backupRestoreUtil3.receiveTime;
                                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS running, statusCode: " + i12 + ";appendData: " + str2);
                                    BackupRestoreUtil.this.updatePmsProgress(str2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (BackupRestoreUtil.this.pmsFileModel == null) {
                        BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    }
                    BackupRestoreUtil.this.pmsFileModel.m70023e(!str2.contains(String.valueOf(-22)));
                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file error, statusCode: " + i12);
                    BackupRestoreUtil.this.mTaskIdFinish = true;
                    BackupRestoreUtil.this.mTaskIdException = true;
                }
            }
        };
        this.mContext = context;
    }

    public int pmsRestore(String str, String str2, int i10, int i11) throws Throwable {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "pmsRestore mContext is null");
            return -1;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(this.mLocation)) {
                C11839m.m70687e(TAG, "pmsRestore mLocation is empty");
                return -1;
            }
            if (!cleanAppData(this.mContext, str2, i11)) {
                C11839m.m70687e(TAG, "pmsRestore cleanAppData failed");
                return -1;
            }
            try {
                convertPmsTxt(str, str2, C10278a.m63443i(this.mLocation, str + ".txt"), i10, i11, new String[]{".dbhashfile", ".differencepacket"});
                renamePmsDir(str, str2);
                return execute("restore " + CloudBackupConstant.Command.PMS_OPTION_DIR + " " + this.mLocation + " " + BackupRestoreConstans.getDefaultDataPath(str2, i11));
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "pmsRestore convertTwinPmsTxt failed: " + e10.getMessage());
                return -1;
            }
        }
        C11839m.m70687e(TAG, "pmsRestore appId or oriAppId is null");
        return -1;
    }

    public BackupRestoreUtil(Context context, CacheTask cacheTask, String str) {
        this.mGetFdFinsh = false;
        this.mTaskId = -1;
        this.mSessionId = -1;
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.receiveTime = 0L;
        this.pmsProgressUpdateTime = 0L;
        this.logStartTime = 0L;
        this.receivedAppendData = 0L;
        this.isCompleted = false;
        this.cleanAppDataResult = false;
        this.pmsBriefFileSpeed = 0L;
        this.mSessionCallback = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.1
            @Override // android.p018os.IBackupSessionCallback
            public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                C11839m.m70688i(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fileSize: " + j10 + " modifiedTime: " + j11);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    BackupRestoreUtil.this.pmsFileModel.m70026h(parcelFileDescriptor);
                    BackupRestoreUtil.this.pmsFileModel.m70024f(j10);
                    BackupRestoreUtil.this.pmsFileModel.m70025g(j11 * 1000);
                } else if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e10) {
                        C11839m.m70687e(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fd close error: " + e10.toString());
                    }
                }
                BackupRestoreUtil.this.mGetFdFinsh = true;
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str2) {
                C11839m.m70686d(BackupRestoreUtil.TAG, "onTaskStatusChanged:sessionId = " + BackupRestoreUtil.this.mSessionId + "/" + i10 + ",taskId = " + BackupRestoreUtil.this.mTaskId + "/" + i11 + ",statusCode = " + i12 + ",appendData = " + str2);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.receiveTime = System.currentTimeMillis();
                    long jM1688f = C0241z.m1688f(str2);
                    if (i12 == 3 && jM1688f > BackupRestoreUtil.this.receivedAppendData) {
                        BackupRestoreUtil.this.receivedAppendData = jM1688f;
                    }
                    if (i12 != -1) {
                        if (i12 == 0) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file success.");
                            BackupRestoreUtil backupRestoreUtil = BackupRestoreUtil.this;
                            backupRestoreUtil.updatePmsProgress(String.valueOf(backupRestoreUtil.receivedAppendData));
                            BackupRestoreUtil.this.mTaskIdFinish = true;
                            if (BackupRestoreUtil.this.pmsFileModel != null) {
                                BackupRestoreUtil.this.pmsFileModel.m70023e(true);
                                return;
                            }
                            return;
                        }
                        if (i12 == 1) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file begin.");
                            BackupRestoreUtil backupRestoreUtil2 = BackupRestoreUtil.this;
                            backupRestoreUtil2.logStartTime = backupRestoreUtil2.receiveTime;
                            BackupRestoreUtil.this.receivedAppendData = 0L;
                            return;
                        }
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 != 6) {
                                    return;
                                }
                                BackupRestoreUtil.this.updatePmsProgress(str2);
                                return;
                            } else {
                                if (BackupRestoreUtil.this.receiveTime - BackupRestoreUtil.this.logStartTime >= RippleView.SINGLE_RIPPLE_TIME) {
                                    BackupRestoreUtil backupRestoreUtil3 = BackupRestoreUtil.this;
                                    backupRestoreUtil3.logStartTime = backupRestoreUtil3.receiveTime;
                                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS running, statusCode: " + i12 + ";appendData: " + str2);
                                    BackupRestoreUtil.this.updatePmsProgress(str2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (BackupRestoreUtil.this.pmsFileModel == null) {
                        BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    }
                    BackupRestoreUtil.this.pmsFileModel.m70023e(!str2.contains(String.valueOf(-22)));
                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file error, statusCode: " + i12);
                    BackupRestoreUtil.this.mTaskIdFinish = true;
                    BackupRestoreUtil.this.mTaskIdException = true;
                }
            }
        };
        this.mContext = context;
        this.task = cacheTask;
        this.mLocation = checkLocation(str);
    }

    public int pmsRestore(String str, String str2, int i10) {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "pmsRestore mContext is null");
            return -1;
        }
        if (C0209d.m1273k1()) {
            str = adapteHonorRPath(i10, str);
            str2 = adapteHonorRPath(i10, str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return execute("restore " + CloudBackupConstant.Command.PMS_OPTION_DIR + " " + str + " " + str2);
        }
        C11839m.m70687e(TAG, "pmsRestore srcPath or destPath is empty");
        return -1;
    }

    public BackupRestoreUtil(Context context, CacheTask cacheTask, String str, InterfaceC0275i1 interfaceC0275i1) {
        this(context, cacheTask, str);
        this.pmsCopyProgressCallback = interfaceC0275i1;
    }

    public BackupRestoreUtil(Context context, String str) {
        this.mGetFdFinsh = false;
        this.mTaskId = -1;
        this.mSessionId = -1;
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.receiveTime = 0L;
        this.pmsProgressUpdateTime = 0L;
        this.logStartTime = 0L;
        this.receivedAppendData = 0L;
        this.isCompleted = false;
        this.cleanAppDataResult = false;
        this.pmsBriefFileSpeed = 0L;
        this.mSessionCallback = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil.1
            @Override // android.p018os.IBackupSessionCallback
            public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                C11839m.m70688i(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fileSize: " + j10 + " modifiedTime: " + j11);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    BackupRestoreUtil.this.pmsFileModel.m70026h(parcelFileDescriptor);
                    BackupRestoreUtil.this.pmsFileModel.m70024f(j10);
                    BackupRestoreUtil.this.pmsFileModel.m70025g(j11 * 1000);
                } else if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e10) {
                        C11839m.m70687e(BackupRestoreUtil.TAG, "onTaskFileDescriptorCreated fd close error: " + e10.toString());
                    }
                }
                BackupRestoreUtil.this.mGetFdFinsh = true;
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str2) {
                C11839m.m70686d(BackupRestoreUtil.TAG, "onTaskStatusChanged:sessionId = " + BackupRestoreUtil.this.mSessionId + "/" + i10 + ",taskId = " + BackupRestoreUtil.this.mTaskId + "/" + i11 + ",statusCode = " + i12 + ",appendData = " + str2);
                if (BackupRestoreUtil.this.mSessionId == i10 || i11 == BackupRestoreUtil.this.mTaskId) {
                    BackupRestoreUtil.this.receiveTime = System.currentTimeMillis();
                    long jM1688f = C0241z.m1688f(str2);
                    if (i12 == 3 && jM1688f > BackupRestoreUtil.this.receivedAppendData) {
                        BackupRestoreUtil.this.receivedAppendData = jM1688f;
                    }
                    if (i12 != -1) {
                        if (i12 == 0) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file success.");
                            BackupRestoreUtil backupRestoreUtil = BackupRestoreUtil.this;
                            backupRestoreUtil.updatePmsProgress(String.valueOf(backupRestoreUtil.receivedAppendData));
                            BackupRestoreUtil.this.mTaskIdFinish = true;
                            if (BackupRestoreUtil.this.pmsFileModel != null) {
                                BackupRestoreUtil.this.pmsFileModel.m70023e(true);
                                return;
                            }
                            return;
                        }
                        if (i12 == 1) {
                            C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file begin.");
                            BackupRestoreUtil backupRestoreUtil2 = BackupRestoreUtil.this;
                            backupRestoreUtil2.logStartTime = backupRestoreUtil2.receiveTime;
                            BackupRestoreUtil.this.receivedAppendData = 0L;
                            return;
                        }
                        if (i12 != 2) {
                            if (i12 != 3) {
                                if (i12 != 6) {
                                    return;
                                }
                                BackupRestoreUtil.this.updatePmsProgress(str2);
                                return;
                            } else {
                                if (BackupRestoreUtil.this.receiveTime - BackupRestoreUtil.this.logStartTime >= RippleView.SINGLE_RIPPLE_TIME) {
                                    BackupRestoreUtil backupRestoreUtil3 = BackupRestoreUtil.this;
                                    backupRestoreUtil3.logStartTime = backupRestoreUtil3.receiveTime;
                                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS running, statusCode: " + i12 + ";appendData: " + str2);
                                    BackupRestoreUtil.this.updatePmsProgress(str2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (BackupRestoreUtil.this.pmsFileModel == null) {
                        BackupRestoreUtil.this.pmsFileModel = new C11733n();
                    }
                    BackupRestoreUtil.this.pmsFileModel.m70023e(!str2.contains(String.valueOf(-22)));
                    C11839m.m70688i(BackupRestoreUtil.TAG, "PMS copy file error, statusCode: " + i12);
                    BackupRestoreUtil.this.mTaskIdFinish = true;
                    BackupRestoreUtil.this.mTaskIdException = true;
                }
            }
        };
        this.mContext = context;
        this.mLocation = checkLocation(str);
    }
}
