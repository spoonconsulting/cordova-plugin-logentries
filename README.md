# Cordova LogEntries Plugin 

Unofficial plugin for [LogEntries](https://logentries.com)


## Installation

    $ cordova plugin add https://github.com/spoonconsulting/cordova-plugin-logentries.git

Modify or add what you need to create your custom plugin

## Init plugin
```javascript
LogEntries.init('your token-here', function(){
     console.log('initialised');
},function(){
    console.log('Error)';
});
```

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