package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button StartGame;
    public static Character Player;
    public static Story story;
    public TextView Subject;
    public TextView Text;
    public Button Button1;
    public Button Button2;
    public Button Button3;
    public TextView Rep;
    public TextView Mon;
    public TextView Hp;
    public Button ExitButton;
    public TextView Mesto;
    public MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player=MediaPlayer.create(this,R.raw.astronomia);
        player.start();
        player.setLooping(true);
        StartGame=(Button)findViewById(R.id.StartButton);
        StartGame.setOnClickListener(StartGameClick);
        Subject=(TextView)findViewById(R.id.Subject);
        Text=(TextView)findViewById(R.id.Text);
        Rep=(TextView)findViewById(R.id.Rep);
        Mon=(TextView)findViewById(R.id.Mon);
        Hp=(TextView)findViewById(R.id.Hp);
        Button1=(Button)findViewById(R.id.Button1);
        Button1.setOnClickListener(Button1Click);
        Button2=(Button)findViewById(R.id.Button2);
        Button3=(Button)findViewById(R.id.Button3);
        Button2.setOnClickListener(Button2Click);
        Button3.setOnClickListener(Button3Click);
        ExitButton=(Button)findViewById(R.id.ExitButton);
       ExitButton.setOnClickListener(ExitButtonClick);
       Mesto=(TextView)findViewById(R.id.Mesto);
    }
    View.OnClickListener StartGameClick= (v) ->{
        Player = new Character("Player");
        story = new Story();
        Subject.setVisibility(View.VISIBLE);
        Text.setVisibility(View.VISIBLE);
        Rep.setVisibility(View.VISIBLE);
        Mon.setVisibility(View.VISIBLE);
        Hp.setVisibility(View.VISIBLE);
        Button1.setVisibility(View.VISIBLE);
        Button2.setVisibility(View.VISIBLE);
        Button3.setVisibility(View.VISIBLE);
        StartGame.setVisibility(View.GONE);
        Mesto.setVisibility(View.GONE);

        ReWrite();
    };
   View.OnClickListener Button1Click=(v) ->{
        story.current_situation = story.current_situation.direction[0];
       ReWrite();
    };
    View.OnClickListener Button2Click=(v) ->{
        story.current_situation = story.current_situation.direction[1];
        ReWrite();
    };
    View.OnClickListener Button3Click=(v) ->{
        story.current_situation = story.current_situation.direction[2];
        ReWrite();
    };
     View.OnClickListener ExitButtonClick=(v) -> {
        System.exit(0);
    };
   public void ReWrite(){
        Subject.setText(story.current_situation.subject);
        Text.setText(story.current_situation.text);
        Player.Rep += story.current_situation.dRep;
        Player.Mon += story.current_situation.dMon;
        Player.Hp += story.current_situation.dHp;
        Button1.setText(story.current_situation.Var1);
        Button2.setText(story.current_situation.Var2);
        Button3.setText(story.current_situation.Var3);
        Rep.setText("Репутация:"+String.valueOf(Player.Rep));
        Mon.setText("Деньги:"+String.valueOf(Player.Mon));
        Hp.setText("Здоровье:"+String.valueOf(Player.Hp));
        if(story.current_situation.direction.length==0)
        {
         Button1.setVisibility(View.GONE);
          Button2.setVisibility(View.GONE);
           Button3.setVisibility(View.GONE);
           ExitButton.setVisibility(View.VISIBLE);
        }
    }
}