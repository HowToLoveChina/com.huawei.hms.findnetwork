package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import gy.C10064c;
import gy.C10065d;
import gy.C10067f;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import mk.C11476b;
import p015ak.C0209d;
import p270ey.InterfaceC9572a;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class TarFileUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BUFFER = 1024;
    private static final String TAG = "TarFileUtil";
    private FileOutputStream fos;
    private boolean isConvertAndroidData;
    private boolean mClearModifyTime;
    private Set<String> mCompares;
    private C10067f tarArchiveOutputStreamLimit;

    public TarFileUtil(Set<String> set) {
        this.isConvertAndroidData = false;
        this.mClearModifyTime = false;
        this.mCompares = set;
    }

    private void checkModifyTime(InterfaceC9572a interfaceC9572a) {
        if (this.mClearModifyTime && (interfaceC9572a instanceof C10064c)) {
            C10064c c10064c = (C10064c) interfaceC9572a;
            c10064c.m62586i0(0L);
            c10064c.m62580f0(null);
            c10064c.m62571a0(null);
            c10064c.m62596n0(null);
        }
    }

    private void checkTarDir(File file) {
        File fileM63437c = C10278a.m63437c(file);
        if (fileM63437c == null || fileM63437c.exists() || fileM63437c.mkdirs()) {
            return;
        }
        C11839m.m70686d(TAG, "checkTarDir error " + C10279b.m63452a(file));
    }

    private static void dearchiveFile(File file, C10065d c10065d) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = c10065d.read(bArr, 0, 1024);
                    if (i10 == -1) {
                        ICBUtil.closeStream(bufferedOutputStream2);
                        return;
                    }
                    bufferedOutputStream2.write(bArr, 0, i10);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                ICBUtil.closeStream(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void fileProber(File file) throws C9721b {
        File fileM63437c = C10278a.m63437c(file);
        if (fileM63437c == null || fileM63437c.exists() || fileM63437c.mkdirs()) {
            return;
        }
        C11839m.m70686d(TAG, "fileProber create dir error = " + C10279b.m63452a(fileM63437c));
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "fileProber create dir error");
    }

    private boolean pmsCopyAndroidData(String str, BackupRestoreUtil backupRestoreUtil, int i10, boolean z10, boolean z11, String str2, String str3, File file, File file2, String str4) throws C9721b {
        if (backupRestoreUtil == null) {
            return false;
        }
        if ("2".equals(str4)) {
            if (PmsUtils.copyAndroidDataFileByBrief(backupRestoreUtil, str2, C10279b.m63452a(file2), i10, str)) {
                this.isConvertAndroidData = true;
                return true;
            }
        } else {
            if (backupRestoreUtil.backupAndroid(str, i10, str2, str3) == 0 && file.exists()) {
                this.isConvertAndroidData = true;
                return true;
            }
            if ((z10 || (z11 && str2.contains(" "))) && PmsUtils.copyAndroidDataFileByBrief(backupRestoreUtil, str2, C10279b.m63452a(file2), i10, str)) {
                this.isConvertAndroidData = true;
                return true;
            }
        }
        return false;
    }

    public static void unTarAll(File file, String str) throws Throwable {
        C10065d c10065d = null;
        try {
            try {
                C10065d c10065d2 = new C10065d(new FileInputStream(file));
                while (true) {
                    try {
                        C10064c c10064cM62615A = c10065d2.m62615A();
                        if (c10064cM62615A == null) {
                            ICBUtil.closeStream(c10065d2);
                            return;
                        }
                        String str2 = str + File.separator + c10064cM62615A.m62607t();
                        File file2 = new File(str2);
                        fileProber(file2);
                        if (!c10064cM62615A.m62614z()) {
                            dearchiveFile(file2, c10065d2);
                        } else if (!file2.mkdirs()) {
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unTarAll mkdir error: " + str2);
                        }
                    } catch (IOException e10) {
                        e = e10;
                        c10065d = c10065d2;
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unTar error srcFile: " + C10279b.m63452a(file) + " , " + e.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        c10065d = c10065d2;
                        ICBUtil.closeStream(c10065d);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    public void closeTarStream() {
        C10067f c10067f = this.tarArchiveOutputStreamLimit;
        if (c10067f != null) {
            try {
                c10067f.m62654s();
            } catch (IOException e10) {
                C11839m.m70689w(TAG, "closeTarStream, closeArchiveEntry error: " + e10.toString());
            }
            try {
                this.tarArchiveOutputStreamLimit.flush();
            } catch (IOException e11) {
                C11839m.m70689w(TAG, "closeTarStream, flush error: " + e11.toString());
            }
            try {
                this.tarArchiveOutputStreamLimit.close();
            } catch (IOException e12) {
                C11839m.m70689w(TAG, "closeTarStream, close error: " + e12.toString());
            }
            this.tarArchiveOutputStreamLimit = null;
        }
        C0209d.m1263i(this.fos);
    }

    public File endCurrentTar(File file) throws C9721b {
        if (this.tarArchiveOutputStreamLimit == null) {
            return null;
        }
        closeTarStream();
        File fileM63442h = C10278a.m63442h(C10279b.m63452a(file.getParentFile()) + File.separator + C11476b.m68622d(file).getMD5() + ".tar");
        if (file.renameTo(fileM63442h)) {
            return fileM63442h;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "tarFile rename failed " + C10279b.m63452a(file) + " dest = " + fileM63442h);
    }

    public String getRelativePath(String str) {
        String next;
        Iterator<String> it = this.mCompares.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.startsWith(next)) {
                break;
            }
        }
        if (next == null) {
            return null;
        }
        return getRelativePath(next, str);
    }

    public boolean isConvertAndroidData() {
        return this.isConvertAndroidData;
    }

    public String tarFile(File file, File file2) throws C9721b {
        return tarFile(file, file2, C10279b.m63452a(file2));
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String tarFileCheckAndroidData(java.io.File r20, java.io.File r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil r25, int r26, long r27, boolean r29, boolean r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil.tarFileCheckAndroidData(java.io.File, java.io.File, java.lang.String, java.lang.String, java.lang.String, com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil, int, long, boolean, boolean):java.lang.String");
    }

    public String tarFile(File file, File file2, String str) throws Throwable {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                checkTarDir(file);
                String relativePath = getRelativePath(str);
                if (TextUtils.isEmpty(relativePath)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "tar file error relativePath is null " + C10279b.m63452a(file2));
                }
                if (this.tarArchiveOutputStreamLimit == null) {
                    this.fos = new FileOutputStream(file);
                    this.tarArchiveOutputStreamLimit = new C10067f(this.fos);
                }
                C10064c c10064cM62655t = this.tarArchiveOutputStreamLimit.m62655t(file2, relativePath);
                checkModifyTime(c10064cM62655t);
                try {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                        try {
                            this.tarArchiveOutputStreamLimit.m62641E(2);
                            this.tarArchiveOutputStreamLimit.m62642F(3);
                            this.tarArchiveOutputStreamLimit.m62640D(c10064cM62655t);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i10 = bufferedInputStream2.read(bArr, 0, 1024);
                                if (i10 == -1) {
                                    this.tarArchiveOutputStreamLimit.m62654s();
                                    C0209d.m1263i(bufferedInputStream2);
                                    C0209d.m1263i(fileInputStream);
                                    return relativePath;
                                }
                                this.tarArchiveOutputStreamLimit.write(bArr, 0, i10);
                            }
                        } catch (IOException e10) {
                            e = e10;
                            C11839m.m70687e(TAG, "tarFile error: " + e.toString());
                            ICBUtil.checkDataLocalLimitSpace("upload tar file local size not enough left space: ");
                            throw new C9721b(PlayerConstants.ErrorCode.MEDIA_SEEK_NO_AVAILABLE_SEGMENT, "tarFile failed " + e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = bufferedInputStream2;
                            C0209d.m1263i(bufferedInputStream);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (IOException e11) {
                        e = e11;
                    }
                } catch (FileNotFoundException e12) {
                    String strM63452a = C10279b.m63452a(file2);
                    C11839m.m70687e(TAG, "tarFile error file not found: " + strM63452a);
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "tarFile error file not found: " + strM63452a + ",error: " + e12.getMessage());
                }
            } catch (IOException e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private String getRelativePath(String str, String str2) {
        if (str2 == null || "".equals(str)) {
            return null;
        }
        return SafeString.substring(str2, str2.indexOf(str) + str.length() + 1);
    }

    public TarFileUtil(Set<String> set, boolean z10) {
        this(set);
        this.mClearModifyTime = z10;
    }
}
