<h1 align="center">
<img src="https://www.apascualco.com/wp-content/uploads/2020/02/1_X25YjzCl4a3eRrJoVIl5Wg.png" width="500">
</h1><br>

# ⚙ Quiz job question ingest

[![Code style: black](https://img.shields.io/badge/code%20style-black-000000.svg)](https://github.com/psf/black)

With this piece of the engine, you have to run first the spring batch piece, with the mysql server and the spring boot too. Once it is running you can change the CSV to make request to the server and make the server to save your questions in the MySQL database

## 🔩  How install the server

```sh
docker build -t spring-batch-job .
docker run -it --name spring-batch-job --network host spring-batch-job:latest
```
