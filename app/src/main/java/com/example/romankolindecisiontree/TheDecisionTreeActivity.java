package com.example.romankolindecisiontree;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class TheDecisionTreeActivity extends AppCompatActivity
{
    TextView textView5optimaldecision;
    EditText editText1demand1;
    EditText editText2demand2;
    EditText editText3demand3;
    EditText editText4demand4;
    EditText editText5probability1;
    EditText editText6probability2;
    EditText editText7probability3;
    EditText editText8probability4;
    EditText editText9profit;
    EditText editText10loss;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thedecisiontreeactivity);

        textView5optimaldecision = findViewById(R.id.textView5optimaldecision);
        editText1demand1 = findViewById(R.id.editText1demand1);
        editText2demand2 = findViewById(R.id.editText2demand2);
        editText3demand3 = findViewById(R.id.editText3demand3);
        editText4demand4 = findViewById(R.id.editText4demand4);
        editText5probability1 = findViewById(R.id.editText5probability1);
        editText6probability2 = findViewById(R.id.editText6probability2);
        editText7probability3 = findViewById(R.id.editText7probability3);
        editText8probability4 = findViewById(R.id.editText8probability4);
        editText9profit = findViewById(R.id.editText9profit);
        editText10loss = findViewById(R.id.editText10loss);
    }

    @SuppressLint("SetTextI18n")
    public void onclickoptimaldecision(View optimaldecision)
    {
        textView5optimaldecision.setText("");

        if (editText1demand1.getText().toString().equals("") || editText2demand2.getText().toString().equals("") || editText3demand3.getText().toString().equals("") || editText4demand4.getText().toString().equals("") || editText5probability1.getText().toString().equals("") || editText6probability2.getText().toString().equals("") || editText7probability3.getText().toString().equals("") || editText8probability4.getText().toString().equals("") || editText9profit.getText().toString().equals("") || editText10loss.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Заполните все поля", Toast.LENGTH_LONG).show();
        else
        {
            double d1, d2, d3, d4, p1, p2, p3, p4, prof, loss, dec1, dec2, dec3, dec4, optdec, optdecdem;

            d1 = Double.parseDouble(editText1demand1.getText().toString());
            d2 = Double.parseDouble(editText2demand2.getText().toString());
            d3 = Double.parseDouble(editText3demand3.getText().toString());
            d4 = Double.parseDouble(editText4demand4.getText().toString());
            p1 = Double.parseDouble(editText5probability1.getText().toString());
            p2 = Double.parseDouble(editText6probability2.getText().toString());
            p3 = Double.parseDouble(editText7probability3.getText().toString());
            p4 = Double.parseDouble(editText8probability4.getText().toString());
            prof = Double.parseDouble(editText9profit.getText().toString());
            loss = Double.parseDouble(editText10loss.getText().toString()) - (Double.parseDouble(editText10loss.getText().toString()) * 2);

            if (p1 > 1 || p2 > 1 || p3 > 1 || p4 > 1)
                Toast.makeText(getApplicationContext(), "Вероятность должна быть меньше или равна единице", Toast.LENGTH_LONG).show();
            else
            {
                dec1 = ((d1 * loss + d1 * prof) * p1) + ((d1 * loss + d1 * prof) * p2) + ((d1 * loss + d1 * prof) * p3) + ((d1 * loss + d1 * prof) * p4);
                dec2 = ((d2 * loss + d1 * prof) * p1) + ((d2 * loss + d2 * prof) * p2) + ((d2 * loss + d2 * prof) * p3) + ((d2 * loss + d2 * prof) * p4);
                dec3 = ((d3 * loss + d1 * prof) * p1) + ((d3 * loss + d2 * prof) * p2) + ((d3 * loss + d3 * prof) * p3) + ((d3 * loss + d3 * prof) * p4);
                dec4 = ((d4 * loss + d1 * prof) * p1) + ((d4 * loss + d2 * prof) * p2) + ((d4 * loss + d3 * prof) * p3) + ((d4 * loss + d4 * prof) * p4);

                double[] dem = new double[] {d1, d2, d3, d4};
                double[] dec = new double[] {dec1, dec2, dec3, dec4};
                optdec = 0;
                optdecdem = 0;
                for (int i = 0; i < 4; i++)
                    if (optdec < dec[i])
                    {
                        optdec = dec[i];
                        optdecdem = dem[i];
                    }

                DecimalFormat df = new DecimalFormat("#.##");
                textView5optimaldecision.setText("Выигрыши при спросе в \n" +
                        String.valueOf(d1).substring(0, String.valueOf(d1).length() - 2) + " = " + df.format(dec1) + ", \n" +
                        String.valueOf(d2).substring(0, String.valueOf(d2).length() - 2) + " = " + df.format(dec2) + ", \n" +
                        String.valueOf(d3).substring(0, String.valueOf(d3).length() - 2) + " = " + df.format(dec3) + ", \n" +
                        String.valueOf(d4).substring(0, String.valueOf(d4).length() - 2) + " = " + df.format(dec4) + " \n" +
                        "Оптимальное решение: \n" +
                        "при спросе в " + String.valueOf(optdecdem).substring(0, String.valueOf(optdecdem).length() - 2));
            }
        }
    }
}