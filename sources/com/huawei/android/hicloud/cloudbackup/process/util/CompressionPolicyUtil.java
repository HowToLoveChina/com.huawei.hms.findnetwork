package com.huawei.android.hicloud.cloudbackup.process.util;

import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicyEncoding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import p514o9.C11839m;
import p617rl.C12526j;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class CompressionPolicyUtil {
    private static final long CONVERT_MB_TO_BYTE_SIZE_UNIT = 1048576;
    private static final List<String> SUPPORT_COMPRESSION_TYPE = new ArrayList<String>() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil.1
        {
            add("sparse");
        }
    };
    private static final String TAG = "CompressionPolicyUtil";

    public static boolean containsIgnoreCase(Collection<String> collection, final String str) {
        return collection.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CompressionPolicyUtil.lambda$containsIgnoreCase$0(str, (String) obj);
            }
        });
    }

    public static SCompressionPolicy getCompressionPolicy(String str, boolean z10) {
        List<SCompressionPolicy> listM75344K = new C12526j().m75344K();
        SCompressionPolicy sCompressionPolicy = null;
        if (AbstractC14026a.m84159a(listM75344K)) {
            C11839m.m70688i(TAG, "get om compressionPolicy empty.");
            return null;
        }
        Iterator<SCompressionPolicy> it = listM75344K.iterator();
        SCompressionPolicy sCompressionPolicy2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SCompressionPolicy next = it.next();
            if (next.getBundles().equals("*") && z10) {
                sCompressionPolicy2 = next;
            } else if (next.getBundles().equals(str)) {
                sCompressionPolicy = next;
                break;
            }
        }
        return sCompressionPolicy == null ? sCompressionPolicy2 : sCompressionPolicy;
    }

    public static SCompressionPolicyEncoding getEncodingConfig(SCompressionPolicy sCompressionPolicy, String str, long j10) {
        SCompressionPolicyEncoding sCompressionPolicyEncoding = null;
        if (sCompressionPolicy == null || AbstractC14026a.m84159a(sCompressionPolicy.getEncodingConfig())) {
            C11839m.m70689w(TAG, "compressionPolicy is null");
            return null;
        }
        for (SCompressionPolicyEncoding sCompressionPolicyEncoding2 : sCompressionPolicy.getEncodingConfig()) {
            if (SUPPORT_COMPRESSION_TYPE.contains(sCompressionPolicyEncoding2.getEncoding()) && containsIgnoreCase(sCompressionPolicyEncoding2.getFileExtension(), str) && j10 >= sCompressionPolicyEncoding2.getMinSize() * 1048576 && j10 <= sCompressionPolicyEncoding2.getMaxSize() * 1048576 && (sCompressionPolicyEncoding == null || sCompressionPolicyEncoding.getPriority() > sCompressionPolicyEncoding2.getPriority())) {
                sCompressionPolicyEncoding = sCompressionPolicyEncoding2;
            }
        }
        return sCompressionPolicyEncoding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$containsIgnoreCase$0(String str, String str2) {
        return str2.equalsIgnoreCase(str);
    }
}
