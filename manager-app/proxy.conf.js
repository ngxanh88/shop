const PROXY_CONFIG = {
  "/manager/api/**": {
    "target": "http://localhost:8080",
    "secure": false,
    // "logLevel": "debug",
    "bypass": function (req, res, proxyOptions) {
      if (req.headers.accept.indexOf("html") !== -1) {
        console.log("Skipping proxy for browser request.");
        return "/admin-home.html";
      }
      req.headers["X-Custom-Header"] = "yes";
    }
  }
};

module.exports = PROXY_CONFIG;
