package fluper.dev.mytest;

import android.content.Context;
import android.content.Intent;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fluper-android on 1/9/17.
 */

public class VideoCapture extends AppCompatActivity implements View.OnClickListener, SurfaceHolder.Callback {
    private MediaRecorder recorder;
    private SurfaceHolder holder;
    private boolean recording = false;
    private Button btn_record;
    private Context context;
    private ArrayList<String> mQuestions;
    private int count=0;
    private TextView txt_question;
    private  int time=0;
    private ProgressBar progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        recorder = new MediaRecorder();



        initRecorder();
        setContentView(R.layout.layout_videocapture);

        context=this;
        mQuestions=new ArrayList<>();
        mQuestions.add("Question 1: What is your name?");
        mQuestions.add("Question 2: Your age?");
        mQuestions.add("Question 3: What is your profile?");
        mQuestions.add("Question 4: Why I hire you?");

        btn_record=(Button)findViewById(R.id.btn_start_recording);
        btn_record.setOnClickListener(this);

        txt_question=(TextView)findViewById(R.id.txt_question);
        progressBar=(ProgressBar)findViewById(R.id.circularProgressbar);
        count=0;
        txt_question.setText(mQuestions.get(count));

        SurfaceView cameraView = (SurfaceView) findViewById(R.id.CameraView);

        holder = cameraView.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        cameraView.setClickable(true);
        cameraView.setOnClickListener(this);

    }

    private void initRecorder() {


        recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        recorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);

        CamcorderProfile cpHigh = CamcorderProfile
                .get(CamcorderProfile.QUALITY_HIGH);
        recorder.setProfile(cpHigh);
        recorder.setOutputFile("/sdcard/video.mp4");
        recorder.setMaxDuration(300000); // 30 seconds
        //recorder.setMaxFileSize(5000000); // Approximately 5 megabytes
    }


    private void prepareRecorder() {

        recorder.setOrientationHint(90);
        recorder.setPreviewDisplay(holder.getSurface());

        try {
            recorder.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            btn_record.setText(getResources().getString(R.string.record_video));
            finish();
        } catch (IOException e) {
            e.printStackTrace();
            btn_record.setText(getResources().getString(R.string.record_video));
            finish();
        }
    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_start_recording:
                    recording = true;
                    recorder.start();

                btn_record.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                startTimmer();

                break;

        }

    }

    // Todo Start Timmer

    private void startTimmer(){

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                btn_record.setText("seconds remaining: " + millisUntilFinished / 1000);


                long timeRemain=millisUntilFinished / 1000;

                progressBar.setProgress(30-Integer.parseInt(""+timeRemain));

                if(timeRemain >28){
                    txt_question.setText(mQuestions.get(0));
                }else if(timeRemain > 26){
                    txt_question.setText(mQuestions.get(1));
                }else if(timeRemain > 23){
                    txt_question.setText(mQuestions.get(2));
                }else if(timeRemain > 0){
                    txt_question.setText(mQuestions.get(3));

                }


            }

            public void onFinish() {

                Toast.makeText(context,"Video Save",Toast.LENGTH_LONG).show();
                 btn_record.setText("done!");

                recorder.stop();
                recording = false;
                btn_record.setText(getResources().getString(R.string.record_video));

                Toast.makeText(context,"Task Complete",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(VideoCapture.this,PlayVideoActivity.class);
                startActivity(intent);
                finish();

            }

        }.start();

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        prepareRecorder();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        if (recording) {
            recorder.stop();
            recording = false;
        }
        recorder.release();
        finish();

    }

}