#import <Cordova/CDV.h>

@interface LogEntries : CDVPlugin

- (void)init:(CDVInvokedUrlCommand*)command;
- (void)log:(CDVInvokedUrlCommand*)command;

@end