package pe.edu.cibertec.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // crear variables como atributos de la clase

    Button btnYes, btnNo, btnnNext, btnPrevious;
    ArrayList<Question> questions;
    TextView tvQuestion;
    int actualPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R --> se refiere a recursos

        btnYes = findViewById(R.id.btnYes); // aqui enlazo el boton de mi vista con la variable
        btnNo = findViewById(R.id.btnNo);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnnNext = findViewById(R.id.btnNext);
        tvQuestion = findViewById(R.id.tvQuestion);

        questions = new ArrayList<>();

        actualPosition = 0;

        loadQuestions();

        showQuestions();

        //llamar al metodo onclick para el boton yes y no

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyResponse(true);
            }

        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyResponse(false);

            }
        });

        // para pasar de una preguntya a otra

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualPosition -= 1;

                if (actualPosition == 0){
                    actualPosition = questions.size()-1;
                }
                tvQuestion.setText(questions.get(actualPosition).getName());


            }
        });

        btnnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    actualPosition += 1;

                    if (actualPosition == questions.size()){
                        actualPosition = 0;
                    }
                    tvQuestion.setText(questions.get(actualPosition).getName());


            }
        });


    }
    // verificacion de respuesta
    private void verifyResponse(boolean option) {
        Question actualQuestion = questions.get(actualPosition);
    if (option == actualQuestion.isResponse()){
        Toast.makeText(MainActivity.this, getString(R.string.answer_correct), Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(MainActivity.this, getString(R.string.answer_incorrect), Toast.LENGTH_SHORT).show();

    }
    };


    private void showQuestions() {
        tvQuestion.setText(questions.get(actualPosition).getName());

    }


    private void loadQuestions() {
        Question questionPeru = new Question(getString(R.string.peru_question), true);
        questions.add(questionPeru);

        Question questionChile = new Question(getString(R.string.chile_question), false);
        questions.add(questionChile);

        Question questionColombia = new Question(getString(R.string.colombia_question), false);
        questions.add(questionColombia);


    }

    /* otra manera de hacer el toast

        public void respCorrecta(View v){
            Toast toast = Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT);
            toast.show();
        }

        public void respIncorrecta(View v){
            Toast toast = Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT);
            toast.show();
        } */

}


