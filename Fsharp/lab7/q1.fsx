open System

let workertask (id: int, time: int) =
    async {
        printfn "Starting Task %d" id
        do! Async.Sleep(time)
        printfn "Completed Task %d" id
        return id
    }

let main argv =
    printfn "Starting concurrent tasks"

    let jobs = [
        workertask (1, 2000)
        workertask (2, 3000)
        workertask (3, 4000)
    ]

    let parallelTask = Async.Parallel jobs

    let results = Async.RunSynchronously parallelTask

    results
    |> Array.iter (fun result ->
        printfn "Completed result is %d" result
    )

    0

main [||]