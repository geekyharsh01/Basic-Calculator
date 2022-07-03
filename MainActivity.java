package com.example.calculatorz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView inputText , outputText;
    private String input, output;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,clear_button,power_button,division_button,percent_button,
    multiply_btn,minus_btn,add_btn,dot_btn,output_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        add_btn = findViewById(R.id.add_btn);
        dot_btn = findViewById(R.id.dot_btn);
        output_btn = findViewById(R.id.output_btn);
        power_button = findViewById(R.id.power_button);
        division_button = findViewById(R.id.division_button);
        percent_button = findViewById(R.id.percent_button);
        multiply_btn = findViewById(R.id.multiply_btn);
        minus_btn = findViewById(R.id.minus_btn);
        clear_button = findViewById(R.id.clear_button);


    }

    public void onButtonClicked(View view){
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "C":
                input = null;
                output = null;

                outputText.setText("");
                break;
            case "^":
                solve();
                input+="^";

                break;
            case "*":
                solve();
                input+="*";

                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if(input==null){
                    input = "";
                }
                if(data.equals("+")||data.equals("-")||data.equals("/")){
                    solve();
                }
                input+=data;

        }
        inputText.setText(input);
    }
    private void solve(){
        if(input.split("\\+").length==2){
            String numbers [] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);

                output = String.format("%.5f", d);
                double d1 = Double.parseDouble(output);

                outputText.setText(output);
                input = d1 + "";
            }catch (Exception e){
//                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\*").length==2){
            String numbers [] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);

                output = String.format("%.5f", d);
                double d1 = Double.parseDouble(output);

                outputText.setText(output);
                input = d1 + "";
            }catch (Exception e){
//                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\/").length==2){
            String numbers [] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);

                output = String.format("%.5f", d);
                double d1 = Double.parseDouble(output);

                outputText.setText(output);
                input = d1 + "";
            }catch (Exception e){
//                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\-").length==2){
            String numbers [] = input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);

                output = String.format("%.5f", d);
                double d1 = Double.parseDouble(output);

                outputText.setText(output);
                input = d1 + "";
            }catch (Exception e){
//                outputText.setError(e.getMessage().toString());
            }
        }

        if(input.split("\\^").length==2){
            String numbers [] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));

                output = String.format("%.5f", d);
                double d1 = Double.parseDouble(output);

                outputText.setText(output);
                input = d1 + "";
            }catch (Exception e){
//                outputText.setError(e.getMessage().toString());
            }
        }


    }


}