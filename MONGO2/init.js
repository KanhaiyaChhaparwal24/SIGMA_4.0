const mongoose = require("mongoose");
const Chat = require("./models/chat.js");

main()
  .then(() => {
    console.log("Connected to MongoDB");
  })
  .catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://127.0.0.1:27017/whatsapp");
}

let allChats = [
  { from: "Alice", to: "Bob", msg: "Hello Bob!", createdAt: new Date() },
  {
    from: "Bob",
    to: "Alice",
    msg: "Hi Alice! How are you?",
    createdAt: new Date(),
  },
  {
    from: "Alice",
    to: "Bob",
    msg: "I'm good, thanks! And you?",
    createdAt: new Date(),
  },
  {
    from: "Bob",
    to: "Alice",
    msg: "Doing well, just busy with work.",
    createdAt: new Date(),
  },
  {
    from: "Alice",
    to: "Bob",
    msg: "I understand, work can be hectic.",
    createdAt: new Date(),
  },
];

Chat.insertMany(allChats)
  .then((res) => console.log("Chats inserted:", res))
  .catch((err) => console.log("Error inserting chats:", err));
