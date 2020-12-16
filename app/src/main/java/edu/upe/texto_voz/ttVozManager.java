package edu.upe.texto_voz;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class ttVozManager {
    TextToSpeech mTts=null;
    boolean isloaded=false;
    public void init(Context context){
        try{
            mTts=new TextToSpeech(context,onInitListener);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private TextToSpeech.OnInitListener onInitListener=new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            Locale language=new Locale("es","PE");
            if (status==TextToSpeech.SUCCESS);
                int resul=mTts.setLanguage(language);
                isloaded=true;
                if(resul==TextToSpeech.LANG_MISSING_DATA || resul==TextToSpeech.LANG_NOT_SUPPORTED)
                    Log.e("error","este lenguaje no esta soportado");
        }
    };
    public void apagar(){
        mTts.shutdown();
    }
    public void agregarCola(String texto){
        if(isloaded)mTts.speak(texto,TextToSpeech.QUEUE_ADD,null);
        else Log.e("error","TTS no inicializado");

    }
    public void iniciarCola(String texto){
        if(isloaded)mTts.speak(texto,TextToSpeech.QUEUE_FLUSH,null);
        else Log.e("error","TTS no inicializado");
    }
}
