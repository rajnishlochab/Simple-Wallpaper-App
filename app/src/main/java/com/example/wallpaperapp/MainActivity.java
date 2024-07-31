package com.example.wallpaperapp;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button setWallpaperButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        setWallpaperButton = findViewById(R.id.setWallpaperButton);

        setWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }

    private void setWallpaper() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.your_wallpaper);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
        }
    }
}
