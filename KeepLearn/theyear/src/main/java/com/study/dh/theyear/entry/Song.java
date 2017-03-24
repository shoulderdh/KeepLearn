package com.study.dh.theyear.entry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dh on 2017/3/21.
 */

  public class Song  implements Parcelable {
    private String  name;
    private String  singer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
           parcel.writeString(name);        //此处写和下面的读  必须顺序一致
           parcel.writeString(singer);

    }

    public static  final  Parcelable.Creator<Song>  CREATOR=new Parcelable.Creator<Song>(){
        @Override
        public Song createFromParcel(Parcel parcel) {
            Song  song=new Song();
            song.name=parcel.readString();
            song.singer=parcel.readString();
            return song;
        }

        @Override
        public Song[] newArray(int i) {
            return new Song[i];
        }
    };

}
