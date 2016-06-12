
Parse.Cloud.define('hello', function(req, res) {
  res.success('Hi');
});


Parse.Cloud.define("sendAnnouncement", function(request, response) {
  var name = request.params.senderName;
  var msg = request.params.message;

  Parse.Push.send({
    channels: [ request.params.accountId ],
    data: {
      title: name,
      message: msg,
      action: "com.hello.announcement.sample.SEND_ANNOUNCEMENT",
      senderId: request.params.senderId,
      accountId: request.params.accountId
    }
  }, {
    success: function() {
      // Push was successful
      response.success("sendAnnouncement sent");
    },
    error: function(error) {
      // Handle error
      response.error("error with sendAnnouncement: " + error);
    },
    useMasterKey: true
  });
});

