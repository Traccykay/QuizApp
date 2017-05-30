package com.example.user.Crystalize;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.user.Crystalize.R.id.answer;

public class Questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        findViewById(R.id.tickcross).setVisibility(View.INVISIBLE);
        findViewById(R.id.correctornot).setVisibility(View.INVISIBLE);
        findViewById(R.id.nextbutton).setVisibility(View.INVISIBLE);
    }

    public void onHintClick(View view) {
        Toast toasty = Toast.makeText(getApplicationContext(), getString(R.string.H1), Toast.LENGTH_SHORT);
        toasty.show();
    }


    public void onAnswerClick(View view) {
        String answer = ((EditText) findViewById(answer)).getText().toString();
        String correctanswer = getString(R.string.A1);
        answer = answer.toLowerCase();
    }
    public void answersubmitted(){
        if (answer.equals(correctanswer)) {
            TextView t =(TextView) findViewById(R.id.correctornot);
            t.setText("CORRECT!");
            ImageView i = (ImageView) findViewById(R.id.tickcross);
            i.setImageDrawable(getDrawable(R.drawable.weirdtick));
            answersubmitted();
        } else {
            TextView t =(TextView) findViewById(R.id.correctornot);
            t.setText("CORRECT ANSWER: " + correctanswer);
            ImageView i = (ImageView) findViewById(R.id.tickcross);
            i.setImageDrawable(getDrawable(R.drawable.weirdtick));
            answersubmitted();
        }
            findViewById(R.id.tickcross).setVisibility(View.VISIBLE);
            TranslateAnimation animation = new TranslateAnimation(0,0,2000,0);
            animation.setDuration(1000);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    findViewById(R.id.correctornot).setVisibility(View.VISIBLE);
                    findViewById(R.id.nextbutton).setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            findViewById(R.id.tickcross).setVisibility(View.VISIBLE);


        } else {
            Toast toasty = Toast.makeText(getApplicationContext(), "Nope!", Toast.LENGTH_SHORT);
            toasty.show();
        }

    }
}

