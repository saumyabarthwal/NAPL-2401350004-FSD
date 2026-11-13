
type Shape() =
    abstract member Area : unit -> float
    default this.Area() = 0.0

type Circle() =
    inherit Shape()

    override this.Area() =
        3.14 * 5.0 * 5.0

type Rectangle() =
    inherit Shape()

    override this.Area() =
        4.0 * 6.0

let c = Circle()
let r = Rectangle()

printfn "Area of Circle = %f" (c.Area())
printfn "Area of Rectangle = %f" (r.Area())

//// STUDENT MANAGEMENT SYSTEM 
// 13-2-26 (F# ASSISMENT)

#r "nuget: MongoDB.Driver"

open System
open MongoDB.Bson
open MongoDB.Driver


type Student =
    {
        Id: string
        Name: string
        Age: int
    }

// 2. DATABASE CONNECTION

let client = MongoClient("yadavrashi2006_db_user:vmILywFyzX4UZByP@cluster0.i4tdsht.mongodb.net/")
let db = client.GetDatabase("StudentDB")
let collection = db.GetCollection<BsonDocument>("Students")

let toDoc s =
    let d = BsonDocument()
    d.Add("_id", BsonString(s.Id)) |> ignore
    d.Add("Name", BsonString(s.Name)) |> ignore
    d.Add("Age", BsonInt32(s.Age)) |> ignore
    d

let fromDoc (d: BsonDocument) =
    {
        Id = d["_id"].AsString
        Name = d["Name"].AsString
        Age = d["Age"].AsInt32
    }


let main = async {

    let s1 = {
        Id = Guid.NewGuid().ToString()
        Name = "RASHI YADAV"
        Age = 30
    }

    let s2 = {
        Id = Guid.NewGuid().ToString()
        Name = "MAHAK YADAV"
        Age = 17
    }
    let s3 = {
        Id = Guid.NewGuid().ToString()
        Name = "MAHI YADAV"
        Age = 22
    }
    let s4 = {
        Id = Guid.NewGuid().ToString()
        Name = "VANSH YADAV"
        Age = 13
    }
    let s5 = {
        Id = Guid.NewGuid().ToString()
        Name = "KUMKUM SISODIYA"
        Age = 25
    }
    let s6 = {
        Id = Guid.NewGuid().ToString()
        Name = "PRIYA YADAV"
        Age = 35
    }


    do! collection.InsertOneAsync(toDoc s1) |> Async.AwaitTask
    do! collection.InsertOneAsync(toDoc s2) |> Async.AwaitTask

    printfn "Students inserted!"


    let! docs =
        collection.Find(Builders<BsonDocument>.Filter.Empty)
            .ToListAsync()
        |> Async.AwaitTask

    let students = docs |> Seq.map fromDoc |> Seq.toList

    printfn "\nAll Students: %A" students
-
    // MAP (Higher Order Function)

    let names = students |> List.map (fun s -> s.Name)

    printfn "\nStudent Names: %A" names

    // FILTER (Higher Order Function)

    let adults = students |> List.filter (fun s -> s.Age >= 18)

    printfn "\nAdult Students: %A" adults

    // PATTERN MATCHING

    students |> List.iter (fun s ->
        match s.Age with
        | age when age >= 18 -> printfn "%s is Adult" s.Name
        | _ -> printfn "%s is Minor" s.Name
    )

    // UPDATE

    let filter =
        Builders<BsonDocument>.Filter.Eq("_id", BsonString(s1.Id))

    let update =
        Builders<BsonDocument>.Update.Set("Age", BsonInt32(21))

    let! result =
        collection.UpdateOneAsync(filter, update) |> Async.AwaitTask

    printfn "\nUpdated: %A" result.ModifiedCount

    // DELETE

    let deleteFilter =
        Builders<BsonDocument>.Filter.Eq("_id", BsonString(s2.Id))

    let! deleted =
        collection.DeleteOneAsync(deleteFilter) |> Async.AwaitTask

    printfn "Deleted: %A" deleted.DeletedCount

    printfn "\nProgram completed!"
}

// 4. EXECUTE ASYNC WORKFLOW

Async.RunSynchronously main