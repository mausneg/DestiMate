const UsersModel = require("../models/users");

const getAllUsers = async (req, res) => {
  try {
    const [data] = await UsersModel.getAllUsers();
    res.json({
      message: "GET all users success",
      data: data,
    });
  } catch (error) {
    res.status(500).json({
      message: "Server Error",
      serverMessage: error,
    });
  }
};

const creatNewUsers = async (req, res) => {
  const { body } = req;
  try {
    await UsersModel.creatNewUsers(body);
    res.json({
      message: "CREATE new user success",
      data: body,
    });
  } catch (error) {
    res.status(500).json({
      message: "Server Error",
      serverMessage: error,
    });
  }
};

const updateUsers = async (req, res) => {
  const { idUsers } = req.params;
  const { body } = req;
  try {
    await UsersModel.updateUsers(body, idUsers);
    res.json({
      message: "UPDATE user success",
      data: {
        id: idUsers,
        ...body,
      },
    });
  } catch (error) {
    res.status(500).json({
      message: "Server Error",
      serverMessage: error,
    });
  }
};

const deleteUsers = async (req, res) => {
  const { idUsers } = req.params;
  try {
    await UsersModel.deleteUsers(idUsers);
    res.json({
      message: "DELETE user success",
      data: null,
    });
  } catch (error) {
    res.status(500).json({
      message: "Server Error",
      serverMessage: error,
    });
  }
};

module.exports = {
  getAllUsers,
  creatNewUsers,
  updateUsers,
  deleteUsers,
};
