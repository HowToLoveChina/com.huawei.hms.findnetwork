package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.DifferenceDBPacketInfo;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import p015ak.C0209d;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12571m;

/* loaded from: classes2.dex */
public class SplitFileUtil {
    private static final String TAG = "SplitFileUtil";

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.util.SplitFileUtil$1 */
    public class C26231 implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return C0241z.m1685c(file.getName().split("_")[0]) - C0241z.m1685c(file2.getName().split("_")[0]);
        }
    }

    public static void deleteDBDifferenceFiles(File file, File file2, List<File> list) {
        File fileM63442h = C10278a.m63442h(C10279b.m63452a(file) + ".dbFileMetaInfo");
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "delete dbMetaFile error, name = " + fileM63442h.getName());
        }
        if (!file2.delete()) {
            C11839m.m70687e(TAG, "delete packetfile error, name = " + file2.getName());
        }
        for (File file3 : list) {
            if (!file3.delete()) {
                C11839m.m70687e(TAG, "delete delFile error, name = " + file3.getName());
            }
        }
    }

    public static void deleteDbSplitFile(String str, Set<String> set) throws C9721b {
        File fileM63442h = C10278a.m63442h(str);
        File fileM63442h2 = C10278a.m63442h(C10279b.m63452a(fileM63442h) + ".dbhashfile");
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            C11839m.m70688i(TAG, "delete hash file again, error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete hash file again, error: " + fileM63442h2.getName());
        }
        if (set == null || set.isEmpty()) {
            C11839m.m70688i(TAG, "db difference packet file paths is null");
            return;
        }
        Set<String> lastPacketFilePaths = getLastPacketFilePaths(fileM63442h, set);
        for (int i10 = 0; i10 < lastPacketFilePaths.size(); i10++) {
            File fileM63442h3 = C10278a.m63442h(C10279b.m63452a(fileM63442h) + "_diff_packet_index_" + i10 + ".differencepacket");
            if (fileM63442h3.exists() && !fileM63442h3.delete()) {
                C11839m.m70687e(TAG, "delete packet file error, name = " + fileM63442h3.getName());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete packet file error: " + fileM63442h3.getName());
            }
        }
    }

    public static File getDifferencePacketFile(File file, List<File> list) {
        String str = C10279b.m63452a(file) + "_diff_packet_index_" + getLastPacketsNum(list, file.getName()) + ".differencepacket";
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            return fileM63442h;
        }
        if (!fileM63442h.delete()) {
            C11839m.m70688i(TAG, "delete packet file error, file = " + fileM63442h.getName());
        }
        return C10278a.m63442h(str);
    }

    public static File getHashFile(List<File> list, String str) {
        for (File file : list) {
            String name = file.getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(str) && name.endsWith(".dbhashfile")) {
                return file;
            }
        }
        return null;
    }

    public static Set<String> getLastPacketFilePaths(File file, Set<String> set) {
        HashSet hashSet = new HashSet();
        String name = file.getName();
        String parent = file.getParent();
        for (String str : set) {
            File fileM63442h = C10278a.m63442h(str);
            String name2 = fileM63442h.getName();
            String parent2 = fileM63442h.getParent();
            if (parent == null || parent2 == null) {
                C11839m.m70689w(TAG, "dbFileParent or packetFileParent is null, dbName: " + name);
            } else if (!parent.equalsIgnoreCase(parent2)) {
                C11839m.m70688i(TAG, "dbFileParent and packetFileParent are not equal, dbFileParent: " + parent + ", packetFileParent: " + parent2);
            } else if (!TextUtils.isEmpty(name2) && name2.startsWith(name) && name2.endsWith(".differencepacket")) {
                C11839m.m70688i(TAG, "get packet file: " + str);
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static int getLastPacketsNum(List<File> list, String str) {
        Iterator<File> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            String name = it.next().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(str) && name.endsWith(".differencepacket")) {
                i10++;
            }
        }
        return i10;
    }

    public static boolean isDBFile(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !str3.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return false;
        }
        return str.endsWith(SnapshotDBManager.SUFFIX_DATABASE_NAME);
    }

    public static boolean isDBNodeFile(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !str3.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return false;
        }
        return str.endsWith(".dbFileMetaInfo");
    }

    public static boolean isDifferentPacketFile(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !str3.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return false;
        }
        return str.endsWith(".dbhashfile") || str.contains("_diff_packet_index_");
    }

    public static void merge(String str) throws Throwable {
        RandomAccessFile randomAccessFileM63448n;
        RandomAccessFile randomAccessFile;
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error sqlite dir is empty");
        }
        File[] fileArrListFiles = fileM63442h.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error sqlite dir is empty");
        }
        File fileM63442h2 = C10278a.m63442h(fileM63442h.getParent() + File.separator + UUID.randomUUID());
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFileM63448n = C10278a.m63448n(fileM63442h2, "rw");
            try {
                List<File> listAsList = Arrays.asList(fileArrListFiles);
                Collections.sort(listAsList, new Comparator<File>() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.SplitFileUtil.1
                    @Override // java.util.Comparator
                    public int compare(File file, File file2) {
                        return C0241z.m1685c(file.getName().split("_")[0]) - C0241z.m1685c(file2.getName().split("_")[0]);
                    }
                });
                for (File file : listAsList) {
                    C11839m.m70686d(TAG, "merge file = " + file.getName());
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i10 = randomAccessFile.read(bArr);
                            if (i10 == -1) {
                                break;
                            } else {
                                randomAccessFileM63448n.write(bArr, 0, i10);
                            }
                        }
                        ICBUtil.closeStream(randomAccessFile);
                        randomAccessFile2 = randomAccessFile;
                    } catch (Exception e10) {
                        e = e10;
                        randomAccessFile2 = randomAccessFileM63448n;
                        try {
                            C11839m.m70687e(TAG, "getWrite error: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error: " + e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFileM63448n = randomAccessFile2;
                            randomAccessFile2 = randomAccessFile;
                            ICBUtil.closeStream(randomAccessFile2);
                            ICBUtil.closeStream(randomAccessFileM63448n);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        ICBUtil.closeStream(randomAccessFile2);
                        ICBUtil.closeStream(randomAccessFileM63448n);
                        throw th;
                    }
                }
                C12571m.m75547i(C10279b.m63452a(fileM63442h));
                if (fileM63442h.exists()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge delete erorr path = " + C10279b.m63452a(fileM63442h));
                }
                if (fileM63442h.exists()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge delete erorr path = " + C10279b.m63452a(fileM63442h));
                }
                if (!fileM63442h2.renameTo(fileM63442h)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge renameTo erorr path = " + C10279b.m63452a(fileM63442h));
                }
                ICBUtil.closeStream(randomAccessFile2);
                ICBUtil.closeStream(randomAccessFileM63448n);
            } catch (Exception e11) {
                e = e11;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                ICBUtil.closeStream(randomAccessFile2);
                ICBUtil.closeStream(randomAccessFileM63448n);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFileM63448n = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable, java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static boolean mergeDbfile(String str, Set<String> set) throws Throwable {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        ?? objectInputStream;
        int i10 = 0;
        if (set == null || set.isEmpty()) {
            C11839m.m70688i(TAG, "db difference packet file paths is null");
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        Set<String> lastPacketFilePaths = getLastPacketFilePaths(fileM63442h, set);
        boolean z10 = false;
        while (i10 < lastPacketFilePaths.size()) {
            String str2 = C10279b.m63452a(fileM63442h) + "_diff_packet_index_" + i10 + ".differencepacket";
            File fileM63442h2 = C10278a.m63442h(str2);
            if (fileM63442h2.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(fileM63442h2);
                } catch (IOException | ClassNotFoundException e10) {
                    e = e10;
                    objectInputStream = 0;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    randomAccessFile = null;
                }
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        randomAccessFile = new RandomAccessFile(fileM63442h, "rw");
                        while (true) {
                            try {
                                try {
                                    try {
                                        DifferenceDBPacketInfo differenceDBPacketInfo = (DifferenceDBPacketInfo) objectInputStream.readObject();
                                        randomAccessFile.seek(differenceDBPacketInfo.getOffset());
                                        randomAccessFile.write(differenceDBPacketInfo.getContent());
                                        C11839m.m70686d(TAG, "merge file:  offset = " + differenceDBPacketInfo.getOffset() + ", size = " + differenceDBPacketInfo.getLength());
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream2 = objectInputStream;
                                        C0209d.m1263i(fileInputStream2);
                                        C0209d.m1263i(fileInputStream);
                                        C0209d.m1263i(randomAccessFile);
                                        throw th;
                                    }
                                } catch (EOFException unused) {
                                    C11839m.m70688i(TAG, "merge one file end, name = " + str2);
                                    C0209d.m1263i(objectInputStream);
                                    C0209d.m1263i(fileInputStream);
                                    C0209d.m1263i(randomAccessFile);
                                }
                            } catch (IOException | ClassNotFoundException e11) {
                                e = e11;
                                fileInputStream2 = fileInputStream;
                                objectInputStream = objectInputStream;
                                try {
                                    C11839m.m70687e(TAG, "merge file exception" + e.getMessage());
                                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file exception: " + e.toString());
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileInputStream = fileInputStream2;
                                    fileInputStream2 = objectInputStream;
                                    C0209d.m1263i(fileInputStream2);
                                    C0209d.m1263i(fileInputStream);
                                    C0209d.m1263i(randomAccessFile);
                                    throw th;
                                }
                            }
                        }
                    } catch (IOException | ClassNotFoundException e12) {
                        e = e12;
                        randomAccessFile = null;
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = null;
                    }
                } catch (IOException | ClassNotFoundException e13) {
                    e = e13;
                    objectInputStream = 0;
                    randomAccessFile = null;
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile = null;
                    C0209d.m1263i(fileInputStream2);
                    C0209d.m1263i(fileInputStream);
                    C0209d.m1263i(randomAccessFile);
                    throw th;
                }
            }
            i10++;
            z10 = true;
        }
        return z10;
    }

    public static void mergeFiles(List<File> list, File file) throws Throwable {
        RandomAccessFile randomAccessFileM63448n;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFileM63448n = C10278a.m63448n(file, "rw");
        } catch (Exception e10) {
            e = e10;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFileM63448n = null;
        }
        try {
            for (File file2 : list) {
                C11839m.m70686d(TAG, "merge file = " + file2.getName());
                randomAccessFile = new RandomAccessFile(file2, "r");
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = randomAccessFile.read(bArr);
                        if (i10 == -1) {
                            break;
                        } else {
                            randomAccessFileM63448n.write(bArr, 0, i10);
                        }
                    }
                    ICBUtil.closeStream(randomAccessFile);
                    if (!file2.delete()) {
                        C11839m.m70689w(TAG, "mergeFiles delete file failed");
                    }
                    randomAccessFile2 = randomAccessFile;
                } catch (Exception e11) {
                    e = e11;
                    randomAccessFile2 = randomAccessFileM63448n;
                    try {
                        C11839m.m70687e(TAG, "mergeFiles error: " + e.toString());
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error: " + e.toString());
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFileM63448n = randomAccessFile2;
                        randomAccessFile2 = randomAccessFile;
                        ICBUtil.closeStream(randomAccessFile2);
                        ICBUtil.closeStream(randomAccessFileM63448n);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile2 = randomAccessFile;
                    ICBUtil.closeStream(randomAccessFile2);
                    ICBUtil.closeStream(randomAccessFileM63448n);
                    throw th;
                }
            }
            ICBUtil.closeStream(randomAccessFile2);
            ICBUtil.closeStream(randomAccessFileM63448n);
        } catch (Exception e12) {
            e = e12;
            randomAccessFile = randomAccessFile2;
        } catch (Throwable th5) {
            th = th5;
            ICBUtil.closeStream(randomAccessFile2);
            ICBUtil.closeStream(randomAccessFileM63448n);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static Object readObjectToFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th2;
        Object e10;
        ObjectInputStream objectInputStream;
        try {
            try {
                fileInputStream = new FileInputStream((File) file);
            } catch (IOException | ClassNotFoundException e11) {
                e10 = e11;
            } catch (Throwable th3) {
                fileInputStream = null;
                th2 = th3;
                file = 0;
            }
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (IOException | ClassNotFoundException e12) {
                e10 = e12;
            } catch (Throwable th4) {
                th2 = th4;
                file = 0;
                C0209d.m1263i(file);
                C0209d.m1263i(fileInputStream);
                throw th2;
            }
            try {
                Object object = objectInputStream.readObject();
                C0209d.m1263i(objectInputStream);
                C0209d.m1263i(fileInputStream);
                return object;
            } catch (IOException | ClassNotFoundException e13) {
                e10 = e13;
                C11839m.m70689w(TAG, "readObjectToFile exception" + e10.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readObjectToFile file error: " + e10.toString());
            }
        } catch (Throwable th5) {
            th2 = th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void writeObjectToFile(String str, String str2, Object obj) throws Throwable {
        FileOutputStream fileOutputStream;
        ?? objectOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || obj == null) {
            C11839m.m70689w(TAG, "writeObjectToFile error, params invalid.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "writeObjectToFile error, params invalid.");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            String str3 = str + File.separator + str2 + ".dbFileMetaInfo";
            fileOutputStream = new FileOutputStream(C10278a.m63442h(str3));
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (IOException e10) {
                e = e10;
                objectOutputStream = 0;
            } catch (Throwable th2) {
                th = th2;
                C0209d.m1263i(fileOutputStream2);
                C0209d.m1263i(fileOutputStream);
                throw th;
            }
            try {
                objectOutputStream.writeObject(obj);
                C11839m.m70686d(TAG, "writeObjectToFile success, file = " + str3);
                C0209d.m1263i(objectOutputStream);
                C0209d.m1263i(fileOutputStream);
            } catch (IOException e11) {
                e = e11;
                fileOutputStream2 = fileOutputStream;
                objectOutputStream = objectOutputStream;
                try {
                    C11839m.m70689w(TAG, "writeObjectToFile exception: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "writeObjectToFile file error: " + e.toString());
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream2 = objectOutputStream;
                    C0209d.m1263i(fileOutputStream2);
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = objectOutputStream;
                C0209d.m1263i(fileOutputStream2);
                C0209d.m1263i(fileOutputStream);
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            objectOutputStream = 0;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable, java.io.RandomAccessFile] */
    public static void merge(File file, File file2, long j10) throws Throwable {
        ?? M63448n;
        FileInputStream fileInputStream;
        if (file.exists()) {
            FileInputStream fileInputStreamM63444j = null;
            try {
                M63448n = C10278a.m63448n(file2, "rw");
                try {
                    fileInputStreamM63444j = C10278a.m63444j(file);
                    M63448n.seek(j10);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = fileInputStreamM63444j.read(bArr);
                        if (i10 != -1) {
                            M63448n.write(bArr, 0, i10);
                        } else {
                            ICBUtil.closeStream(fileInputStreamM63444j);
                            ICBUtil.closeStream(M63448n);
                            return;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream = fileInputStreamM63444j;
                    fileInputStreamM63444j = M63448n;
                    if (file2 != null) {
                        try {
                            if (file2.exists()) {
                                C11839m.m70689w(TAG, "merge file fail, delete " + file2.delete());
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            M63448n = fileInputStreamM63444j;
                            fileInputStreamM63444j = fileInputStream;
                            ICBUtil.closeStream(fileInputStreamM63444j);
                            ICBUtil.closeStream(M63448n);
                            throw th;
                        }
                    }
                    C11839m.m70687e(TAG, "merge error: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error: " + e.toString());
                } catch (Throwable th3) {
                    th = th3;
                    ICBUtil.closeStream(fileInputStreamM63444j);
                    ICBUtil.closeStream(M63448n);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                M63448n = 0;
            }
        } else {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error srcFile is not exist");
        }
    }
}
