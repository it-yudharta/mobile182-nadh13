package com.anas.komikapp.Interface;

import com.anas.komikapp.Model.Comic;

import java.util.List;

public interface IComicLoadDone {

    void onComicLoadDoneListener(List<Comic> comic_load);
}
