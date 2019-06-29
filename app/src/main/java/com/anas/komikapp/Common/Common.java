package com.anas.komikapp.Common;

import com.anas.komikapp.Model.Chapter;
import com.anas.komikapp.Model.Comic;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static List<Comic> comicList = new ArrayList<>();

    public static Comic comicSelected;
    public static List<Chapter> chapterList;
    public static Chapter chapterSelected;
    public static int chapterIndex=-1;

    public static String formatString(String name) {
        StringBuilder finalReult = new StringBuilder(name.length() > 15?name.substring(0,15)+"...":name);
        return finalReult.toString();
    }
}
