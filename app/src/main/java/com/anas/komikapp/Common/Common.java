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
    public static String[] categories = {
            "Action",
            "Adult",
            "Adventure",
            "Comedy",
            "Completed",
            "Cooking",
            "Doujinshi",
            "Drama",
            "Drop",
            "Ecchi",
            "Fantasy",
            "Gender bender",
            "Harem",
            "Historical",
            "Horror",
            "Jose",
            "Latest",
            "Manhua",
            "Manhwa",
            "Material arts",
            "Mature",
            "Mecha",
            "Medical",
            "Mystery",
            "Newest",
            "One shot",
            "Ongoing",
            "Psychological",
            "Romance",
            "School life",
            "Sci fi",
            "Seinen",
            "Shoujo",
            "Shoujo a",
            "Shounen",
            "Shounen ai",
            "Slice of life",
            "Smut",
            "Sports",
            "Superhero",
            "Supernatural",
            "Top Read",
            "Tragedy",
            "Webtoons",
            "Yaoi",
            "Yuri"
    };

    public static String formatString(String name) {
        StringBuilder finalReult = new StringBuilder(name.length() > 15?name.substring(0,15)+"...":name);
        return finalReult.toString();
    }
}
