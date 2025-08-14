const mongoose = require("mongoose");

main()
  .then((res) => {
    console.log("Database connection established successfully");
  })
  .catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://127.0.0.1:27017/test");
  console.log("Connected to MongoDB");
}

const userSchema = new mongoose.Schema({
  name: String,
  email: String,
  age: Number,
});

const User = mongoose.model("User", userSchema);

// const user2 = new User({
//   name: "Eve",
//   email: "eve@gmail.com",
//   age: 30,
// });
// user2
//   .save()
//   .then((res) => {
//     console.log(res);
//   })
//   .catch((err) => {
//     console.error("Error saving user:", err);
//   });

// User.insertMany([
//   {
//     name: "Alice",
//     email: "alice@gmail.com",
//     age: 25,
//   },
//   {
//     name: "Bob",
//     email: "bob@gmail.com",
//     age: 28,
//   },
//   { name: "Charlie", email: "charlie@gmail.com", age: 22 },
// ])
//   .then((res) => {
//     console.log("Users inserted successfully:", res);
//   })
//   .catch((err) => {
//     console.error("Error inserting users:", err);
//   });

// User.find()
//   .then((users) => {
//     console.log("Users found:", users);
//   })
//   .catch((err) => {
//     console.error("Error finding users:", err);
//   });
// User.find({ age: { $gte: 28 } })
//   .then((user) => {
//     console.log("User found:", user);
//   })
//   .catch((err) => {
//     console.error("Error finding user:", err);
//   });

// User.updateOne({ name: "Alice" }, { age: 26 })
//   .then((res) => {
//     console.log("User updated successfully:", res);
//   })
//   .catch((err) => {
//     console.error("Error updating user:", err);
//   });
// User.updateMany({ age: { $gte: 28 } }, { age: 29 })
//   .then((res) => {
//     console.log("Users updated successfully:", res);
//   })
//   .catch((err) => {
//     console.error("Error updating users:", err);
//   });

// User.deleteOne({ name: "Alice" })
//   .then((res) => {
//     console.log("User deleted successfully:", res);
//   })
//   .catch((err) => {
//     console.error("Error deleting user:", err);
//   });
// User.deleteMany({ age: { $gte: 28 } })
//   .then((res) => {
//     console.log("Users deleted successfully:", res);
//   })
//   .catch((err) => {
//     console.error("Error deleting users:", err);
//   });

