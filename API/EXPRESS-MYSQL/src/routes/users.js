const express = require("express");

const UserController = require("../controller/users.js");

const router = express.Router();

//CREATE - POST
router.post("/", UserController.creatNewUsers);

//READ - GET
router.get("/", UserController.getAllUsers);

//UPDATE - PATCH
router.patch("/:idUsers", UserController.updateUsers);

//DELETE - DELETE
router.delete("/:idUsers", UserController.deleteUsers);

module.exports = router;
