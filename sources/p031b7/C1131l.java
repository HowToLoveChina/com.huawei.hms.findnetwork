package p031b7;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hiar.ARImageMetadata;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: b7.l */
/* loaded from: classes2.dex */
public class C1131l {
    /* renamed from: a */
    public static String m6919a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            cArr2[i11] = cArr[(b10 >>> 4) & 15];
            cArr2[i11 + 1] = cArr[b10 & BaseType.Obj];
        }
        return new String(cArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0031: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:12:0x0031 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* renamed from: b */
    public static String m6920b(File file) throws Throwable {
        AbstractInterruptibleChannel abstractInterruptibleChannel;
        FileInputStream fileInputStream;
        FileChannel channel;
        FileInputStream fileInputStream2;
        StringBuilder sb2;
        MessageDigest messageDigest;
        String strM6919a = null;
        strM6919a = null;
        strM6919a = null;
        strM6919a = null;
        strM6919a = null;
        strM6919a = null;
        strM6919a = null;
        abstractInterruptibleChannel = null;
        AbstractInterruptibleChannel abstractInterruptibleChannel2 = null;
        try {
            if (file != 0) {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    file = C10278a.m63444j(file);
                    try {
                        channel = file.getChannel();
                    } catch (IOException e10) {
                        e = e10;
                        channel = null;
                        fileInputStream2 = file;
                    } catch (NoSuchAlgorithmException e11) {
                        e = e11;
                        channel = null;
                        fileInputStream = file;
                    } catch (Throwable th2) {
                        th = th2;
                        if (abstractInterruptibleChannel2 != null) {
                            try {
                                abstractInterruptibleChannel2.close();
                            } catch (IOException e12) {
                                C1120a.m6676e("MD5Util", "getMD5 finally error:" + e12.getMessage());
                                throw th;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                    fileInputStream2 = null;
                    channel = null;
                } catch (NoSuchAlgorithmException e14) {
                    e = e14;
                    fileInputStream = null;
                    channel = null;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                }
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(ARImageMetadata.SHADING_MODE);
                    while (true) {
                        byteBufferAllocate.clear();
                        int i10 = channel.read(byteBufferAllocate);
                        if (i10 == -1) {
                            break;
                        }
                        messageDigest.update(byteBufferAllocate.array(), 0, i10);
                    }
                    strM6919a = m6919a(messageDigest.digest());
                } catch (IOException e15) {
                    e = e15;
                    fileInputStream2 = file;
                    C1120a.m6676e("MD5Util", "getMD5 error:" + e.toString());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e16) {
                            e = e16;
                            sb2 = new StringBuilder();
                            sb2.append("getMD5 finally error:");
                            sb2.append(e.getMessage());
                            C1120a.m6676e("MD5Util", sb2.toString());
                            return strM6919a;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return strM6919a;
                } catch (NoSuchAlgorithmException e17) {
                    e = e17;
                    fileInputStream = file;
                    C1120a.m6676e("MD5Util", "getMD5 error:" + e.toString());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e18) {
                            e = e18;
                            sb2 = new StringBuilder();
                            sb2.append("getMD5 finally error:");
                            sb2.append(e.getMessage());
                            C1120a.m6676e("MD5Util", sb2.toString());
                            return strM6919a;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strM6919a;
                }
                try {
                    channel.close();
                    file.close();
                } catch (IOException e19) {
                    e = e19;
                    sb2 = new StringBuilder();
                    sb2.append("getMD5 finally error:");
                    sb2.append(e.getMessage());
                    C1120a.m6676e("MD5Util", sb2.toString());
                    return strM6919a;
                }
            }
            return strM6919a;
        } catch (Throwable th4) {
            th = th4;
            abstractInterruptibleChannel2 = abstractInterruptibleChannel;
        }
    }
}
