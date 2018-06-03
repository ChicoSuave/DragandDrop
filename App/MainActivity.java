package com.example.jose.favoritegame;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer[] games = {R.drawable.ocarinaoftime2,R.drawable.oracleofages,R.drawable.windwaker,R.drawable.twilightprincess,
            R.drawable.skywardsword,R.drawable.botw};
    ImageView pic;
    TextView text;

    Button button1, button2;
    MediaPlayer main;
    int playing;
    int song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = MediaPlayer.create(MainActivity.this,R.raw.fairyfountain);
        main.start();
        main.setLooping(true);
        song = 0;

        button1 = (Button)findViewById(R.id.btnPlay);
        button2 = (Button)findViewById(R.id.btnStop);
        button1.setOnClickListener(playButton);
        button2.setOnClickListener(stopButton);

        text = (TextView)findViewById(R.id.lblGame);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imageLarge);

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (main.isPlaying()){
                    main.stop();
                    pic.setImageResource(games[position]);
                    selectSong(position);
                }
                else {
                    pic.setImageResource(games[position]);
                    selectSong(position);
                }
            }
        });
    }

    public void selectSong(int position){
        main = new MediaPlayer();
        switch (position) {
            case 0:
                text.setText(getString(R.string.ocarina));
                main = MediaPlayer.create(MainActivity.this, R.raw.main);
                song = 1;
                break;
            case 1:
                text.setText(getString(R.string.oracle));
                main = MediaPlayer.create(MainActivity.this, R.raw.oracleofages);
                song = 2;
                break;
            case 2:
                text.setText(getString(R.string.wind));
                main = MediaPlayer.create(MainActivity.this, R.raw.windwaker);
                song = 3;
                break;
            case 3:
                text.setText(getString(R.string.twilight));
                main = MediaPlayer.create(MainActivity.this, R.raw.twilightprincess);
                song = 4;
                break;
            case 4:
                text.setText(getString(R.string.skyward));
                main = MediaPlayer.create(MainActivity.this, R.raw.skywardsword);
                song = 5;
                break;
            case 5:
                text.setText(getString(R.string.breath));
                main = MediaPlayer.create(MainActivity.this, R.raw.breathofthewild);
                song = 6;
                break;
        }
        main.start();
        main.setLooping(true);
        playing = 1;

    }
    Button.OnClickListener playButton = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing){
                case 0:
                    main.start();
                    main.setLooping(true);
                    playing = 1;
                    break;
                case  1:
                    main.pause();
                    playing=0;
                    break;
                case 3:
                    main = new MediaPlayer();
                    switch (song){
                        case 0:
                            main = MediaPlayer.create(MainActivity.this,R.raw.fairyfountain);
                            break;
                        case 1:
                            main = MediaPlayer.create(MainActivity.this,R.raw.main);
                            break;
                        case 2:
                            main = MediaPlayer.create(MainActivity.this,R.raw.oracleofages);
                            break;
                        case 3:
                            main = MediaPlayer.create(MainActivity.this,R.raw.windwaker);
                            break;
                        case 4:
                            main = MediaPlayer.create(MainActivity.this,R.raw.twilightprincess);
                            break;
                        case 5:
                            main = MediaPlayer.create(MainActivity.this,R.raw.skywardsword);
                            break;
                        case 6:
                            main = MediaPlayer.create(MainActivity.this,R.raw.breathofthewild);
                            break;
                    }
                    main.start();
                    main.setLooping(true);
                    playing = 1;
                    break;
            }
        }
    };

    Button.OnClickListener stopButton = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            main.stop();
            playing = 3;
        }
    };

    private class ImageAdapter extends BaseAdapter{
        private Context context;

        private ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return games.length;
        }

        @Override
        public Object getItem(int parent) {
            return null;
        }

        @Override
        public long getItemId(int parent) {
            return 0;
        }

        @Override
        public View getView(int parent, View view, ViewGroup position) {
            pic = new ImageView(context);
            pic.setImageResource(games[parent]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(300,200));
            return pic;
        }
    }


}
