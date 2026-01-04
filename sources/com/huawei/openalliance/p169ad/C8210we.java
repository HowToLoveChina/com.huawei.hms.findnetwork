package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.C8209wd;
import com.huawei.openalliance.p169ad.C8213wh;
import com.huawei.openalliance.p169ad.C8239xg;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.huawei.openalliance.ad.we */
/* loaded from: classes8.dex */
public final class C8210we extends Table {
    /* renamed from: a */
    public int m51017a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: b */
    public StringVector m51023b(StringVector stringVector) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: c */
    public C8209wd.a m51026c() {
        return m51019a(new C8209wd.a());
    }

    /* renamed from: d */
    public StringVector m51027d() {
        return m51018a(new StringVector());
    }

    /* renamed from: e */
    public C8239xg.a m51028e() {
        return m51021a(new C8239xg.a());
    }

    /* renamed from: f */
    public StringVector m51029f() {
        return m51023b(new StringVector());
    }

    /* renamed from: g */
    public String m51030g() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: h */
    public C8213wh.a m51031h() {
        return m51020a(new C8213wh.a());
    }

    /* renamed from: i */
    public int m51032i() {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: j */
    public int m51033j() {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: k */
    public int m51034k() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: l */
    public int m51035l() {
        int i__offset = __offset(30);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: m */
    public String m51036m() {
        int i__offset = __offset(32);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: n */
    public String m51037n() {
        int i__offset = __offset(50);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public StringVector m51018a(StringVector stringVector) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8210we m51024b(int i10, ByteBuffer byteBuffer) {
        m51022a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public C8209wd.a m51019a(C8209wd.a aVar) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return aVar.m51012a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public String m51025b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public static C8210we m51015a(ByteBuffer byteBuffer) {
        return m51016a(byteBuffer, new C8210we());
    }

    /* renamed from: a */
    public static C8210we m51016a(ByteBuffer byteBuffer, C8210we c8210we) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c8210we.m51024b(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    /* renamed from: a */
    public C8213wh.a m51020a(C8213wh.a aVar) {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return aVar.m51061a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8239xg.a m51021a(C8239xg.a aVar) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return aVar.m51462a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public void m51022a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
