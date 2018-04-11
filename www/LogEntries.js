module.exports = {
    log: function (message, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "LogEntries", "log", [message]);
    }
};
