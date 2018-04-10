module.exports = {
    init: function (token, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "LogEntries", "init", [token]);
    }, 
    log: function (message, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "LogEntries", "log", [message]);
    }
};
