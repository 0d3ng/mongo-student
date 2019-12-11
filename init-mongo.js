db.createUser(
    {
        user: "root",
        pwd: "parkir",
        roles:[
            {
                role:"readWrite",
                db:"parkir-db"
            }
        ]
    }
)