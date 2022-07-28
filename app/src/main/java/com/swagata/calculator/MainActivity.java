package com.swagata.calculator;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
TextView tv_c,tv_mul,tv_7,tv_8,tv_9,tv_div,tv_4,tv_5,tv_6,tv_sub,tv_1,tv_2,tv_3,tv_add,tv_0,tv_dot,tv_equal,ans,statement;
ImageView iv_ba;
boolean f=false;
String statementstr="",ansstr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        statement=findViewById(R.id.statement);
        ans=findViewById(R.id.ans);
        tv_c=findViewById(R.id.tv_c);
        tv_mul=findViewById(R.id.tv_mul);
        tv_7=findViewById(R.id.tv_7);
        tv_8=findViewById(R.id.tv_8);
        tv_9=findViewById(R.id.tv_9);
        tv_div=findViewById(R.id.tv_div);
        tv_4=findViewById(R.id.tv_4);
        tv_5=findViewById(R.id.tv_5);
        tv_6=findViewById(R.id.tv_6);
        tv_3=findViewById(R.id.tv_3);
        tv_2=findViewById(R.id.tv_2);
        tv_1=findViewById(R.id.tv_1);
        tv_sub=findViewById(R.id.tv_sub);
        tv_add=findViewById(R.id.tv_add);
        tv_0=findViewById(R.id.tv_0);
        tv_dot=findViewById(R.id.tv_dot);
        tv_equal=findViewById(R.id.tv_equal);
        iv_ba=findViewById(R.id.iv_ba);


        tv_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statement.setText("");
                ans.setText("0");
                statementstr="";
                ansstr="";
            }
        });
        tv_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("*");
            }
        });
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("+");
            }
        });
        tv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("-");
            }
        });
        tv_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set(".");
            }
        });
        tv_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solve();
            }
        });
        tv_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("9");
            }
        });
        tv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("8");
            }
        });
        tv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("7");
            }
        });
        tv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("6");
            }
        });
        tv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("5");
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("4");
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("3");
            }
        });
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("2");
            }
        });
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("1");
            }
        });
        tv_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("0");
            }
        });
        iv_ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statementstr=statementstr.substring(0,statementstr.length()-1);
                statement.setText(statementstr);
            }
        });
        tv_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set("/");
            }
        });
    }
    void set(String str1){
        statementstr=statementstr+str1;
        statement.setText(statementstr);
    }
    public void solve()
    {
        try {
            char p=statementstr.charAt(statementstr.length()-1);
            if(p=='/' || p=='*' || p=='-' || p=='+') {
                f = false;
                return;
            }
            else
            {
                f=true;
            }
            BigDecimal result=null;
            Expression expression=new Expression(statementstr);
            result=expression.eval(); // 1.333333
            // Lowering the precision.
            expression.setPrecision(5);
            result=expression.eval(); // 1.3
            result= BigDecimal.valueOf(result.intValue());
            ans.setText(String.valueOf(result));
        }
        catch (Exception e){
            statement.setText("");
            ans.setText("0");
            statementstr="";
            ansstr="";
        }
    }
}