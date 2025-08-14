const express = require("express");
const router = express.Router();
const Chat = require("../models/chat");

// Show all chats
router.get("/", async (req, res) => {
  const chats = await Chat.find();
  res.render("index", { chats });
});

// New chat form
router.get("/new", (req, res) => {
  res.render("new");
});

// Create chat
router.post("/", async (req, res) => {
  const { from, to, msg } = req.body;
  await Chat.create({ from, to, msg });
  res.redirect("/chats");
});

// Edit chat form
router.get("/:id/edit", async (req, res) => {
  const chat = await Chat.findById(req.params.id);
  res.render("edit", { chat });
});

// Update chat
router.post("/:id", async (req, res) => {
  const { from, to, msg } = req.body;
  await Chat.findByIdAndUpdate(req.params.id, { from, to, msg });
  res.redirect("/chats");
});

// Destroy chat
router.post("/:id/delete", async (req, res) => {
  await Chat.findByIdAndDelete(req.params.id);
  res.redirect("/chats");
});

module.exports = router;
