package com.example.spenex;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.samsung.sdraw.CanvasView;
import com.samsung.sdraw.CanvasView.OnHistoryChangeListener;
import com.samsung.sdraw.SDrawLibrary;
import com.samsung.sdraw.SettingView;

public class MainActivity extends Activity implements OnClickListener{

    private RadioButton penButton;
    private RadioButton eraserButton;
    private RadioGroup penGroup;
    private Button undoButton;
    private Button redoButton;

    private CanvasView canvas;
    private SettingView settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        penButton = findViewById(R.id.penRadio);
        eraserButton = findViewById(R.id.eraserRadio);
        penGroup = findViewById(R.id.penGroup);
        undoButton = findViewById(R.id.undo);
        redoButton = findViewById(R.id.redo);

        penGroup.setOnCheckedChangeListener(radioListener);
        penButton.setOnClickListener(this);
        eraserButton.setOnClickListener(this);
        undoButton.setOnClickListener(this);
        redoButton.setOnClickListener(this);

        canvas = findViewById(R.id.canvas);
        settings = findViewById(R.id.setting);

        canvas.setSettingView(settings);
        canvas.setOnHistoryChangeListener(historyListener);

        if(!SDrawLibrary.isSupportedModel()){
            Toast.makeText(getApplicationContext(), "Not supported model.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private OnHistoryChangeListener historyListener = new OnHistoryChangeListener(){

        public void onHistoryChanged(boolean undoable, boolean redoable) {
            undoButton.setEnabled(undoable);
            redoButton.setEnabled(redoable);
        }

    };

    private OnCheckedChangeListener radioListener = new OnCheckedChangeListener(){

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.penRadio:
                    canvas.changeModeTo(CanvasView.PEN_MODE);
                    break;

                case R.id.eraserRadio:
                    canvas.changeModeTo(CanvasView.ERASER_MODE);
                    break;
            }
        }

    };

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.penRadio:
                if(settings.isShown(SettingView.PEN_SETTING_VIEW)){
                    settings.closeView();
                }else{
                    settings.showView(SettingView.PEN_SETTING_VIEW);
                }
                break;

            case R.id.eraserRadio:
                if(settings.isShown(SettingView.ERASER_SETTING_VIEW)){
                    settings.closeView();
                }else{
                    settings.showView(SettingView.ERASER_SETTING_VIEW);
                }
                break;
            case R.id.undo:
                canvas.undo();
                break;

            case R.id.redo:
                canvas.redo();
                break;
        }

    }


}
