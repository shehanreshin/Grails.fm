db.createUser(
  {
    user: "root",
    pwd: "12345",
    roles: [ { role: "root", db: "admin" } ]
  }
)
