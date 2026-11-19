
#r "nuget: MongoDB.Driver"

open System
open MongoDB.Bson
open MongoDB.Driver



type Student =
    {
        Id: string
        Name: string
        Age: int
        Course: string
        Marks: int
    }



let client = new MongoClient("mongodb+srv://saumyabarthwalo9_db_user:saumya2345@cluster0.gnnebch.mongodb.net/")
let db = client.GetDatabase("StudentDB")
let collection = db.GetCollection<BsonDocument>("Students")



let toDoc (s: Student) =
    let d = new BsonDocument()
    d.Add("_id", BsonString(s.Id)) |> ignore
    d.Add("Name", BsonString(s.Name)) |> ignore
    d.Add("Age", BsonInt32(s.Age)) |> ignore
    d.Add("Course", BsonString(s.Course)) |> ignore
    d.Add("Marks", BsonInt32(s.Marks)) |> ignore
    d



let fromDoc (d: BsonDocument) =
    {
        Id = d["_id"].AsString
        Name = d["Name"].AsString
        Age = d["Age"].AsInt32
        Course = d["Course"].AsString
        Marks = d["Marks"].AsInt32
    }

// GRADE FUNCTION

let grade marks =
    match marks with
    | m when m >= 90 -> "O"
    | m when m >= 75 -> "A+"
    | m when m >= 60 -> "A"
    | m when m >= 50 -> "B"
    | m when m >= 40 -> "C"
    | _ -> "F"

// MAIN PROGRAM

let main = async {

    // CREATE STUDENTS

    let s1 = {
        Id = Guid.NewGuid().ToString()
        Name = "Saumya Barthwal"
        Age = 21
        Course = "Btech"
        Marks = 90
    }

    let s2 = {
        Id = Guid.NewGuid().ToString()
        Name = "Rashi Yadav"
        Age = 20
        Course = "Btech"
        Marks = 75
    }

    let s3 = {
        Id = Guid.NewGuid().ToString()
        Name = "Manju"
        Age = 19
        Course = "Btech"
        Marks = 86
    }

    let s4 = {
        Id = Guid.NewGuid().ToString()
        Name = "Pari"
        Age = 20
        Course = "Btech"
        Marks = 35
    }

    let s5 = {
        Id = Guid.NewGuid().ToString()
        Name = "Bhavii"
        Age = 20
        Course = "Btech"
        Marks = 34
    }

    let s6 = {
        Id = Guid.NewGuid().ToString()
        Name = "Vansh"
        Age = 21
        Course = "Btech"
        Marks = 90
    }

    // INSERT ALL STUDENTS

    do!
        collection.InsertManyAsync(
            [s1; s2; s3; s4; s5; s6] |> List.map toDoc
        )
        |> Async.AwaitTask

    printfn "Students inserted successfully!"

  

    let! docs =
        collection.Find(Builders<BsonDocument>.Filter.Empty)
            .ToListAsync()
        |> Async.AwaitTask

    let students =
        docs |> Seq.map fromDoc |> Seq.toList

    printfn "\nAll Students:"
    students |> List.iter (printfn "%A")

   

    let names =
        students |> List.map (fun s -> s.Name)

    printfn "\nStudent Names:"
    printfn "%A" names

    

    let adults =
        students |> List.filter (fun s -> s.Age >= 20)

    printfn "\nAdult Students:"
    adults |> List.iter (printfn "%A")

  

    printfn "\nStudent Grades:"

    students |> List.iter (fun s ->
        printfn "%s - Marks: %d - Grade: %s"
            s.Name s.Marks (grade s.Marks)
    )


    let filter =
        Builders<BsonDocument>.Filter.Eq("_id", BsonString(s1.Id))

    let update =
        Builders<BsonDocument>.Update
            .Set("Age", BsonInt32(22))
            .Set("Course", BsonString("MCA"))
            .Set("Marks", BsonInt32(95))

    let! result =
        collection.UpdateOneAsync(filter, update)
        |> Async.AwaitTask

    printfn "\nUpdated Students: %A" result.ModifiedCount

    let! updatedDoc =
        collection.Find(filter).FirstOrDefaultAsync()
        |> Async.AwaitTask

    if not (isNull updatedDoc) then
        let updatedStudent = fromDoc updatedDoc
        printfn "\nUpdated Student:"
        printfn "%A" updatedStudent

   

    let deleteFilter =
        Builders<BsonDocument>.Filter.Eq("_id", BsonString(s2.Id))

    let! deleted =
        collection.DeleteOneAsync(deleteFilter)
        |> Async.AwaitTask

    printfn "\nDeleted Students: %A" deleted.DeletedCount

   

    printfn "\nProgram completed successfully!"
}



Async.RunSynchronously main
