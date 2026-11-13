#r "nuget: Microsoft.Data.Sqlite, 11.0.0"

open Microsoft.Data.Sqlite

let con = new SqliteConnection("Data Source=students.db")
con.Open()

let cmd = con.CreateCommand()

// Create table
cmd.CommandText <- "CREATE TABLE IF NOT EXISTS Student (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"
cmd.ExecuteNonQuery() |> ignore

// Create
cmd.CommandText <- "INSERT OR REPLACE INTO Student VALUES (1, 'Rahul', 20)"
cmd.ExecuteNonQuery() |> ignore

printfn "After Create:"

// Read
let show() =
    cmd.CommandText <- "SELECT * FROM Student"
    let reader = cmd.ExecuteReader()

    while reader.Read() do
        printfn "%d %s %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))

    reader.Close()

show()

// Read
printfn "After Read:"
show()

// Update
cmd.CommandText <- "UPDATE Student SET Age = 21 WHERE Id = 1"
cmd.ExecuteNonQuery() |> ignore

printfn "After Update:"
show()

// Delete
cmd.CommandText <- "DELETE FROM Student WHERE Id = 1"
cmd.ExecuteNonQuery() |> ignore

printfn "After Delete:"
show()

con.Close()
