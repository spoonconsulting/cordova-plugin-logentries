package com.spoonconsulting.LogEntries;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.logentries.logger.AndroidLogger;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;


public class LogEntries extends CordovaPlugin {

    AndroidLogger logger;
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Context context = this.cordova.getActivity();
        packageName = context.getPackageName();
        Resources resources = context.getResources();
        
        String token = context.getString(resources.getIdentifier("LOG_ENTRIES_API_KEY", "string", packageName));
        logger = AndroidLogger.createInstance(this.cordova.getActivity().getApplicationContext(), false, false, false, null, 0, token, true);
             
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("log")) {
            if (logger !=null){
                 if (args.length() > 0){
                    String msg = args.get(0).toString();
                    logger.log(msg);
                }else{
                    PluginResult errorResult = new PluginResult(PluginResult.Status.ERROR, "parameter not specified");
                    errorResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(errorResult);
                }
            }else{
                PluginResult errorResult = new PluginResult(PluginResult.Status.ERROR,"Logger not initialised. Call init first");
                errorResult.setKeepCallback(true);
                callbackContext.sendPluginResult(errorResult);
            }
             return true;
        }else {
            
            return false;
        }
    }
}
