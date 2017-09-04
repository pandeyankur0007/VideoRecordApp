package fluper.dev.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by fluper-android on 1/9/17.
 */

public class PlayVideoActivity extends AppCompatActivity{


    private String SrcPath = "/sdcard/video.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video_play);


        VideoView myVideoView = (VideoView)findViewById(R.id.video_view);
//        myVideoView.getHolder().lockCanvas().rotate(90);
        myVideoView.setVideoPath(SrcPath);
        myVideoView.setMediaController(new MediaController(this));
        myVideoView.requestFocus();
        myVideoView.start();

    }
    }
