const { faker } = require("@faker-js/faker");
const mysql = require("mysql2");
const express = require("express");
const app = express();
const path = require("path");
const methodOverride = require("method-override");

app.use(methodOverride("_method"));
app.use(express.urlencoded({ extended: true })); // For parsing application/x-www-form-urlencoded
app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "/views"));

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "Kanhaiya@2406",
  database: "test_db",
});
let getRandomUser = () => {
  return [
    faker.string.uuid(),
    faker.internet.username(),
    faker.internet.email(),
    faker.internet.password(),
  ];
};

// let q = "INSERT INTO user (userId, username, email, password) VALUES ?";
// let data = [];
// for (let i = 0; i < 10; i++) {
//   data.push(getRandomUser());
// }

// try {
//   connection.query(q, [data], (err, results) => {
//     if (err) throw err;
//     console.log("Tables in the database: ", results);
//   });
// } catch (err) {
//   console.error("Error fetching tables: ", err);
// }

// connection.end();

app.get("/", (req, res) => {
  let q = "SELECT count(*) FROM user";
  try {
    connection.query(q, (err, results) => {
      if (err) throw err;
      let userCount = results[0]["count(*)"];
      console.log("Total users: ", userCount);
      // res.send(`Total users: ${results[0]["count(*)"]}`);
      res.render("home.ejs", { userCount: userCount });
    });
  } catch (err) {
    console.error("Error fetching user count: ", err);
    res.status(500).send("Internal Server Error");
  }
});

// Show all users
app.get("/users", (req, res) => {
  let q = "SELECT * FROM user";
  try {
    connection.query(q, (err, results) => {
      if (err) throw err;
      // console.log("Users: ", results);
      res.render("users.ejs", { users: results });
    });
  } catch (err) {
    console.error("Error fetching users: ", err);
    res.status(500).send("Internal Server Error");
  }
});

//Edit user
app.get("/users/:userId/edit", (req, res) => {
  let userId = req.params.userId;
  let q = "SELECT * FROM user WHERE userId = ?";
  try {
    connection.query(q, [userId], (err, results) => {
      if (err) throw err;
      if (results.length > 0) {
        res.render("edit.ejs", { user: results[0] });
      } else {
        res.status(404).send("User not found");
      }
    });
  } catch (err) {
    console.error("Error fetching user for edit: ", err);
    res.status(500).send("Internal Server Error");
  }
});

// Update user
app.patch("/users/:userId", (req, res) => {
  let userId = req.params.userId;
  let { username, password } = req.body;
  let q = "SELECT email, password FROM user WHERE userId = ?";
  try {
    connection.query(q, [userId], (err, results) => {
      if (err) {
        console.error("Error fetching user details: ", err);
        return res.status(500).send("Internal Server Error");
      }

      if (results.length > 0 && results[0].password === password) {
        const email = results[0].email; // Preserve the existing email
        const updateQuery =
          "UPDATE user SET username = ?, email = ? WHERE userId = ?";
        connection.query(
          updateQuery,
          [username, email, userId],
          (updateErr) => {
            if (updateErr) {
              console.error("Error updating username: ", updateErr);
              return res.status(500).send("Internal Server Error");
            }
            res.redirect("/users");
          }
        );
      } else {
        res.status(401).send("Invalid password");
      }
    });
  } catch (err) {
    console.error("Error updating user: ", err);
    res.status(500).send("Internal Server Error");
  }
});

app.listen(8080, () => {
  console.log("Server is running on port 8080");
});
