package com.bumptech.glide;

import com.bumptech.glide.AbstractC1556l;
import p564q2.C12274a;
import p564q2.InterfaceC12276c;

/* renamed from: com.bumptech.glide.l */
/* loaded from: classes.dex */
public abstract class AbstractC1556l<CHILD extends AbstractC1556l<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    public InterfaceC12276c<? super TranscodeType> f6924a = C12274a.m73798b();

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: d */
    public final InterfaceC12276c<? super TranscodeType> m8995d() {
        return this.f6924a;
    }
}
