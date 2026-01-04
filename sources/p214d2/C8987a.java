package p214d2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p630s2.C12666a;
import p759x1.C13684i;
import p759x1.InterfaceC13679d;

/* renamed from: d2.a */
/* loaded from: classes.dex */
public class C8987a implements InterfaceC13679d<ByteBuffer> {
    @Override // p759x1.InterfaceC13679d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean mo56815b(ByteBuffer byteBuffer, File file, C13684i c13684i) throws Throwable {
        try {
            C12666a.m76251f(byteBuffer, file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e10);
            }
            return false;
        }
    }
}
