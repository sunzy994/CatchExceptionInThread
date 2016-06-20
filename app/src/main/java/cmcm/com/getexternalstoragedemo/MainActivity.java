package cmcm.com.getexternalstoragedemo;

import android.os.*;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fixIt();
        //write2ExternalStorageAsync();

    }

    private void write2ExternalStorageAsync(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                write2ExternalStorage();
            }
        });
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }


    private void write2ExternalStorage(){
        Log.e("sunzy", "dddddddddddddddd ");
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, "download_file");
        Log.e("sunzy", "dir = " + dir);


        byte bytes[] = new byte[4096];
        OutputStream outputStream = null;
        while (true){
            try {
                //Thread.sleep(2);
                outputStream = new FileOutputStream(file, true);
               // Log.e("sunzy", "write");
                outputStream.write(bytes);

            } catch (Exception e){
                Log.wtf("sunzy", e);
            }
            try {
                outputStream.close();
            } catch (Exception e){
                Log.wtf("sunzy", e);
            }

        }


    }
    private void fixIt(){
        File f = new File("/storage/emulated/0/Android/data/com.cleanmaster.mguard_cn/files/Download");
        File f1 = new File("/storage/emulated/0/Android/data/dddd");
        f.mkdir();
        Log.v("sunzy","is file = " + f.isFile() + );
        Log.v("sunzy", "delete result = " + f.delete() + ", f rename = " + f.renameTo(new File("/storage/emulated/0/Android/data/com.cleanmaster.mguard_cn/files/Download1")));
        Log.v("sunzy", "f result = " + f.mkdirs() + ", f1 result = " + f1.mkdirs());
        Log.v("sunzy", "exist = " + f.exists());
        Log.v("sunzy", "list = " + f.listFiles());
    }
}
