package com.huawei.hms.framework.network.grs.p125h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.framework.network.grs.h.c */
/* loaded from: classes8.dex */
public class C5457c {

    /* renamed from: a */
    private static final String f25003a = "c";

    /* renamed from: a */
    public static String m32327a(String str, Context context) throws IOException {
        Logger.m32136d(f25003a, "Io getConfigContent, fileName: " + str);
        if (TextUtils.isEmpty(str) || context == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            try {
                if (!new File(str).isDirectory()) {
                    inputStreamOpen = context.getAssets().open(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i10 = inputStreamOpen.read(bArr);
                        if (i10 == -1) {
                            byteArrayOutputStream.flush();
                            String string = byteArrayOutputStream.toString(Constants.UTF_8);
                            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
                            IoUtils.closeSecure(inputStreamOpen);
                            return string;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                }
            } catch (IOException unused) {
                Logger.m32147w(f25003a, "local config file is not exist.filename is {%s}", str);
            }
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStreamOpen);
            return "";
        } catch (Throwable th2) {
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStreamOpen);
            throw th2;
        }
    }
}
