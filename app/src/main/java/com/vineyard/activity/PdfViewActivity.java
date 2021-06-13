package com.vineyard.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.vineyard.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView; //pdfView object
    static String URL;
    static String fileName;
    File directory; //path of created File

    // Container for all parameters of DownloadAsync
    private static class AsyncParameters {
        String URL;
        File directory;

        AsyncParameters(String URL, File directory) {
            this.URL = URL;
            this.directory = directory;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_pdf_view);

        // Возьмите дополнения от намеренного вызова
        Intent intent = getIntent(); //что бы ни вызывало это действие, собери намерение
        URL = intent.getStringExtra("File URL"); // в этом случае получить имя файла «лишнего», переданного через
        fileName = intent.getStringExtra("File Name");

        //Захватить внутренний каталог хранения и создать папку, если она не существует
        File intDirectory = getFilesDir();
        File folder = new File(intDirectory, "pdf");
        boolean isDirectoryCreated = folder.exists();

        //Посмотрите, существует ли файл
        if (!isDirectoryCreated) {
            isDirectoryCreated = folder.mkdir();
        }

        if (isDirectoryCreated) {
            directory = new File(folder, fileName);
            try {
                directory.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //See if file already exists (reduces wait time)
            boolean empty = directory.length() == 0;
            if (empty) {
                /**Call class to create parameter container **/
                AsyncParameters param = new AsyncParameters(URL, directory);
                DownloadAsync Downloader = new DownloadAsync();
                Downloader.execute(param);
            }
            showPdf();
        }
    }

    /**
     * class for library showPdf
     **/
    public void showPdf() {
        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromFile(directory).load();
    }

    /**
     * Class for asynchronous tasks
     **/
    public class DownloadAsync extends AsyncTask<AsyncParameters, Void, Void> {

        // Container for all parameters of DownloadAsync
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            //Create a progress bar that details the program downloading
            super.onPreExecute();
            // pDialog = new ProgressDialog(PdfView.this);
            pDialog = new ProgressDialog(PdfViewActivity.this, R.style.ProgressDialogTheme);
            //pDialog.setProgressStyle(R.style.ProgressDialogTheme);
            pDialog.setMessage("Downloading Database...");
            String message = "Книга завантажується";

            SpannableString ss2 = new SpannableString(message);
            // розмір тексту
            ss2.setSpan(new RelativeSizeSpan(1.3f), 0, ss2.length(), 0);
            // колір тексту
            // ss2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorApp)), 0, ss2.length(), 0);

            pDialog.setMessage(ss2);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(AsyncParameters... params) {
            /**grab the container AsyncParameters and the values within it**/
            String fileURL = params[0].URL;
            File directory = params[0].directory;
            try {
                FileOutputStream f = new FileOutputStream(directory);
                java.net.URL u = new URL(fileURL);
                HttpURLConnection c = (HttpURLConnection) u.openConnection();
                c.connect();
                InputStream in = c.getInputStream();

                byte[] buffer = new byte[8192];
                int len1 = 0;
                while ((len1 = in.read(buffer)) > 0) {
                    f.write(buffer, 0, len1);
                }
                f.close();
            } catch (Exception e) {
                e.printStackTrace();
                pDialog.setMessage(new SpannableString("ERROR DOWNLOADING"));
            }
            onPostExecute();
            return null;
        }

        private void onPostExecute() {
            pDialog.dismiss();
            showPdf();
        }
    }
}
