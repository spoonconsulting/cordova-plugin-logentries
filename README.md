# Cordova LogEntries Plugin 

Unofficial plugin for [LogEntries](https://logentries.com)


## Installation

    $ cordova plugin add https://github.com/spoonconsulting/cordova-plugin-logentries.git --variable LOG_ENTRIES_API_KEY="<api_key>"


## Log event
```javascript
LogEntries.log('Hello world', function(){
     console.log('logged successfuly');
},function(){
    console.log('Error while logging');
});
```
### References

```
https://docs.logentries.com/docs/android
https://docs.logentries.com/docs/ios
```