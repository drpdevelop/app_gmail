package com.movilespascual.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DetailEmail extends AppCompatActivity {

    private TextView subjectTextView, senderTextView, dateTextView, bodyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_email);


        subjectTextView = findViewById(R.id.email_subject);
        senderTextView = findViewById(R.id.email_sender);
        dateTextView = findViewById(R.id.email_date);
        bodyTextView = findViewById(R.id.email_body);

        String name = getIntent().getStringExtra("name");
        String ciudad = getIntent().getStringExtra("ciudad");
        String estado = getIntent().getStringExtra("estado");
        String mensaje = "Hola mi nombre es: ".concat(name).concat(" Estimado/a Señor@,\n" +
                "\n" +
                "Espero que este correo electrónico le encuentre bien. Me dirijo a usted porque [razón por la que estás escribiendo].\n" +
                "\n" +
                "Quería informarle que [información importante relacionada con la razón por la que estás escribiendo]. Además, quisiera [acción específica que esperas que el destinatario haga, si aplica].\n" +
                "\n" +
                "Por favor, no dude en ponerse en contacto conmigo si tiene alguna pregunta o si necesita más información sobre este tema. Estoy a su disposición para ayudarlo/a en lo que necesite.\n" +
                "\n" +
                "Muchas gracias por su tiempo y consideración.\n" +
                "\n" +
                "Atentamente, ").concat(name);





        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);

        subjectTextView.setText(name.concat(" De la ciudad de ").concat(ciudad));
        senderTextView.setText("Mensaje: ".concat(estado));
        dateTextView.setText(formattedDate);
        bodyTextView.setText(mensaje);
    }
}