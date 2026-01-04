package p390ja;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.Chunking;
import com.huawei.android.hicloud.drive.clouddisk.model.DeltaFragment;
import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import com.huawei.cloud.base.http.C4611n;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import la.C11264b;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: ja.k */
/* loaded from: classes3.dex */
public class C10757k {
    /* renamed from: a */
    public static Digest m65559a(byte[] bArr) throws IOException {
        C11839m.m70688i("DeltaSyncUtil", "deserialize buffer size:" + bArr.length);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            short s10 = dataInputStream.readShort();
            int i10 = s10 >> 1;
            boolean z10 = true;
            int i11 = 0;
            if ((s10 & 1) != 1) {
                z10 = false;
            }
            int i12 = dataInputStream.readInt();
            int i13 = dataInputStream.readInt();
            if (z10) {
                if ((i13 * 58) + 10 != bArr.length) {
                    throw new IOException("error format, illegal length");
                }
                ArrayList arrayList = new ArrayList();
                while (i11 < i13) {
                    long j10 = dataInputStream.readLong();
                    long j11 = dataInputStream.readLong();
                    byte[] bArr2 = new byte[32];
                    dataInputStream.readFully(bArr2);
                    arrayList.add(new DeltaFragment(j10, j11, bArr2, dataInputStream.readShort(), dataInputStream.readLong()));
                    i11++;
                }
                Digest digest = new Digest(i10, i12, arrayList);
                dataInputStream.close();
                return digest;
            }
            if ((i13 * 48) + 10 != bArr.length) {
                throw new IOException("error format, illegal length");
            }
            ArrayList arrayList2 = new ArrayList();
            while (i11 < i13) {
                long j12 = dataInputStream.readLong();
                long j13 = dataInputStream.readLong();
                byte[] bArr3 = new byte[32];
                dataInputStream.readFully(bArr3);
                arrayList2.add(new DeltaFragment(j12, j13, bArr3));
                i11++;
            }
            Digest digest2 = new Digest(i10, i12, arrayList2);
            dataInputStream.close();
            return digest2;
        } catch (Throwable th2) {
            try {
                dataInputStream.close();
                throw th2;
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static Digest m65560b(Digest digest, File file) throws NoSuchAlgorithmException, IOException {
        Chunking chunkingM67607a = C11264b.m67607a(digest.getTag());
        if (chunkingM67607a != null) {
            return chunkingM67607a.mo16344b(digest, file);
        }
        throw new NoSuchAlgorithmException("digest chunking null");
    }

    /* renamed from: c */
    public static C4611n m65561c(Map<String, List<String>> map) {
        List<String> list;
        if (map == null || (list = map.get("content-type")) == null || list.size() == 0) {
            return null;
        }
        return new C4611n(list.get(0));
    }

    /* renamed from: d */
    public static long m65562d(Map<String, List<String>> map) {
        List<String> list;
        if (map == null || (list = map.get("content-range")) == null || list.size() == 0) {
            return 0L;
        }
        String str = list.get(0);
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String strTrim = str.trim();
        return C0241z.m1688f(strTrim.substring(strTrim.indexOf("bytes") + 6, strTrim.indexOf(45)));
    }
}
