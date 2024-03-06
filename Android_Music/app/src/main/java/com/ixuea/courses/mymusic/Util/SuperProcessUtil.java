package com.ixuea.courses.mymusic.Util;

import android.os.Process;
public class SuperProcessUtil {
    public static void killApp(){
        Process.killProcess(Process.myPid());
    }
}
