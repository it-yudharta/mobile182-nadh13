package com.anas.komikapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anas.komikapp.Adapter.MyViewPagerAdapter;
import com.anas.komikapp.Common.Common;
import com.anas.komikapp.Model.Chapter;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

public class ViewComicActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView txt_chapter_name;
    View back, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comic);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        txt_chapter_name = (TextView)findViewById(R.id.txt_chapter_name);
        back = findViewById(R.id.chapter_back);
        next = findViewById(R.id.chapter_next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Common.chapterIndex ==  0)
                    Toast.makeText(ViewComicActivity.this, "Kamu Membaca Chapter Pertama", Toast.LENGTH_SHORT).show();
                else {
                    Common.chapterIndex--;
                    fetcLinks(Common.chapterList.get(Common.chapterIndex));
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Common.chapterIndex ==  Common.chapterList.size()-1)
                    Toast.makeText(ViewComicActivity.this, "Kamu Membaca Chapter Terakhir", Toast.LENGTH_SHORT).show();
                else {
                    Common.chapterIndex++;
                    fetcLinks(Common.chapterList.get(Common.chapterIndex));
                }
            }
        });

        fetcLinks(Common.chapterSelected);

    }

    private void fetcLinks(Chapter chapter) {

         if (chapter.Links !=null){
             if (chapter.Links.size() > 0) {

                 MyViewPagerAdapter adapter = new MyViewPagerAdapter(getBaseContext(), chapter.Links);
                 viewPager.setAdapter(adapter);

                 txt_chapter_name.setText(Common.formatString(Common.chapterSelected.Name));

                 //animasi
                 BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
                 bookFlipPageTransformer.setScaleAmountPercent(10f);
                 viewPager.setPageTransformer(true, bookFlipPageTransformer);

             }
             else {
                 Toast.makeText(this, "Tidak ada gambar", Toast.LENGTH_SHORT).show();
             }
         }
         else {
             Toast.makeText(this, "Chapter ini sedang dalam proses pengerjaan ... ", Toast.LENGTH_SHORT).show();

         }

    }
}
