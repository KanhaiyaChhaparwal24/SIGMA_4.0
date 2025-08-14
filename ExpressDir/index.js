const express = require("express");
const app = express();
const port = 8080; //8080

app.listen(port, () => {
  console.log(`app listening on port ${port}`);
});

// app.use((req, res) => {
//   console.log("request recieved");
//   res.send("Hello, World!");
// });

app.get("/", (req, res) => {
  res.send("its root path");
});
// app.get("/apple", (req, res) => {
//   res.send("apple path");
// });
// app.get("/orange", (req, res) => {
//   res.send("orange path");
// });

// app.get("*", (req, res) => {
//   res.send("invalid path");
// });

// app.post("/", (req, res) => {
//   res.send("post method");
// });

app.get("/:username/:id", (req, res) => {
  let { username, id } = req.params;
  let htmlStr = `<h1>Welcome to page of @${username}!</h1>`;
  res.send(htmlStr);
});

app.get("/search", (req, res) => {
  let { q } = req.query;
  //   console.log(req.query);
  if (!q) {
    res.send("Please enter a search query");
  }
  res.send(`results for query: ${q}`);
});
