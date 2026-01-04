package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.videokit.player.AudioTrackInfo;
import com.huawei.hms.videokit.player.InitBitrateParam;
import com.huawei.hms.videokit.player.StreamInfo;
import com.huawei.hms.videokit.player.SubtitleTrackInfo;
import com.huawei.hms.videokit.player.VideoInfo;

/* renamed from: com.huawei.hms.videokit.player.internal.f */
/* loaded from: classes8.dex */
public interface InterfaceC6571f extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.f$a */
    public static abstract class a extends Binder implements InterfaceC6571f {

        /* renamed from: com.huawei.hms.videokit.player.internal.f$a$a, reason: collision with other inner class name */
        public static class C14445a implements InterfaceC6571f {

            /* renamed from: b */
            public static InterfaceC6571f f30524b;

            /* renamed from: a */
            private IBinder f30525a;

            public C14445a(IBinder iBinder) {
                this.f30525a = iBinder;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public long mo37166a() throws RemoteException {
                long jMo37166a;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(54, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        jMo37166a = parcelObtain2.readLong();
                    } else {
                        jMo37166a = a.m37412g().mo37166a();
                    }
                    return jMo37166a;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30525a;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: b */
            public String mo37182b() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(51, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.m37412g().mo37182b();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: c */
            public int mo37185c() throws RemoteException {
                int iMo37185c;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(72, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        iMo37185c = parcelObtain2.readInt();
                    } else {
                        iMo37185c = a.m37412g().mo37185c();
                    }
                    return iMo37185c;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void closeLogo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(39, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().closeLogo();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: d */
            public void mo37190d(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(73, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37190d(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void deselectSubtitleTrack() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(60, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().deselectSubtitleTrack();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: e */
            public void mo37192e(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(75, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37192e(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public AudioTrackInfo[] getAudioTracks() throws RemoteException {
                AudioTrackInfo[] audioTracks;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(64, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        audioTracks = (AudioTrackInfo[]) parcelObtain2.createTypedArray(AudioTrackInfo.CREATOR);
                    } else {
                        audioTracks = a.m37412g().getAudioTracks();
                    }
                    return audioTracks;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getBufferTime() throws RemoteException {
                int bufferTime;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(22, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        bufferTime = parcelObtain2.readInt();
                    } else {
                        bufferTime = a.m37412g().getBufferTime();
                    }
                    return bufferTime;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public long getBufferingSpeed() throws RemoteException {
                long bufferingSpeed;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(23, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        bufferingSpeed = parcelObtain2.readLong();
                    } else {
                        bufferingSpeed = a.m37412g().getBufferingSpeed();
                    }
                    return bufferingSpeed;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public StreamInfo getCurrentStreamInfo() throws RemoteException {
                StreamInfo streamInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(25, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        streamInfoCreateFromParcel = parcelObtain2.readInt() != 0 ? StreamInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        streamInfoCreateFromParcel = a.m37412g().getCurrentStreamInfo();
                    }
                    return streamInfoCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getCurrentTime() throws RemoteException {
                int currentTime;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(21, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        currentTime = parcelObtain2.readInt();
                    } else {
                        currentTime = a.m37412g().getCurrentTime();
                    }
                    return currentTime;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getDuration() throws RemoteException {
                int duration;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(20, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        duration = parcelObtain2.readInt();
                    } else {
                        duration = a.m37412g().getDuration();
                    }
                    return duration;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getPlayMode() throws RemoteException {
                int playMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(32, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        playMode = parcelObtain2.readInt();
                    } else {
                        playMode = a.m37412g().getPlayMode();
                    }
                    return playMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public float getPlaySpeed() throws RemoteException {
                float playSpeed;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(30, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        playSpeed = parcelObtain2.readFloat();
                    } else {
                        playSpeed = a.m37412g().getPlaySpeed();
                    }
                    return playSpeed;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public AudioTrackInfo getSelectedAudioTrack() throws RemoteException {
                AudioTrackInfo audioTrackInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(63, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        audioTrackInfoCreateFromParcel = parcelObtain2.readInt() != 0 ? AudioTrackInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        audioTrackInfoCreateFromParcel = a.m37412g().getSelectedAudioTrack();
                    }
                    return audioTrackInfoCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public SubtitleTrackInfo getSelectedSubtitleTrack() throws RemoteException {
                SubtitleTrackInfo subtitleTrackInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(58, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        subtitleTrackInfoCreateFromParcel = parcelObtain2.readInt() != 0 ? SubtitleTrackInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        subtitleTrackInfoCreateFromParcel = a.m37412g().getSelectedSubtitleTrack();
                    }
                    return subtitleTrackInfoCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public SubtitleTrackInfo[] getSubtitleTracks() throws RemoteException {
                SubtitleTrackInfo[] subtitleTracks;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(57, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        subtitleTracks = (SubtitleTrackInfo[]) parcelObtain2.createTypedArray(SubtitleTrackInfo.CREATOR);
                    } else {
                        subtitleTracks = a.m37412g().getSubtitleTracks();
                    }
                    return subtitleTracks;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getVideoHeight() throws RemoteException {
                int videoHeight;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(19, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        videoHeight = parcelObtain2.readInt();
                    } else {
                        videoHeight = a.m37412g().getVideoHeight();
                    }
                    return videoHeight;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public VideoInfo getVideoInfo() throws RemoteException {
                VideoInfo videoInfoCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(17, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        videoInfoCreateFromParcel = parcelObtain2.readInt() != 0 ? VideoInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        videoInfoCreateFromParcel = a.m37412g().getVideoInfo();
                    }
                    return videoInfoCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int getVideoWidth() throws RemoteException {
                int videoWidth;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(18, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        videoWidth = parcelObtain2.readInt();
                    } else {
                        videoWidth = a.m37412g().getVideoWidth();
                    }
                    return videoWidth;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public boolean isPlaying() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (!this.f30525a.transact(16, parcelObtain, parcelObtain2, 0) && a.m37412g() != null) {
                        return a.m37412g().isPlaying();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void pause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(9, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().pause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void presetAudioLanguage(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(66, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().presetAudioLanguage(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void presetSubtitleLanguage(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(61, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().presetSubtitleLanguage(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void ready() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(7, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().ready();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void refreshPlayUrl(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(62, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().refreshPlayUrl(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void release() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(15, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().release();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void reset() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(14, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().reset();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void resume(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(11, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().resume(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void seek(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(12, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().seek(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void selectAudioTrack(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(65, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().selectAudioTrack(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void selectSubtitleTrack(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(59, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().selectSubtitleTrack(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public int setBandwidthSwitchMode(int i10) throws RemoteException {
                int bandwidthSwitchMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(33, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        bandwidthSwitchMode = parcelObtain2.readInt();
                    } else {
                        bandwidthSwitchMode = a.m37412g().setBandwidthSwitchMode(i10);
                    }
                    return bandwidthSwitchMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setBitrateRange(int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    if (this.f30525a.transact(34, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setBitrateRange(i10, i11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setBookmark(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(28, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setBookmark(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setBufferingStatus(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(24, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setBufferingStatus(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setCycleMode(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(40, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setCycleMode(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setInitBitrate(InitBitrateParam initBitrateParam) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (initBitrateParam != null) {
                        parcelObtain.writeInt(1);
                        initBitrateParam.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f30525a.transact(37, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setInitBitrate(initBitrateParam);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setMute(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(26, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setMute(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setPlayMode(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(31, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setPlayMode(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setPlaySpeed(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeFloat(f10);
                    if (this.f30525a.transact(29, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setPlaySpeed(f10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setSurfaceChange() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(38, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setSurfaceChange();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setVideoType(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(2, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setVideoType(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void setVolume(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeFloat(f10);
                    if (this.f30525a.transact(27, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().setVolume(f10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void start() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(8, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().start();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void stop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(13, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().stop();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void suspend() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    if (this.f30525a.transact(10, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().suspend();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void switchBitrateDesignated(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(35, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().switchBitrateDesignated(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            public void switchBitrateSmooth(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(36, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().switchBitrateSmooth(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37167a(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(67, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37167a(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: b */
            public void mo37183b(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(77, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37183b(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: c */
            public IObjectWrapper mo37186c(int i10) throws RemoteException {
                IObjectWrapper iObjectWrapperAsInterface;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(74, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                        iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                    } else {
                        iObjectWrapperAsInterface = a.m37412g().mo37186c(i10);
                    }
                    return iObjectWrapperAsInterface;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: d */
            public void mo37191d(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(52, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37191d(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: e */
            public void mo37193e(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(69, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37193e(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37168a(IObjectWrapper iObjectWrapper, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    if (this.f30525a.transact(70, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37168a(iObjectWrapper, i10);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: b */
            public void mo37184b(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(50, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37184b(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: c */
            public void mo37187c(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.f30525a.transact(6, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37187c(iObjectWrapper);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37169a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeStrongBinder(iObjectWrapper2 != null ? iObjectWrapper2.asBinder() : null);
                    if (this.f30525a.transact(1, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37169a(iObjectWrapper, iObjectWrapper2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: c */
            public void mo37188c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(56, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37188c(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37170a(InterfaceC6566a interfaceC6566a) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6566a != null ? interfaceC6566a.asBinder() : null);
                    if (this.f30525a.transact(48, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37170a(interfaceC6566a);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: c */
            public void mo37189c(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(76, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37189c(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37171a(InterfaceC6567b interfaceC6567b) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6567b != null ? interfaceC6567b.asBinder() : null);
                    if (this.f30525a.transact(47, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37171a(interfaceC6567b);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37172a(InterfaceC6568c interfaceC6568c) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6568c != null ? interfaceC6568c.asBinder() : null);
                    if (this.f30525a.transact(43, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37172a(interfaceC6568c);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37173a(InterfaceC6570e interfaceC6570e) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6570e != null ? interfaceC6570e.asBinder() : null);
                    if (this.f30525a.transact(44, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37173a(interfaceC6570e);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37174a(InterfaceC6573h interfaceC6573h) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6573h != null ? interfaceC6573h.asBinder() : null);
                    if (this.f30525a.transact(42, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37174a(interfaceC6573h);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37175a(InterfaceC6574i interfaceC6574i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6574i != null ? interfaceC6574i.asBinder() : null);
                    if (this.f30525a.transact(46, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37175a(interfaceC6574i);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37176a(InterfaceC6575j interfaceC6575j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6575j != null ? interfaceC6575j.asBinder() : null);
                    if (this.f30525a.transact(45, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37176a(interfaceC6575j);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37177a(InterfaceC6577l interfaceC6577l) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStrongBinder(interfaceC6577l != null ? interfaceC6577l.asBinder() : null);
                    if (this.f30525a.transact(71, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37177a(interfaceC6577l);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37178a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    if (this.f30525a.transact(3, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37178a(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37179a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.f30525a.transact(68, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37179a(str, str2, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37180a(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30525a.transact(55, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37180a(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
            /* renamed from: a */
            public void mo37181a(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPlayerCore");
                    parcelObtain.writeStringArray(strArr);
                    if (this.f30525a.transact(4, parcelObtain, parcelObtain2, 0) || a.m37412g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37412g().mo37181a(strArr);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC6571f m37411a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.videokit.player.internal.IPlayerCore");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC6571f)) ? new C14445a(iBinder) : (InterfaceC6571f) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC6571f m37412g() {
            return C14445a.f30524b;
        }
    }

    /* renamed from: a */
    long mo37166a() throws RemoteException;

    /* renamed from: a */
    void mo37167a(int i10) throws RemoteException;

    /* renamed from: a */
    void mo37168a(IObjectWrapper iObjectWrapper, int i10) throws RemoteException;

    /* renamed from: a */
    void mo37169a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    /* renamed from: a */
    void mo37170a(InterfaceC6566a interfaceC6566a) throws RemoteException;

    /* renamed from: a */
    void mo37171a(InterfaceC6567b interfaceC6567b) throws RemoteException;

    /* renamed from: a */
    void mo37172a(InterfaceC6568c interfaceC6568c) throws RemoteException;

    /* renamed from: a */
    void mo37173a(InterfaceC6570e interfaceC6570e) throws RemoteException;

    /* renamed from: a */
    void mo37174a(InterfaceC6573h interfaceC6573h) throws RemoteException;

    /* renamed from: a */
    void mo37175a(InterfaceC6574i interfaceC6574i) throws RemoteException;

    /* renamed from: a */
    void mo37176a(InterfaceC6575j interfaceC6575j) throws RemoteException;

    /* renamed from: a */
    void mo37177a(InterfaceC6577l interfaceC6577l) throws RemoteException;

    /* renamed from: a */
    void mo37178a(String str) throws RemoteException;

    /* renamed from: a */
    void mo37179a(String str, String str2, String str3, String str4) throws RemoteException;

    /* renamed from: a */
    void mo37180a(boolean z10) throws RemoteException;

    /* renamed from: a */
    void mo37181a(String[] strArr) throws RemoteException;

    /* renamed from: b */
    String mo37182b() throws RemoteException;

    /* renamed from: b */
    void mo37183b(int i10) throws RemoteException;

    /* renamed from: b */
    void mo37184b(boolean z10) throws RemoteException;

    /* renamed from: c */
    int mo37185c() throws RemoteException;

    /* renamed from: c */
    IObjectWrapper mo37186c(int i10) throws RemoteException;

    /* renamed from: c */
    void mo37187c(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: c */
    void mo37188c(String str) throws RemoteException;

    /* renamed from: c */
    void mo37189c(boolean z10) throws RemoteException;

    void closeLogo() throws RemoteException;

    /* renamed from: d */
    void mo37190d(int i10) throws RemoteException;

    /* renamed from: d */
    void mo37191d(String str) throws RemoteException;

    void deselectSubtitleTrack() throws RemoteException;

    /* renamed from: e */
    void mo37192e(int i10) throws RemoteException;

    /* renamed from: e */
    void mo37193e(boolean z10) throws RemoteException;

    AudioTrackInfo[] getAudioTracks() throws RemoteException;

    int getBufferTime() throws RemoteException;

    long getBufferingSpeed() throws RemoteException;

    StreamInfo getCurrentStreamInfo() throws RemoteException;

    int getCurrentTime() throws RemoteException;

    int getDuration() throws RemoteException;

    int getPlayMode() throws RemoteException;

    float getPlaySpeed() throws RemoteException;

    AudioTrackInfo getSelectedAudioTrack() throws RemoteException;

    SubtitleTrackInfo getSelectedSubtitleTrack() throws RemoteException;

    SubtitleTrackInfo[] getSubtitleTracks() throws RemoteException;

    int getVideoHeight() throws RemoteException;

    VideoInfo getVideoInfo() throws RemoteException;

    int getVideoWidth() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void pause() throws RemoteException;

    void presetAudioLanguage(String str) throws RemoteException;

    void presetSubtitleLanguage(String str) throws RemoteException;

    void ready() throws RemoteException;

    void refreshPlayUrl(String str) throws RemoteException;

    void release() throws RemoteException;

    void reset() throws RemoteException;

    void resume(int i10) throws RemoteException;

    void seek(int i10) throws RemoteException;

    void selectAudioTrack(int i10) throws RemoteException;

    void selectSubtitleTrack(int i10) throws RemoteException;

    int setBandwidthSwitchMode(int i10) throws RemoteException;

    void setBitrateRange(int i10, int i11) throws RemoteException;

    void setBookmark(int i10) throws RemoteException;

    void setBufferingStatus(boolean z10) throws RemoteException;

    void setCycleMode(int i10) throws RemoteException;

    void setInitBitrate(InitBitrateParam initBitrateParam) throws RemoteException;

    void setMute(boolean z10) throws RemoteException;

    void setPlayMode(int i10) throws RemoteException;

    void setPlaySpeed(float f10) throws RemoteException;

    void setSurfaceChange() throws RemoteException;

    void setVideoType(int i10) throws RemoteException;

    void setVolume(float f10) throws RemoteException;

    void start() throws RemoteException;

    void stop() throws RemoteException;

    void suspend() throws RemoteException;

    void switchBitrateDesignated(int i10) throws RemoteException;

    void switchBitrateSmooth(int i10) throws RemoteException;
}
