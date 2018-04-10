package com.spoonconsulting.LogEntries;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.logentries.logger.AndroidLogger;
import java.io.IOException;

public class LogEntries extends CordovaPlugin {

    AndroidLogger logger;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("init")) {
            try {
                if (args.length() > 0){
                    String token = args.get(0).toString();
                    logger = AndroidLogger.createInstance(this.cordova.getActivity().getApplicationContext(), false, false, false, null, 0, token, true);
                }else{
                    PluginResult errorResult = new PluginResult(PluginResult.Status.ERROR, "Token not specified");
                    errorResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(errorResult);
                }
               
            } catch (IOException e) {
                e.printStackTrace();
                PluginResult errorResult = new PluginResult(PluginResult.Status.ERROR, e.getMessage());
                errorResult.setKeepCallback(true);
                callbackContext.sendPluginResult(errorResult);
            }
            return true;

        }else if (action.equals("log")) {
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
