package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.StringVector;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ec */
/* loaded from: classes8.dex */
public class C7087ec {
    /* renamed from: a */
    public static String m42868a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: a */
    public static List<Integer> m42869a(IntVector intVector) {
        if (intVector == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(intVector.length());
        for (int i10 = 0; i10 < intVector.length(); i10++) {
            arrayList.add(Integer.valueOf(intVector.get(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m42870a(StringVector stringVector) {
        if (stringVector == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(stringVector.length());
        for (int i10 = 0; i10 < stringVector.length(); i10++) {
            arrayList.add(stringVector.get(i10));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static byte[] m42871a(ByteVector byteVector) {
        if (byteVector == null) {
            return null;
        }
        byte[] bArr = new byte[byteVector.length()];
        for (int i10 = 0; i10 < byteVector.length(); i10++) {
            bArr[i10] = byteVector.get(i10);
        }
        return bArr;
    }

    /* renamed from: a */
    public static int[] m42872a(List<Integer> list) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                Integer num = list.get(i10);
                iArr[i10] = num == null ? 0 : num.intValue();
            }
        }
        return m42874a(iArr);
    }

    /* renamed from: a */
    public static int[] m42873a(List<String> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = flatBufferBuilder.createString(m42868a(list.get(i10)));
            }
        }
        return m42874a(iArr);
    }

    /* renamed from: a */
    public static int[] m42874a(int[] iArr) {
        return iArr == null ? new int[0] : iArr;
    }
}
