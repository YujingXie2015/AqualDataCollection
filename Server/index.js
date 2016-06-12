// Example express application adding the parse-server module to expose Parse
// compatible API routes.

var express = require('express');
var router = express.Router();
var ParseServer = require('parse-server').ParseServer;
var ParseDashboard = require('parse-dashboard');
var ejs = require('ejs');
var bodyParser = require('body-parser');
var path = require('path');
var bcrypt = require('bcrypt');

var databaseUri = process.env.DATABASE_URI || process.env.MONGODB_URI;

var app = express();

if (!databaseUri) {
  console.log('DATABASE_URI not specified, falling back to localhost.');
}

var api = new ParseServer({
  databaseURI: databaseUri || 'mongodb://localhost:27017/dev',
  cloud: process.env.CLOUD_CODE_MAIN || __dirname + '/cloud/main.js',
  appId: process.env.APP_ID || 'aquascale',
  masterKey: process.env.MASTER_KEY || '237', //Add your master key here. Keep it secret!
  serverURL: process.env.SERVER_URL || 'http://localhost:1337/parse',  // Don't forget to change to https if needed
  liveQuery: {
    classNames: ["Posts", "Comments"] // List of classes to support for query subscriptions
  }
});

var dashboard = new ParseDashboard({
  "apps": [
    {
      "serverURL": "http://localhost:1337/parse",
      "appId": "aquascale",
      "masterKey": "237",
      "appName": "AquaScale"
    }
  ]
});

// Client-keys like the javascript key or the .NET key are not necessary with parse-server
// If you wish you require them, you can set them as options in the initialization above:
// javascriptKey, restAPIKey, dotNetKey, clientKey

app.use(bodyParser.urlencoded({ extended: true }));

// Serve static assets from the /public folder
app.use('/public', express.static(path.join(__dirname, '/public')));

// Serve the Parse API on the /parse URL prefix
var mountPath = process.env.PARSE_MOUNT || '/parse';
app.use(mountPath, api);

// make the Parse Dashboard available at /dashboard
// app.use('/dashboard', dashboard);


// Parse Server plays nicely with the rest of your web routes
app.get('/', function(req, res) {
  res.sendFile(path.join(__dirname, '/public/mainpage.html'));
});

// There will be a test page available on the /test path of your server url
// Remove this before launching your app
app.get('/test', function(req, res) {
  res.sendFile(path.join(__dirname, '/public/test.html'));
});


// This will get to the login to Dashboard
app.get('/dashboardlogin', function(req, res) {
  // res.sendFile(path.join(__dirname, '/public/dashboardlogin.ejs'));
  res.render(path.join(__dirname, '/public/dashboardlogin.ejs'));
});


// This will post login in information to the login to Dashboard
app.post('/dashboardlogin', function(req, res) {

  if (req.body.username == "Aqua"){
    app.use('/dashboard', dashboard);
    res.redirect("/dashboard");
  }

});



// This will get to the login to Dashboard
app.get('/visitorDashboard', function(req, res) {
  // res.sendFile(path.join(__dirname, '/public/dashboardlogin.ejs'));
  res.render(path.join(__dirname, '/public/visitorDashboard.ejs'));
});



// // make the Parse Server available at /parse
// app.use('/parse', api);
//
// // make the Parse Dashboard available at /dashboard
// app.use('/dashboard', dashboard);

var port = process.env.PORT || 1337;
var httpServer = require('http').createServer(app);
httpServer.listen(port, function() {
    console.log('parse-server-example running on port ' + port + '.');
});

// This will enable the Live Query real-time server
ParseServer.createLiveQueryServer(httpServer);
