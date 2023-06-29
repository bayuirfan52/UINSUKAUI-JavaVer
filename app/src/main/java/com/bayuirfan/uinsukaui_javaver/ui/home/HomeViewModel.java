package com.bayuirfan.uinsukaui_javaver.ui.home;

import androidx.lifecycle.ViewModel;

import com.bayuirfan.uinsukaui_javaver.data.model.News;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private ArrayList<News> listNews = new ArrayList<>();

    ArrayList<News> get() {

        News news = new News();
        news.setDate("24 October 2021 16:15");
        news.setHeadline("Punya Rumah Sendiri Sebelum Usia 30 Tahun, Bisa Nggak Ya?");
        news.setImage("https://akcdn.detik.net.id/visual/2018/01/04/b44f9510-6905-42d9-8193-cf1e6b9532f1_169.jpeg?w=715&q=90");
        listNews.add(news);
        listNews.add(news);
        listNews.add(news);
        listNews.add(news);

        return listNews;
    }
}