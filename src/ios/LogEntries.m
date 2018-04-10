#import "LogEntries.h"
#import "lelib.h"
@implementation LogEntries

- (void)init:(CDVInvokedUrlCommand*)command{
    NSString* token = [[command arguments] objectAtIndex:0];
    CDVPluginResult* pluginResult = nil;
    if (token != nil) {
        LELog* log = [LELog sharedInstance];
        log.token = token;
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Token not specified"];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)log:(CDVInvokedUrlCommand*)command{
    NSString* parameter = [[command arguments] objectAtIndex:0];
    CDVPluginResult* pluginResult = nil;
    if (parameter != nil) {
        LELog* logger = [LELog sharedInstance];
        [logger log:parameter];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"parameter not specified"];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end