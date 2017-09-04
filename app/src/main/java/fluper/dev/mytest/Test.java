package fluper.dev.mytest;

/**
 * Created by fluper-android on 1/9/17.
 */

public class Test {

//    private MediaRecorder recorder;
//    private SurfaceHolder holder;
//    private boolean recording = false;
//    private Button btn_record;
//    private Context context;
//    private ArrayList<String> mQuestions;
//    private int count=0;
//    private TextView txt_question;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        recorder = new MediaRecorder();
//        initRecorder();
//        setContentView(R.layout.layout_videocapture);
//
//        context=this;
//        mQuestions=new ArrayList<>();
//        mQuestions.add("Question 1: What is your name?");
//        mQuestions.add("Question 2: Your age?");
//        mQuestions.add("Question 3: What is your profile?");
//        mQuestions.add("Question 4: Why I hire you?");
//
//        btn_record=(Button)findViewById(R.id.btn_start_recording);
//        btn_record.setOnClickListener(this);
//
//        txt_question=(TextView)findViewById(R.id.txt_question);
//        count=0;
//        txt_question.setText(mQuestions.get(count));
//
//        SurfaceView cameraView = (SurfaceView) findViewById(R.id.CameraView);
//        holder = cameraView.getHolder();
//        holder.addCallback(this);
//        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//
//        cameraView.setClickable(true);
//        cameraView.setOnClickListener(this);
//    }
//
//    private void initRecorder() {
//        recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
//        recorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
//
//        CamcorderProfile cpHigh = CamcorderProfile
//                .get(CamcorderProfile.QUALITY_HIGH);
//        recorder.setProfile(cpHigh);
//        recorder.setOutputFile("/sdcard/000.mp4");
//        recorder.setMaxDuration(300000); // 30 seconds
//        //recorder.setMaxFileSize(5000000); // Approximately 5 megabytes
//    }
//
//    private void prepareRecorder() {
//        recorder.setPreviewDisplay(holder.getSurface());
//
//        try {
//            recorder.prepare();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//            btn_record.setText(getResources().getString(R.string.record_video));
//            finish();
//        } catch (IOException e) {
//            e.printStackTrace();
//            btn_record.setText(getResources().getString(R.string.record_video));
//            finish();
//        }
//    }
//
//    public void onClick(View v) {
//
//        switch (v.getId()){
//
//            case R.id.btn_start_recording:
//
//                if (recording) {
//                    recorder.stop();
//                    recording = false;
//                    btn_record.setText(getResources().getString(R.string.record_video));
//                    // Let's initRecorder so we can record again
//                    initRecorder();
//                    prepareRecorder();
//                } else {
//                    recording = true;
//                    initRecorder();
//                    prepareRecorder();
////                    btn_record.setText(getResources().getString(R.string.stop_video));
//                    recorder.start();
//
////                    new CountDownTimer(30000, 1000) {
////
////                        public void onTick(long millisUntilFinished) {
////                            btn_record.setText("seconds remaining: " + millisUntilFinished / 1000);
////                        }
////
////                        public void onFinish() {
////
////                            Toast.makeText(context,"Video Record",Toast.LENGTH_LONG).show();
////                           // btn_record.setText("done!");
////
////                            recorder.stop();
////                            recording = false;
////                            btn_record.setText(getResources().getString(R.string.record_video));
////                            count++;
////
////                            if(count<mQuestions.size())
////                            txt_question.setText(mQuestions.get(count));
////
////                        }
////
////                    }.start();
//                }
//
//                break;
//
//        }
//
//    }
//
//    public void surfaceCreated(SurfaceHolder holder) {
//        prepareRecorder();
//    }
//
//    public void surfaceChanged(SurfaceHolder holder, int format, int width,
//                               int height) {
//    }
//
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        if (recording) {
//            recorder.stop();
//            recording = false;
//        }
//        recorder.release();
//        finish();
//    }
}
