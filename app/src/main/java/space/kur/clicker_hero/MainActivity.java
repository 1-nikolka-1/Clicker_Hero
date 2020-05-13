package space.kur.clicker_hero;


/*Место для историй

ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааААААААААААААААААА
начинаю марафонить. бэкап готов, можно ломать
ОНО РАБОТАЕТ РАБОТАЕТ РРРРРРРРРРРРРРРРРРРАААААААААББББББББББББББООООООООООООТТТТТТТТТТТТТТТТАААААААААААААААЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕТТТТТТТТТТТТТТТТТТТТТТТТ

*/

//app:srcCompat="@mipmap/oil_station"


//StringBuilder StringBuffer

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigInteger;
public class MainActivity extends AppCompatActivity {
    //форматирование чисел
    private String chenge(BigInteger a){

        if(q==96 && a.compareTo(new BigInteger("1000000"))>=1){
            q+=1;
            return chenge(a.divide(new BigInteger("10000")));
        }
        else if(a.compareTo(new BigInteger("100000"))>=1){
            q+=1;
            return chenge(a.divide(new BigInteger("1000")));
        }
        else{
            int aa=q;
            int bb=97;
            if(aa==96){aa=0; bb=0;}
            q=96;
            StringBuilder qq = new StringBuilder(a.toString());
            if(qq.length()>2&&aa!=0){
                qq.insert(qq.length()-2,".");}

            return qq.toString()+(char)bb+(char)aa;
        }

    }

    private BigInteger score = new BigInteger("0");



    private BigInteger afk = new BigInteger("0");
    private BigInteger bust = new BigInteger("1");
    private int q=96;

    private BigInteger save_afk_pause = new BigInteger("1");

    private int many_button = 40;

    private int[] bust_many = new int[many_button];
    private int[] afk_many = new int[many_button];



    final Handler handler = new Handler();
    final Handler handler1 = new Handler();
    TextView tv_score;
    TextView tv_bust;
    TextView tv_afk;
    TextView tv_many;
    TextView tv_plus;
    Button btn;


    final String LOG_TAG = "myLogs";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAll();
        if(afk.compareTo(save_afk_pause)<0){
        afk=save_afk_pause;}
        runTimer();
        runTimer_save();

        tv_score = findViewById(R.id.score);
        tv_score.setText(chenge(score));
        tv_bust = findViewById(R.id.bust_tv);
        tv_bust.setText(chenge(bust));
        tv_afk = findViewById(R.id.afk_tv);
        tv_afk.setText(chenge(afk));
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d(LOG_TAG, "onCreate");



        SharedPreferences loaaaad = getPreferences(MODE_PRIVATE);

        for(int ii=0;ii<many_button;ii++){
            bust_many[ii]=loaaaad.getInt(Integer.toString(ii),0);}
        for(int ii=0;ii<many_button;ii++){
            afk_many[ii]=loaaaad.getInt(Integer.toString(ii+many_button),0);}
        int goo=0;



        //0
        tv_many = findViewById(R.id.bust_tv__many_0);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_0);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_0);
        btn=findViewById(R.id.afk_button_0);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_0_1);
                    btn.setText(R.string.many_0_1);
                    break;
            case 2: tv_plus.setText(R.string.plus_0_2);
                    btn.setText(R.string.many_0_2);
                    break;
            case 3: tv_plus.setText(R.string.plus_0_3);
                    btn.setText(R.string.many_0_3);
                    break;
            case 4: tv_plus.setText(R.string.plus_0_4);
                    btn.setText(R.string.many_0_4);
                    break;
            case 5: tv_plus.setText(R.string.end);
                    btn.setText(R.string.end);
                    btn.setEnabled(false);
                    break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_0);
        btn=findViewById(R.id.bust_button_0);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_0_1);
                btn.setText(R.string.many_0_1);
                break;
            case 2: tv_plus.setText(R.string.plus_0_2);
                btn.setText(R.string.many_0_2);
                break;
            case 3: tv_plus.setText(R.string.plus_0_3);
                btn.setText(R.string.many_0_3);
                break;
            case 4: tv_plus.setText(R.string.plus_0_4);
                btn.setText(R.string.many_0_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;


        //1
        tv_many = findViewById(R.id.bust_tv__many_1);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_1);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_1);
        btn=findViewById(R.id.afk_button_1);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_1_1);
                btn.setText(R.string.many_1_1);
                break;
            case 2: tv_plus.setText(R.string.plus_1_2);
                btn.setText(R.string.many_1_2);
                break;
            case 3: tv_plus.setText(R.string.plus_1_3);
                btn.setText(R.string.many_1_3);
                break;
            case 4: tv_plus.setText(R.string.plus_1_4);
                btn.setText(R.string.many_1_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_1);
        btn=findViewById(R.id.bust_button_1);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_1_1);
                btn.setText(R.string.many_1_1);
                break;
            case 2: tv_plus.setText(R.string.plus_1_2);
                btn.setText(R.string.many_1_2);
                break;
            case 3: tv_plus.setText(R.string.plus_1_3);
                btn.setText(R.string.many_1_3);
                break;
            case 4: tv_plus.setText(R.string.plus_1_4);
                btn.setText(R.string.many_1_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //2
        tv_many = findViewById(R.id.bust_tv__many_2);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_2);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_2);
        btn=findViewById(R.id.afk_button_2);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_2_1);
                btn.setText(R.string.many_2_1);
                break;
            case 2: tv_plus.setText(R.string.plus_2_2);
                btn.setText(R.string.many_2_2);
                break;
            case 3: tv_plus.setText(R.string.plus_2_3);
                btn.setText(R.string.many_2_3);
                break;
            case 4: tv_plus.setText(R.string.plus_2_4);
                btn.setText(R.string.many_2_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_2);
        btn=findViewById(R.id.bust_button_2);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_2_1);
                btn.setText(R.string.many_2_1);
                break;
            case 2: tv_plus.setText(R.string.plus_2_2);
                btn.setText(R.string.many_2_2);
                break;
            case 3: tv_plus.setText(R.string.plus_2_3);
                btn.setText(R.string.many_2_3);
                break;
            case 4: tv_plus.setText(R.string.plus_2_4);
                btn.setText(R.string.many_2_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //3
        tv_many = findViewById(R.id.bust_tv__many_3);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_3);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_3);
        btn=findViewById(R.id.afk_button_3);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_3_1);
                btn.setText(R.string.many_3_1);
                break;
            case 2: tv_plus.setText(R.string.plus_3_2);
                btn.setText(R.string.many_3_2);
                break;
            case 3: tv_plus.setText(R.string.plus_3_3);
                btn.setText(R.string.many_3_3);
                break;
            case 4: tv_plus.setText(R.string.plus_3_4);
                btn.setText(R.string.many_3_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_3);
        btn=findViewById(R.id.bust_button_3);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_3_1);
                btn.setText(R.string.many_3_1);
                break;
            case 2: tv_plus.setText(R.string.plus_3_2);
                btn.setText(R.string.many_3_2);
                break;
            case 3: tv_plus.setText(R.string.plus_3_3);
                btn.setText(R.string.many_3_3);
                break;
            case 4: tv_plus.setText(R.string.plus_3_4);
                btn.setText(R.string.many_3_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //4
        tv_many = findViewById(R.id.bust_tv__many_4);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_4);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_4);
        btn=findViewById(R.id.afk_button_4);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_4_1);
                btn.setText(R.string.many_4_1);
                break;
            case 2: tv_plus.setText(R.string.plus_4_2);
                btn.setText(R.string.many_4_2);
                break;
            case 3: tv_plus.setText(R.string.plus_4_3);
                btn.setText(R.string.many_4_3);
                break;
            case 4: tv_plus.setText(R.string.plus_4_4);
                btn.setText(R.string.many_4_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_4);
        btn=findViewById(R.id.bust_button_4);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_4_1);
                btn.setText(R.string.many_4_1);
                break;
            case 2: tv_plus.setText(R.string.plus_4_2);
                btn.setText(R.string.many_4_2);
                break;
            case 3: tv_plus.setText(R.string.plus_4_3);
                btn.setText(R.string.many_4_3);
                break;
            case 4: tv_plus.setText(R.string.plus_4_4);
                btn.setText(R.string.many_4_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;




        //5
        tv_many = findViewById(R.id.bust_tv__many_5);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_5);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_5);
        btn=findViewById(R.id.afk_button_5);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_5_1);
                btn.setText(R.string.many_5_1);
                break;
            case 2: tv_plus.setText(R.string.plus_5_2);
                btn.setText(R.string.many_5_2);
                break;
            case 3: tv_plus.setText(R.string.plus_5_3);
                btn.setText(R.string.many_5_3);
                break;
            case 4: tv_plus.setText(R.string.plus_5_4);
                btn.setText(R.string.many_5_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_5);
        btn=findViewById(R.id.bust_button_5);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_5_1);
                btn.setText(R.string.many_5_1);
                break;
            case 2: tv_plus.setText(R.string.plus_5_2);
                btn.setText(R.string.many_5_2);
                break;
            case 3: tv_plus.setText(R.string.plus_5_3);
                btn.setText(R.string.many_5_3);
                break;
            case 4: tv_plus.setText(R.string.plus_5_4);
                btn.setText(R.string.many_5_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //6
        tv_many = findViewById(R.id.bust_tv__many_6);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_6);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_6);
        btn=findViewById(R.id.afk_button_6);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_6_1);
                btn.setText(R.string.many_6_1);
                break;
            case 2: tv_plus.setText(R.string.plus_6_2);
                btn.setText(R.string.many_6_2);
                break;
            case 3: tv_plus.setText(R.string.plus_6_3);
                btn.setText(R.string.many_6_3);
                break;
            case 4: tv_plus.setText(R.string.plus_6_4);
                btn.setText(R.string.many_6_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_6);
        btn=findViewById(R.id.bust_button_6);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_6_1);
                btn.setText(R.string.many_6_1);
                break;
            case 2: tv_plus.setText(R.string.plus_6_2);
                btn.setText(R.string.many_6_2);
                break;
            case 3: tv_plus.setText(R.string.plus_6_3);
                btn.setText(R.string.many_6_3);
                break;
            case 4: tv_plus.setText(R.string.plus_6_4);
                btn.setText(R.string.many_6_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //7
        tv_many = findViewById(R.id.bust_tv__many_7);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_7);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_7);
        btn=findViewById(R.id.afk_button_7);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_7_1);
                btn.setText(R.string.many_7_1);
                break;
            case 2: tv_plus.setText(R.string.plus_7_2);
                btn.setText(R.string.many_7_2);
                break;
            case 3: tv_plus.setText(R.string.plus_7_3);
                btn.setText(R.string.many_7_3);
                break;
            case 4: tv_plus.setText(R.string.plus_7_4);
                btn.setText(R.string.many_7_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_7);
        btn=findViewById(R.id.bust_button_7);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_7_1);
                btn.setText(R.string.many_7_1);
                break;
            case 2: tv_plus.setText(R.string.plus_7_2);
                btn.setText(R.string.many_7_2);
                break;
            case 3: tv_plus.setText(R.string.plus_7_3);
                btn.setText(R.string.many_7_3);
                break;
            case 4: tv_plus.setText(R.string.plus_7_4);
                btn.setText(R.string.many_7_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //8
        tv_many = findViewById(R.id.bust_tv__many_8);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_8);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_8);
        btn=findViewById(R.id.afk_button_8);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_8_1);
                btn.setText(R.string.many_8_1);
                break;
            case 2: tv_plus.setText(R.string.plus_8_2);
                btn.setText(R.string.many_8_2);
                break;
            case 3: tv_plus.setText(R.string.plus_8_3);
                btn.setText(R.string.many_8_3);
                break;
            case 4: tv_plus.setText(R.string.plus_8_4);
                btn.setText(R.string.many_8_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_8);
        btn=findViewById(R.id.bust_button_8);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_8_1);
                btn.setText(R.string.many_8_1);
                break;
            case 2: tv_plus.setText(R.string.plus_8_2);
                btn.setText(R.string.many_8_2);
                break;
            case 3: tv_plus.setText(R.string.plus_8_3);
                btn.setText(R.string.many_8_3);
                break;
            case 4: tv_plus.setText(R.string.plus_8_4);
                btn.setText(R.string.many_8_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //9
        tv_many = findViewById(R.id.bust_tv__many_9);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_9);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_9);
        btn=findViewById(R.id.afk_button_9);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_9_1);
                btn.setText(R.string.many_9_1);
                break;
            case 2: tv_plus.setText(R.string.plus_9_2);
                btn.setText(R.string.many_9_2);
                break;
            case 3: tv_plus.setText(R.string.plus_9_3);
                btn.setText(R.string.many_9_3);
                break;
            case 4: tv_plus.setText(R.string.plus_9_4);
                btn.setText(R.string.many_9_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_9);
        btn=findViewById(R.id.bust_button_9);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_9_1);
                btn.setText(R.string.many_9_1);
                break;
            case 2: tv_plus.setText(R.string.plus_9_2);
                btn.setText(R.string.many_9_2);
                break;
            case 3: tv_plus.setText(R.string.plus_9_3);
                btn.setText(R.string.many_9_3);
                break;
            case 4: tv_plus.setText(R.string.plus_9_4);
                btn.setText(R.string.many_9_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //10
        tv_many = findViewById(R.id.bust_tv__many_10);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_10);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_10);
        btn=findViewById(R.id.afk_button_10);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_10_1);
                btn.setText(R.string.many_10_1);
                break;
            case 2: tv_plus.setText(R.string.plus_10_2);
                btn.setText(R.string.many_10_2);
                break;
            case 3: tv_plus.setText(R.string.plus_10_3);
                btn.setText(R.string.many_10_3);
                break;
            case 4: tv_plus.setText(R.string.plus_10_4);
                btn.setText(R.string.many_10_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_10);
        btn=findViewById(R.id.bust_button_10);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_10_1);
                btn.setText(R.string.many_10_1);
                break;
            case 2: tv_plus.setText(R.string.plus_10_2);
                btn.setText(R.string.many_10_2);
                break;
            case 3: tv_plus.setText(R.string.plus_10_3);
                btn.setText(R.string.many_10_3);
                break;
            case 4: tv_plus.setText(R.string.plus_10_4);
                btn.setText(R.string.many_10_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //11
        tv_many = findViewById(R.id.bust_tv__many_11);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_11);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_11);
        btn=findViewById(R.id.afk_button_11);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_11_1);
                btn.setText(R.string.many_11_1);
                break;
            case 2: tv_plus.setText(R.string.plus_11_2);
                btn.setText(R.string.many_11_2);
                break;
            case 3: tv_plus.setText(R.string.plus_11_3);
                btn.setText(R.string.many_11_3);
                break;
            case 4: tv_plus.setText(R.string.plus_11_4);
                btn.setText(R.string.many_11_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_11);
        btn=findViewById(R.id.bust_button_11);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_11_1);
                btn.setText(R.string.many_11_1);
                break;
            case 2: tv_plus.setText(R.string.plus_11_2);
                btn.setText(R.string.many_11_2);
                break;
            case 3: tv_plus.setText(R.string.plus_11_3);
                btn.setText(R.string.many_11_3);
                break;
            case 4: tv_plus.setText(R.string.plus_11_4);
                btn.setText(R.string.many_11_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //12
        tv_many = findViewById(R.id.bust_tv__many_12);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_12);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_12);
        btn=findViewById(R.id.afk_button_12);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_12_1);
                btn.setText(R.string.many_12_1);
                break;
            case 2: tv_plus.setText(R.string.plus_12_2);
                btn.setText(R.string.many_12_2);
                break;
            case 3: tv_plus.setText(R.string.plus_12_3);
                btn.setText(R.string.many_12_3);
                break;
            case 4: tv_plus.setText(R.string.plus_12_4);
                btn.setText(R.string.many_12_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_12);
        btn=findViewById(R.id.bust_button_12);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_12_1);
                btn.setText(R.string.many_12_1);
                break;
            case 2: tv_plus.setText(R.string.plus_12_2);
                btn.setText(R.string.many_12_2);
                break;
            case 3: tv_plus.setText(R.string.plus_12_3);
                btn.setText(R.string.many_12_3);
                break;
            case 4: tv_plus.setText(R.string.plus_12_4);
                btn.setText(R.string.many_12_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //13
        tv_many = findViewById(R.id.bust_tv__many_13);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_13);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_13);
        btn=findViewById(R.id.afk_button_13);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_13_1);
                btn.setText(R.string.many_13_1);
                break;
            case 2: tv_plus.setText(R.string.plus_13_2);
                btn.setText(R.string.many_13_2);
                break;
            case 3: tv_plus.setText(R.string.plus_13_3);
                btn.setText(R.string.many_13_3);
                break;
            case 4: tv_plus.setText(R.string.plus_13_4);
                btn.setText(R.string.many_13_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_13);
        btn=findViewById(R.id.bust_button_13);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_13_1);
                btn.setText(R.string.many_13_1);
                break;
            case 2: tv_plus.setText(R.string.plus_13_2);
                btn.setText(R.string.many_13_2);
                break;
            case 3: tv_plus.setText(R.string.plus_13_3);
                btn.setText(R.string.many_13_3);
                break;
            case 4: tv_plus.setText(R.string.plus_13_4);
                btn.setText(R.string.many_13_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //14
        tv_many = findViewById(R.id.bust_tv__many_14);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_14);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_14);
        btn=findViewById(R.id.afk_button_14);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_14_1);
                btn.setText(R.string.many_14_1);
                break;
            case 2: tv_plus.setText(R.string.plus_14_2);
                btn.setText(R.string.many_14_2);
                break;
            case 3: tv_plus.setText(R.string.plus_14_3);
                btn.setText(R.string.many_14_3);
                break;
            case 4: tv_plus.setText(R.string.plus_14_4);
                btn.setText(R.string.many_14_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_14);
        btn=findViewById(R.id.bust_button_14);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_14_1);
                btn.setText(R.string.many_14_1);
                break;
            case 2: tv_plus.setText(R.string.plus_14_2);
                btn.setText(R.string.many_14_2);
                break;
            case 3: tv_plus.setText(R.string.plus_14_3);
                btn.setText(R.string.many_14_3);
                break;
            case 4: tv_plus.setText(R.string.plus_14_4);
                btn.setText(R.string.many_14_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //15
        tv_many = findViewById(R.id.bust_tv__many_15);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_15);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_15);
        btn=findViewById(R.id.afk_button_15);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_15_1);
                btn.setText(R.string.many_15_1);
                break;
            case 2: tv_plus.setText(R.string.plus_15_2);
                btn.setText(R.string.many_15_2);
                break;
            case 3: tv_plus.setText(R.string.plus_15_3);
                btn.setText(R.string.many_15_3);
                break;
            case 4: tv_plus.setText(R.string.plus_15_4);
                btn.setText(R.string.many_15_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_15);
        btn=findViewById(R.id.bust_button_15);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_15_1);
                btn.setText(R.string.many_15_1);
                break;
            case 2: tv_plus.setText(R.string.plus_15_2);
                btn.setText(R.string.many_15_2);
                break;
            case 3: tv_plus.setText(R.string.plus_15_3);
                btn.setText(R.string.many_15_3);
                break;
            case 4: tv_plus.setText(R.string.plus_15_4);
                btn.setText(R.string.many_15_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //16
        tv_many = findViewById(R.id.bust_tv__many_16);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_16);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_16);
        btn=findViewById(R.id.afk_button_16);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_16_1);
                btn.setText(R.string.many_16_1);
                break;
            case 2: tv_plus.setText(R.string.plus_16_2);
                btn.setText(R.string.many_16_2);
                break;
            case 3: tv_plus.setText(R.string.plus_16_3);
                btn.setText(R.string.many_16_3);
                break;
            case 4: tv_plus.setText(R.string.plus_16_4);
                btn.setText(R.string.many_16_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_16);
        btn=findViewById(R.id.bust_button_16);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_16_1);
                btn.setText(R.string.many_16_1);
                break;
            case 2: tv_plus.setText(R.string.plus_16_2);
                btn.setText(R.string.many_16_2);
                break;
            case 3: tv_plus.setText(R.string.plus_16_3);
                btn.setText(R.string.many_16_3);
                break;
            case 4: tv_plus.setText(R.string.plus_16_4);
                btn.setText(R.string.many_16_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //17
        tv_many = findViewById(R.id.bust_tv__many_17);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_17);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_17);
        btn=findViewById(R.id.afk_button_17);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_17_1);
                btn.setText(R.string.many_17_1);
                break;
            case 2: tv_plus.setText(R.string.plus_17_2);
                btn.setText(R.string.many_17_2);
                break;
            case 3: tv_plus.setText(R.string.plus_17_3);
                btn.setText(R.string.many_17_3);
                break;
            case 4: tv_plus.setText(R.string.plus_17_4);
                btn.setText(R.string.many_17_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_17);
        btn=findViewById(R.id.bust_button_17);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_17_1);
                btn.setText(R.string.many_17_1);
                break;
            case 2: tv_plus.setText(R.string.plus_17_2);
                btn.setText(R.string.many_17_2);
                break;
            case 3: tv_plus.setText(R.string.plus_17_3);
                btn.setText(R.string.many_17_3);
                break;
            case 4: tv_plus.setText(R.string.plus_17_4);
                btn.setText(R.string.many_17_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //18
        tv_many = findViewById(R.id.bust_tv__many_18);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_18);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_18);
        btn=findViewById(R.id.afk_button_18);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_18_1);
                btn.setText(R.string.many_18_1);
                break;
            case 2: tv_plus.setText(R.string.plus_18_2);
                btn.setText(R.string.many_18_2);
                break;
            case 3: tv_plus.setText(R.string.plus_18_3);
                btn.setText(R.string.many_18_3);
                break;
            case 4: tv_plus.setText(R.string.plus_18_4);
                btn.setText(R.string.many_18_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_18);
        btn=findViewById(R.id.bust_button_18);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_18_1);
                btn.setText(R.string.many_18_1);
                break;
            case 2: tv_plus.setText(R.string.plus_18_2);
                btn.setText(R.string.many_18_2);
                break;
            case 3: tv_plus.setText(R.string.plus_18_3);
                btn.setText(R.string.many_18_3);
                break;
            case 4: tv_plus.setText(R.string.plus_18_4);
                btn.setText(R.string.many_18_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //19
        tv_many = findViewById(R.id.bust_tv__many_19);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_19);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_19);
        btn=findViewById(R.id.afk_button_19);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_19_1);
                btn.setText(R.string.many_19_1);
                break;
            case 2: tv_plus.setText(R.string.plus_19_2);
                btn.setText(R.string.many_19_2);
                break;
            case 3: tv_plus.setText(R.string.plus_19_3);
                btn.setText(R.string.many_19_3);
                break;
            case 4: tv_plus.setText(R.string.plus_19_4);
                btn.setText(R.string.many_19_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_19);
        btn=findViewById(R.id.bust_button_19);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_19_1);
                btn.setText(R.string.many_19_1);
                break;
            case 2: tv_plus.setText(R.string.plus_19_2);
                btn.setText(R.string.many_19_2);
                break;
            case 3: tv_plus.setText(R.string.plus_19_3);
                btn.setText(R.string.many_19_3);
                break;
            case 4: tv_plus.setText(R.string.plus_19_4);
                btn.setText(R.string.many_19_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //20
        tv_many = findViewById(R.id.bust_tv__many_20);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_20);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_20);
        btn=findViewById(R.id.afk_button_20);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_20_1);
                btn.setText(R.string.many_20_1);
                break;
            case 2: tv_plus.setText(R.string.plus_20_2);
                btn.setText(R.string.many_20_2);
                break;
            case 3: tv_plus.setText(R.string.plus_20_3);
                btn.setText(R.string.many_20_3);
                break;
            case 4: tv_plus.setText(R.string.plus_20_4);
                btn.setText(R.string.many_20_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_20);
        btn=findViewById(R.id.bust_button_20);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_20_1);
                btn.setText(R.string.many_20_1);
                break;
            case 2: tv_plus.setText(R.string.plus_20_2);
                btn.setText(R.string.many_20_2);
                break;
            case 3: tv_plus.setText(R.string.plus_20_3);
                btn.setText(R.string.many_20_3);
                break;
            case 4: tv_plus.setText(R.string.plus_20_4);
                btn.setText(R.string.many_20_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //21
        tv_many = findViewById(R.id.bust_tv__many_21);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_21);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_21);
        btn=findViewById(R.id.afk_button_21);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_21_1);
                btn.setText(R.string.many_21_1);
                break;
            case 2: tv_plus.setText(R.string.plus_21_2);
                btn.setText(R.string.many_21_2);
                break;
            case 3: tv_plus.setText(R.string.plus_21_3);
                btn.setText(R.string.many_21_3);
                break;
            case 4: tv_plus.setText(R.string.plus_21_4);
                btn.setText(R.string.many_21_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_21);
        btn=findViewById(R.id.bust_button_21);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_21_1);
                btn.setText(R.string.many_21_1);
                break;
            case 2: tv_plus.setText(R.string.plus_21_2);
                btn.setText(R.string.many_21_2);
                break;
            case 3: tv_plus.setText(R.string.plus_21_3);
                btn.setText(R.string.many_21_3);
                break;
            case 4: tv_plus.setText(R.string.plus_21_4);
                btn.setText(R.string.many_21_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //22
        tv_many = findViewById(R.id.bust_tv__many_22);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_22);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_22);
        btn=findViewById(R.id.afk_button_22);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_22_1);
                btn.setText(R.string.many_22_1);
                break;
            case 2: tv_plus.setText(R.string.plus_22_2);
                btn.setText(R.string.many_22_2);
                break;
            case 3: tv_plus.setText(R.string.plus_22_3);
                btn.setText(R.string.many_22_3);
                break;
            case 4: tv_plus.setText(R.string.plus_22_4);
                btn.setText(R.string.many_22_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_22);
        btn=findViewById(R.id.bust_button_22);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_22_1);
                btn.setText(R.string.many_22_1);
                break;
            case 2: tv_plus.setText(R.string.plus_22_2);
                btn.setText(R.string.many_22_2);
                break;
            case 3: tv_plus.setText(R.string.plus_22_3);
                btn.setText(R.string.many_22_3);
                break;
            case 4: tv_plus.setText(R.string.plus_22_4);
                btn.setText(R.string.many_22_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //23
        tv_many = findViewById(R.id.bust_tv__many_23);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_23);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_23);
        btn=findViewById(R.id.afk_button_23);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_23_1);
                btn.setText(R.string.many_23_1);
                break;
            case 2: tv_plus.setText(R.string.plus_23_2);
                btn.setText(R.string.many_23_2);
                break;
            case 3: tv_plus.setText(R.string.plus_23_3);
                btn.setText(R.string.many_23_3);
                break;
            case 4: tv_plus.setText(R.string.plus_23_4);
                btn.setText(R.string.many_23_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_23);
        btn=findViewById(R.id.bust_button_23);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_23_1);
                btn.setText(R.string.many_23_1);
                break;
            case 2: tv_plus.setText(R.string.plus_23_2);
                btn.setText(R.string.many_23_2);
                break;
            case 3: tv_plus.setText(R.string.plus_23_3);
                btn.setText(R.string.many_23_3);
                break;
            case 4: tv_plus.setText(R.string.plus_23_4);
                btn.setText(R.string.many_23_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //24
        tv_many = findViewById(R.id.bust_tv__many_24);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_24);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_24);
        btn=findViewById(R.id.afk_button_24);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_24_1);
                btn.setText(R.string.many_24_1);
                break;
            case 2: tv_plus.setText(R.string.plus_24_2);
                btn.setText(R.string.many_24_2);
                break;
            case 3: tv_plus.setText(R.string.plus_24_3);
                btn.setText(R.string.many_24_3);
                break;
            case 4: tv_plus.setText(R.string.plus_24_4);
                btn.setText(R.string.many_24_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_24);
        btn=findViewById(R.id.bust_button_24);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_24_1);
                btn.setText(R.string.many_24_1);
                break;
            case 2: tv_plus.setText(R.string.plus_24_2);
                btn.setText(R.string.many_24_2);
                break;
            case 3: tv_plus.setText(R.string.plus_24_3);
                btn.setText(R.string.many_24_3);
                break;
            case 4: tv_plus.setText(R.string.plus_24_4);
                btn.setText(R.string.many_24_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //25
        tv_many = findViewById(R.id.bust_tv__many_25);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_25);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_25);
        btn=findViewById(R.id.afk_button_25);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_25_1);
                btn.setText(R.string.many_25_1);
                break;
            case 2: tv_plus.setText(R.string.plus_25_2);
                btn.setText(R.string.many_25_2);
                break;
            case 3: tv_plus.setText(R.string.plus_25_3);
                btn.setText(R.string.many_25_3);
                break;
            case 4: tv_plus.setText(R.string.plus_25_4);
                btn.setText(R.string.many_25_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_25);
        btn=findViewById(R.id.bust_button_25);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_25_1);
                btn.setText(R.string.many_25_1);
                break;
            case 2: tv_plus.setText(R.string.plus_25_2);
                btn.setText(R.string.many_25_2);
                break;
            case 3: tv_plus.setText(R.string.plus_25_3);
                btn.setText(R.string.many_25_3);
                break;
            case 4: tv_plus.setText(R.string.plus_25_4);
                btn.setText(R.string.many_25_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //26
        tv_many = findViewById(R.id.bust_tv__many_26);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_26);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_26);
        btn=findViewById(R.id.afk_button_26);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_26_1);
                btn.setText(R.string.many_26_1);
                break;
            case 2: tv_plus.setText(R.string.plus_26_2);
                btn.setText(R.string.many_26_2);
                break;
            case 3: tv_plus.setText(R.string.plus_26_3);
                btn.setText(R.string.many_26_3);
                break;
            case 4: tv_plus.setText(R.string.plus_26_4);
                btn.setText(R.string.many_26_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_26);
        btn=findViewById(R.id.bust_button_26);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_26_1);
                btn.setText(R.string.many_26_1);
                break;
            case 2: tv_plus.setText(R.string.plus_26_2);
                btn.setText(R.string.many_26_2);
                break;
            case 3: tv_plus.setText(R.string.plus_26_3);
                btn.setText(R.string.many_26_3);
                break;
            case 4: tv_plus.setText(R.string.plus_26_4);
                btn.setText(R.string.many_26_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //27
        tv_many = findViewById(R.id.bust_tv__many_27);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_27);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_27);
        btn=findViewById(R.id.afk_button_27);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_27_1);
                btn.setText(R.string.many_27_1);
                break;
            case 2: tv_plus.setText(R.string.plus_27_2);
                btn.setText(R.string.many_27_2);
                break;
            case 3: tv_plus.setText(R.string.plus_27_3);
                btn.setText(R.string.many_27_3);
                break;
            case 4: tv_plus.setText(R.string.plus_27_4);
                btn.setText(R.string.many_27_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_27);
        btn=findViewById(R.id.bust_button_27);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_27_1);
                btn.setText(R.string.many_27_1);
                break;
            case 2: tv_plus.setText(R.string.plus_27_2);
                btn.setText(R.string.many_27_2);
                break;
            case 3: tv_plus.setText(R.string.plus_27_3);
                btn.setText(R.string.many_27_3);
                break;
            case 4: tv_plus.setText(R.string.plus_27_4);
                btn.setText(R.string.many_27_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //28
        tv_many = findViewById(R.id.bust_tv__many_28);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_28);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_28);
        btn=findViewById(R.id.afk_button_28);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_28_1);
                btn.setText(R.string.many_28_1);
                break;
            case 2: tv_plus.setText(R.string.plus_28_2);
                btn.setText(R.string.many_28_2);
                break;
            case 3: tv_plus.setText(R.string.plus_28_3);
                btn.setText(R.string.many_28_3);
                break;
            case 4: tv_plus.setText(R.string.plus_28_4);
                btn.setText(R.string.many_28_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_28);
        btn=findViewById(R.id.bust_button_28);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_28_1);
                btn.setText(R.string.many_28_1);
                break;
            case 2: tv_plus.setText(R.string.plus_28_2);
                btn.setText(R.string.many_28_2);
                break;
            case 3: tv_plus.setText(R.string.plus_28_3);
                btn.setText(R.string.many_28_3);
                break;
            case 4: tv_plus.setText(R.string.plus_28_4);
                btn.setText(R.string.many_28_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //29
        tv_many = findViewById(R.id.bust_tv__many_29);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_29);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_29);
        btn=findViewById(R.id.afk_button_29);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_29_1);
                btn.setText(R.string.many_29_1);
                break;
            case 2: tv_plus.setText(R.string.plus_29_2);
                btn.setText(R.string.many_29_2);
                break;
            case 3: tv_plus.setText(R.string.plus_29_3);
                btn.setText(R.string.many_29_3);
                break;
            case 4: tv_plus.setText(R.string.plus_29_4);
                btn.setText(R.string.many_29_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_29);
        btn=findViewById(R.id.bust_button_29);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_29_1);
                btn.setText(R.string.many_29_1);
                break;
            case 2: tv_plus.setText(R.string.plus_29_2);
                btn.setText(R.string.many_29_2);
                break;
            case 3: tv_plus.setText(R.string.plus_29_3);
                btn.setText(R.string.many_29_3);
                break;
            case 4: tv_plus.setText(R.string.plus_29_4);
                btn.setText(R.string.many_29_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //30
        tv_many = findViewById(R.id.bust_tv__many_30);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_30);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_30);
        btn=findViewById(R.id.afk_button_30);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_30_1);
                btn.setText(R.string.many_30_1);
                break;
            case 2: tv_plus.setText(R.string.plus_30_2);
                btn.setText(R.string.many_30_2);
                break;
            case 3: tv_plus.setText(R.string.plus_30_3);
                btn.setText(R.string.many_30_3);
                break;
            case 4: tv_plus.setText(R.string.plus_30_4);
                btn.setText(R.string.many_30_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_30);
        btn=findViewById(R.id.bust_button_30);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_30_1);
                btn.setText(R.string.many_30_1);
                break;
            case 2: tv_plus.setText(R.string.plus_30_2);
                btn.setText(R.string.many_30_2);
                break;
            case 3: tv_plus.setText(R.string.plus_30_3);
                btn.setText(R.string.many_30_3);
                break;
            case 4: tv_plus.setText(R.string.plus_30_4);
                btn.setText(R.string.many_30_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //31
        tv_many = findViewById(R.id.bust_tv__many_31);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_31);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_31);
        btn=findViewById(R.id.afk_button_31);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_31_1);
                btn.setText(R.string.many_31_1);
                break;
            case 2: tv_plus.setText(R.string.plus_31_2);
                btn.setText(R.string.many_31_2);
                break;
            case 3: tv_plus.setText(R.string.plus_31_3);
                btn.setText(R.string.many_31_3);
                break;
            case 4: tv_plus.setText(R.string.plus_31_4);
                btn.setText(R.string.many_31_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_31);
        btn=findViewById(R.id.bust_button_31);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_31_1);
                btn.setText(R.string.many_31_1);
                break;
            case 2: tv_plus.setText(R.string.plus_31_2);
                btn.setText(R.string.many_31_2);
                break;
            case 3: tv_plus.setText(R.string.plus_31_3);
                btn.setText(R.string.many_31_3);
                break;
            case 4: tv_plus.setText(R.string.plus_31_4);
                btn.setText(R.string.many_31_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //32
        tv_many = findViewById(R.id.bust_tv__many_32);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_32);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_32);
        btn=findViewById(R.id.afk_button_32);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_32_1);
                btn.setText(R.string.many_32_1);
                break;
            case 2: tv_plus.setText(R.string.plus_32_2);
                btn.setText(R.string.many_32_2);
                break;
            case 3: tv_plus.setText(R.string.plus_32_3);
                btn.setText(R.string.many_32_3);
                break;
            case 4: tv_plus.setText(R.string.plus_32_4);
                btn.setText(R.string.many_32_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_32);
        btn=findViewById(R.id.bust_button_32);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_32_1);
                btn.setText(R.string.many_32_1);
                break;
            case 2: tv_plus.setText(R.string.plus_32_2);
                btn.setText(R.string.many_32_2);
                break;
            case 3: tv_plus.setText(R.string.plus_32_3);
                btn.setText(R.string.many_32_3);
                break;
            case 4: tv_plus.setText(R.string.plus_32_4);
                btn.setText(R.string.many_32_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //33
        tv_many = findViewById(R.id.bust_tv__many_33);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_33);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_33);
        btn=findViewById(R.id.afk_button_33);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_33_1);
                btn.setText(R.string.many_33_1);
                break;
            case 2: tv_plus.setText(R.string.plus_33_2);
                btn.setText(R.string.many_33_2);
                break;
            case 3: tv_plus.setText(R.string.plus_33_3);
                btn.setText(R.string.many_33_3);
                break;
            case 4: tv_plus.setText(R.string.plus_33_4);
                btn.setText(R.string.many_33_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_33);
        btn=findViewById(R.id.bust_button_33);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_33_1);
                btn.setText(R.string.many_33_1);
                break;
            case 2: tv_plus.setText(R.string.plus_33_2);
                btn.setText(R.string.many_33_2);
                break;
            case 3: tv_plus.setText(R.string.plus_33_3);
                btn.setText(R.string.many_33_3);
                break;
            case 4: tv_plus.setText(R.string.plus_33_4);
                btn.setText(R.string.many_33_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //34
        tv_many = findViewById(R.id.bust_tv__many_34);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_34);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_34);
        btn=findViewById(R.id.afk_button_34);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_34_1);
                btn.setText(R.string.many_34_1);
                break;
            case 2: tv_plus.setText(R.string.plus_34_2);
                btn.setText(R.string.many_34_2);
                break;
            case 3: tv_plus.setText(R.string.plus_34_3);
                btn.setText(R.string.many_34_3);
                break;
            case 4: tv_plus.setText(R.string.plus_34_4);
                btn.setText(R.string.many_34_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_34);
        btn=findViewById(R.id.bust_button_34);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_34_1);
                btn.setText(R.string.many_34_1);
                break;
            case 2: tv_plus.setText(R.string.plus_34_2);
                btn.setText(R.string.many_34_2);
                break;
            case 3: tv_plus.setText(R.string.plus_34_3);
                btn.setText(R.string.many_34_3);
                break;
            case 4: tv_plus.setText(R.string.plus_34_4);
                btn.setText(R.string.many_34_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //35
        tv_many = findViewById(R.id.bust_tv__many_35);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_35);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_35);
        btn=findViewById(R.id.afk_button_35);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_35_1);
                btn.setText(R.string.many_35_1);
                break;
            case 2: tv_plus.setText(R.string.plus_35_2);
                btn.setText(R.string.many_35_2);
                break;
            case 3: tv_plus.setText(R.string.plus_35_3);
                btn.setText(R.string.many_35_3);
                break;
            case 4: tv_plus.setText(R.string.plus_35_4);
                btn.setText(R.string.many_35_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_35);
        btn=findViewById(R.id.bust_button_35);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_35_1);
                btn.setText(R.string.many_35_1);
                break;
            case 2: tv_plus.setText(R.string.plus_35_2);
                btn.setText(R.string.many_35_2);
                break;
            case 3: tv_plus.setText(R.string.plus_35_3);
                btn.setText(R.string.many_35_3);
                break;
            case 4: tv_plus.setText(R.string.plus_35_4);
                btn.setText(R.string.many_35_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //36
        tv_many = findViewById(R.id.bust_tv__many_36);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_36);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_36);
        btn=findViewById(R.id.afk_button_36);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_36_1);
                btn.setText(R.string.many_36_1);
                break;
            case 2: tv_plus.setText(R.string.plus_36_2);
                btn.setText(R.string.many_36_2);
                break;
            case 3: tv_plus.setText(R.string.plus_36_3);
                btn.setText(R.string.many_36_3);
                break;
            case 4: tv_plus.setText(R.string.plus_36_4);
                btn.setText(R.string.many_36_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_36);
        btn=findViewById(R.id.bust_button_36);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_36_1);
                btn.setText(R.string.many_36_1);
                break;
            case 2: tv_plus.setText(R.string.plus_36_2);
                btn.setText(R.string.many_36_2);
                break;
            case 3: tv_plus.setText(R.string.plus_36_3);
                btn.setText(R.string.many_36_3);
                break;
            case 4: tv_plus.setText(R.string.plus_36_4);
                btn.setText(R.string.many_36_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //37
        tv_many = findViewById(R.id.bust_tv__many_37);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_37);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_37);
        btn=findViewById(R.id.afk_button_37);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_37_1);
                btn.setText(R.string.many_37_1);
                break;
            case 2: tv_plus.setText(R.string.plus_37_2);
                btn.setText(R.string.many_37_2);
                break;
            case 3: tv_plus.setText(R.string.plus_37_3);
                btn.setText(R.string.many_37_3);
                break;
            case 4: tv_plus.setText(R.string.plus_37_4);
                btn.setText(R.string.many_37_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_37);
        btn=findViewById(R.id.bust_button_37);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_37_1);
                btn.setText(R.string.many_37_1);
                break;
            case 2: tv_plus.setText(R.string.plus_37_2);
                btn.setText(R.string.many_37_2);
                break;
            case 3: tv_plus.setText(R.string.plus_37_3);
                btn.setText(R.string.many_37_3);
                break;
            case 4: tv_plus.setText(R.string.plus_37_4);
                btn.setText(R.string.many_37_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //38
        tv_many = findViewById(R.id.bust_tv__many_38);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_38);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_38);
        btn=findViewById(R.id.afk_button_38);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_38_1);
                btn.setText(R.string.many_38_1);
                break;
            case 2: tv_plus.setText(R.string.plus_38_2);
                btn.setText(R.string.many_38_2);
                break;
            case 3: tv_plus.setText(R.string.plus_38_3);
                btn.setText(R.string.many_38_3);
                break;
            case 4: tv_plus.setText(R.string.plus_38_4);
                btn.setText(R.string.many_38_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_38);
        btn=findViewById(R.id.bust_button_38);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_38_1);
                btn.setText(R.string.many_38_1);
                break;
            case 2: tv_plus.setText(R.string.plus_38_2);
                btn.setText(R.string.many_38_2);
                break;
            case 3: tv_plus.setText(R.string.plus_38_3);
                btn.setText(R.string.many_38_3);
                break;
            case 4: tv_plus.setText(R.string.plus_38_4);
                btn.setText(R.string.many_38_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        goo++;



        //39
        tv_many = findViewById(R.id.bust_tv__many_39);
        tv_many.setText(bust_many[goo] +"/5");
        tv_many = findViewById(R.id.afk_tv__many_39);
        tv_many.setText(afk_many[goo] +"/5");
        tv_plus=findViewById(R.id.afk_tv_39);
        btn=findViewById(R.id.afk_button_39);
        switch (afk_many[goo]){
            case 1: tv_plus.setText(R.string.plus_39_1);
                btn.setText(R.string.many_39_1);
                break;
            case 2: tv_plus.setText(R.string.plus_39_2);
                btn.setText(R.string.many_39_2);
                break;
            case 3: tv_plus.setText(R.string.plus_39_3);
                btn.setText(R.string.many_39_3);
                break;
            case 4: tv_plus.setText(R.string.plus_39_4);
                btn.setText(R.string.many_39_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }
        tv_plus=findViewById(R.id.bust_tv_39);
        btn=findViewById(R.id.bust_button_39);
        switch (bust_many[goo]){
            case 1: tv_plus.setText(R.string.plus_39_1);
                btn.setText(R.string.many_39_1);
                break;
            case 2: tv_plus.setText(R.string.plus_39_2);
                btn.setText(R.string.many_39_2);
                break;
            case 3: tv_plus.setText(R.string.plus_39_3);
                btn.setText(R.string.many_39_3);
                break;
            case 4: tv_plus.setText(R.string.plus_39_4);
                btn.setText(R.string.many_39_4);
                break;
            case 5: tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);
                break;
            default:break;
        }








    }


    //жизненный цикл активити
    protected void onDestroy() {
        super.onDestroy();
        saveAll();
        Log.d(LOG_TAG, "onDestroy");

    }
    protected void onPause() {
        super.onPause();
        saveAll();
        save_afk_pause=afk;
        afk=new BigInteger("0");
        Log.d(LOG_TAG, "onPause");

    }
    protected void onRestart() {
        super.onRestart();
        afk=save_afk_pause;
        Log.d(LOG_TAG, "onRestart");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");

    }
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");

    }
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");

    }


    //таймер афк и таймер сохранения
    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {

                score=score.add(afk);
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                handler.postDelayed(this, 1000);
            }
        });
    }
    private void runTimer_save() {
        handler1.post(new Runnable() {
            @Override
            public void run() {
               saveAll();
                handler1.postDelayed(this, 1000);
            }
        });
    }


    //клик
    public void click(View view) {
        score=score.add(bust);
        tv_score = findViewById(R.id.score);
        tv_score.setText(chenge(score));

    }

    //сейв и загрузка основного(большинство загрузки в креате, а сейва в функциях ниже)
    void saveAll(){
        SharedPreferences save_score = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = save_score.edit();
        ed.putString("SAVED_score", score.toString());
        ed.apply();

        SharedPreferences save_bust = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor bbust = save_bust.edit();
        bbust.putString("SAVED_bust", bust.toString());
        bbust.apply();

        SharedPreferences save_afk = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor aafk = save_afk.edit();
        aafk.putString("SAVED_afk", afk.toString());
        aafk.apply();


        SharedPreferences save_afk_p = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor aafk_p = save_afk_p.edit();
        aafk_p.putString("SAVED_afk_p", save_afk_pause.toString());
        aafk_p.apply();
    }
    void loadAll(){
        SharedPreferences save_score = getPreferences(MODE_PRIVATE);
        SharedPreferences save_afk = getPreferences(MODE_PRIVATE);
        SharedPreferences save_bust = getPreferences(MODE_PRIVATE);
        SharedPreferences save_afk_p = getPreferences(MODE_PRIVATE);
        score=new BigInteger("0");
        bust=new BigInteger("0");
        afk=new BigInteger("0");
        save_afk_pause=new BigInteger("0");
        score =score.add(new BigInteger( save_score.getString("SAVED_score","0")));
        bust =bust.add(new BigInteger( save_bust.getString("SAVED_bust","1")));
        afk =afk.add(new BigInteger( save_afk.getString("SAVED_afk","0")));
        save_afk_pause =save_afk_pause.add(new BigInteger( save_afk_p.getString("SAVED_afk_p","0")));
    }


    @SuppressLint("SetTextI18n")
    public void bust_button_0(View view) {
        btn=findViewById(R.id.bust_button_0);
        tv_plus=findViewById(R.id.bust_tv_0);
        switch (bust_many[0]){


            case 0: if(score.compareTo(new BigInteger("50")) >= 0) {
            bust=bust.add(new BigInteger("1"));
            score=score.subtract(new BigInteger("50"));
            tv_bust = findViewById(R.id.bust_tv);
            tv_bust.setText(chenge(bust));
            tv_score = findViewById(R.id.score);
            tv_score.setText(chenge(score));
            bust_many[0]+=1;
            tv_many = findViewById(R.id.bust_tv__many_0);
            tv_many.setText(bust_many[0] +"/5");

            tv_plus.setText(R.string.plus_0_1);
            btn.setText(R.string.many_0_1);





            SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor b_0 = save_bust_button_0.edit();
            b_0.putInt("0",bust_many[0]);
            b_0.apply();

        }
                break;
            case 1: if(score.compareTo(new BigInteger("150")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("150"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[0]+=1;
                tv_many = findViewById(R.id.bust_tv__many_0);
                tv_many.setText(bust_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_2);
                btn.setText(R.string.many_0_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("0",bust_many[0]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("450")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("450"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[0]+=1;
                tv_many = findViewById(R.id.bust_tv__many_0);
                tv_many.setText(bust_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_3);
                btn.setText(R.string.many_0_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("0",bust_many[0]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("1350")) >= 0) {
                bust=bust.add(new BigInteger("6"));
                score=score.subtract(new BigInteger("1350"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[0]+=1;
                tv_many = findViewById(R.id.bust_tv__many_0);
                tv_many.setText(bust_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_4);
                btn.setText(R.string.many_0_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("0",bust_many[0]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("4050")) >= 0) {
                bust=bust.add(new BigInteger("9"));
                score=score.subtract(new BigInteger("4050"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[0]+=1;
                tv_many = findViewById(R.id.bust_tv__many_0);
                tv_many.setText(bust_many[0] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("0",bust_many[0]);
                b_0.apply();

            }
                break;
            default:break;
    }}
    @SuppressLint("SetTextI18n")
    public void bust_button_1(View view) {
        btn=findViewById(R.id.bust_button_1);
        tv_plus=findViewById(R.id.bust_tv_1);
        switch (bust_many[1]){


            case 0: if(score.compareTo(new BigInteger("300")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("300"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[1]+=1;
                tv_many = findViewById(R.id.bust_tv__many_1);
                tv_many.setText(bust_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_1);
                btn.setText(R.string.many_1_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("1",bust_many[1]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("900")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("900"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[1]+=1;
                tv_many = findViewById(R.id.bust_tv__many_1);
                tv_many.setText(bust_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_2);
                btn.setText(R.string.many_1_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("1",bust_many[1]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("2700")) >= 0) {
                bust=bust.add(new BigInteger("8"));
                score=score.subtract(new BigInteger("2700"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[1]+=1;
                tv_many = findViewById(R.id.bust_tv__many_1);
                tv_many.setText(bust_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_3);
                btn.setText(R.string.many_1_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("1",bust_many[1]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("8100")) >= 0) {
                bust=bust.add(new BigInteger("16"));
                score=score.subtract(new BigInteger("8100"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[1]+=1;
                tv_many = findViewById(R.id.bust_tv__many_1);
                tv_many.setText(bust_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_4);
                btn.setText(R.string.many_1_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("1",bust_many[1]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("20300")) >= 0) {
                bust=bust.add(new BigInteger("28"));
                score=score.subtract(new BigInteger("20300"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[1]+=1;
                tv_many = findViewById(R.id.bust_tv__many_1);
                tv_many.setText(bust_many[1] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("1",bust_many[1]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_2(View view) {
        btn=findViewById(R.id.bust_button_2);
        tv_plus=findViewById(R.id.bust_tv_2);
        switch (bust_many[2]){


            case 0: if(score.compareTo(new BigInteger("1800")) >= 0) {
                bust=bust.add(new BigInteger("8"));
                score=score.subtract(new BigInteger("1800"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[2]+=1;
                tv_many = findViewById(R.id.bust_tv__many_2);
                tv_many.setText(bust_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_1);
                btn.setText(R.string.many_2_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("2",bust_many[2]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("5400")) >= 0) {
                bust=bust.add(new BigInteger("16"));
                score=score.subtract(new BigInteger("5400"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[2]+=1;
                tv_many = findViewById(R.id.bust_tv__many_2);
                tv_many.setText(bust_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_2);
                btn.setText(R.string.many_2_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("2",bust_many[2]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("16200")) >= 0) {
                bust=bust.add(new BigInteger("24"));
                score=score.subtract(new BigInteger("16200"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[2]+=1;
                tv_many = findViewById(R.id.bust_tv__many_2);
                tv_many.setText(bust_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_3);
                btn.setText(R.string.many_2_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("2",bust_many[2]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("28100")) >= 0) {
                bust=bust.add(new BigInteger("40"));
                score=score.subtract(new BigInteger("28100"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[2]+=1;
                tv_many = findViewById(R.id.bust_tv__many_2);
                tv_many.setText(bust_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_4);
                btn.setText(R.string.many_2_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("2",bust_many[2]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("45000")) >= 0) {
                bust=bust.add(new BigInteger("70"));
                score=score.subtract(new BigInteger("45000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[2]+=1;
                tv_many = findViewById(R.id.bust_tv__many_2);
                tv_many.setText(bust_many[2] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("2",bust_many[2]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_3(View view) {
        btn=findViewById(R.id.bust_button_3);
        tv_plus=findViewById(R.id.bust_tv_3);
        switch (bust_many[3]){


            case 0: if(score.compareTo(new BigInteger("15000")) >= 0) {
                bust=bust.add(new BigInteger("24"));
                score=score.subtract(new BigInteger("15000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[3]+=1;
                tv_many = findViewById(R.id.bust_tv__many_3);
                tv_many.setText(bust_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_1);
                btn.setText(R.string.many_3_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("3",bust_many[3]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("40000")) >= 0) {
                bust=bust.add(new BigInteger("60"));
                score=score.subtract(new BigInteger("40000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[3]+=1;
                tv_many = findViewById(R.id.bust_tv__many_3);
                tv_many.setText(bust_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_2);
                btn.setText(R.string.many_3_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("3",bust_many[3]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("100000")) >= 0) {
                bust=bust.add(new BigInteger("150"));
                score=score.subtract(new BigInteger("100000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[3]+=1;
                tv_many = findViewById(R.id.bust_tv__many_3);
                tv_many.setText(bust_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_3);
                btn.setText(R.string.many_3_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("3",bust_many[3]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("150000")) >= 0) {
                bust=bust.add(new BigInteger("200"));
                score=score.subtract(new BigInteger("150000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[3]+=1;
                tv_many = findViewById(R.id.bust_tv__many_3);
                tv_many.setText(bust_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_4);
                btn.setText(R.string.many_3_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("3",bust_many[3]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("300000")) >= 0) {
                bust=bust.add(new BigInteger("500"));
                score=score.subtract(new BigInteger("300000"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[3]+=1;
                tv_many = findViewById(R.id.bust_tv__many_3);
                tv_many.setText(bust_many[3] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("3",bust_many[3]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_4(View view) {
        btn=findViewById(R.id.bust_button_4);
        tv_plus=findViewById(R.id.bust_tv_4);
        switch (bust_many[4]){


            case 0: if(score.compareTo(new BigInteger("850")) >= 0) {
                bust=bust.add(new BigInteger("15"));
                score=score.subtract(new BigInteger("850"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[4]+=1;
                tv_many = findViewById(R.id.bust_tv__many_4);
                tv_many.setText(bust_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_1);
                btn.setText(R.string.many_4_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("4",bust_many[4]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("1200")) >= 0) {
                bust=bust.add(new BigInteger("15"));
                score=score.subtract(new BigInteger("1200"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[4]+=1;
                tv_many = findViewById(R.id.bust_tv__many_4);
                tv_many.setText(bust_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_2);
                btn.setText(R.string.many_4_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("4",bust_many[4]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("1650")) >= 0) {
                bust=bust.add(new BigInteger("15"));
                score=score.subtract(new BigInteger("1650"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[4]+=1;
                tv_many = findViewById(R.id.bust_tv__many_4);
                tv_many.setText(bust_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_3);
                btn.setText(R.string.many_4_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("4",bust_many[4]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("2035")) >= 0) {
                bust=bust.add(new BigInteger("15"));
                score=score.subtract(new BigInteger("2035"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[4]+=1;
                tv_many = findViewById(R.id.bust_tv__many_4);
                tv_many.setText(bust_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_4);
                btn.setText(R.string.many_4_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("4",bust_many[4]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("2460")) >= 0) {
                bust=bust.add(new BigInteger("15"));
                score=score.subtract(new BigInteger("2460"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[4]+=1;
                tv_many = findViewById(R.id.bust_tv__many_4);
                tv_many.setText(bust_many[4] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("4",bust_many[4]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_5(View view) {
        btn=findViewById(R.id.bust_button_5);
        tv_plus=findViewById(R.id.bust_tv_5);
        switch (bust_many[5]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[5]+=1;
                tv_many = findViewById(R.id.bust_tv__many_5);
                tv_many.setText(bust_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_1);
                btn.setText(R.string.many_5_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("5",bust_many[5]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[5]+=1;
                tv_many = findViewById(R.id.bust_tv__many_5);
                tv_many.setText(bust_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_2);
                btn.setText(R.string.many_5_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("5",bust_many[5]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[5]+=1;
                tv_many = findViewById(R.id.bust_tv__many_5);
                tv_many.setText(bust_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_3);
                btn.setText(R.string.many_5_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("5",bust_many[5]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[5]+=1;
                tv_many = findViewById(R.id.bust_tv__many_5);
                tv_many.setText(bust_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_4);
                btn.setText(R.string.many_5_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("5",bust_many[5]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[5]+=1;
                tv_many = findViewById(R.id.bust_tv__many_5);
                tv_many.setText(bust_many[5] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("5",bust_many[5]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_6(View view) {
        btn=findViewById(R.id.bust_button_6);
        tv_plus=findViewById(R.id.bust_tv_6);
        switch (bust_many[6]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[6]+=1;
                tv_many = findViewById(R.id.bust_tv__many_6);
                tv_many.setText(bust_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_1);
                btn.setText(R.string.many_6_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("6",bust_many[6]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[6]+=1;
                tv_many = findViewById(R.id.bust_tv__many_6);
                tv_many.setText(bust_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_2);
                btn.setText(R.string.many_6_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("6",bust_many[6]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[6]+=1;
                tv_many = findViewById(R.id.bust_tv__many_6);
                tv_many.setText(bust_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_3);
                btn.setText(R.string.many_6_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("6",bust_many[6]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[6]+=1;
                tv_many = findViewById(R.id.bust_tv__many_6);
                tv_many.setText(bust_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_4);
                btn.setText(R.string.many_6_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("6",bust_many[6]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[6]+=1;
                tv_many = findViewById(R.id.bust_tv__many_6);
                tv_many.setText(bust_many[6] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("6",bust_many[6]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_7(View view) {
        btn=findViewById(R.id.bust_button_7);
        tv_plus=findViewById(R.id.bust_tv_7);
        switch (bust_many[7]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[7]+=1;
                tv_many = findViewById(R.id.bust_tv__many_7);
                tv_many.setText(bust_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_1);
                btn.setText(R.string.many_7_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("7",bust_many[7]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[7]+=1;
                tv_many = findViewById(R.id.bust_tv__many_7);
                tv_many.setText(bust_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_2);
                btn.setText(R.string.many_7_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("7",bust_many[7]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[7]+=1;
                tv_many = findViewById(R.id.bust_tv__many_7);
                tv_many.setText(bust_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_3);
                btn.setText(R.string.many_7_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("7",bust_many[7]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[7]+=1;
                tv_many = findViewById(R.id.bust_tv__many_7);
                tv_many.setText(bust_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_4);
                btn.setText(R.string.many_7_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("7",bust_many[7]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[7]+=1;
                tv_many = findViewById(R.id.bust_tv__many_7);
                tv_many.setText(bust_many[7] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("7",bust_many[7]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_8(View view) {
        btn=findViewById(R.id.bust_button_8);
        tv_plus=findViewById(R.id.bust_tv_8);
        switch (bust_many[8]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[8]+=1;
                tv_many = findViewById(R.id.bust_tv__many_8);
                tv_many.setText(bust_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_1);
                btn.setText(R.string.many_8_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("8",bust_many[8]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[8]+=1;
                tv_many = findViewById(R.id.bust_tv__many_8);
                tv_many.setText(bust_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_2);
                btn.setText(R.string.many_8_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("8",bust_many[8]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[8]+=1;
                tv_many = findViewById(R.id.bust_tv__many_8);
                tv_many.setText(bust_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_3);
                btn.setText(R.string.many_8_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("8",bust_many[8]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[8]+=1;
                tv_many = findViewById(R.id.bust_tv__many_8);
                tv_many.setText(bust_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_4);
                btn.setText(R.string.many_8_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("8",bust_many[8]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[8]+=1;
                tv_many = findViewById(R.id.bust_tv__many_8);
                tv_many.setText(bust_many[8] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("8",bust_many[8]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_9(View view) {
        btn=findViewById(R.id.bust_button_9);
        tv_plus=findViewById(R.id.bust_tv_9);
        switch (bust_many[9]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[9]+=1;
                tv_many = findViewById(R.id.bust_tv__many_9);
                tv_many.setText(bust_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_1);
                btn.setText(R.string.many_9_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("9",bust_many[9]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[9]+=1;
                tv_many = findViewById(R.id.bust_tv__many_9);
                tv_many.setText(bust_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_2);
                btn.setText(R.string.many_9_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("9",bust_many[9]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[9]+=1;
                tv_many = findViewById(R.id.bust_tv__many_9);
                tv_many.setText(bust_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_3);
                btn.setText(R.string.many_9_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("9",bust_many[9]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[9]+=1;
                tv_many = findViewById(R.id.bust_tv__many_9);
                tv_many.setText(bust_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_4);
                btn.setText(R.string.many_9_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("9",bust_many[9]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[9]+=1;
                tv_many = findViewById(R.id.bust_tv__many_9);
                tv_many.setText(bust_many[9] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("9",bust_many[9]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_10(View view) {
        btn=findViewById(R.id.bust_button_10);
        tv_plus=findViewById(R.id.bust_tv_10);
        switch (bust_many[10]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[10]+=1;
                tv_many = findViewById(R.id.bust_tv__many_10);
                tv_many.setText(bust_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_1);
                btn.setText(R.string.many_10_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("10",bust_many[10]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[10]+=1;
                tv_many = findViewById(R.id.bust_tv__many_10);
                tv_many.setText(bust_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_2);
                btn.setText(R.string.many_10_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("10",bust_many[10]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[10]+=1;
                tv_many = findViewById(R.id.bust_tv__many_10);
                tv_many.setText(bust_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_3);
                btn.setText(R.string.many_10_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("10",bust_many[10]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[10]+=1;
                tv_many = findViewById(R.id.bust_tv__many_10);
                tv_many.setText(bust_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_4);
                btn.setText(R.string.many_10_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("10",bust_many[10]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[10]+=1;
                tv_many = findViewById(R.id.bust_tv__many_10);
                tv_many.setText(bust_many[10] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("10",bust_many[10]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_11(View view) {
        btn=findViewById(R.id.bust_button_11);
        tv_plus=findViewById(R.id.bust_tv_11);
        switch (bust_many[11]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[11]+=1;
                tv_many = findViewById(R.id.bust_tv__many_11);
                tv_many.setText(bust_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_1);
                btn.setText(R.string.many_11_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("11",bust_many[11]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[11]+=1;
                tv_many = findViewById(R.id.bust_tv__many_11);
                tv_many.setText(bust_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_2);
                btn.setText(R.string.many_11_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("11",bust_many[11]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[11]+=1;
                tv_many = findViewById(R.id.bust_tv__many_11);
                tv_many.setText(bust_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_3);
                btn.setText(R.string.many_11_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("11",bust_many[11]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[11]+=1;
                tv_many = findViewById(R.id.bust_tv__many_11);
                tv_many.setText(bust_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_4);
                btn.setText(R.string.many_11_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("11",bust_many[11]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[11]+=1;
                tv_many = findViewById(R.id.bust_tv__many_11);
                tv_many.setText(bust_many[11] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("11",bust_many[11]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_12(View view) {
        btn=findViewById(R.id.bust_button_12);
        tv_plus=findViewById(R.id.bust_tv_12);
        switch (bust_many[12]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[12]+=1;
                tv_many = findViewById(R.id.bust_tv__many_12);
                tv_many.setText(bust_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_1);
                btn.setText(R.string.many_12_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("12",bust_many[12]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[12]+=1;
                tv_many = findViewById(R.id.bust_tv__many_12);
                tv_many.setText(bust_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_2);
                btn.setText(R.string.many_12_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("12",bust_many[12]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[12]+=1;
                tv_many = findViewById(R.id.bust_tv__many_12);
                tv_many.setText(bust_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_3);
                btn.setText(R.string.many_12_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("12",bust_many[12]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[12]+=1;
                tv_many = findViewById(R.id.bust_tv__many_12);
                tv_many.setText(bust_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_4);
                btn.setText(R.string.many_12_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("12",bust_many[12]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[12]+=1;
                tv_many = findViewById(R.id.bust_tv__many_12);
                tv_many.setText(bust_many[12] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("12",bust_many[12]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_13(View view) {
        btn=findViewById(R.id.bust_button_13);
        tv_plus=findViewById(R.id.bust_tv_13);
        switch (bust_many[13]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[13]+=1;
                tv_many = findViewById(R.id.bust_tv__many_13);
                tv_many.setText(bust_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_1);
                btn.setText(R.string.many_13_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("13",bust_many[13]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[13]+=1;
                tv_many = findViewById(R.id.bust_tv__many_13);
                tv_many.setText(bust_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_2);
                btn.setText(R.string.many_13_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("13",bust_many[13]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[13]+=1;
                tv_many = findViewById(R.id.bust_tv__many_13);
                tv_many.setText(bust_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_3);
                btn.setText(R.string.many_13_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("13",bust_many[13]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[13]+=1;
                tv_many = findViewById(R.id.bust_tv__many_13);
                tv_many.setText(bust_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_4);
                btn.setText(R.string.many_13_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("13",bust_many[13]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[13]+=1;
                tv_many = findViewById(R.id.bust_tv__many_13);
                tv_many.setText(bust_many[13] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("13",bust_many[13]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_14(View view) {
        btn=findViewById(R.id.bust_button_14);
        tv_plus=findViewById(R.id.bust_tv_14);
        switch (bust_many[14]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[14]+=1;
                tv_many = findViewById(R.id.bust_tv__many_14);
                tv_many.setText(bust_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_1);
                btn.setText(R.string.many_14_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("14",bust_many[14]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[14]+=1;
                tv_many = findViewById(R.id.bust_tv__many_14);
                tv_many.setText(bust_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_2);
                btn.setText(R.string.many_14_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("14",bust_many[14]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[14]+=1;
                tv_many = findViewById(R.id.bust_tv__many_14);
                tv_many.setText(bust_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_3);
                btn.setText(R.string.many_14_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("14",bust_many[14]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[14]+=1;
                tv_many = findViewById(R.id.bust_tv__many_14);
                tv_many.setText(bust_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_4);
                btn.setText(R.string.many_14_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("14",bust_many[14]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[14]+=1;
                tv_many = findViewById(R.id.bust_tv__many_14);
                tv_many.setText(bust_many[14] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("14",bust_many[14]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_15(View view) {
        btn=findViewById(R.id.bust_button_15);
        tv_plus=findViewById(R.id.bust_tv_15);
        switch (bust_many[15]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[15]+=1;
                tv_many = findViewById(R.id.bust_tv__many_15);
                tv_many.setText(bust_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_1);
                btn.setText(R.string.many_15_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("15",bust_many[15]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[15]+=1;
                tv_many = findViewById(R.id.bust_tv__many_15);
                tv_many.setText(bust_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_2);
                btn.setText(R.string.many_15_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("15",bust_many[15]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[15]+=1;
                tv_many = findViewById(R.id.bust_tv__many_15);
                tv_many.setText(bust_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_3);
                btn.setText(R.string.many_15_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("15",bust_many[15]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[15]+=1;
                tv_many = findViewById(R.id.bust_tv__many_15);
                tv_many.setText(bust_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_4);
                btn.setText(R.string.many_15_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("15",bust_many[15]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[15]+=1;
                tv_many = findViewById(R.id.bust_tv__many_15);
                tv_many.setText(bust_many[15] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("15",bust_many[15]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_16(View view) {
        btn=findViewById(R.id.bust_button_16);
        tv_plus=findViewById(R.id.bust_tv_16);
        switch (bust_many[16]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[16]+=1;
                tv_many = findViewById(R.id.bust_tv__many_16);
                tv_many.setText(bust_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_1);
                btn.setText(R.string.many_16_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("16",bust_many[16]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[16]+=1;
                tv_many = findViewById(R.id.bust_tv__many_16);
                tv_many.setText(bust_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_2);
                btn.setText(R.string.many_16_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("16",bust_many[16]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[16]+=1;
                tv_many = findViewById(R.id.bust_tv__many_16);
                tv_many.setText(bust_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_3);
                btn.setText(R.string.many_16_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("16",bust_many[16]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[16]+=1;
                tv_many = findViewById(R.id.bust_tv__many_16);
                tv_many.setText(bust_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_4);
                btn.setText(R.string.many_16_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("16",bust_many[16]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[16]+=1;
                tv_many = findViewById(R.id.bust_tv__many_16);
                tv_many.setText(bust_many[16] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("16",bust_many[16]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_17(View view) {
        btn=findViewById(R.id.bust_button_17);
        tv_plus=findViewById(R.id.bust_tv_17);
        switch (bust_many[17]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[17]+=1;
                tv_many = findViewById(R.id.bust_tv__many_17);
                tv_many.setText(bust_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_1);
                btn.setText(R.string.many_17_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("17",bust_many[17]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[17]+=1;
                tv_many = findViewById(R.id.bust_tv__many_17);
                tv_many.setText(bust_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_2);
                btn.setText(R.string.many_17_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("17",bust_many[17]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[17]+=1;
                tv_many = findViewById(R.id.bust_tv__many_17);
                tv_many.setText(bust_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_3);
                btn.setText(R.string.many_17_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("17",bust_many[17]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[17]+=1;
                tv_many = findViewById(R.id.bust_tv__many_17);
                tv_many.setText(bust_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_4);
                btn.setText(R.string.many_17_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("17",bust_many[17]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[17]+=1;
                tv_many = findViewById(R.id.bust_tv__many_17);
                tv_many.setText(bust_many[17] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("17",bust_many[17]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_18(View view) {
        btn=findViewById(R.id.bust_button_18);
        tv_plus=findViewById(R.id.bust_tv_18);
        switch (bust_many[18]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[18]+=1;
                tv_many = findViewById(R.id.bust_tv__many_18);
                tv_many.setText(bust_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_1);
                btn.setText(R.string.many_18_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("18",bust_many[18]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[18]+=1;
                tv_many = findViewById(R.id.bust_tv__many_18);
                tv_many.setText(bust_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_2);
                btn.setText(R.string.many_18_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("18",bust_many[18]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[18]+=1;
                tv_many = findViewById(R.id.bust_tv__many_18);
                tv_many.setText(bust_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_3);
                btn.setText(R.string.many_18_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("18",bust_many[18]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[18]+=1;
                tv_many = findViewById(R.id.bust_tv__many_18);
                tv_many.setText(bust_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_4);
                btn.setText(R.string.many_18_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("18",bust_many[18]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[18]+=1;
                tv_many = findViewById(R.id.bust_tv__many_18);
                tv_many.setText(bust_many[18] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("18",bust_many[18]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_19(View view) {
        btn=findViewById(R.id.bust_button_19);
        tv_plus=findViewById(R.id.bust_tv_19);
        switch (bust_many[19]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[19]+=1;
                tv_many = findViewById(R.id.bust_tv__many_19);
                tv_many.setText(bust_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_1);
                btn.setText(R.string.many_19_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("19",bust_many[19]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[19]+=1;
                tv_many = findViewById(R.id.bust_tv__many_19);
                tv_many.setText(bust_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_2);
                btn.setText(R.string.many_19_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("19",bust_many[19]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[19]+=1;
                tv_many = findViewById(R.id.bust_tv__many_19);
                tv_many.setText(bust_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_3);
                btn.setText(R.string.many_19_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("19",bust_many[19]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[19]+=1;
                tv_many = findViewById(R.id.bust_tv__many_19);
                tv_many.setText(bust_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_4);
                btn.setText(R.string.many_19_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("19",bust_many[19]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[19]+=1;
                tv_many = findViewById(R.id.bust_tv__many_19);
                tv_many.setText(bust_many[19] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("19",bust_many[19]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_20(View view) {
        btn=findViewById(R.id.bust_button_20);
        tv_plus=findViewById(R.id.bust_tv_20);
        switch (bust_many[20]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[20]+=1;
                tv_many = findViewById(R.id.bust_tv__many_20);
                tv_many.setText(bust_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_1);
                btn.setText(R.string.many_20_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("20",bust_many[20]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[20]+=1;
                tv_many = findViewById(R.id.bust_tv__many_20);
                tv_many.setText(bust_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_2);
                btn.setText(R.string.many_20_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("20",bust_many[20]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[20]+=1;
                tv_many = findViewById(R.id.bust_tv__many_20);
                tv_many.setText(bust_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_3);
                btn.setText(R.string.many_20_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("20",bust_many[20]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[20]+=1;
                tv_many = findViewById(R.id.bust_tv__many_20);
                tv_many.setText(bust_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_4);
                btn.setText(R.string.many_20_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("20",bust_many[20]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[20]+=1;
                tv_many = findViewById(R.id.bust_tv__many_20);
                tv_many.setText(bust_many[20] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("20",bust_many[20]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_21(View view) {
        btn=findViewById(R.id.bust_button_21);
        tv_plus=findViewById(R.id.bust_tv_21);
        switch (bust_many[21]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[21]+=1;
                tv_many = findViewById(R.id.bust_tv__many_21);
                tv_many.setText(bust_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_1);
                btn.setText(R.string.many_21_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("21",bust_many[21]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[21]+=1;
                tv_many = findViewById(R.id.bust_tv__many_21);
                tv_many.setText(bust_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_2);
                btn.setText(R.string.many_21_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("21",bust_many[21]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[21]+=1;
                tv_many = findViewById(R.id.bust_tv__many_21);
                tv_many.setText(bust_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_3);
                btn.setText(R.string.many_21_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("21",bust_many[21]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[21]+=1;
                tv_many = findViewById(R.id.bust_tv__many_21);
                tv_many.setText(bust_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_4);
                btn.setText(R.string.many_21_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("21",bust_many[21]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[21]+=1;
                tv_many = findViewById(R.id.bust_tv__many_21);
                tv_many.setText(bust_many[21] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("21",bust_many[21]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_22(View view) {
        btn=findViewById(R.id.bust_button_22);
        tv_plus=findViewById(R.id.bust_tv_22);
        switch (bust_many[22]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[22]+=1;
                tv_many = findViewById(R.id.bust_tv__many_22);
                tv_many.setText(bust_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_1);
                btn.setText(R.string.many_22_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("22",bust_many[22]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[22]+=1;
                tv_many = findViewById(R.id.bust_tv__many_22);
                tv_many.setText(bust_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_2);
                btn.setText(R.string.many_22_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("22",bust_many[22]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[22]+=1;
                tv_many = findViewById(R.id.bust_tv__many_22);
                tv_many.setText(bust_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_3);
                btn.setText(R.string.many_22_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("22",bust_many[22]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[22]+=1;
                tv_many = findViewById(R.id.bust_tv__many_22);
                tv_many.setText(bust_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_4);
                btn.setText(R.string.many_22_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("22",bust_many[22]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[22]+=1;
                tv_many = findViewById(R.id.bust_tv__many_22);
                tv_many.setText(bust_many[22] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("22",bust_many[22]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_23(View view) {
        btn=findViewById(R.id.bust_button_23);
        tv_plus=findViewById(R.id.bust_tv_23);
        switch (bust_many[23]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[23]+=1;
                tv_many = findViewById(R.id.bust_tv__many_23);
                tv_many.setText(bust_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_1);
                btn.setText(R.string.many_23_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("23",bust_many[23]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[23]+=1;
                tv_many = findViewById(R.id.bust_tv__many_23);
                tv_many.setText(bust_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_2);
                btn.setText(R.string.many_23_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("23",bust_many[23]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[23]+=1;
                tv_many = findViewById(R.id.bust_tv__many_23);
                tv_many.setText(bust_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_3);
                btn.setText(R.string.many_23_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("23",bust_many[23]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[23]+=1;
                tv_many = findViewById(R.id.bust_tv__many_23);
                tv_many.setText(bust_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_4);
                btn.setText(R.string.many_23_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("23",bust_many[23]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[23]+=1;
                tv_many = findViewById(R.id.bust_tv__many_23);
                tv_many.setText(bust_many[23] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("23",bust_many[23]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_24(View view) {
        btn=findViewById(R.id.bust_button_24);
        tv_plus=findViewById(R.id.bust_tv_24);
        switch (bust_many[24]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[24]+=1;
                tv_many = findViewById(R.id.bust_tv__many_24);
                tv_many.setText(bust_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_1);
                btn.setText(R.string.many_24_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("24",bust_many[24]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[24]+=1;
                tv_many = findViewById(R.id.bust_tv__many_24);
                tv_many.setText(bust_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_2);
                btn.setText(R.string.many_24_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("24",bust_many[24]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[24]+=1;
                tv_many = findViewById(R.id.bust_tv__many_24);
                tv_many.setText(bust_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_3);
                btn.setText(R.string.many_24_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("24",bust_many[24]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[24]+=1;
                tv_many = findViewById(R.id.bust_tv__many_24);
                tv_many.setText(bust_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_4);
                btn.setText(R.string.many_24_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("24",bust_many[24]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[24]+=1;
                tv_many = findViewById(R.id.bust_tv__many_24);
                tv_many.setText(bust_many[24] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("24",bust_many[24]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_25(View view) {
        btn=findViewById(R.id.bust_button_25);
        tv_plus=findViewById(R.id.bust_tv_25);
        switch (bust_many[25]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[25]+=1;
                tv_many = findViewById(R.id.bust_tv__many_25);
                tv_many.setText(bust_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_1);
                btn.setText(R.string.many_25_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("25",bust_many[25]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[25]+=1;
                tv_many = findViewById(R.id.bust_tv__many_25);
                tv_many.setText(bust_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_2);
                btn.setText(R.string.many_25_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("25",bust_many[25]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[25]+=1;
                tv_many = findViewById(R.id.bust_tv__many_25);
                tv_many.setText(bust_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_3);
                btn.setText(R.string.many_25_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("25",bust_many[25]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[25]+=1;
                tv_many = findViewById(R.id.bust_tv__many_25);
                tv_many.setText(bust_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_4);
                btn.setText(R.string.many_25_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("25",bust_many[25]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[25]+=1;
                tv_many = findViewById(R.id.bust_tv__many_25);
                tv_many.setText(bust_many[25] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("25",bust_many[25]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_26(View view) {
        btn=findViewById(R.id.bust_button_26);
        tv_plus=findViewById(R.id.bust_tv_26);
        switch (bust_many[26]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[26]+=1;
                tv_many = findViewById(R.id.bust_tv__many_26);
                tv_many.setText(bust_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_1);
                btn.setText(R.string.many_26_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("26",bust_many[26]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[26]+=1;
                tv_many = findViewById(R.id.bust_tv__many_26);
                tv_many.setText(bust_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_2);
                btn.setText(R.string.many_26_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("26",bust_many[26]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[26]+=1;
                tv_many = findViewById(R.id.bust_tv__many_26);
                tv_many.setText(bust_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_3);
                btn.setText(R.string.many_26_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("26",bust_many[26]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[26]+=1;
                tv_many = findViewById(R.id.bust_tv__many_26);
                tv_many.setText(bust_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_4);
                btn.setText(R.string.many_26_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("26",bust_many[26]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[26]+=1;
                tv_many = findViewById(R.id.bust_tv__many_26);
                tv_many.setText(bust_many[26] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("26",bust_many[26]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_27(View view) {
        btn=findViewById(R.id.bust_button_27);
        tv_plus=findViewById(R.id.bust_tv_27);
        switch (bust_many[27]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[27]+=1;
                tv_many = findViewById(R.id.bust_tv__many_27);
                tv_many.setText(bust_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_1);
                btn.setText(R.string.many_27_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("27",bust_many[27]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[27]+=1;
                tv_many = findViewById(R.id.bust_tv__many_27);
                tv_many.setText(bust_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_2);
                btn.setText(R.string.many_27_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("27",bust_many[27]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[27]+=1;
                tv_many = findViewById(R.id.bust_tv__many_27);
                tv_many.setText(bust_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_3);
                btn.setText(R.string.many_27_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("27",bust_many[27]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[27]+=1;
                tv_many = findViewById(R.id.bust_tv__many_27);
                tv_many.setText(bust_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_4);
                btn.setText(R.string.many_27_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("27",bust_many[27]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[27]+=1;
                tv_many = findViewById(R.id.bust_tv__many_27);
                tv_many.setText(bust_many[27] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("27",bust_many[27]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_28(View view) {
        btn=findViewById(R.id.bust_button_28);
        tv_plus=findViewById(R.id.bust_tv_28);
        switch (bust_many[28]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[28]+=1;
                tv_many = findViewById(R.id.bust_tv__many_28);
                tv_many.setText(bust_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_1);
                btn.setText(R.string.many_28_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("28",bust_many[28]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[28]+=1;
                tv_many = findViewById(R.id.bust_tv__many_28);
                tv_many.setText(bust_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_2);
                btn.setText(R.string.many_28_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("28",bust_many[28]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[28]+=1;
                tv_many = findViewById(R.id.bust_tv__many_28);
                tv_many.setText(bust_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_3);
                btn.setText(R.string.many_28_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("28",bust_many[28]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[28]+=1;
                tv_many = findViewById(R.id.bust_tv__many_28);
                tv_many.setText(bust_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_4);
                btn.setText(R.string.many_28_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("28",bust_many[28]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[28]+=1;
                tv_many = findViewById(R.id.bust_tv__many_28);
                tv_many.setText(bust_many[28] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("28",bust_many[28]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_29(View view) {
        btn=findViewById(R.id.bust_button_29);
        tv_plus=findViewById(R.id.bust_tv_29);
        switch (bust_many[29]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[29]+=1;
                tv_many = findViewById(R.id.bust_tv__many_29);
                tv_many.setText(bust_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_1);
                btn.setText(R.string.many_29_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("29",bust_many[29]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[29]+=1;
                tv_many = findViewById(R.id.bust_tv__many_29);
                tv_many.setText(bust_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_2);
                btn.setText(R.string.many_29_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("29",bust_many[29]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[29]+=1;
                tv_many = findViewById(R.id.bust_tv__many_29);
                tv_many.setText(bust_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_3);
                btn.setText(R.string.many_29_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("29",bust_many[29]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[29]+=1;
                tv_many = findViewById(R.id.bust_tv__many_29);
                tv_many.setText(bust_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_4);
                btn.setText(R.string.many_29_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("29",bust_many[29]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[29]+=1;
                tv_many = findViewById(R.id.bust_tv__many_29);
                tv_many.setText(bust_many[29] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("29",bust_many[29]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_30(View view) {
        btn=findViewById(R.id.bust_button_30);
        tv_plus=findViewById(R.id.bust_tv_30);
        switch (bust_many[30]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[30]+=1;
                tv_many = findViewById(R.id.bust_tv__many_30);
                tv_many.setText(bust_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_1);
                btn.setText(R.string.many_30_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("30",bust_many[30]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[30]+=1;
                tv_many = findViewById(R.id.bust_tv__many_30);
                tv_many.setText(bust_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_2);
                btn.setText(R.string.many_30_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("30",bust_many[30]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[30]+=1;
                tv_many = findViewById(R.id.bust_tv__many_30);
                tv_many.setText(bust_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_3);
                btn.setText(R.string.many_30_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("30",bust_many[30]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[30]+=1;
                tv_many = findViewById(R.id.bust_tv__many_30);
                tv_many.setText(bust_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_4);
                btn.setText(R.string.many_30_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("30",bust_many[30]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[30]+=1;
                tv_many = findViewById(R.id.bust_tv__many_30);
                tv_many.setText(bust_many[30] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("30",bust_many[30]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_31(View view) {
        btn=findViewById(R.id.bust_button_31);
        tv_plus=findViewById(R.id.bust_tv_31);
        switch (bust_many[31]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[31]+=1;
                tv_many = findViewById(R.id.bust_tv__many_31);
                tv_many.setText(bust_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_1);
                btn.setText(R.string.many_31_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("31",bust_many[31]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[31]+=1;
                tv_many = findViewById(R.id.bust_tv__many_31);
                tv_many.setText(bust_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_2);
                btn.setText(R.string.many_31_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("31",bust_many[31]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[31]+=1;
                tv_many = findViewById(R.id.bust_tv__many_31);
                tv_many.setText(bust_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_3);
                btn.setText(R.string.many_31_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("31",bust_many[31]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[31]+=1;
                tv_many = findViewById(R.id.bust_tv__many_31);
                tv_many.setText(bust_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_4);
                btn.setText(R.string.many_31_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("31",bust_many[31]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[31]+=1;
                tv_many = findViewById(R.id.bust_tv__many_31);
                tv_many.setText(bust_many[31] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("31",bust_many[31]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_32(View view) {
        btn=findViewById(R.id.bust_button_32);
        tv_plus=findViewById(R.id.bust_tv_32);
        switch (bust_many[32]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[32]+=1;
                tv_many = findViewById(R.id.bust_tv__many_32);
                tv_many.setText(bust_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_1);
                btn.setText(R.string.many_32_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("32",bust_many[32]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[32]+=1;
                tv_many = findViewById(R.id.bust_tv__many_32);
                tv_many.setText(bust_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_2);
                btn.setText(R.string.many_32_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("32",bust_many[32]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[32]+=1;
                tv_many = findViewById(R.id.bust_tv__many_32);
                tv_many.setText(bust_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_3);
                btn.setText(R.string.many_32_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("32",bust_many[32]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[32]+=1;
                tv_many = findViewById(R.id.bust_tv__many_32);
                tv_many.setText(bust_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_4);
                btn.setText(R.string.many_32_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("32",bust_many[32]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[32]+=1;
                tv_many = findViewById(R.id.bust_tv__many_32);
                tv_many.setText(bust_many[32] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("32",bust_many[32]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_33(View view) {
        btn=findViewById(R.id.bust_button_33);
        tv_plus=findViewById(R.id.bust_tv_33);
        switch (bust_many[33]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[33]+=1;
                tv_many = findViewById(R.id.bust_tv__many_33);
                tv_many.setText(bust_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_1);
                btn.setText(R.string.many_33_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("33",bust_many[33]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[33]+=1;
                tv_many = findViewById(R.id.bust_tv__many_33);
                tv_many.setText(bust_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_2);
                btn.setText(R.string.many_33_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("33",bust_many[33]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[33]+=1;
                tv_many = findViewById(R.id.bust_tv__many_33);
                tv_many.setText(bust_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_3);
                btn.setText(R.string.many_33_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("33",bust_many[33]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[33]+=1;
                tv_many = findViewById(R.id.bust_tv__many_33);
                tv_many.setText(bust_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_4);
                btn.setText(R.string.many_33_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("33",bust_many[33]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[33]+=1;
                tv_many = findViewById(R.id.bust_tv__many_33);
                tv_many.setText(bust_many[33] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("33",bust_many[33]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_34(View view) {
        btn=findViewById(R.id.bust_button_34);
        tv_plus=findViewById(R.id.bust_tv_34);
        switch (bust_many[34]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[34]+=1;
                tv_many = findViewById(R.id.bust_tv__many_34);
                tv_many.setText(bust_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_1);
                btn.setText(R.string.many_34_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("34",bust_many[34]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[34]+=1;
                tv_many = findViewById(R.id.bust_tv__many_34);
                tv_many.setText(bust_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_2);
                btn.setText(R.string.many_34_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("34",bust_many[34]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[34]+=1;
                tv_many = findViewById(R.id.bust_tv__many_34);
                tv_many.setText(bust_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_3);
                btn.setText(R.string.many_34_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("34",bust_many[34]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[34]+=1;
                tv_many = findViewById(R.id.bust_tv__many_34);
                tv_many.setText(bust_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_4);
                btn.setText(R.string.many_34_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("34",bust_many[34]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[34]+=1;
                tv_many = findViewById(R.id.bust_tv__many_34);
                tv_many.setText(bust_many[34] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("34",bust_many[34]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_35(View view) {
        btn=findViewById(R.id.bust_button_35);
        tv_plus=findViewById(R.id.bust_tv_35);
        switch (bust_many[35]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[35]+=1;
                tv_many = findViewById(R.id.bust_tv__many_35);
                tv_many.setText(bust_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_1);
                btn.setText(R.string.many_35_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("35",bust_many[35]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[35]+=1;
                tv_many = findViewById(R.id.bust_tv__many_35);
                tv_many.setText(bust_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_2);
                btn.setText(R.string.many_35_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("35",bust_many[35]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[35]+=1;
                tv_many = findViewById(R.id.bust_tv__many_35);
                tv_many.setText(bust_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_3);
                btn.setText(R.string.many_35_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("35",bust_many[35]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[35]+=1;
                tv_many = findViewById(R.id.bust_tv__many_35);
                tv_many.setText(bust_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_4);
                btn.setText(R.string.many_35_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("35",bust_many[35]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[35]+=1;
                tv_many = findViewById(R.id.bust_tv__many_35);
                tv_many.setText(bust_many[35] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("35",bust_many[35]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_36(View view) {
        btn=findViewById(R.id.bust_button_36);
        tv_plus=findViewById(R.id.bust_tv_36);
        switch (bust_many[36]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[36]+=1;
                tv_many = findViewById(R.id.bust_tv__many_36);
                tv_many.setText(bust_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_1);
                btn.setText(R.string.many_36_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("36",bust_many[36]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[36]+=1;
                tv_many = findViewById(R.id.bust_tv__many_36);
                tv_many.setText(bust_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_2);
                btn.setText(R.string.many_36_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("36",bust_many[36]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[36]+=1;
                tv_many = findViewById(R.id.bust_tv__many_36);
                tv_many.setText(bust_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_3);
                btn.setText(R.string.many_36_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("36",bust_many[36]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[36]+=1;
                tv_many = findViewById(R.id.bust_tv__many_36);
                tv_many.setText(bust_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_4);
                btn.setText(R.string.many_36_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("36",bust_many[36]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[36]+=1;
                tv_many = findViewById(R.id.bust_tv__many_36);
                tv_many.setText(bust_many[36] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("36",bust_many[36]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_37(View view) {
        btn=findViewById(R.id.bust_button_37);
        tv_plus=findViewById(R.id.bust_tv_37);
        switch (bust_many[37]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[37]+=1;
                tv_many = findViewById(R.id.bust_tv__many_37);
                tv_many.setText(bust_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_1);
                btn.setText(R.string.many_37_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("37",bust_many[37]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[37]+=1;
                tv_many = findViewById(R.id.bust_tv__many_37);
                tv_many.setText(bust_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_2);
                btn.setText(R.string.many_37_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("37",bust_many[37]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[37]+=1;
                tv_many = findViewById(R.id.bust_tv__many_37);
                tv_many.setText(bust_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_3);
                btn.setText(R.string.many_37_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("37",bust_many[37]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[37]+=1;
                tv_many = findViewById(R.id.bust_tv__many_37);
                tv_many.setText(bust_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_4);
                btn.setText(R.string.many_37_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("37",bust_many[37]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[37]+=1;
                tv_many = findViewById(R.id.bust_tv__many_37);
                tv_many.setText(bust_many[37] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("37",bust_many[37]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_38(View view) {
        btn=findViewById(R.id.bust_button_38);
        tv_plus=findViewById(R.id.bust_tv_38);
        switch (bust_many[38]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[38]+=1;
                tv_many = findViewById(R.id.bust_tv__many_38);
                tv_many.setText(bust_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_1);
                btn.setText(R.string.many_38_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("38",bust_many[38]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[38]+=1;
                tv_many = findViewById(R.id.bust_tv__many_38);
                tv_many.setText(bust_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_2);
                btn.setText(R.string.many_38_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("38",bust_many[38]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[38]+=1;
                tv_many = findViewById(R.id.bust_tv__many_38);
                tv_many.setText(bust_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_3);
                btn.setText(R.string.many_38_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("38",bust_many[38]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[38]+=1;
                tv_many = findViewById(R.id.bust_tv__many_38);
                tv_many.setText(bust_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_4);
                btn.setText(R.string.many_38_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("38",bust_many[38]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[38]+=1;
                tv_many = findViewById(R.id.bust_tv__many_38);
                tv_many.setText(bust_many[38] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("38",bust_many[38]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void bust_button_39(View view) {
        btn=findViewById(R.id.bust_button_39);
        tv_plus=findViewById(R.id.bust_tv_39);
        switch (bust_many[39]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                bust=bust.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[39]+=1;
                tv_many = findViewById(R.id.bust_tv__many_39);
                tv_many.setText(bust_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_1);
                btn.setText(R.string.many_39_1);





                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("39",bust_many[39]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                bust=bust.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[39]+=1;
                tv_many = findViewById(R.id.bust_tv__many_39);
                tv_many.setText(bust_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_2);
                btn.setText(R.string.many_39_2);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("39",bust_many[39]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                bust=bust.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[39]+=1;
                tv_many = findViewById(R.id.bust_tv__many_39);
                tv_many.setText(bust_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_3);
                btn.setText(R.string.many_39_3);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("39",bust_many[39]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                bust=bust.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[39]+=1;
                tv_many = findViewById(R.id.bust_tv__many_39);
                tv_many.setText(bust_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_4);
                btn.setText(R.string.many_39_4);

                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("39",bust_many[39]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                bust=bust.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_bust = findViewById(R.id.bust_tv);
                tv_bust.setText(chenge(bust));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                bust_many[39]+=1;
                tv_many = findViewById(R.id.bust_tv__many_39);
                tv_many.setText(bust_many[39] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_bust_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_bust_button_0.edit();
                b_0.putInt("39",bust_many[39]);
                b_0.apply();

            }
                break;
            default:break;
        }}






















    @SuppressLint("SetTextI18n")
    public void afk_button_0(View view) {
        btn=findViewById(R.id.afk_button_0);
        tv_plus=findViewById(R.id.afk_tv_0);
        switch (afk_many[0]){


            case 0: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[0]+=1;
                tv_many = findViewById(R.id.afk_tv__many_0);
                tv_many.setText(afk_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_1);
                btn.setText(R.string.many_0_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button),afk_many[0]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("150")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("150"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[0]+=1;
                tv_many = findViewById(R.id.afk_tv__many_0);
                tv_many.setText(afk_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_2);
                btn.setText(R.string.many_0_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button),afk_many[0]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("450")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("450"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[0]+=1;
                tv_many = findViewById(R.id.afk_tv__many_0);
                tv_many.setText(afk_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_3);
                btn.setText(R.string.many_0_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button),afk_many[0]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("1350")) >= 0) {
                afk=afk.add(new BigInteger("6"));
                score=score.subtract(new BigInteger("1350"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[0]+=1;
                tv_many = findViewById(R.id.afk_tv__many_0);
                tv_many.setText(afk_many[0] +"/5");

                tv_plus.setText(R.string.plus_0_4);
                btn.setText(R.string.many_0_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button),afk_many[0]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("4050")) >= 0) {
                afk=afk.add(new BigInteger("9"));
                score=score.subtract(new BigInteger("4050"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[0]+=1;
                tv_many = findViewById(R.id.afk_tv__many_0);
                tv_many.setText(afk_many[0] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button),afk_many[0]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_1(View view) {
        btn=findViewById(R.id.afk_button_1);
        tv_plus=findViewById(R.id.afk_tv_1);
        switch (afk_many[1]){


            case 0: if(score.compareTo(new BigInteger("300")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("300"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[1]+=1;
                tv_many = findViewById(R.id.afk_tv__many_1);
                tv_many.setText(afk_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_1);
                btn.setText(R.string.many_1_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+1),afk_many[1]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("900")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("900"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[1]+=1;
                tv_many = findViewById(R.id.afk_tv__many_1);
                tv_many.setText(afk_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_2);
                btn.setText(R.string.many_1_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+1),afk_many[1]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("2700")) >= 0) {
                afk=afk.add(new BigInteger("8"));
                score=score.subtract(new BigInteger("2700"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[1]+=1;
                tv_many = findViewById(R.id.afk_tv__many_1);
                tv_many.setText(afk_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_3);
                btn.setText(R.string.many_1_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+1),afk_many[1]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("8100")) >= 0) {
                afk=afk.add(new BigInteger("16"));
                score=score.subtract(new BigInteger("8100"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[1]+=1;
                tv_many = findViewById(R.id.afk_tv__many_1);
                tv_many.setText(afk_many[1] +"/5");

                tv_plus.setText(R.string.plus_1_4);
                btn.setText(R.string.many_1_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+1),afk_many[1]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("20300")) >= 0) {
                afk=afk.add(new BigInteger("28"));
                score=score.subtract(new BigInteger("20300"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[1]+=1;
                tv_many = findViewById(R.id.afk_tv__many_1);
                tv_many.setText(afk_many[1] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+1),afk_many[1]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_2(View view) {
        btn=findViewById(R.id.afk_button_2);
        tv_plus=findViewById(R.id.afk_tv_2);
        switch (afk_many[2]){


            case 0: if(score.compareTo(new BigInteger("1800")) >= 0) {
                afk=afk.add(new BigInteger("8"));
                score=score.subtract(new BigInteger("1800"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[2]+=1;
                tv_many = findViewById(R.id.afk_tv__many_2);
                tv_many.setText(afk_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_1);
                btn.setText(R.string.many_2_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+2),afk_many[2]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("5400")) >= 0) {
                afk=afk.add(new BigInteger("16"));
                score=score.subtract(new BigInteger("5400"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[2]+=1;
                tv_many = findViewById(R.id.afk_tv__many_2);
                tv_many.setText(afk_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_2);
                btn.setText(R.string.many_2_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+2),afk_many[2]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("16200")) >= 0) {
                afk=afk.add(new BigInteger("24"));
                score=score.subtract(new BigInteger("16200"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[2]+=1;
                tv_many = findViewById(R.id.afk_tv__many_2);
                tv_many.setText(afk_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_3);
                btn.setText(R.string.many_2_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+2),afk_many[2]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("28100")) >= 0) {
                afk=afk.add(new BigInteger("40"));
                score=score.subtract(new BigInteger("28100"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[2]+=1;
                tv_many = findViewById(R.id.afk_tv__many_2);
                tv_many.setText(afk_many[2] +"/5");

                tv_plus.setText(R.string.plus_2_4);
                btn.setText(R.string.many_2_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+2),afk_many[2]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("45000")) >= 0) {
                afk=afk.add(new BigInteger("70"));
                score=score.subtract(new BigInteger("45000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[2]+=1;
                tv_many = findViewById(R.id.afk_tv__many_2);
                tv_many.setText(afk_many[2] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+2),afk_many[2]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_3(View view) {
        btn=findViewById(R.id.afk_button_3);
        tv_plus=findViewById(R.id.afk_tv_3);
        switch (afk_many[3]){


            case 0: if(score.compareTo(new BigInteger("15000")) >= 0) {
                afk=afk.add(new BigInteger("24"));
                score=score.subtract(new BigInteger("15000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[3]+=1;
                tv_many = findViewById(R.id.afk_tv__many_3);
                tv_many.setText(afk_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_1);
                btn.setText(R.string.many_3_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+3),afk_many[3]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("40000")) >= 0) {
                afk=afk.add(new BigInteger("60"));
                score=score.subtract(new BigInteger("40000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[3]+=1;
                tv_many = findViewById(R.id.afk_tv__many_3);
                tv_many.setText(afk_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_2);
                btn.setText(R.string.many_3_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+3),afk_many[3]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("100000")) >= 0) {
                afk=afk.add(new BigInteger("150"));
                score=score.subtract(new BigInteger("100000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[3]+=1;
                tv_many = findViewById(R.id.afk_tv__many_3);
                tv_many.setText(afk_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_3);
                btn.setText(R.string.many_3_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+3),afk_many[3]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("150000")) >= 0) {
                afk=afk.add(new BigInteger("200"));
                score=score.subtract(new BigInteger("150000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[3]+=1;
                tv_many = findViewById(R.id.afk_tv__many_3);
                tv_many.setText(afk_many[3] +"/5");

                tv_plus.setText(R.string.plus_3_4);
                btn.setText(R.string.many_3_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+3),afk_many[3]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("300000")) >= 0) {
                afk=afk.add(new BigInteger("500"));
                score=score.subtract(new BigInteger("300000"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[3]+=1;
                tv_many = findViewById(R.id.afk_tv__many_3);
                tv_many.setText(afk_many[3] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+3),afk_many[3]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_4(View view) {
        btn=findViewById(R.id.afk_button_4);
        tv_plus=findViewById(R.id.afk_tv_4);
        switch (afk_many[4]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[4]+=1;
                tv_many = findViewById(R.id.afk_tv__many_4);
                tv_many.setText(afk_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_1);
                btn.setText(R.string.many_4_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+4),afk_many[4]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[4]+=1;
                tv_many = findViewById(R.id.afk_tv__many_4);
                tv_many.setText(afk_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_2);
                btn.setText(R.string.many_4_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+4),afk_many[4]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[4]+=1;
                tv_many = findViewById(R.id.afk_tv__many_4);
                tv_many.setText(afk_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_3);
                btn.setText(R.string.many_4_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+4),afk_many[4]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[4]+=1;
                tv_many = findViewById(R.id.afk_tv__many_4);
                tv_many.setText(afk_many[4] +"/5");

                tv_plus.setText(R.string.plus_4_4);
                btn.setText(R.string.many_4_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+4),afk_many[4]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[4]+=1;
                tv_many = findViewById(R.id.afk_tv__many_4);
                tv_many.setText(afk_many[4] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+4),afk_many[4]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_5(View view) {
        btn=findViewById(R.id.afk_button_5);
        tv_plus=findViewById(R.id.afk_tv_5);
        switch (afk_many[5]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[5]+=1;
                tv_many = findViewById(R.id.afk_tv__many_5);
                tv_many.setText(afk_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_1);
                btn.setText(R.string.many_5_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+5),afk_many[5]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[5]+=1;
                tv_many = findViewById(R.id.afk_tv__many_5);
                tv_many.setText(afk_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_2);
                btn.setText(R.string.many_5_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+5),afk_many[5]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[5]+=1;
                tv_many = findViewById(R.id.afk_tv__many_5);
                tv_many.setText(afk_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_3);
                btn.setText(R.string.many_5_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+5),afk_many[5]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[5]+=1;
                tv_many = findViewById(R.id.afk_tv__many_5);
                tv_many.setText(afk_many[5] +"/5");

                tv_plus.setText(R.string.plus_5_4);
                btn.setText(R.string.many_5_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+5),afk_many[5]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[5]+=1;
                tv_many = findViewById(R.id.afk_tv__many_5);
                tv_many.setText(afk_many[5] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+5),afk_many[5]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_6(View view) {
        btn=findViewById(R.id.afk_button_6);
        tv_plus=findViewById(R.id.afk_tv_6);
        switch (afk_many[6]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[6]+=1;
                tv_many = findViewById(R.id.afk_tv__many_6);
                tv_many.setText(afk_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_1);
                btn.setText(R.string.many_6_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+6),afk_many[6]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[6]+=1;
                tv_many = findViewById(R.id.afk_tv__many_6);
                tv_many.setText(afk_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_2);
                btn.setText(R.string.many_6_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+6),afk_many[6]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[6]+=1;
                tv_many = findViewById(R.id.afk_tv__many_6);
                tv_many.setText(afk_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_3);
                btn.setText(R.string.many_6_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+6),afk_many[6]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[6]+=1;
                tv_many = findViewById(R.id.afk_tv__many_6);
                tv_many.setText(afk_many[6] +"/5");

                tv_plus.setText(R.string.plus_6_4);
                btn.setText(R.string.many_6_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+6),afk_many[6]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[6]+=1;
                tv_many = findViewById(R.id.afk_tv__many_6);
                tv_many.setText(afk_many[6] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+6),afk_many[6]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_7(View view) {
        btn=findViewById(R.id.afk_button_7);
        tv_plus=findViewById(R.id.afk_tv_7);
        switch (afk_many[7]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[7]+=1;
                tv_many = findViewById(R.id.afk_tv__many_7);
                tv_many.setText(afk_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_1);
                btn.setText(R.string.many_7_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+7),afk_many[7]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[7]+=1;
                tv_many = findViewById(R.id.afk_tv__many_7);
                tv_many.setText(afk_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_2);
                btn.setText(R.string.many_7_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+7),afk_many[7]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[7]+=1;
                tv_many = findViewById(R.id.afk_tv__many_7);
                tv_many.setText(afk_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_3);
                btn.setText(R.string.many_7_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+7),afk_many[7]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[7]+=1;
                tv_many = findViewById(R.id.afk_tv__many_7);
                tv_many.setText(afk_many[7] +"/5");

                tv_plus.setText(R.string.plus_7_4);
                btn.setText(R.string.many_7_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+7),afk_many[7]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[7]+=1;
                tv_many = findViewById(R.id.afk_tv__many_7);
                tv_many.setText(afk_many[7] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+7),afk_many[7]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_8(View view) {
        btn=findViewById(R.id.afk_button_8);
        tv_plus=findViewById(R.id.afk_tv_8);
        switch (afk_many[8]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[8]+=1;
                tv_many = findViewById(R.id.afk_tv__many_8);
                tv_many.setText(afk_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_1);
                btn.setText(R.string.many_8_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+8),afk_many[8]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[8]+=1;
                tv_many = findViewById(R.id.afk_tv__many_8);
                tv_many.setText(afk_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_2);
                btn.setText(R.string.many_8_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+8),afk_many[8]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[8]+=1;
                tv_many = findViewById(R.id.afk_tv__many_8);
                tv_many.setText(afk_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_3);
                btn.setText(R.string.many_8_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+8),afk_many[8]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[8]+=1;
                tv_many = findViewById(R.id.afk_tv__many_8);
                tv_many.setText(afk_many[8] +"/5");

                tv_plus.setText(R.string.plus_8_4);
                btn.setText(R.string.many_8_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+8),afk_many[8]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[8]+=1;
                tv_many = findViewById(R.id.afk_tv__many_8);
                tv_many.setText(afk_many[8] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+8),afk_many[8]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_9(View view) {
        btn=findViewById(R.id.afk_button_9);
        tv_plus=findViewById(R.id.afk_tv_9);
        switch (afk_many[9]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[9]+=1;
                tv_many = findViewById(R.id.afk_tv__many_9);
                tv_many.setText(afk_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_1);
                btn.setText(R.string.many_9_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+9),afk_many[9]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[9]+=1;
                tv_many = findViewById(R.id.afk_tv__many_9);
                tv_many.setText(afk_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_2);
                btn.setText(R.string.many_9_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+9),afk_many[9]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[9]+=1;
                tv_many = findViewById(R.id.afk_tv__many_9);
                tv_many.setText(afk_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_3);
                btn.setText(R.string.many_9_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+9),afk_many[9]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[9]+=1;
                tv_many = findViewById(R.id.afk_tv__many_9);
                tv_many.setText(afk_many[9] +"/5");

                tv_plus.setText(R.string.plus_9_4);
                btn.setText(R.string.many_9_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+9),afk_many[9]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[9]+=1;
                tv_many = findViewById(R.id.afk_tv__many_9);
                tv_many.setText(afk_many[9] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+9),afk_many[9]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_10(View view) {
        btn=findViewById(R.id.afk_button_10);
        tv_plus=findViewById(R.id.afk_tv_10);
        switch (afk_many[10]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[10]+=1;
                tv_many = findViewById(R.id.afk_tv__many_10);
                tv_many.setText(afk_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_1);
                btn.setText(R.string.many_10_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+10),afk_many[10]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[10]+=1;
                tv_many = findViewById(R.id.afk_tv__many_10);
                tv_many.setText(afk_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_2);
                btn.setText(R.string.many_10_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+10),afk_many[10]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[10]+=1;
                tv_many = findViewById(R.id.afk_tv__many_10);
                tv_many.setText(afk_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_3);
                btn.setText(R.string.many_10_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+10),afk_many[10]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[10]+=1;
                tv_many = findViewById(R.id.afk_tv__many_10);
                tv_many.setText(afk_many[10] +"/5");

                tv_plus.setText(R.string.plus_10_4);
                btn.setText(R.string.many_10_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+10),afk_many[10]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[10]+=1;
                tv_many = findViewById(R.id.afk_tv__many_10);
                tv_many.setText(afk_many[10] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+10),afk_many[10]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_11(View view) {
        btn=findViewById(R.id.afk_button_11);
        tv_plus=findViewById(R.id.afk_tv_11);
        switch (afk_many[11]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[11]+=1;
                tv_many = findViewById(R.id.afk_tv__many_11);
                tv_many.setText(afk_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_1);
                btn.setText(R.string.many_11_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+11),afk_many[11]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[11]+=1;
                tv_many = findViewById(R.id.afk_tv__many_11);
                tv_many.setText(afk_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_2);
                btn.setText(R.string.many_11_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+11),afk_many[11]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[11]+=1;
                tv_many = findViewById(R.id.afk_tv__many_11);
                tv_many.setText(afk_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_3);
                btn.setText(R.string.many_11_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+11),afk_many[11]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[11]+=1;
                tv_many = findViewById(R.id.afk_tv__many_11);
                tv_many.setText(afk_many[11] +"/5");

                tv_plus.setText(R.string.plus_11_4);
                btn.setText(R.string.many_11_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+11),afk_many[11]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[11]+=1;
                tv_many = findViewById(R.id.afk_tv__many_11);
                tv_many.setText(afk_many[11] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+11),afk_many[11]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_12(View view) {
        btn=findViewById(R.id.afk_button_12);
        tv_plus=findViewById(R.id.afk_tv_12);
        switch (afk_many[12]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[12]+=1;
                tv_many = findViewById(R.id.afk_tv__many_12);
                tv_many.setText(afk_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_1);
                btn.setText(R.string.many_12_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+12),afk_many[12]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[12]+=1;
                tv_many = findViewById(R.id.afk_tv__many_12);
                tv_many.setText(afk_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_2);
                btn.setText(R.string.many_12_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+12),afk_many[12]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[12]+=1;
                tv_many = findViewById(R.id.afk_tv__many_12);
                tv_many.setText(afk_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_3);
                btn.setText(R.string.many_12_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+12),afk_many[12]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[12]+=1;
                tv_many = findViewById(R.id.afk_tv__many_12);
                tv_many.setText(afk_many[12] +"/5");

                tv_plus.setText(R.string.plus_12_4);
                btn.setText(R.string.many_12_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+12),afk_many[12]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[12]+=1;
                tv_many = findViewById(R.id.afk_tv__many_12);
                tv_many.setText(afk_many[12] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+12),afk_many[12]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_13(View view) {
        btn=findViewById(R.id.afk_button_13);
        tv_plus=findViewById(R.id.afk_tv_13);
        switch (afk_many[13]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[13]+=1;
                tv_many = findViewById(R.id.afk_tv__many_13);
                tv_many.setText(afk_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_1);
                btn.setText(R.string.many_13_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+13),afk_many[13]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[13]+=1;
                tv_many = findViewById(R.id.afk_tv__many_13);
                tv_many.setText(afk_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_2);
                btn.setText(R.string.many_13_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+13),afk_many[13]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[13]+=1;
                tv_many = findViewById(R.id.afk_tv__many_13);
                tv_many.setText(afk_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_3);
                btn.setText(R.string.many_13_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+13),afk_many[13]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[13]+=1;
                tv_many = findViewById(R.id.afk_tv__many_13);
                tv_many.setText(afk_many[13] +"/5");

                tv_plus.setText(R.string.plus_13_4);
                btn.setText(R.string.many_13_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+13),afk_many[13]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[13]+=1;
                tv_many = findViewById(R.id.afk_tv__many_13);
                tv_many.setText(afk_many[13] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+13),afk_many[13]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_14(View view) {
        btn=findViewById(R.id.afk_button_14);
        tv_plus=findViewById(R.id.afk_tv_14);
        switch (afk_many[14]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[14]+=1;
                tv_many = findViewById(R.id.afk_tv__many_14);
                tv_many.setText(afk_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_1);
                btn.setText(R.string.many_14_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+14),afk_many[14]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[14]+=1;
                tv_many = findViewById(R.id.afk_tv__many_14);
                tv_many.setText(afk_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_2);
                btn.setText(R.string.many_14_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+14),afk_many[14]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[14]+=1;
                tv_many = findViewById(R.id.afk_tv__many_14);
                tv_many.setText(afk_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_3);
                btn.setText(R.string.many_14_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+14),afk_many[14]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[14]+=1;
                tv_many = findViewById(R.id.afk_tv__many_14);
                tv_many.setText(afk_many[14] +"/5");

                tv_plus.setText(R.string.plus_14_4);
                btn.setText(R.string.many_14_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+14),afk_many[14]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[14]+=1;
                tv_many = findViewById(R.id.afk_tv__many_14);
                tv_many.setText(afk_many[14] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+14),afk_many[14]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_15(View view) {
        btn=findViewById(R.id.afk_button_15);
        tv_plus=findViewById(R.id.afk_tv_15);
        switch (afk_many[15]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[15]+=1;
                tv_many = findViewById(R.id.afk_tv__many_15);
                tv_many.setText(afk_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_1);
                btn.setText(R.string.many_15_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+15),afk_many[15]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[15]+=1;
                tv_many = findViewById(R.id.afk_tv__many_15);
                tv_many.setText(afk_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_2);
                btn.setText(R.string.many_15_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+15),afk_many[15]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[15]+=1;
                tv_many = findViewById(R.id.afk_tv__many_15);
                tv_many.setText(afk_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_3);
                btn.setText(R.string.many_15_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+15),afk_many[15]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[15]+=1;
                tv_many = findViewById(R.id.afk_tv__many_15);
                tv_many.setText(afk_many[15] +"/5");

                tv_plus.setText(R.string.plus_15_4);
                btn.setText(R.string.many_15_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+15),afk_many[15]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[15]+=1;
                tv_many = findViewById(R.id.afk_tv__many_15);
                tv_many.setText(afk_many[15] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+15),afk_many[15]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_16(View view) {
        btn=findViewById(R.id.afk_button_16);
        tv_plus=findViewById(R.id.afk_tv_16);
        switch (afk_many[16]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[16]+=1;
                tv_many = findViewById(R.id.afk_tv__many_16);
                tv_many.setText(afk_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_1);
                btn.setText(R.string.many_16_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+16),afk_many[16]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[16]+=1;
                tv_many = findViewById(R.id.afk_tv__many_16);
                tv_many.setText(afk_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_2);
                btn.setText(R.string.many_16_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+16),afk_many[16]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[16]+=1;
                tv_many = findViewById(R.id.afk_tv__many_16);
                tv_many.setText(afk_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_3);
                btn.setText(R.string.many_16_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+16),afk_many[16]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[16]+=1;
                tv_many = findViewById(R.id.afk_tv__many_16);
                tv_many.setText(afk_many[16] +"/5");

                tv_plus.setText(R.string.plus_16_4);
                btn.setText(R.string.many_16_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+16),afk_many[16]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[16]+=1;
                tv_many = findViewById(R.id.afk_tv__many_16);
                tv_many.setText(afk_many[16] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+16),afk_many[16]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_17(View view) {
        btn=findViewById(R.id.afk_button_17);
        tv_plus=findViewById(R.id.afk_tv_17);
        switch (afk_many[17]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[17]+=1;
                tv_many = findViewById(R.id.afk_tv__many_17);
                tv_many.setText(afk_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_1);
                btn.setText(R.string.many_17_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+17),afk_many[17]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[17]+=1;
                tv_many = findViewById(R.id.afk_tv__many_17);
                tv_many.setText(afk_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_2);
                btn.setText(R.string.many_17_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+17),afk_many[17]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[17]+=1;
                tv_many = findViewById(R.id.afk_tv__many_17);
                tv_many.setText(afk_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_3);
                btn.setText(R.string.many_17_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+17),afk_many[17]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[17]+=1;
                tv_many = findViewById(R.id.afk_tv__many_17);
                tv_many.setText(afk_many[17] +"/5");

                tv_plus.setText(R.string.plus_17_4);
                btn.setText(R.string.many_17_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+17),afk_many[17]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[17]+=1;
                tv_many = findViewById(R.id.afk_tv__many_17);
                tv_many.setText(afk_many[17] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+17),afk_many[17]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_18(View view) {
        btn=findViewById(R.id.afk_button_18);
        tv_plus=findViewById(R.id.afk_tv_18);
        switch (afk_many[18]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[18]+=1;
                tv_many = findViewById(R.id.afk_tv__many_18);
                tv_many.setText(afk_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_1);
                btn.setText(R.string.many_18_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+18),afk_many[18]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[18]+=1;
                tv_many = findViewById(R.id.afk_tv__many_18);
                tv_many.setText(afk_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_2);
                btn.setText(R.string.many_18_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+18),afk_many[18]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[18]+=1;
                tv_many = findViewById(R.id.afk_tv__many_18);
                tv_many.setText(afk_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_3);
                btn.setText(R.string.many_18_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+18),afk_many[18]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[18]+=1;
                tv_many = findViewById(R.id.afk_tv__many_18);
                tv_many.setText(afk_many[18] +"/5");

                tv_plus.setText(R.string.plus_18_4);
                btn.setText(R.string.many_18_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+18),afk_many[18]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[18]+=1;
                tv_many = findViewById(R.id.afk_tv__many_18);
                tv_many.setText(afk_many[18] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+18),afk_many[18]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_19(View view) {
        btn=findViewById(R.id.afk_button_19);
        tv_plus=findViewById(R.id.afk_tv_19);
        switch (afk_many[19]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[19]+=1;
                tv_many = findViewById(R.id.afk_tv__many_19);
                tv_many.setText(afk_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_1);
                btn.setText(R.string.many_19_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+19),afk_many[19]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[19]+=1;
                tv_many = findViewById(R.id.afk_tv__many_19);
                tv_many.setText(afk_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_2);
                btn.setText(R.string.many_19_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+19),afk_many[19]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[19]+=1;
                tv_many = findViewById(R.id.afk_tv__many_19);
                tv_many.setText(afk_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_3);
                btn.setText(R.string.many_19_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+19),afk_many[19]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[19]+=1;
                tv_many = findViewById(R.id.afk_tv__many_19);
                tv_many.setText(afk_many[19] +"/5");

                tv_plus.setText(R.string.plus_19_4);
                btn.setText(R.string.many_19_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+19),afk_many[19]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[19]+=1;
                tv_many = findViewById(R.id.afk_tv__many_19);
                tv_many.setText(afk_many[19] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+19),afk_many[19]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_20(View view) {
        btn=findViewById(R.id.afk_button_20);
        tv_plus=findViewById(R.id.afk_tv_20);
        switch (afk_many[20]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[20]+=1;
                tv_many = findViewById(R.id.afk_tv__many_20);
                tv_many.setText(afk_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_1);
                btn.setText(R.string.many_20_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+20),afk_many[20]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[20]+=1;
                tv_many = findViewById(R.id.afk_tv__many_20);
                tv_many.setText(afk_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_2);
                btn.setText(R.string.many_20_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+20),afk_many[20]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[20]+=1;
                tv_many = findViewById(R.id.afk_tv__many_20);
                tv_many.setText(afk_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_3);
                btn.setText(R.string.many_20_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+20),afk_many[20]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[20]+=1;
                tv_many = findViewById(R.id.afk_tv__many_20);
                tv_many.setText(afk_many[20] +"/5");

                tv_plus.setText(R.string.plus_20_4);
                btn.setText(R.string.many_20_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+20),afk_many[20]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[20]+=1;
                tv_many = findViewById(R.id.afk_tv__many_20);
                tv_many.setText(afk_many[20] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+20),afk_many[20]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_21(View view) {
        btn=findViewById(R.id.afk_button_21);
        tv_plus=findViewById(R.id.afk_tv_21);
        switch (afk_many[21]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[21]+=1;
                tv_many = findViewById(R.id.afk_tv__many_21);
                tv_many.setText(afk_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_1);
                btn.setText(R.string.many_21_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+21),afk_many[21]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[21]+=1;
                tv_many = findViewById(R.id.afk_tv__many_21);
                tv_many.setText(afk_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_2);
                btn.setText(R.string.many_21_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+21),afk_many[21]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[21]+=1;
                tv_many = findViewById(R.id.afk_tv__many_21);
                tv_many.setText(afk_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_3);
                btn.setText(R.string.many_21_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+21),afk_many[21]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[21]+=1;
                tv_many = findViewById(R.id.afk_tv__many_21);
                tv_many.setText(afk_many[21] +"/5");

                tv_plus.setText(R.string.plus_21_4);
                btn.setText(R.string.many_21_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+21),afk_many[21]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[21]+=1;
                tv_many = findViewById(R.id.afk_tv__many_21);
                tv_many.setText(afk_many[21] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+21),afk_many[21]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_22(View view) {
        btn=findViewById(R.id.afk_button_22);
        tv_plus=findViewById(R.id.afk_tv_22);
        switch (afk_many[22]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[22]+=1;
                tv_many = findViewById(R.id.afk_tv__many_22);
                tv_many.setText(afk_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_1);
                btn.setText(R.string.many_22_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+22),afk_many[22]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[22]+=1;
                tv_many = findViewById(R.id.afk_tv__many_22);
                tv_many.setText(afk_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_2);
                btn.setText(R.string.many_22_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+22),afk_many[22]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[22]+=1;
                tv_many = findViewById(R.id.afk_tv__many_22);
                tv_many.setText(afk_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_3);
                btn.setText(R.string.many_22_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+22),afk_many[22]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[22]+=1;
                tv_many = findViewById(R.id.afk_tv__many_22);
                tv_many.setText(afk_many[22] +"/5");

                tv_plus.setText(R.string.plus_22_4);
                btn.setText(R.string.many_22_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+22),afk_many[22]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[22]+=1;
                tv_many = findViewById(R.id.afk_tv__many_22);
                tv_many.setText(afk_many[22] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+22),afk_many[22]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_23(View view) {
        btn=findViewById(R.id.afk_button_23);
        tv_plus=findViewById(R.id.afk_tv_23);
        switch (afk_many[23]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[23]+=1;
                tv_many = findViewById(R.id.afk_tv__many_23);
                tv_many.setText(afk_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_1);
                btn.setText(R.string.many_23_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+23),afk_many[23]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[23]+=1;
                tv_many = findViewById(R.id.afk_tv__many_23);
                tv_many.setText(afk_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_2);
                btn.setText(R.string.many_23_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+23),afk_many[23]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[23]+=1;
                tv_many = findViewById(R.id.afk_tv__many_23);
                tv_many.setText(afk_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_3);
                btn.setText(R.string.many_23_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+23),afk_many[23]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[23]+=1;
                tv_many = findViewById(R.id.afk_tv__many_23);
                tv_many.setText(afk_many[23] +"/5");

                tv_plus.setText(R.string.plus_23_4);
                btn.setText(R.string.many_23_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+23),afk_many[23]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[23]+=1;
                tv_many = findViewById(R.id.afk_tv__many_23);
                tv_many.setText(afk_many[23] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+23),afk_many[23]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_24(View view) {
        btn=findViewById(R.id.afk_button_24);
        tv_plus=findViewById(R.id.afk_tv_24);
        switch (afk_many[24]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[24]+=1;
                tv_many = findViewById(R.id.afk_tv__many_24);
                tv_many.setText(afk_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_1);
                btn.setText(R.string.many_24_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+24),afk_many[24]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[24]+=1;
                tv_many = findViewById(R.id.afk_tv__many_24);
                tv_many.setText(afk_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_2);
                btn.setText(R.string.many_24_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+24),afk_many[24]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[24]+=1;
                tv_many = findViewById(R.id.afk_tv__many_24);
                tv_many.setText(afk_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_3);
                btn.setText(R.string.many_24_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+24),afk_many[24]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[24]+=1;
                tv_many = findViewById(R.id.afk_tv__many_24);
                tv_many.setText(afk_many[24] +"/5");

                tv_plus.setText(R.string.plus_24_4);
                btn.setText(R.string.many_24_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+24),afk_many[24]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[24]+=1;
                tv_many = findViewById(R.id.afk_tv__many_24);
                tv_many.setText(afk_many[24] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+24),afk_many[24]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_25(View view) {
        btn=findViewById(R.id.afk_button_25);
        tv_plus=findViewById(R.id.afk_tv_25);
        switch (afk_many[25]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[25]+=1;
                tv_many = findViewById(R.id.afk_tv__many_25);
                tv_many.setText(afk_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_1);
                btn.setText(R.string.many_25_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+25),afk_many[25]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[25]+=1;
                tv_many = findViewById(R.id.afk_tv__many_25);
                tv_many.setText(afk_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_2);
                btn.setText(R.string.many_25_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+25),afk_many[25]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[25]+=1;
                tv_many = findViewById(R.id.afk_tv__many_25);
                tv_many.setText(afk_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_3);
                btn.setText(R.string.many_25_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+25),afk_many[25]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[25]+=1;
                tv_many = findViewById(R.id.afk_tv__many_25);
                tv_many.setText(afk_many[25] +"/5");

                tv_plus.setText(R.string.plus_25_4);
                btn.setText(R.string.many_25_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+25),afk_many[25]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[25]+=1;
                tv_many = findViewById(R.id.afk_tv__many_25);
                tv_many.setText(afk_many[25] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+25),afk_many[25]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_26(View view) {
        btn=findViewById(R.id.afk_button_26);
        tv_plus=findViewById(R.id.afk_tv_26);
        switch (afk_many[26]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[26]+=1;
                tv_many = findViewById(R.id.afk_tv__many_26);
                tv_many.setText(afk_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_1);
                btn.setText(R.string.many_26_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+26),afk_many[26]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[26]+=1;
                tv_many = findViewById(R.id.afk_tv__many_26);
                tv_many.setText(afk_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_2);
                btn.setText(R.string.many_26_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+26),afk_many[26]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[26]+=1;
                tv_many = findViewById(R.id.afk_tv__many_26);
                tv_many.setText(afk_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_3);
                btn.setText(R.string.many_26_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+26),afk_many[26]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[26]+=1;
                tv_many = findViewById(R.id.afk_tv__many_26);
                tv_many.setText(afk_many[26] +"/5");

                tv_plus.setText(R.string.plus_26_4);
                btn.setText(R.string.many_26_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+26),afk_many[26]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[26]+=1;
                tv_many = findViewById(R.id.afk_tv__many_26);
                tv_many.setText(afk_many[26] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+26),afk_many[26]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_27(View view) {
        btn=findViewById(R.id.afk_button_27);
        tv_plus=findViewById(R.id.afk_tv_27);
        switch (afk_many[27]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[27]+=1;
                tv_many = findViewById(R.id.afk_tv__many_27);
                tv_many.setText(afk_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_1);
                btn.setText(R.string.many_27_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+27),afk_many[27]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[27]+=1;
                tv_many = findViewById(R.id.afk_tv__many_27);
                tv_many.setText(afk_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_2);
                btn.setText(R.string.many_27_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+27),afk_many[27]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[27]+=1;
                tv_many = findViewById(R.id.afk_tv__many_27);
                tv_many.setText(afk_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_3);
                btn.setText(R.string.many_27_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+27),afk_many[27]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[27]+=1;
                tv_many = findViewById(R.id.afk_tv__many_27);
                tv_many.setText(afk_many[27] +"/5");

                tv_plus.setText(R.string.plus_27_4);
                btn.setText(R.string.many_27_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+27),afk_many[27]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[27]+=1;
                tv_many = findViewById(R.id.afk_tv__many_27);
                tv_many.setText(afk_many[27] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+27),afk_many[27]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_28(View view) {
        btn=findViewById(R.id.afk_button_28);
        tv_plus=findViewById(R.id.afk_tv_28);
        switch (afk_many[28]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[28]+=1;
                tv_many = findViewById(R.id.afk_tv__many_28);
                tv_many.setText(afk_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_1);
                btn.setText(R.string.many_28_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+28),afk_many[28]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[28]+=1;
                tv_many = findViewById(R.id.afk_tv__many_28);
                tv_many.setText(afk_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_2);
                btn.setText(R.string.many_28_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+28),afk_many[28]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[28]+=1;
                tv_many = findViewById(R.id.afk_tv__many_28);
                tv_many.setText(afk_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_3);
                btn.setText(R.string.many_28_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+28),afk_many[28]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[28]+=1;
                tv_many = findViewById(R.id.afk_tv__many_28);
                tv_many.setText(afk_many[28] +"/5");

                tv_plus.setText(R.string.plus_28_4);
                btn.setText(R.string.many_28_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+28),afk_many[28]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[28]+=1;
                tv_many = findViewById(R.id.afk_tv__many_28);
                tv_many.setText(afk_many[28] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+28),afk_many[28]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_29(View view) {
        btn=findViewById(R.id.afk_button_29);
        tv_plus=findViewById(R.id.afk_tv_29);
        switch (afk_many[29]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[29]+=1;
                tv_many = findViewById(R.id.afk_tv__many_29);
                tv_many.setText(afk_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_1);
                btn.setText(R.string.many_29_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+29),afk_many[29]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[29]+=1;
                tv_many = findViewById(R.id.afk_tv__many_29);
                tv_many.setText(afk_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_2);
                btn.setText(R.string.many_29_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+29),afk_many[29]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[29]+=1;
                tv_many = findViewById(R.id.afk_tv__many_29);
                tv_many.setText(afk_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_3);
                btn.setText(R.string.many_29_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+29),afk_many[29]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[29]+=1;
                tv_many = findViewById(R.id.afk_tv__many_29);
                tv_many.setText(afk_many[29] +"/5");

                tv_plus.setText(R.string.plus_29_4);
                btn.setText(R.string.many_29_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+29),afk_many[29]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[29]+=1;
                tv_many = findViewById(R.id.afk_tv__many_29);
                tv_many.setText(afk_many[29] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+29),afk_many[29]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_30(View view) {
        btn=findViewById(R.id.afk_button_30);
        tv_plus=findViewById(R.id.afk_tv_30);
        switch (afk_many[30]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[30]+=1;
                tv_many = findViewById(R.id.afk_tv__many_30);
                tv_many.setText(afk_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_1);
                btn.setText(R.string.many_30_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+30),afk_many[30]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[30]+=1;
                tv_many = findViewById(R.id.afk_tv__many_30);
                tv_many.setText(afk_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_2);
                btn.setText(R.string.many_30_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+30),afk_many[30]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[30]+=1;
                tv_many = findViewById(R.id.afk_tv__many_30);
                tv_many.setText(afk_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_3);
                btn.setText(R.string.many_30_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+30),afk_many[30]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[30]+=1;
                tv_many = findViewById(R.id.afk_tv__many_30);
                tv_many.setText(afk_many[30] +"/5");

                tv_plus.setText(R.string.plus_30_4);
                btn.setText(R.string.many_30_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+30),afk_many[30]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[30]+=1;
                tv_many = findViewById(R.id.afk_tv__many_30);
                tv_many.setText(afk_many[30] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+30),afk_many[30]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_31(View view) {
        btn=findViewById(R.id.afk_button_31);
        tv_plus=findViewById(R.id.afk_tv_31);
        switch (afk_many[31]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[31]+=1;
                tv_many = findViewById(R.id.afk_tv__many_31);
                tv_many.setText(afk_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_1);
                btn.setText(R.string.many_31_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+31),afk_many[31]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[31]+=1;
                tv_many = findViewById(R.id.afk_tv__many_31);
                tv_many.setText(afk_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_2);
                btn.setText(R.string.many_31_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+31),afk_many[31]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[31]+=1;
                tv_many = findViewById(R.id.afk_tv__many_31);
                tv_many.setText(afk_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_3);
                btn.setText(R.string.many_31_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+31),afk_many[31]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[31]+=1;
                tv_many = findViewById(R.id.afk_tv__many_31);
                tv_many.setText(afk_many[31] +"/5");

                tv_plus.setText(R.string.plus_31_4);
                btn.setText(R.string.many_31_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+31),afk_many[31]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[31]+=1;
                tv_many = findViewById(R.id.afk_tv__many_31);
                tv_many.setText(afk_many[31] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+31),afk_many[31]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_32(View view) {
        btn=findViewById(R.id.afk_button_32);
        tv_plus=findViewById(R.id.afk_tv_32);
        switch (afk_many[32]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[32]+=1;
                tv_many = findViewById(R.id.afk_tv__many_32);
                tv_many.setText(afk_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_1);
                btn.setText(R.string.many_32_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+32),afk_many[32]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[32]+=1;
                tv_many = findViewById(R.id.afk_tv__many_32);
                tv_many.setText(afk_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_2);
                btn.setText(R.string.many_32_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+32),afk_many[32]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[32]+=1;
                tv_many = findViewById(R.id.afk_tv__many_32);
                tv_many.setText(afk_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_3);
                btn.setText(R.string.many_32_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+32),afk_many[32]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[32]+=1;
                tv_many = findViewById(R.id.afk_tv__many_32);
                tv_many.setText(afk_many[32] +"/5");

                tv_plus.setText(R.string.plus_32_4);
                btn.setText(R.string.many_32_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+32),afk_many[32]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[32]+=1;
                tv_many = findViewById(R.id.afk_tv__many_32);
                tv_many.setText(afk_many[32] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+32),afk_many[32]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_33(View view) {
        btn=findViewById(R.id.afk_button_33);
        tv_plus=findViewById(R.id.afk_tv_33);
        switch (afk_many[33]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[33]+=1;
                tv_many = findViewById(R.id.afk_tv__many_33);
                tv_many.setText(afk_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_1);
                btn.setText(R.string.many_33_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+33),afk_many[33]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[33]+=1;
                tv_many = findViewById(R.id.afk_tv__many_33);
                tv_many.setText(afk_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_2);
                btn.setText(R.string.many_33_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+33),afk_many[33]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[33]+=1;
                tv_many = findViewById(R.id.afk_tv__many_33);
                tv_many.setText(afk_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_3);
                btn.setText(R.string.many_33_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+33),afk_many[33]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[33]+=1;
                tv_many = findViewById(R.id.afk_tv__many_33);
                tv_many.setText(afk_many[33] +"/5");

                tv_plus.setText(R.string.plus_33_4);
                btn.setText(R.string.many_33_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+33),afk_many[33]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[33]+=1;
                tv_many = findViewById(R.id.afk_tv__many_33);
                tv_many.setText(afk_many[33] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+33),afk_many[33]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_34(View view) {
        btn=findViewById(R.id.afk_button_34);
        tv_plus=findViewById(R.id.afk_tv_34);
        switch (afk_many[34]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[34]+=1;
                tv_many = findViewById(R.id.afk_tv__many_34);
                tv_many.setText(afk_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_1);
                btn.setText(R.string.many_34_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+34),afk_many[34]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[34]+=1;
                tv_many = findViewById(R.id.afk_tv__many_34);
                tv_many.setText(afk_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_2);
                btn.setText(R.string.many_34_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+34),afk_many[34]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[34]+=1;
                tv_many = findViewById(R.id.afk_tv__many_34);
                tv_many.setText(afk_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_3);
                btn.setText(R.string.many_34_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+34),afk_many[34]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[34]+=1;
                tv_many = findViewById(R.id.afk_tv__many_34);
                tv_many.setText(afk_many[34] +"/5");

                tv_plus.setText(R.string.plus_34_4);
                btn.setText(R.string.many_34_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+34),afk_many[34]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[34]+=1;
                tv_many = findViewById(R.id.afk_tv__many_34);
                tv_many.setText(afk_many[34] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+34),afk_many[34]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_35(View view) {
        btn=findViewById(R.id.afk_button_35);
        tv_plus=findViewById(R.id.afk_tv_35);
        switch (afk_many[35]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[35]+=1;
                tv_many = findViewById(R.id.afk_tv__many_35);
                tv_many.setText(afk_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_1);
                btn.setText(R.string.many_35_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+35),afk_many[35]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[35]+=1;
                tv_many = findViewById(R.id.afk_tv__many_35);
                tv_many.setText(afk_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_2);
                btn.setText(R.string.many_35_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+35),afk_many[35]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[35]+=1;
                tv_many = findViewById(R.id.afk_tv__many_35);
                tv_many.setText(afk_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_3);
                btn.setText(R.string.many_35_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+35),afk_many[35]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[35]+=1;
                tv_many = findViewById(R.id.afk_tv__many_35);
                tv_many.setText(afk_many[35] +"/5");

                tv_plus.setText(R.string.plus_35_4);
                btn.setText(R.string.many_35_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+35),afk_many[35]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[35]+=1;
                tv_many = findViewById(R.id.afk_tv__many_35);
                tv_many.setText(afk_many[35] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+35),afk_many[35]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_36(View view) {
        btn=findViewById(R.id.afk_button_36);
        tv_plus=findViewById(R.id.afk_tv_36);
        switch (afk_many[36]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[36]+=1;
                tv_many = findViewById(R.id.afk_tv__many_36);
                tv_many.setText(afk_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_1);
                btn.setText(R.string.many_36_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+36),afk_many[36]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[36]+=1;
                tv_many = findViewById(R.id.afk_tv__many_36);
                tv_many.setText(afk_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_2);
                btn.setText(R.string.many_36_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+36),afk_many[36]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[36]+=1;
                tv_many = findViewById(R.id.afk_tv__many_36);
                tv_many.setText(afk_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_3);
                btn.setText(R.string.many_36_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+36),afk_many[36]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[36]+=1;
                tv_many = findViewById(R.id.afk_tv__many_36);
                tv_many.setText(afk_many[36] +"/5");

                tv_plus.setText(R.string.plus_36_4);
                btn.setText(R.string.many_36_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+36),afk_many[36]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[36]+=1;
                tv_many = findViewById(R.id.afk_tv__many_36);
                tv_many.setText(afk_many[36] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+36),afk_many[36]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_37(View view) {
        btn=findViewById(R.id.afk_button_37);
        tv_plus=findViewById(R.id.afk_tv_37);
        switch (afk_many[37]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[37]+=1;
                tv_many = findViewById(R.id.afk_tv__many_37);
                tv_many.setText(afk_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_1);
                btn.setText(R.string.many_37_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+37),afk_many[37]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[37]+=1;
                tv_many = findViewById(R.id.afk_tv__many_37);
                tv_many.setText(afk_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_2);
                btn.setText(R.string.many_37_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+37),afk_many[37]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[37]+=1;
                tv_many = findViewById(R.id.afk_tv__many_37);
                tv_many.setText(afk_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_3);
                btn.setText(R.string.many_37_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+37),afk_many[37]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[37]+=1;
                tv_many = findViewById(R.id.afk_tv__many_37);
                tv_many.setText(afk_many[37] +"/5");

                tv_plus.setText(R.string.plus_37_4);
                btn.setText(R.string.many_37_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+37),afk_many[37]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[37]+=1;
                tv_many = findViewById(R.id.afk_tv__many_37);
                tv_many.setText(afk_many[37] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+37),afk_many[37]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_38(View view) {
        btn=findViewById(R.id.afk_button_38);
        tv_plus=findViewById(R.id.afk_tv_38);
        switch (afk_many[38]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[38]+=1;
                tv_many = findViewById(R.id.afk_tv__many_38);
                tv_many.setText(afk_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_1);
                btn.setText(R.string.many_38_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+38),afk_many[38]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[38]+=1;
                tv_many = findViewById(R.id.afk_tv__many_38);
                tv_many.setText(afk_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_2);
                btn.setText(R.string.many_38_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+38),afk_many[38]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[38]+=1;
                tv_many = findViewById(R.id.afk_tv__many_38);
                tv_many.setText(afk_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_3);
                btn.setText(R.string.many_38_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+38),afk_many[38]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[38]+=1;
                tv_many = findViewById(R.id.afk_tv__many_38);
                tv_many.setText(afk_many[38] +"/5");

                tv_plus.setText(R.string.plus_38_4);
                btn.setText(R.string.many_38_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+38),afk_many[38]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[38]+=1;
                tv_many = findViewById(R.id.afk_tv__many_38);
                tv_many.setText(afk_many[38] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+38),afk_many[38]);
                b_0.apply();

            }
                break;
            default:break;
        }}
    @SuppressLint("SetTextI18n")
    public void afk_button_39(View view) {
        btn=findViewById(R.id.afk_button_39);
        tv_plus=findViewById(R.id.afk_tv_39);
        switch (afk_many[39]){


            case 0: if(score.compareTo(new BigInteger("10")) >= 0) {
                afk=afk.add(new BigInteger("1"));
                score=score.subtract(new BigInteger("10"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[39]+=1;
                tv_many = findViewById(R.id.afk_tv__many_39);
                tv_many.setText(afk_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_1);
                btn.setText(R.string.many_39_1);





                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+39),afk_many[39]);
                b_0.apply();

            }
                break;
            case 1: if(score.compareTo(new BigInteger("20")) >= 0) {
                afk=afk.add(new BigInteger("2"));
                score=score.subtract(new BigInteger("20"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[39]+=1;
                tv_many = findViewById(R.id.afk_tv__many_39);
                tv_many.setText(afk_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_2);
                btn.setText(R.string.many_39_2);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+39),afk_many[39]);
                b_0.apply();

            }
                break;
            case 2: if(score.compareTo(new BigInteger("30")) >= 0) {
                afk=afk.add(new BigInteger("3"));
                score=score.subtract(new BigInteger("30"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[39]+=1;
                tv_many = findViewById(R.id.afk_tv__many_39);
                tv_many.setText(afk_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_3);
                btn.setText(R.string.many_39_3);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+39),afk_many[39]);
                b_0.apply();

            }
                break;
            case 3: if(score.compareTo(new BigInteger("40")) >= 0) {
                afk=afk.add(new BigInteger("4"));
                score=score.subtract(new BigInteger("40"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[39]+=1;
                tv_many = findViewById(R.id.afk_tv__many_39);
                tv_many.setText(afk_many[39] +"/5");

                tv_plus.setText(R.string.plus_39_4);
                btn.setText(R.string.many_39_4);

                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+39),afk_many[39]);
                b_0.apply();

            }
                break;
            case 4: if(score.compareTo(new BigInteger("50")) >= 0) {
                afk=afk.add(new BigInteger("5"));
                score=score.subtract(new BigInteger("50"));
                tv_afk = findViewById(R.id.afk_tv);
                tv_afk.setText(chenge(afk));
                tv_score = findViewById(R.id.score);
                tv_score.setText(chenge(score));
                afk_many[39]+=1;
                tv_many = findViewById(R.id.afk_tv__many_39);
                tv_many.setText(afk_many[39] +"/5");

                tv_plus.setText(R.string.end);
                btn.setText(R.string.end);
                btn.setEnabled(false);



                SharedPreferences save_afk_button_0 = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor b_0 = save_afk_button_0.edit();
                b_0.putInt(Integer.toString(many_button+39),afk_many[39]);
                b_0.apply();

            }
                break;
            default:break;
        }}





}