package sg.edu.rp.c346.id20017533.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    String click = "";
    boolean toggleDBS = false;
    boolean toggleOCBC = false;
    boolean toggleUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
        registerForContextMenu(tv3);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tv1) {
            click = "DBS";
        } else if (v == tv2) {
            click = "OCBC";
        } else if (v == tv3) {
            click = "UOB";
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (click.equalsIgnoreCase("DBS")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.dbs.com.sg")));
                startActivity(intent);
                return true;
            } else if (id == R.id.contact) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:" + "18001111111")));
                startActivity(intent);
                return true;
            } else if (id == R.id.Toggle) {
                if (!toggleDBS) {
                    toggleDBS = true;
                    tv1.setTextColor(Color.RED);
                } else {
                    toggleDBS = false;
                    tv1.setTextColor(Color.BLACK);
                }
            }
        } else if (click.equalsIgnoreCase("OCBC")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.ocbc.com")));
                startActivity(intent);
                return true;
            } else if (id == R.id.contact) { //check if the selected menu item ID is 1
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:" + "18003633333")));
                startActivity(intent);
                return true;
            } else if (id == R.id.Toggle) {
                if (!toggleOCBC) {
                    toggleOCBC = true;
                    tv2.setTextColor(Color.RED);
                } else {
                    toggleOCBC = false;
                    tv2.setTextColor(Color.BLACK);
                }
            }
        } else if (click.equalsIgnoreCase("UOB")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.uob.com.sg")));
                startActivity(intent);
                return true;
            } else if (id == R.id.contact) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:" + "18002222121")));
                startActivity(intent);
                return true;
            } else if (id == R.id.Toggle) {
                if (!toggleUOB) {
                    toggleUOB = true;
                    tv3.setTextColor(Color.RED);
                } else {
                    toggleUOB = false;
                    tv3.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.English) {
            tv1.setText("DBS");
            tv2.setText("OCBC");
            tv3.setText("UOB");
            return true;
        } else if (id == R.id.Chinese) {
            tv1.setText("星展银行");
            tv2.setText("华侨银行");
            tv3.setText("大华银行");
            return true;
        } else {
            tv1.setText("Error translation");
            tv2.setText("Error translation");
            tv3.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }
}