package p629s1;

import android.os.Process;
import java.util.Hashtable;
import p629s1.C12665d;

/* renamed from: s1.c */
/* loaded from: classes.dex */
public class C12664c {

    /* renamed from: a */
    public static short f58157a;

    /* renamed from: b */
    public static Hashtable<String, int[]> f58158b = new Hashtable<>();

    /* renamed from: a */
    public static synchronized int[] m76236a(String str) {
        if (str == null) {
            C12665d.a.m76245d("SenderIdManager", "getSenderId, param == null");
            return null;
        }
        int[] iArr = f58158b.get(str);
        if (iArr == null || 2 != iArr.length) {
            C12665d.a.m76245d("SenderIdManager", "getSenderId, param: " + str + " fail!");
            return null;
        }
        iArr[1] = ((short) (Math.abs((int) ((short) (((short) (iArr[1] & 65535)) + 1))) % 32767)) | (iArr[1] & (-65536));
        C12665d.a.m76242a("SenderIdManager", "getSenderId, tidAndTime:" + str + " pid:" + iArr[0] + ", gid:" + (iArr[1] & (-65536)) + ", seq:" + (iArr[1] & 65535));
        return iArr;
    }

    /* renamed from: b */
    public static synchronized void m76237b(String str) {
        if (str == null) {
            C12665d.a.m76245d("SenderIdManager", "registerSender, param == null");
            return;
        }
        C12665d.a.m76242a("SenderIdManager", "registerSender groupId:" + ((int) f58157a));
        short s10 = (short) (f58157a + 1);
        f58157a = s10;
        short sAbs = (short) (Math.abs((int) s10) % 32767);
        f58157a = sAbs;
        int[] iArr = {Process.myPid(), sAbs << 16};
        C12665d.a.m76242a("SenderIdManager", "registerSender, tidAndTime:" + str + " senderId:" + iArr[0] + "," + iArr[1]);
        f58158b.put(str, iArr);
    }

    /* renamed from: c */
    public static synchronized void m76238c(String str) {
        if (str == null) {
            C12665d.a.m76245d("SenderIdManager", "registerSender, param == null");
        } else {
            f58158b.remove(str);
        }
    }
}
