package kr.jay.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by soeun on 2016. 3. 5..
 */
public class VoiceRecogActivity extends Activity{
    Intent mIntent;
    SpeechRecognizer mRecognizer;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_recog);

        mIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(listener);
        mRecognizer.startListening(mIntent);

        textView = (TextView) findViewById(R.id.textView);
    }

    private RecognitionListener listener = new RecognitionListener() {

        @Override
        public void onReadyForSpeech(Bundle params)  {
            Toast.makeText(VoiceRecogActivity.this, "onReadyForSpeech", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onBeginningOfSpeech() {
            Toast.makeText(VoiceRecogActivity.this, "onBeginningOfSpeech", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRmsChanged(float rmsdB) {
            // Toast.makeText(MainActivity.this, "onRmsChanged", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBufferReceived(byte[] buffer) {
        }

        @Override
        public void onEndOfSpeech() {
            Toast.makeText(VoiceRecogActivity.this, "onEndOfSpeech", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(int error) {

        }

        @Override
        public void onResults(Bundle results) {
            ///
            String key= "";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = results.getStringArrayList(key);
            if(mResult.size() != 0) {
                String[] rs = new String[mResult.size()];
                mResult.toArray(rs);
                textView.setText("" + rs[0]);
            }
            mRecognizer.startListening(mIntent);
            ///
        }

        @Override
        public void onPartialResults(Bundle partialResults) {
            Toast.makeText(VoiceRecogActivity.this, "onPartialResults", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onEvent(int eventType, Bundle params) {
            Toast.makeText(VoiceRecogActivity.this, "onEvent", Toast.LENGTH_SHORT).show();
        }
    };
}
