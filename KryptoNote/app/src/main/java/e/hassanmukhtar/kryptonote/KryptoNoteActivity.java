package e.hassanmukhtar.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }



    public void onEncrypt(View v)
    {
        try
        {
            EditText kryptoView = (EditText) findViewById(R.id.key);
            String krypto = kryptoView.getText().toString();
            EditText dataView = (EditText) findViewById(R.id.data);
            String data = dataView.getText().toString();

            Cipher myModel = new Cipher(krypto);
            String myCipher = myModel.Encrypt(data);
            ((TextView) findViewById(R.id.data)).setText(myCipher);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
    public void onDecrypt(View v)
    {
        try
        {
            EditText kryptoView = (EditText) findViewById(R.id.key);
            String krypto = kryptoView.getText().toString();
            EditText dataView = (EditText) findViewById(R.id.data);
            String data = dataView.getText().toString();

            Cipher myModel = new Cipher(krypto);
            String myCipher = myModel.Decrypt(data);
            ((TextView) findViewById(R.id.data)).setText(myCipher);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
    public void onSave(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
    public void onLoad(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show = "";
            for (int c = fr.read(); c != -1; c = fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }

    }
}
