const dbPool = require("../config/database");

const getAllUsers = () => {
  const SQLQuery = "SELECT * FROM users";

  return dbPool.execute(SQLQuery);
};

const creatNewUsers = (body) => {
  const SQLQuery = `  INSERT INTO users (name, email, address) 
                        VALUES ('${body.name}', '${body.email}', '${body.address}')`;
  return dbPool.execute(SQLQuery);
};

const updateUsers = (body, idUsers) => {
  const SQLQuery = `  UPDATE users 
                        SET name= '${body.name}', email='${body.email}', address='${body.address}' 
                        WHERE id =${idUsers}`;
  return dbPool.execute(SQLQuery);
};
const deleteUsers = (idUsers) => {
  const SQLQuery = `DELETE FROM users WHERE id=${idUsers}`;
  return dbPool.execute(SQLQuery);
};

module.exports = {
  getAllUsers,
  creatNewUsers,
  updateUsers,
  deleteUsers,
};
