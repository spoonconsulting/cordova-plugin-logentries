#import "LogEntries.h"
#import "lelib.h"
@implementation LogEntries
- (void)pluginInitialize
{
	NSString *token = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"LOG_ENTRIES_API_KEY"];
	LELog* log = [LELog sharedInstance];
    log.token = token;
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