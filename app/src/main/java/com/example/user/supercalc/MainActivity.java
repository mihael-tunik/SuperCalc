package com.example.user.supercalc;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Evaluate, Erase, BackSpace, Zero, One,
            Two, Three, Four, Five, Six, Seven, Eight, Nine, Left, Right, Plus, Minus, Mult, Div ;
    TextView ExprEdit, OutLine;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Evaluate = (Button)findViewById(R.id.button_equal);
        Erase = (Button)findViewById(R.id.button_erase);
        BackSpace = (Button)findViewById(R.id.button_back);

        Zero = (Button)findViewById(R.id.button_number_0);
        One = (Button)findViewById(R.id.button_number_1);
        Two = (Button)findViewById(R.id.button_number_2);
        Three = (Button)findViewById(R.id.button_number_3);
        Four = (Button)findViewById(R.id.button_number_4);
        Five = (Button)findViewById(R.id.button_number_5);
        Six = (Button)findViewById(R.id.button_number_6);
        Seven  = (Button)findViewById(R.id.button_number_7);
        Eight = (Button)findViewById(R.id.button_number_8);
        Nine  = (Button)findViewById(R.id.button_number_9);
        Left  = (Button)findViewById(R.id.button_left);
        Right = (Button)findViewById(R.id.button_right);
        Plus = (Button)findViewById(R.id.button_op_plus);
        Minus = (Button)findViewById(R.id.button_op_minus);
        Mult = (Button)findViewById(R.id.button_op_mult);
        Div = (Button)findViewById(R.id.button_op_div);

        ExprEdit   = (TextView)findViewById(R.id.ExprLine);
        OutLine = (TextView)findViewById(R.id.ResultString);



        Erase.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.setText("");
                    }
                });

        Evaluate.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        String Rpn = Calc.infixToPostfix(  ExprEdit.getText().toString()  );
                        double Calculated =  Calc.calcRPN(Rpn);
                        String Result = Double.toString(Calculated);

                        OutLine.setText("Result:");
                        OutLine.append(Result);
                    }
                });

        BackSpace.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        String BackSpaced = ExprEdit.getText().toString();
                        if(BackSpaced.length() > 0)
                            ExprEdit.setText(BackSpaced.substring(0, BackSpaced.length() - 1));
                    }
                });

        Zero.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("0");
                    }
                });
        One.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("1");
                    }
                });
        Two.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("2");
                    }
                });
        Three.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("3");
                    }
                });
        Four.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("4");
                    }
                });
        Five.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("5");
                    }
                });
        Six.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("6");
                    }
                });
        Seven.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("7");
                    }
                });
        Eight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("8");
                    }
                });
        Nine.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append("9");
                    }
                });
        Left.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" ( ");
                    }
                });
        Right.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" ) ");
                    }
                });
        Plus.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" + ");
                    }
                });
        Minus.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" - ");
                    }
                });
        Mult.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" * ");
                    }
                });
        Div.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ExprEdit.append(" / ");
                    }
                });

    }

}