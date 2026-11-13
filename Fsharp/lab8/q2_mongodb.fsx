
#r "nuget: MongoDB.Driver, 3.13.0"

open MongoDB.Bson
open MongoDB.Driver

// Connect to MongoDB Atlas
let client = new MongoClient("mongodb+srv://saumyabarthwalo9_db_user:saumya2345@cluster0.gnnebch.mongodb.net/")

let db = client.GetDatabase("College")
let collection = db.GetCollection<BsonDocument>("Student")

// Create student document
let student = BsonDocument()
student.Add("_id", ObjectId.GenerateNewId())
student.Add("Name", "Rahul")
student.Add("Age", 20)

let filter = Builders<BsonDocument>.Filter.Eq("_id", student.["_id"])

// CREATE
collection.InsertOne(student)
printfn "After Create:"
printfn "%O" student

// READ
printfn "\nAfter Read:"
let records = collection.Find(FilterDefinition<BsonDocument>.Empty).ToList()

for s in records do
    printfn "%O" s

// UPDATE
let update = Builders<BsonDocument>.Update.Set("Age", 21)
collection.UpdateOne(filter, update)

printfn "\nAfter Update:"
let updated = collection.Find(filter).FirstOrDefault()
printfn "%O" updated

// DELETE
collection.DeleteOne(filter)

printfn "\nAfter Delete:"
let remaining = collection.Find(filter).FirstOrDefault()
printfn "%O" remaining
//#saumya2005@3344>