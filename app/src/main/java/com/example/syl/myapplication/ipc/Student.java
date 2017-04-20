package com.example.syl.myapplication.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shen YunLong on 2017/04/10.
 */
public class Student implements Parcelable {

    private String name;
    private int age;

    protected Student(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    private void readFromParcel(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }
}
