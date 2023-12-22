require("dotenv").config();
const PORT = process.env.PORT || 5000;

const express = require("express");

const usersRoutes = require("./routes/users.js");

const MiddlewareLogRequest = require("./middleware/logs");

const app = express();

app.use(MiddlewareLogRequest);

app.use(express.json());

app.use("/users", usersRoutes);

app.listen(PORT, () => {
  console.log(`Server berhasil di running di port ${PORT}`);
});
