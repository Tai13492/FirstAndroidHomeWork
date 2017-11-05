package com.example.tai.firstandroidhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final ChangeColor c1 = new ChangeColor(textView,imageView);
        Button red = (Button) findViewById(R.id.buttonRed);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setTextAndImageView("red");
            }
        });
        Button yellow = (Button) findViewById(R.id.buttonYellow);
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setTextAndImageView("yellow");
            }
        });
        Button green = (Button) findViewById(R.id.buttonGreen);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setTextAndImageView("green");
            }
        });
    }
    class ChangeColor{

        TextView textView;
        ImageView imageView;

        public ChangeColor(TextView textView, ImageView imageView){
            this.textView = textView;
            this.imageView = imageView;
        }

        public void setTextAndImageView(String color){
            this.textView.setText(color.toUpperCase());
            switch (color){
                case "red": this.imageView.setImageResource(R.drawable.red);
                            this.imageView.setTranslationX(-1000f);
                            this.imageView.animate().translationXBy(1000f).setDuration(300);
                            Log.i("test","red clicked");
                      break;
                case "yellow": this.imageView.setImageResource(R.drawable.yellow);
                               this.imageView.setTranslationY(-1000f);
                               this.imageView.animate().translationYBy(1000f).setDuration(300);
                               Log.i("test","yellow clicked");
                      break;
                case "green": this.imageView.setImageResource(R.drawable.green);
                              this.imageView.setTranslationX(1000f);
                              this.imageView.animate().translationXBy(-1000f);
                              Log.i("test","green clicked");
                      break;
                default: this.imageView.setImageResource(R.drawable.red);
                    break;
            }
        }
    }
}
